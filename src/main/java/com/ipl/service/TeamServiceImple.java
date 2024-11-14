package com.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.custom_exceptions.ResourceNotFoundException;
import com.ipl.dao.TeamDao;
import com.ipl.pojos.Team;

@Service
public class TeamServiceImple implements TeamService {
	
	//dependency - Dao layer's TeamDao
	@Autowired
	private TeamDao teamDao; 
	

	@Override
	public String addNewTeam(Team team) {
		teamDao.save(team);
		return "new category added with id: " + team.getId();
	}


	@Override
	public List<Team> getAllTeams() {	
		//
		return teamDao.findAll();
	}


	@Override
	public String updateTeam(Long teamId, Team team) {
		if (teamDao.existsById(teamId)) {
			//save() internally fires insert | update based on whether the entity is transient or detached
			teamDao.save(team);
			return "team details updated successfully!!";
		}
		throw new ResourceNotFoundException("Invalid team id");
	}


	@Override
	public String deleteTeam(Long teamId) {
		if(teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			return "Deleted team successfully!!";
		}
		throw new ResourceNotFoundException("No team with team id "+ teamId);
	}


	@Override
	public List<Team> getTeamByWicketsAndBatAvg(int wickets, double average) {
		List<Team> fetchedTeams = teamDao.getTeamsByWicketsNAvg(wickets, average);
		
		return fetchedTeams;
	}

}
