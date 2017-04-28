package tz.challenge;

public class FloorButton extends Button {
	private int floor;

	public FloorButton(int floor) {
		this.floor = floor;
	}

	// request elevator from a floor
	@Override
	public int requestElevatorFloor() {
		return floor;
	}

}
