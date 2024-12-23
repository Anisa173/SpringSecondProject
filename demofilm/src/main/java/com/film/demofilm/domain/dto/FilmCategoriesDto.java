package com.film.demofilm.domain.dto;

public class FilmCategoriesDto {

	private Integer idCtg;
	private String categoryName;
	private Integer adminId;
	private Long totalFilms;

	public FilmCategoriesDto() {
	}

	public FilmCategoriesDto(Integer idCtg, String categoryName, Integer adminId, Long totalFilms) {
		this.idCtg = idCtg;
		this.categoryName = categoryName;
		this.adminId = adminId;
		this.totalFilms = totalFilms;

	}

	public Integer getIdCtg() {
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

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Long getTotalFilms() {
		return totalFilms;
	}

	public void setTotalFilms(long totalFilms2) {
		this.totalFilms = totalFilms2;
	}

	public String toString() {
		return "FilmCategoriesDto[idCtg=" + idCtg + ",categoryName=" + categoryName + ",adminId=" + adminId
				+ ",totalFilms=" + totalFilms + "]";
	}

}
