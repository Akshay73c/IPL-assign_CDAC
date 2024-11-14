package com.ipl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ipl.pojos.Team;

public interface TeamDao extends JpaRepository<Team, Long>{
	//get teams with wickets >= wickets specified and avg > avg
	@Query("select t from Team t where t.wicketsTaken >= :wickets and t.battingAvg > :avg")
	List<Team> getTeamsByWicketsNAvg(int wickets, double avg);
}
