package com.github.nmichas;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AppTest {
	private static Conf conf;

	private List<Path> findTestFiles() throws IOException {
		List<Path> files = new ArrayList<>();
		String testingFilesRoot = System.getProperty("user.dir")
				+ File.separator +  "src"
				+ File.separator + "test" + File.separator
				+ "samples";
		Files.walk(Paths.get(testingFilesRoot))
				.filter(Files::isRegularFile)
				.filter(o -> o.getFileName().toString().endsWith(".jpg"))
				.forEach(o -> files.add(o.toAbsolutePath()));

		return files;
	}

	@BeforeClass
	public static void setup() throws IllegalAccessException, NoSuchFieldException, IOException {
		conf = Util.readConf("img2mqtt.conf");
		conf.setDebug(false);
		//conf.setTrace(null);
	}

	private void checkResults(Msg msg, Path path) {
		String fileName = path.getFileName().toString();
		String testPattern = fileName.substring(0, fileName.indexOf("_"));

		System.out.print("\tPlayroom (" + (int)msg.getLedPlayroomVal() + ")");
		Assert.assertEquals(msg.isLedPlayroom() ? "1" : "0", testPattern.substring(0, 1));

		System.out.print("\tGround (" + (int)msg.getLedGroundVal() + ")");
		Assert.assertEquals(msg.isLedGround() ? "1" : "0", testPattern.substring(1, 2));

		System.out.print("\tFloor (" + (int)msg.getLedFloorVal() + ")");
		Assert.assertEquals(msg.isLedFloor() ? "1" : "0", testPattern.substring(2, 3));

		System.out.print("\tBoiler (" + (int)msg.getLedBoilerVal() + ")");
		Assert.assertEquals(msg.isLedBoiler() ? "1" : "0", testPattern.substring(3, 4));

		System.out.print("\tPump (" + (int)msg.getLedPumpVal() + ")");
		Assert.assertEquals(msg.isLedPump() ? "1" : "0", testPattern.substring(4, 5));

		System.out.print("\tStatus (" + (int)msg.getLedStatusVal() + ")");
		Assert.assertEquals(msg.isLedStatus() ? "1" : "0", testPattern.substring(5, 6));

		System.out.println();
	}

	@Test
	public void test() throws IOException {
		for (Path path : findTestFiles()) {
			System.out.println(path.toAbsolutePath());
			conf.setUrl(path.toAbsolutePath().toString());
			Poller poller = new Poller(conf);
			final Msg msg = poller.handle(null);
			checkResults(msg, path);
		}
	}

//	@Test
//	public void day_000000_000() throws IOException {
//		final String file = getFileForMethod();
//		System.out.println("Testing: " + file);
//		conf.setUrl(file);
//		Poller poller = new Poller(conf);
//		final Msg msg = poller.handle(null);
//
//		checkResults(msg, getFileForMethod());
//	}

}
