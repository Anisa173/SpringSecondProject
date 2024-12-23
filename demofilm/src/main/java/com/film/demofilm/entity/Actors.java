package com.film.demofilm.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actors")
public class Actors extends BaseEntity<Integer> {
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "movies", joinColumns = {
			@JoinColumn(name = "actoresId", referencedColumnName = "idAct") }, inverseJoinColumns = {
					@JoinColumn(name = "filmsId", referencedColumnName = "idFilm") })
	@JsonIgnoreProperties
	private List<Films> films = new ArrayList<Films>();

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAct;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "biography")
	private String biography;
	@Column(name = "imageUrl")
	private String imageUrl;
	@Column(name = "grades")
	private String grades;

	public Actors() {
		super();
	}

	public Actors(String fullName, String biography, String imageUrl, String grades, List<Films> films) {
		super();
		this.fullName = fullName;
		this.biography = biography;
		this.imageUrl = imageUrl;
		this.grades = grades;
		this.films = films;
	    
	}

	@Override
	public Integer getId() {
		return idAct;
	}

	public void setIdAct(Integer actorId) {
		this.idAct = actorId;

	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public List<Films> getFilms() {

		return films;
	}

	public void setFilms(List<Films> film) {
		this.films = film;
	}

	
	public String toString() {
		return "Actors[idAct=" + idAct + ",fullName=" + fullName + ",biography=" + biography + ",imgUrl=" + biography
				+ ",grades=" + grades + ",films=" + films + "]";
	}

}
