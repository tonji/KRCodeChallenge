package tz.challenge;

public abstract class Button {
	
	private boolean isPressed;

	public boolean isPressed() {
		return isPressed;
	}
	
	public abstract int requestElevatorFloor();
}
