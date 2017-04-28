package tz.challenge;

public class Elevator {

	private int elevatorId;
	private int currentFloor;
	private int numberOfTrips;
	private int numberOfFloors;
	private boolean occupied;
	private ElevatorDoor door;

	public Elevator(int elevatorId) {
		this.elevatorId = elevatorId;
		this.door = new ElevatorDoor();
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
		reportCurrentFloor();
		addToNumberOfFloors();
	}

	public void moveDown() {
		currentFloor--;
		reportCurrentFloor();
		addToNumberOfFloors();
	}

	public boolean isOpen() {
		return door.isOpen();
	}

	public void closeDoors() {
		door.setOpen(false);
	}

	public void openDoors() {
		door.setOpen(false);
	}

	public void reportCurrentFloor() {
		System.out.println("Elevator " + getElevatorId() + " current floor: " + currentFloor);
	}
	

	public void reportForDoors() {
		System.out.println("Elevator " + getElevatorId() + " doors are: " + (isOpen() ? "Yes" : "No"));
	}
}
