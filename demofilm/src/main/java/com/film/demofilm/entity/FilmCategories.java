package com.film.demofilm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class FilmCategories extends BaseEntity<Integer> {
	@OneToMany(mappedBy = "filmCategory", cascade = CascadeType.ALL)
	private List<Films> film = new ArrayList<Films>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "adminId", referencedColumnName = "id")
	private User adm;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCtg;
	@Column(name = "categoryName")
	private String categoryName;

	public FilmCategories() {
		super();
	}

	public FilmCategories(String categoryName, List<Films> film, User adm) {
		super();
		this.categoryName = categoryName;
		this.film = film;
		this.adm = adm;
	}

	@Override
	public Integer getId() {

		return idCtg;
	}

	public void setIdCtg(Integer idCtg) {
		this.idCtg = idCtg;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public User getAdm() {
		return adm;
	}

	public void setAdm(User admin) {
		this.adm = admin;
	}
	public List<Films> getFilm() {
		return film;
	}

	public void setFilm(List<Films> fName) {
		this.film = fName;
	}
	
	
	public String toString() {
		return "FilmCategories[idCtg=" + idCtg + ",categoryName=" + categoryName + ",film=" + film + ", adm=" + adm + "]";
	}

}
