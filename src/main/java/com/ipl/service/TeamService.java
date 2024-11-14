package com.ipl.service;

import java.util.List;

import com.ipl.pojos.Team;

public interface TeamService {
	String addNewTeam(Team team);
	List<Team> getAllTeams();
	String updateTeam(Long teamId, Team team);
	String deleteTeam(Long teamId);
	List<Team> getTeamByWicketsAndBatAvg(int wickets, double average);

}
