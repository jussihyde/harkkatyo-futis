package palvelinohjelmointi.futisappi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity

public class Player {
	
	//jpa
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//atribuutit
	@NotEmpty
	private String name;
	@NotNull
	private Integer number;
	
	@ManyToOne
	@JoinColumn(name = "clubId")
	private Club club;
	
	@ManyToOne
	@JoinColumn(name = "posId")
	private Position position;
	
	//parametritön konstruktori
	public Player() {}
	
	//konstruktori
	public Player(String name, Integer number, Club club, Position position) {
		super();
		this.name = name;
		this.number = number;
		this.club = club;
		this.position = position;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	//toString

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", number=" + number + ", club=" + club + ", position="
				+ position + "]";
	}
}
