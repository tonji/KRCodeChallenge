package tz.challenge;

public class TripRequest {
	private int elevatorId;
	private int floorFrom;
	private int floorTo;

	public TripRequest(int floorFrom, int floorTo) {
		this.floorFrom = floorFrom;
		this.floorTo = floorTo;
	}
	
	public int getElevatorId() {
		return elevatorId;
	}

	public void setElevatorId(int elevatorId) {
		this.elevatorId = elevatorId;
	}

	public int getFloorFrom() {
		return floorFrom;
	}

	public void setFloorFrom(int floorFrom) {
		this.floorFrom = floorFrom;
	}

	public int getFloorTo() {
		return floorTo;
	}

	public void setFloorTo(int floorTo) {
		this.floorTo = floorTo;
	}

}
