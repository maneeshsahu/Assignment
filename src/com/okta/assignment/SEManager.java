package com.okta.assignment;

public class SEManager extends SETeamMember {
	boolean busy = false;
	
	public SEManager(String name) {
		super(name);
	}
	
	@Override
	public void handleMeeting(Customer customer) {
		System.out.println("handleMeeting: " + customer + ", " + toString());
		//busy = true;
	}

	@Override
	public boolean isBusy() {
		// Managers are never busy :)
		return busy;
	}

	@Override
	public void finishMeeting(Customer customer) {
		//busy = false;
	}
	
	@Override
	public String toString() {
		return "Manager" + super.toString();
	}

}
