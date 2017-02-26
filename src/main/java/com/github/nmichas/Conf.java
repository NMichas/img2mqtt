package com.github.nmichas;

import java.awt.*;

public class Conf {
	private long pollerFreq;
	private String url;
	private String trace;
	private String mqttHost;
	private String mqttUsername;
	private String mqttPassword;
	private String mqttTopic;

	private Point ledPlayroomT;
	private Point ledPlayroomB;

	private Point ledGroundT;
	private Point ledGroundB;

	private Point ledFloorT;
	private Point ledFloorB;

	private Point ledBoilerT;
	private Point ledBoilerB;

	private Point ledStatusT;
	private Point ledStatusB;

	private Point ledPumpT;
	private Point ledPumpB;

	private Point cmdPlayroomT;
	private Point cmdPlayroomB;

	private Point cmdGroundT;
	private Point cmdGroundB;

	private Point cmdFloorT;
	private Point cmdFloorB;

	private int sampleSize;
	private Point sample1;
	private Point sample2;
	private Point sample3;
	private Point sample4;
	private Point sample5;

	private double thresholdLed;
	private double thresholdCmd;

	private boolean debug;

	public long getPollerFreq() {
		return pollerFreq;
	}

	public void setPollerFreq(long pollerFreq) {
		this.pollerFreq = pollerFreq;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMqttHost() {
		return mqttHost;
	}

	public void setMqttHost(String mqttHost) {
		this.mqttHost = mqttHost;
	}

	public String getMqttUsername() {
		return mqttUsername;
	}

	public void setMqttUsername(String mqttUsername) {
		this.mqttUsername = mqttUsername;
	}

	public String getMqttPassword() {
		return mqttPassword;
	}

	public void setMqttPassword(String mqttPassword) {
		this.mqttPassword = mqttPassword;
	}

	public Point getLedPlayroomT() {
		return ledPlayroomT;
	}

	public void setLedPlayroomT(Point ledPlayroomT) {
		this.ledPlayroomT = ledPlayroomT;
	}

	public Point getLedPlayroomB() {
		return ledPlayroomB;
	}

	public void setLedPlayroomB(Point ledPlayroomB) {
		this.ledPlayroomB = ledPlayroomB;
	}

	public Point getLedGroundT() {
		return ledGroundT;
	}

	public void setLedGroundT(Point ledGroundT) {
		this.ledGroundT = ledGroundT;
	}

	public Point getLedGroundB() {
		return ledGroundB;
	}

	public void setLedGroundB(Point ledGroundB) {
		this.ledGroundB = ledGroundB;
	}

	public Point getLedFloorT() {
		return ledFloorT;
	}

	public void setLedFloorT(Point ledFloorT) {
		this.ledFloorT = ledFloorT;
	}

	public Point getLedFloorB() {
		return ledFloorB;
	}

	public void setLedFloorB(Point ledFloorB) {
		this.ledFloorB = ledFloorB;
	}

	public Point getLedBoilerT() {
		return ledBoilerT;
	}

	public void setLedBoilerT(Point ledBoilerT) {
		this.ledBoilerT = ledBoilerT;
	}

	public Point getLedBoilerB() {
		return ledBoilerB;
	}

	public void setLedBoilerB(Point ledBoilerB) {
		this.ledBoilerB = ledBoilerB;
	}

	public Point getCmdPlayroomT() {
		return cmdPlayroomT;
	}

	public void setCmdPlayroomT(Point cmdPlayroomT) {
		this.cmdPlayroomT = cmdPlayroomT;
	}

	public Point getCmdPlayroomB() {
		return cmdPlayroomB;
	}

	public void setCmdPlayroomB(Point cmdPlayroomB) {
		this.cmdPlayroomB = cmdPlayroomB;
	}

	public Point getCmdGroundT() {
		return cmdGroundT;
	}

	public void setCmdGroundT(Point cmdGroundT) {
		this.cmdGroundT = cmdGroundT;
	}

	public Point getCmdGroundB() {
		return cmdGroundB;
	}

	public void setCmdGroundB(Point cmdGroundB) {
		this.cmdGroundB = cmdGroundB;
	}

	public Point getCmdFloorT() {
		return cmdFloorT;
	}

	public void setCmdFloorT(Point cmdFloorT) {
		this.cmdFloorT = cmdFloorT;
	}

	public Point getCmdFloorB() {
		return cmdFloorB;
	}

	public void setCmdFloorB(Point cmdFloorB) {
		this.cmdFloorB = cmdFloorB;
	}

	public Point getSample1() {
		return sample1;
	}

	public void setSample1(Point sample1) {
		this.sample1 = sample1;
	}

	public Point getSample2() {
		return sample2;
	}

	public void setSample2(Point sample2) {
		this.sample2 = sample2;
	}

	public Point getSample3() {
		return sample3;
	}

	public void setSample3(Point sample3) {
		this.sample3 = sample3;
	}

	public Point getSample4() {
		return sample4;
	}

	public void setSample4(Point sample4) {
		this.sample4 = sample4;
	}

	public Point getSample5() {
		return sample5;
	}

	public void setSample5(Point sample5) {
		this.sample5 = sample5;
	}

	public double getThresholdLed() {
		return thresholdLed;
	}

	public void setThresholdLed(double thresholdLed) {
		this.thresholdLed = thresholdLed;
	}

	public double getThresholdCmd() {
		return thresholdCmd;
	}

	public void setThresholdCmd(double thresholdCmd) {
		this.thresholdCmd = thresholdCmd;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public int getSampleSize() {
		return sampleSize;
	}

	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	public String getMqttTopic() {
		return mqttTopic;
	}

	public void setMqttTopic(String mqttTopic) {
		this.mqttTopic = mqttTopic;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public Point getLedStatusT() {
		return ledStatusT;
	}

	public void setLedStatusT(Point ledStatusT) {
		this.ledStatusT = ledStatusT;
	}

	public Point getLedStatusB() {
		return ledStatusB;
	}

	public void setLedStatusB(Point ledStatusB) {
		this.ledStatusB = ledStatusB;
	}

	public Point getLedPumpT() {
		return ledPumpT;
	}

	public void setLedPumpT(Point ledPumpT) {
		this.ledPumpT = ledPumpT;
	}

	public Point getLedPumpB() {
		return ledPumpB;
	}

	public void setLedPumpB(Point ledPumpB) {
		this.ledPumpB = ledPumpB;
	}
}
