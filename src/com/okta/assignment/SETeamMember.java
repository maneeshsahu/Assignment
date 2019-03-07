package com.okta.assignment;

public abstract class SETeamMember implements MeetingHandler {
	protected String name;
	
	public SETeamMember(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "(" + name + ")";
	}
}
