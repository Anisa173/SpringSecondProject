package com.film.demofilm.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Films extends BaseEntity<Integer> {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", referencedColumnName = "idCtg")
	private FilmCategories filmCategory;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId", referencedColumnName = "id")
	private User admin;

	@ManyToMany(mappedBy = "films", cascade = CascadeType.ALL)
	@JsonIgnoreProperties
	private List<Actors> actors = new ArrayList<Actors>();

	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private List<SubscribedFilm> sbcFilm = new ArrayList<SubscribedFilm>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFilm;
	@Column(name = "filmTitle")
	private String filmTitle;
	@Column(name = "description")
	private String description;
	@Column(name = "releaseDate")
	private Date releaseDate;
	@Column(name = "trialUrl")
	private String trialUrl;
	@Column(name = "filmUrl")
	private String filmUrl;
	@Column(name = "movieDuration")
	private String movieDuration;
	@Column(name = "onlineCost")
	private BigDecimal onlineCost;
	@Column(name = "filmSponsor")
	private String filmSponsor;

	public Films() {
		super();
	}

	public Films(String filmTitle, String description, Date releaseFilm, String trialUrl, String filmUrl,
			String movieDuration, BigDecimal onlineTicketCost, String filmSponsor, FilmCategories filmCategory,
			User admin, List<Actors> actors, List<SubscribedFilm> sbcFilm) {
		super();
		this.filmTitle = filmTitle;
		this.description = description;
		this.setReleaseDate(releaseFilm);
		this.trialUrl = trialUrl;
		this.filmUrl = filmUrl;
		this.movieDuration = movieDuration;
		this.onlineCost = onlineTicketCost;
		this.filmSponsor = filmSponsor;
		this.filmCategory = filmCategory;
		this.admin = admin;
		this.actors = actors;
		this.sbcFilm = sbcFilm;

	}

	@Override
	public Integer getId() {

		return idFilm;
	}

	public void setIdFilm(Integer idFilm) {
		this.idFilm = idFilm;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrialUrl() {
		return trialUrl;
	}

	public void setTrialUrl(String trialUrl) {
		this.trialUrl = trialUrl;
	}

	public String getFilmUrl() {
		return filmUrl;
	}

	public void setFilmUrl(String filmUrl) {
		this.filmUrl = filmUrl;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public BigDecimal getOnlineCost() {
		return onlineCost;
	}

	public void setOnlineCost(BigDecimal onlineTicketCost) {
		this.onlineCost = onlineTicketCost;
	}

	public String getFilmSponsor() {
		return filmSponsor;
	}

	public void setFilmSponsor(String filmSponsor) {
		this.filmSponsor = filmSponsor;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public FilmCategories getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(FilmCategories fCategory) {
		this.filmCategory = fCategory;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}

	public List<SubscribedFilm> getSbcFilm() {
		return sbcFilm;
	}

	public void setSbcFilm(List<SubscribedFilm> sbcFilm) {
		this.sbcFilm = sbcFilm;
	}

	public String toString() {
		return "Films[idFilm = " + idFilm + ",filmTitle = " + filmTitle + ",description = " + description
				+ ",releaseDate = " + releaseDate + ",trialUrl = " + trialUrl + ",filmUrl = " + filmUrl
				+ ",movieDuration = " + movieDuration + ",onlineCost = " + onlineCost + ",filmSponsor = " + filmSponsor
				+ ",filmCategory=" + filmCategory + ",admin=" + admin + ",actors=" + actors + ",sbcFilm=" + sbcFilm
				+ "]";

	}

}
