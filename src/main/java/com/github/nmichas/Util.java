package com.github.nmichas;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

	private static Point confToPoint(String pointStr) {
		final String[] split = pointStr.split(",");
		return new Point(Integer.parseInt(split[0]),
				Integer.parseInt(split[1]));
	}

	public static Conf readConf(String configurationFile) throws IOException, NoSuchFieldException, IllegalAccessException {
		Properties c = new Properties();
		try (InputStream in = new FileInputStream(configurationFile)) {
			c.load(in);
		}

		Conf conf = new Conf();

		conf.setUrl(c.getProperty("url"));

		conf.setPollerFreq(Long.parseLong(c.getProperty("pollerFreq")));
		conf.setMqttHost(c.getProperty("mqtt.host"));
		conf.setMqttUsername(c.getProperty("mqtt.username"));
		conf.setMqttPassword(c.getProperty("mqtt.password"));
		conf.setMqttTopic(c.getProperty("mqtt.topic"));

		conf.setLedPlayroomT(confToPoint(c.getProperty("led.playroom.t")));
		conf.setLedPlayroomB(confToPoint(c.getProperty("led.playroom.b")));

		conf.setLedGroundT(confToPoint(c.getProperty("led.ground.t")));
		conf.setLedGroundB(confToPoint(c.getProperty("led.ground.b")));

		conf.setLedFloorT(confToPoint(c.getProperty("led.floor.t")));
		conf.setLedFloorB(confToPoint(c.getProperty("led.floor.b")));

		conf.setLedBoilerT(confToPoint(c.getProperty("led.boiler.t")));
		conf.setLedBoilerB(confToPoint(c.getProperty("led.boiler.b")));

		conf.setLedStatusT(confToPoint(c.getProperty("led.status.t")));
		conf.setLedStatusB(confToPoint(c.getProperty("led.status.b")));

		conf.setLedPumpT(confToPoint(c.getProperty("led.pump.t")));
		conf.setLedPumpB(confToPoint(c.getProperty("led.pump.b")));

		conf.setCmdPlayroomT(confToPoint(c.getProperty("cmd.playroom.t")));
		conf.setCmdPlayroomB(confToPoint(c.getProperty("cmd.playroom.b")));

		conf.setCmdGroundT(confToPoint(c.getProperty("cmd.ground.t")));
		conf.setCmdGroundB(confToPoint(c.getProperty("cmd.ground.b")));

		conf.setCmdFloorT(confToPoint(c.getProperty("cmd.floor.t")));
		conf.setCmdFloorB(confToPoint(c.getProperty("cmd.floor.b")));

		conf.setSampleSize(Integer.parseInt(c.getProperty("sample.size")));
		conf.setSample1(confToPoint(c.getProperty("sample1")));
		conf.setSample2(confToPoint(c.getProperty("sample2")));
		conf.setSample3(confToPoint(c.getProperty("sample3")));
		conf.setSample4(confToPoint(c.getProperty("sample4")));
		conf.setSample5(confToPoint(c.getProperty("sample5")));

		conf.setThresholdCmd(Double.parseDouble(c.getProperty("threshold_cmd")));
		conf.setThresholdLed(Double.parseDouble(c.getProperty("threshold_led")));

		conf.setDebug(Boolean.parseBoolean(c.getProperty("debug")));

		conf.setTrace(c.getProperty("trace"));
		return conf;
	}
}
