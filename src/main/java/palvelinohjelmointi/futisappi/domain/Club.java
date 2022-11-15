package palvelinohjelmointi.futisappi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Club {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clubId;
	
	//atribuutti
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
	private List<Player> players;
	
	//parametritön konstruktori
	public Club() {}
	
	
	//konstruktori
	public Club(String name) {
		super();
		this.name = name;
	}
	
	//getterit setterit

	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long id) {
		this.clubId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	//toString

	@Override
	public String toString() {
		return "Club [id=" + clubId + ", name=" + name + "]";
	}
}
