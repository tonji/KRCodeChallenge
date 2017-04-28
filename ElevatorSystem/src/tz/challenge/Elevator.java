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
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public int getNumberOfTrips() {
		return numberOfTrips;
	}
	public void setNumberOfTrips(int numberOfTrips) {
		this.numberOfTrips = numberOfTrips;
	}
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public int getElevatorId() {
		return elevatorId;
	}
	
	
}
