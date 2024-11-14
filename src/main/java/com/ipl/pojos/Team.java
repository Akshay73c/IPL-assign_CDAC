package com.ipl.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//id , name, abbreviation,owner,max_age,batting_avg,wickets_taken
//one , parent, inverse
@Entity
@Table(name = "teams")
@NoArgsConstructor
@Getter
@Setter
public class Team extends BaseEntity {
	@Column(length = 100)
	private String name;
	
	@Column(length = 10)
	private String abbreviation;
	
	@Column(length = 20)
	private String owner;
	
	@Column(name = "max_age")
	private int maxAge;// max age of the player allowed in this team
	
	@Column(name = "batting_avg")
	private double battingAvg;
	
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	
	//teams : one , parent ,inverse(non owning side)
	//Team 1--->* Player
	
//	@OneToMany(mappedBy = "myTeam",
//			cascade = CascadeType.ALL,orphanRemoval = true) //o.w MappingException
//	private List<Player> players=new ArrayList<>();
	



	public Team(int teamId, String name, String abbreviation, String owner, int maxAge, double battingAvg,
			int wicketsTaken) {
		super();

		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}



	@Override
	public String toString() {
		return "Team [teamId=" + getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}

}
