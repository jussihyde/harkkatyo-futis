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

public class Position {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//atribuutit
	private String name;
	
	//lyhenne
	private String pos;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "club")
	private List<Player> players;
	
	//parametritön konstruktori
	public Position() {}
	
	//konstruktori
	public Position(String name, String pos) {
		super();
		this.name = name;
		this.pos = pos;
	}
	
	//getterit ja setterit
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
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
		return "Position [id=" + id + ", name=" + name + ", pos=" + pos + "]";
	}	
}
