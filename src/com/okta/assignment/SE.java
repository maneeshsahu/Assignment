package com.okta.assignment;

public class SE extends SETeamMember {
	protected Team team;
	protected TeamRole role;
	protected boolean busy = false;
	
	public SE(String name, TeamRole role) {
		super(name);
		this.role = role;
	}
	
	@Override
	public void handleMeeting(Customer customer) {
		System.out.println("handleMeeting: " + customer + ", " + toString());

		busy = true;
	}

	@Override
	public void finishMeeting(Customer customer) {
		busy = false;
		team.finishMeeting(customer, this);
	}

	@Override
	public boolean isBusy() {
		return busy;
	}
	
	public TeamRole getRole() {
		return role;
	}

	public void setRole(TeamRole role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "SE(" + super.name + ", " + role + ")";
	}
}
