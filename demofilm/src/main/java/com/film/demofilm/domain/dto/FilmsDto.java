package com.film.demofilm.domain.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class FilmsDto {
	private Integer idFilm;

	private String filmTitle;

	private String description;

	private Date releaseDate;

	private String trialUrl;

	private String filmUrl;

	private String movieDuration;

	private BigDecimal onlineCost;

	private String filmSponsor;

	private Integer categoryId;

	private String categoryName;

	private Integer adminId;

	private Long totalActors;

	private Long totalSubscriptionFilms;

	public FilmsDto() {
	}

	public FilmsDto(Integer idFilm, String filmTitle, String description, Date releaseFilm, String trialUrl,
			String filmUrl, String movieDuration, BigDecimal onlineCost, String filmSponsor, Integer categoryId,
			String categoryName, Integer adminId, Long totalActors, Long sbcFilm) {
		this.idFilm = idFilm;
		this.filmTitle = filmTitle;
		this.description = description;
		this.releaseDate = releaseFilm;
		this.trialUrl = trialUrl;
		this.filmUrl = filmUrl;
		this.movieDuration = movieDuration;
		this.onlineCost = onlineCost;
		this.filmSponsor = filmSponsor;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.adminId = adminId;
		this.totalActors = totalActors;
		this.totalSubscriptionFilms = sbcFilm;

	}

	public Integer getIdFilm() {
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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

	public void setOnlineCost(BigDecimal onlineCost) {
		this.onlineCost = onlineCost;
	}

	public String getFilmSponsor() {
		return filmSponsor;
	}

	public void setFilmSponsor(String filmSponsor) {
		this.filmSponsor = filmSponsor;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Long getTotalActors() {
		return totalActors;
	}

	public void setTotalActors(Long totalActors2) {
		this.totalActors = totalActors2;
	}

	public Long getTotalSubscriptionFilms() {
		return totalSubscriptionFilms;
	}

	public void setTotalSubscriptionFilms(Long totalSubscriptionFilms) {
		this.totalSubscriptionFilms = totalSubscriptionFilms;
	}

	public String toString() {
		return "FilmsDto[idFilm =" + idFilm + ",filmTitle=" + filmTitle + ",description=" + description
				+ ",releaseDate=" + releaseDate + ",trialUrl=" + trialUrl + ",filmUrl=" + filmUrl + ",movieDuration="
				+ movieDuration + ",onlineCost=" + onlineCost + ",filmSponsor=" + filmSponsor + " ,categoryId="
				+ categoryId + ",categoryName=" + categoryName + ",adminId=" + adminId + ",totalActors=" + totalActors
				+ ",totalSubscriptionFilms=" + totalSubscriptionFilms + "  ]";

	}

}
