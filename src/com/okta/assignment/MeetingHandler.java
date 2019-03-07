package com.okta.assignment;

public interface MeetingHandler {
	boolean isBusy();
	
	void handleMeeting(Customer customer);
	
	void finishMeeting(Customer customer);
}
