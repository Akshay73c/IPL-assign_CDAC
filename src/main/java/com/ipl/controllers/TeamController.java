package com.ipl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.dto.ApiResponse;
import com.ipl.pojos.Team;
import com.ipl.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	//dependency : TeamService
	@Autowired
	private TeamService teamService;
	
	//req-handling method to add a team
	/*
	 * url : http://host:port/team
	 * method : POST
	 * payload : json of team, so to do json->java : @RequestBody
	 * response : String (Team added/not added)
	 */
	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody Team team) {
		//Todo
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponse(teamService.addNewTeam(team)));
	}
	
	//getAllTeams
	@GetMapping
	public ResponseEntity<?> getAllTeams() {
		List<Team> fetchedTeams = teamService.getAllTeams();
		//if size=0 => no contents
		if(fetchedTeams.isEmpty()) {
			//send only status with no contents
			//build() method of BodyBuilder class
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(fetchedTeams);
//		or can also write in short as ResponseEntity.ok(fetchedTeams);
	}
	
	//update team by id and team
	@PutMapping("/{teamId}")
	public ResponseEntity<?> updateTeam(@PathVariable Long teamId, @RequestBody Team team) {
		
		return ResponseEntity.ok(new ApiResponse(teamService.updateTeam(teamId, team)));
	}
	
	//delete team by id
	@DeleteMapping("/{teamId}")
	public ResponseEntity<?> deleteTeam(@PathVariable Long teamId) {
		
		try {
			return ResponseEntity.ok(new ApiResponse(teamService.deleteTeam(teamId)));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	//get teams with wickets >= wickets specified and avg > avg
	@GetMapping("/criteria")
	public ResponseEntity<?> getTeamsByWicketsNAvg(@RequestParam int wickets, @RequestParam double avg){
		
		List<Team> fetchedTeams = teamService.getTeamByWicketsAndBatAvg(wickets, avg);
		if (fetchedTeams.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.ok(fetchedTeams);
		
	} 
	

}
