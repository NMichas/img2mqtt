package com.github.nmichas;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math.stat.descriptive.moment.Mean;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class Poller {
	private Conf conf;
	private BufferedImage img;
	private ObjectMapper mapper = new ObjectMapper();

	public Poller(Conf conf) {
		this.conf = conf;
	}

	private void loadImage(String readFrom) throws IOException {
		if (readFrom.startsWith("http")) {
			if (conf.isDebug()) {
				System.out.println("Loading image from URL: " + readFrom);
			}
			img = ImageIO.read(new URL(conf.getUrl()));
		} else {
			if (conf.isDebug()) {
				System.out.println("Loading image from file: " + readFrom);
			}
			img = ImageIO.read(new File(readFrom));
		}
	}

	private void drawRect(Graphics2D g, Point top, Point bottom) {
		g.drawRect(top.x, top.y, bottom.x - top.x, bottom.y - top.y);
	}

	private void trace(String filename) throws IOException {
		Graphics2D g = img.createGraphics();

		drawRect(g, conf.getLedPlayroomT(), conf.getLedPlayroomB());
		drawRect(g, conf.getLedGroundT(), conf.getLedGroundB());
		drawRect(g, conf.getLedFloorT(), conf.getLedFloorB());
		drawRect(g, conf.getLedBoilerT(), conf.getLedBoilerB());
		drawRect(g, conf.getLedStatusT(), conf.getLedStatusB());
		drawRect(g, conf.getLedPumpT(), conf.getLedPumpB());
		drawRect(g, conf.getCmdPlayroomT(), conf.getCmdPlayroomB());
		drawRect(g, conf.getCmdGroundT(), conf.getCmdGroundB());
		drawRect(g, conf.getCmdFloorT(), conf.getCmdFloorB());

		drawRect(g, conf.getSample1(), new Point(conf.getSample1().x + conf.getSampleSize(),
				conf.getSample1().y + conf.getSampleSize()));
		drawRect(g, conf.getSample2(), new Point(conf.getSample2().x + conf.getSampleSize(),
				conf.getSample2().y + conf.getSampleSize()));
		drawRect(g, conf.getSample3(), new Point(conf.getSample3().x + conf.getSampleSize(),
				conf.getSample3().y + conf.getSampleSize()));
		drawRect(g, conf.getSample4(), new Point(conf.getSample4().x + conf.getSampleSize(),
				conf.getSample4().y + conf.getSampleSize()));
		drawRect(g, conf.getSample5(), new Point(conf.getSample5().x + conf.getSampleSize(),
				conf.getSample5().y + conf.getSampleSize()));

		g.drawString(filename, 10, 15);
		g.drawString(new Date().toString(), 10f, 30f);

		ImageIO.write(img, "PNG", new File(conf.getTrace()));
	}

	private double getLum(Point point) {
		Color c = new Color(img.getRGB(point.x, point.y));

		return Math.sqrt(
				0.241d * Math.pow(c.getRed(), 2) +
						0.691d * Math.pow(c.getGreen(), 2) +
						0.068d * Math.pow(c.getBlue(), 2));
	}

	private double getAmbientLum() {
		Mean mean = new Mean();
		mean.increment(getAreaLum(conf.getSample1(),
				new Point(conf.getSample1().x + conf.getSampleSize(), conf.getSample1().y + conf.getSampleSize())));
		mean.increment(getAreaLum(conf.getSample2(),
				new Point(conf.getSample2().x + conf.getSampleSize(), conf.getSample2().y + conf.getSampleSize())));
		mean.increment(getAreaLum(conf.getSample3(),
				new Point(conf.getSample3().x + conf.getSampleSize(), conf.getSample3().y + conf.getSampleSize())));
		mean.increment(getAreaLum(conf.getSample4(),
				new Point(conf.getSample4().x + conf.getSampleSize(), conf.getSample4().y + conf.getSampleSize())));
		mean.increment(getAreaLum(conf.getSample5(),
				new Point(conf.getSample5().x + conf.getSampleSize(), conf.getSample5().y + conf.getSampleSize())));


		return mean.getResult();
	}

	private double getAreaLum(Point p1, Point p2) {
		Mean mean = new Mean();
		for (int x = p1.x; x < p2.x; x++) {
			for (int y = p1.y; y < p2.y; y++) {
				mean.increment(getLum(new Point(x, y)));
			}
		}

		return mean.getResult();
	}

	private boolean isLedOn(double val) {
		return val > conf.getThresholdLed();
	}

	private boolean isCmdOn(double val) {
		return val > conf.getThresholdCmd();
	}

	private Msg process() {
		if (conf.isDebug()) {
			System.out.println("Processing image.");
		}
		Msg msg = new Msg();

		msg.setAmbientVal(getAmbientLum());

		msg.setLedPlayroomVal(getAreaLum(conf.getLedPlayroomT(),  conf.getLedPlayroomB()));
		msg.setLedPlayroom(isLedOn(msg.getLedPlayroomVal()));

		msg.setLedGroundVal(getAreaLum(conf.getLedGroundT(),  conf.getLedGroundB()));
		msg.setLedGround(isLedOn(msg.getLedGroundVal()));

		msg.setLedFloorVal(getAreaLum(conf.getLedFloorT(),  conf.getLedFloorB()));
		msg.setLedFloor(isLedOn(msg.getLedFloorVal()));

		msg.setLedBoilerVal(getAreaLum(conf.getLedBoilerT(),  conf.getLedBoilerB()));
		msg.setLedBoiler(isLedOn(msg.getLedBoilerVal()));

		msg.setLedStatusVal(getAreaLum(conf.getLedStatusT(),  conf.getLedStatusB()));
		msg.setLedStatus(isLedOn(msg.getLedStatusVal()));

		msg.setLedPumpVal(getAreaLum(conf.getLedPumpT(),  conf.getLedPumpB()));
		msg.setLedPump(isLedOn(msg.getLedPumpVal()));

		msg.setCmdPlayroomVal(getAreaLum(conf.getCmdPlayroomT(),  conf.getCmdPlayroomB()));
		msg.setCmdPlayroom(isCmdOn(msg.getCmdPlayroomVal()));

		msg.setCmdGroundVal(getAreaLum(conf.getCmdGroundT(),  conf.getCmdGroundB()));
		msg.setCmdGround(isCmdOn(msg.getCmdGroundVal()));

		msg.setCmdFloorVal(getAreaLum(conf.getCmdFloorT(),  conf.getCmdFloorB()));
		msg.setCmdFloor(isCmdOn(msg.getCmdFloorVal()));

		if (conf.isDebug()) {
			System.out.println("Image processed.");
		}

		return msg;
	}

	public Msg handle(Exchange exchange) throws IOException {
		if (conf.isDebug()) {
			System.out.println("Loading image.");
		}
		loadImage(conf.getUrl());
		if (conf.isDebug()) {
			System.out.println("Image loaded.");
		}

		Msg msg = process();

		if (conf.isDebug()) {
			System.out.println("MSG=\n" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(msg));
		}

		if (StringUtils.isNotBlank(conf.getTrace())) {
			trace(conf.getUrl());
		}

		return msg;
	}
}
