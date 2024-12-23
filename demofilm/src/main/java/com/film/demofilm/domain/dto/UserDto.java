package com.film.demofilm.domain.dto;


import com.film.demofilm.entity.UserLogin;
import com.film.demofilm.entity.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
	private Integer id;
	private String fullName;
	@NotBlank(message = " thomas.johnson125@icloud.com ")
	@NotNull(message = "It's required")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}")
	public String email;
	@NotNull(message = "It's required")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password should be at minimum with 8 characters ,which includes num ,upperCase and lowerCase letters and special characters")
	private String password;
	@NotBlank(message = "+355| 6000000000")
	@NotNull(message = " * Required *")
	private String telephoneNo;
	private String address;
	private String gender;
	private UserRole userRole;
	private String personalIdentityNo;
	@NotBlank(message = " 19 ")
	@NotNull(message = " * Required *")
	@Size(min = 18, message = "This should include always numbers with two characters")
	private Integer age;
	private Long totalFilms;
	private Long totalFilmCategories;
	private Long totalSubscribedFilm;
	private Long totalUserCards;
	private Long totalCarts;
	private Long totalCustomers;
	private Integer adminId;
	private UserLogin login;
	private Long totalPaymentMethods;

	public UserDto(Integer id, String fullName, String email, String password, String telephoneNo, String address,
			String gender, String personalIdentityNo, Integer age, UserRole userRole, Long totalFilms,
			Long totalFilmCategories, Long totalSubscribedFilm, Long totalUserCards, Long totalCarts,
			Long totalCustomers, Integer adminId, UserLogin login, Long totalPaymentMethods) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.telephoneNo = telephoneNo;
		this.address = address;
		this.gender = gender;
		this.personalIdentityNo = personalIdentityNo;
		this.age = age;
		this.userRole = userRole;
		this.totalFilms = totalFilms;
		this.totalFilmCategories = totalFilmCategories;
		this.totalSubscribedFilm = totalSubscribedFilm;
		this.totalUserCards = totalUserCards;
		this.setTotalCarts(totalCarts);
		this.setTotalCustomers(totalCustomers);
		this.setAdminId(adminId);
		this.login = login;
		this.setTotalPaymentMethods(totalPaymentMethods);
	}

	public UserDto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole2) {
		this.userRole = userRole2;
	}

	public String getPersonalIdentityNo() {
		return personalIdentityNo;
	}

	public void setPersonalIdentityNo(String personalIdentityNo) {
		this.personalIdentityNo = personalIdentityNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getTotalFilms() {
		return totalFilms;
	}

	public void setTotalFilms(Long totalFilms) {
		this.totalFilms = totalFilms;
	}

	public Long getTotalFilmCategories() {
		return totalFilmCategories;
	}

	public void setTotalFilmCategories(Long totalFilmCategories) {
		this.totalFilmCategories = totalFilmCategories;
	}

	public Long getTotalSubscribedFilm() {
		return totalSubscribedFilm;
	}

	public void setTotalSubscribedFilm(Long totalSubscribedFilm) {
		this.totalSubscribedFilm = totalSubscribedFilm;
	}

	public Long getTotalUserCards() {
		return totalUserCards;
	}

	public void setTotalUserCards(Long totalUserCards) {
		this.totalUserCards = totalUserCards;
	}

	public Long getTotalCarts() {
		return totalCarts;
	}

	public void setTotalCarts(Long totalCarts) {
		this.totalCarts = totalCarts;
	}

	public Long getTotalCustomers() {
		return totalCustomers;
	}

	public void setTotalCustomers(Long totalCustomers) {
		this.totalCustomers = totalCustomers;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}

	public Long getTotalPaymentMethods() {
		return totalPaymentMethods;
	}

	public void setTotalPaymentMethods(Long totalPaymentMethods) {
		this.totalPaymentMethods = totalPaymentMethods;
	}

	public String toString() {
		return "UserDto[id=" + id + ",fullName=" + fullName + ",email=" + email + ",password=" + password
				+ ",telephoneNo=" + telephoneNo + ",address=" + address + ",gender=" + gender + ",personalIdentityNo="
				+ personalIdentityNo + ",age=" + age + ",userRole=" + userRole + ",totalFilms=" + totalFilms
				+ ",totalFilmCategories=" + totalFilmCategories + ", totalSubscribedFilm=" + totalSubscribedFilm
				+ ", totalUserCards=" + totalUserCards + ",totalCarts=" + totalCarts + ",totalCustomers="
				+ totalCustomers + ",adminId=" + adminId + ",login=" + login + ",totalPaymentMethods="
				+ totalPaymentMethods + "]";
	}

}
