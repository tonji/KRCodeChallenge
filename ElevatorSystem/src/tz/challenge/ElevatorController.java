package tz.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {

	private final static int MAX_TRIPS = 100;
	private final static int GROUND_FLOOR = 1;

	private List<Elevator> elevators;
	private Queue<TripRequest> requests;
	private int numOfFloors;

	public ElevatorController(int numberOfElevators, int numberOfFloors) {
		this.numOfFloors = numberOfFloors;
		this.elevators = new ArrayList<Elevator>();
		this.requests = new LinkedList<TripRequest>();
		initializeElevators(numberOfElevators);

	}

	public void addRequest(TripRequest request) {
		requests.add(request);
	}

	public TripRequest getNextRequest() {
		return requests.poll();
	}

	public void getNewRequest(Button button, Elevator elevator) {
		if (button instanceof FloorButton) {
			int requestedFloor = button.requestElevatorFloor();
			if (requestedFloor > numOfFloors || requestedFloor < GROUND_FLOOR) {
				// throw exception for invalid requests
			}
			TripRequest newRequest = new TripRequest(elevator.getCurrentFloor(), requestedFloor);
			addRequest(newRequest);
		}
	}

	public void processTripRequest() {
		TripRequest nextRequest = getNextRequest();
		Elevator closestElevator = findClosestElevator(nextRequest);

		int pickupFloor = nextRequest.getFloorFrom();
		int destinationFloor = nextRequest.getFloorTo();

		// go to pickup
		takeTrip(closestElevator, pickupFloor);
		// go to dropoff
		takeTrip(closestElevator, destinationFloor);
		closestElevator.openDoors();
		closestElevator.closeDoors();
		closestElevator.addToNumberOfTrips();		
	}

	private void takeTrip(Elevator closestElevator, int requestedFloor) {
		int currentFloor = closestElevator.getCurrentFloor();
		
		if (currentFloor == requestedFloor) {
			return;
		}
		if (requestedFloor < currentFloor) {
			while (requestedFloor < currentFloor) {
				closestElevator.moveDown();
				currentFloor--;
			}
		} else if (requestedFloor > currentFloor) {
			while (requestedFloor > currentFloor) {
				closestElevator.moveUp();
				currentFloor++;
			}
		}
	}

	private Elevator findClosestElevator(TripRequest nextRequest) {
		Elevator elevator = elevators.get(0); // set first elevator as default
		int requestFloorPickup = nextRequest.getFloorFrom();
		int requestFloorDropOff = nextRequest.getFloorTo();
		for (Elevator closest : elevators) {
			if (closest.getNumberOfTrips() < MAX_TRIPS) {
				// an unoccupied elevator is already stopped at that floor
				if (requestFloorPickup == closest.getCurrentFloor() && !closest.isOccupied()) {
					elevator = closest;
					// occupied elevator is moving and will pass that floor on
					// its way
				} else if (closest.isOccupied()
						&& (isBetweenFloors(requestFloorPickup, closest.getCurrentFloor(), requestFloorDropOff))) {
					elevator = closest;

				} else if (!closest.isOccupied()) {
					elevator = closest;
				}
			}
		}
		nextRequest.setElevatorId(elevator.getElevatorId());
		return elevator;

	}

	private boolean isBetweenFloors(int requested, int from, int to) {
		return (from < requested && requested < to) || (to < requested && requested < from);
	}

	private void initializeElevators(int numberOfElevators) {
		for (int i = 0; i < numberOfElevators; i++) {
			elevators.add(new Elevator(i + 1));
		}
	}

}
