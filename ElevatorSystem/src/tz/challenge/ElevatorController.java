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

	public void removeRequest(TripRequest request) {
		requests.remove();
	}

	public void getNewRequest(Button button, Elevator elevator) {
		if (button instanceof FloorButton) {
			TripRequest newRequest = new TripRequest(elevator.getCurrentFloor(), button.requestElevatorFloor());
			addRequest(newRequest);
		}
	}

	public void processTripRequest() {
		TripRequest nextRequest = requests.peek();
		Elevator closestElevator = findClosestElevator(nextRequest);
		nextRequest.setElevatorId(closestElevator.getElevatorId());

		int currentFloor = closestElevator.getCurrentFloor();
		int pickupFloor = nextRequest.getFloorFrom();
		int destinationFloor = nextRequest.getFloorTo();

		if (pickupFloor < currentFloor) {
			while (pickupFloor < currentFloor) {
				closestElevator.moveDown();
				currentFloor--;
			}
		} else if (pickupFloor > currentFloor) {
			while (pickupFloor > currentFloor) {
				closestElevator.moveUp();
				currentFloor--;
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
