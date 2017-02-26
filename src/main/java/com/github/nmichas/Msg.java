package com.github.nmichas;


public class Msg {
	private boolean ledPlayroom;
	private boolean ledGround;
	private boolean ledFloor;
	private boolean ledBoiler;
	private boolean ledStatus;
	private boolean ledPump;

	private boolean cmdPlayroom;
	private boolean cmdGround;
	private boolean cmdFloor;

	private double ledPlayroomVal;
	private double ledGroundVal;
	private double ledFloorVal;
	private double ledBoilerVal;
	private double ledStatusVal;
	private double ledPumpVal;

	private double cmdPlayroomVal;
	private double cmdGroundVal;
	private double cmdFloorVal;
	private double ambientVal;

	public boolean isLedPlayroom() {
		return ledPlayroom;
	}

	public void setLedPlayroom(boolean ledPlayroom) {
		this.ledPlayroom = ledPlayroom;
	}

	public boolean isLedGround() {
		return ledGround;
	}

	public void setLedGround(boolean ledGround) {
		this.ledGround = ledGround;
	}

	public boolean isLedFloor() {
		return ledFloor;
	}

	public void setLedFloor(boolean ledFloor) {
		this.ledFloor = ledFloor;
	}

	public boolean isLedBoiler() {
		return ledBoiler;
	}

	public void setLedBoiler(boolean ledBoiler) {
		this.ledBoiler = ledBoiler;
	}

	public boolean isCmdPlayroom() {
		return cmdPlayroom;
	}

	public void setCmdPlayroom(boolean cmdPlayroom) {
		this.cmdPlayroom = cmdPlayroom;
	}

	public boolean isCmdGround() {
		return cmdGround;
	}

	public void setCmdGround(boolean cmdGround) {
		this.cmdGround = cmdGround;
	}

	public boolean isCmdFloor() {
		return cmdFloor;
	}

	public void setCmdFloor(boolean cmdFloor) {
		this.cmdFloor = cmdFloor;
	}

	public double getLedPlayroomVal() {
		return ledPlayroomVal;
	}

	public void setLedPlayroomVal(double ledPlayroomVal) {
		this.ledPlayroomVal = ledPlayroomVal;
	}

	public double getLedGroundVal() {
		return ledGroundVal;
	}

	public void setLedGroundVal(double ledGroundVal) {
		this.ledGroundVal = ledGroundVal;
	}

	public double getLedFloorVal() {
		return ledFloorVal;
	}

	public void setLedFloorVal(double ledFloorVal) {
		this.ledFloorVal = ledFloorVal;
	}

	public double getLedBoilerVal() {
		return ledBoilerVal;
	}

	public void setLedBoilerVal(double ledBoilerVal) {
		this.ledBoilerVal = ledBoilerVal;
	}

	public double getCmdPlayroomVal() {
		return cmdPlayroomVal;
	}

	public void setCmdPlayroomVal(double cmdPlayroomVal) {
		this.cmdPlayroomVal = cmdPlayroomVal;
	}

	public double getCmdGroundVal() {
		return cmdGroundVal;
	}

	public void setCmdGroundVal(double cmdGroundVal) {
		this.cmdGroundVal = cmdGroundVal;
	}

	public double getCmdFloorVal() {
		return cmdFloorVal;
	}

	public void setCmdFloorVal(double cmdFloorVal) {
		this.cmdFloorVal = cmdFloorVal;
	}

	public double getAmbientVal() {
		return ambientVal;
	}

	public void setAmbientVal(double ambientVal) {
		this.ambientVal = ambientVal;
	}

	public boolean isLedStatus() {
		return ledStatus;
	}

	public void setLedStatus(boolean ledStatus) {
		this.ledStatus = ledStatus;
	}

	public boolean isLedPump() {
		return ledPump;
	}

	public void setLedPump(boolean ledPump) {
		this.ledPump = ledPump;
	}

	public double getLedStatusVal() {
		return ledStatusVal;
	}

	public void setLedStatusVal(double ledStatusVal) {
		this.ledStatusVal = ledStatusVal;
	}

	public double getLedPumpVal() {
		return ledPumpVal;
	}

	public void setLedPumpVal(double ledPumpVal) {
		this.ledPumpVal = ledPumpVal;
	}
}
