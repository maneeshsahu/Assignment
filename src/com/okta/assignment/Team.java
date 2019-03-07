package com.okta.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Team {
	protected SEManager manager = null;
	protected SE leadSe = null;
	protected Queue<SE> freePool = new ArrayBlockingQueue<SE>(15);
	protected List<SE> busyPool = new ArrayList<SE>();
	
	public Team(SEManager manager) {
		this.manager = manager;
	}
	
	public void addSE(SE member) {
		member.setTeam(this);
		switch (member.getRole()) {
			case Lead:
				leadSe = member;
				break;
			case New:
			case Staff:
			case Architect:
				freePool.add(member);
				break;
			default:
				throw new IllegalArgumentException("Unknown role: " + member.getRole());
		}
	}
	
	public MeetingHandler handleMeeting(Customer customer) {
		MeetingHandler handler = null;
		if (freePool.peek() != null) {
			// Get from the free pool
			handler = freePool.remove();
			busyPool.add((SE) handler);
		} else {
			// Escalate to the Lead SE
			if (leadSe != null && !leadSe.isBusy()) {
				handler = leadSe;
			} else {
				// We dont care if the manager is busy
				handler = manager;
			}
		}
		
		handler.handleMeeting(customer);
		return handler;
	}
	
	public void finishMeeting(Customer customer, MeetingHandler handler) {
		// Return to free pool
		if (SE.class.isInstance(handler) && busyPool.contains(handler)) {
			busyPool.remove((SE) handler);
			freePool.add((SE) handler);
		}
	}
}