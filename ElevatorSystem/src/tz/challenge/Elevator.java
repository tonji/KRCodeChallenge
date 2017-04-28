package tz.challenge;

public class Elevator {

	private int elevatorId;
	private int currentFloor;
	private int numberOfTrips;
	private int numberOfFloors;
	private boolean occupied;

	public Elevator(int elevatorId) {
		this.elevatorId = elevatorId;
	}

	public int getElevatorId() {
		return elevatorId;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getNumberOfTrips() {
		return numberOfTrips;
	}

	public void addToNumberOfTrips() {
		this.numberOfTrips++;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void addToNumberOfFloors() {
		this.numberOfFloors++;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void moveUp() {
		currentFloor++;
		addToNumberOfFloors();
	}
	
	public void moveDown() {
		currentFloor--;
		addToNumberOfFloors();
	}
}
