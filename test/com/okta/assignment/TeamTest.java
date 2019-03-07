package com.okta.assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {
	
	private Team team;

	@Before
    public void setUp(  ) {
    	SEManager manager = new SEManager("alice");
        team = new Team(manager);
        
		SE se = new SE("bob", TeamRole.New);
		team.addSE(se);

		SE leadSe = new SE("charlie", TeamRole.Lead);
		team.addSE(leadSe);
    }


	@Test
	public void testHandleMeeting() {
		Customer customer1 = new Customer("Customer 1");
		
		SETeamMember handler = (SETeamMember) team.handleMeeting(customer1);
		assertEquals("bob", handler.name);
		
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 2"));
		assertEquals("charlie", handler.name);
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 3"));
		assertEquals("alice", handler.name);
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 4"));
		assertEquals("alice", handler.name);
	}

	@Test
	public void testHandleMeetings() {
		Customer customer1 = new Customer("Customer 1");
		
		SETeamMember handler = (SETeamMember) team.handleMeeting(customer1);
		assertEquals("bob", handler.name);
		((MeetingHandler) handler).finishMeeting(customer1);
		
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 2"));
		assertEquals("bob", handler.name);		
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 3"));
		assertEquals("charlie", handler.name);
		handler = (SETeamMember) team.handleMeeting(new Customer("Customer 4"));
		assertEquals("alice", handler.name);
	}
}