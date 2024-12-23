package com.film.demofilm.domain.dto;

public class ActorsDto {
	private Integer idAct;
	private String fullName;
	private String biography;
	private String imageUrl;
	private String grades;
	private Integer filmsId;
	private String filmTitle;
	private Long totalFilms;

	public ActorsDto() {
	}

	public ActorsDto(Integer idAct, String fullName, String biography, String imageUrl, String grades, Integer filmsId,
			String filmTitle, Long totalFilms) {
		this.idAct = idAct;
		this.fullName = fullName;
		this.biography = biography;
		this.imageUrl = imageUrl;
		this.grades = grades;
		this.filmsId = filmsId;
		this.filmTitle = filmTitle;
		this.totalFilms = totalFilms;

	}

	public Integer getIdAct() {
		return idAct;
	}

	public void setIdAct(Integer idAct) {
		this.idAct = idAct;
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

	public Integer getFilmsId() {
		return filmsId;
	}

	public void setFilmsId(Integer filmsId) {
		this.filmsId = filmsId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public Long getTotalFilms() {
		return totalFilms;
	}

	public void setTotalFilms(Long totalFilms2) {
		this.totalFilms = totalFilms2;
	}

	public String toString() {
		return "ActorsDto[idAct=" + idAct + ", fullName=" + fullName + ", biography=" + biography + ",imageUrl="
				+ imageUrl + ",grades=" + grades + ", filmsId=" + filmsId + ",filmTitle=" + filmTitle + ",totalFilms="
				+ totalFilms + "]";

	}

}
