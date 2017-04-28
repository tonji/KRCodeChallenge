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
		requests.poll();
	}
	
	public void processTripRequest(int floorFrom, int floorTo) {
		TripRequest newRequest = new TripRequest(floorFrom, floorTo);
		addRequest(newRequest);
		
		Elevator closestElevator = findClosestElevator();
	}
	
	
	private Elevator findClosestElevator() {
		Elevator elevator = elevators.get(0);  //set first elevator as default
		
		return elevator;
		
	}

	private void initializeElevators(int numberOfElevators) {
		for (int i = 0; i < numberOfElevators; i++) {
			elevators.add(new Elevator(i + 1));
		}
	}
	
	

}
