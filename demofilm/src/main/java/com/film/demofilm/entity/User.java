package com.film.demofilm.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;

@Entity
public class User extends BaseEntity<Integer> implements UserDetails {

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Films> film = new ArrayList<Films>();

	@OneToMany(mappedBy = "adm", cascade = CascadeType.ALL)
	private List<FilmCategories> filmCategory = new ArrayList<FilmCategories>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<SubscribedFilm> subscFilm = new ArrayList<SubscribedFilm>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Card> cards = new ArrayList<Card>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Cart> carts = new ArrayList<Cart>();

	// Admin miremban te dhenat e userave te regjistruar
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<User> customer = new ArrayList<User>();

	// Shume usera 'vezhgohen' nga admini
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adminId", referencedColumnName = "id")
	private User admin;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserLogin login;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<PaymentMethods> pm = new ArrayList<PaymentMethods>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "telephoneNo")
	private String telephoneNo;
	@Column(name = "address")
	private String address;
	@Column(name = "gender")
	private String gender;
	@Column(name = "personalIdentityNo")
	private String personalIdentityNo;
	@Column(name = "age")
	private Integer age;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	private static final long serialVersionUID = 4002018166978171221L;

	public User() {
		super();
	}

	public User(String fullName, String email, String password, String telephoneNo, String address, String gender,
			String personalIdentityNo, Integer age, UserRole userRole, List<Films> film,
			List<FilmCategories> filmCategory, List<SubscribedFilm> subscFilm, List<Card> cards, List<Cart> carts,
			UserLogin login, List<User> customer, User admin, List<PaymentMethods> pm) {
		super();

		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.telephoneNo = telephoneNo;
		this.address = address;
		this.gender = gender;
		this.personalIdentityNo = personalIdentityNo;
		this.age = age;
		this.userRole = userRole;
		this.film = film;
		this.filmCategory = filmCategory;
		this.subscFilm = subscFilm;
		this.cards = cards;
		this.carts = carts;
		this.login = login;
		this.customer = customer;
		this.admin = admin;
		this.pm = pm;
	}

	@Override
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public List<Films> getFilm() {
		return film;
	}

	public void setFilm(List<Films> film) {
		this.film = film;
	}

	public List<FilmCategories> getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(List<FilmCategories> filmCategory) {
		this.filmCategory = filmCategory;
	}

	public List<SubscribedFilm> getSubscFilm() {
		return subscFilm;
	}

	public void setSubscFilm(List<SubscribedFilm> subscFilm) {
		this.subscFilm = subscFilm;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}

	public List<User> getCustomer() {
		return customer;
	}

	public void setCustomer(List<User> customer) {
		this.customer = customer;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public List<PaymentMethods> getPm() {
		return pm;
	}

	public void setPm(List<PaymentMethods> pm) {
		this.pm = pm;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(userRole.name().split(",")).map(SimpleGrantedAuthority::new).toList();
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return email;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	public String toString() {
		return "User[id=" + id + ",fullName=" + fullName + ",email=" + email + ",password=" + password + ",telephoneNo="
				+ telephoneNo + ",address=" + address + ",gender=" + gender + ",personalIdentityNo="
				+ personalIdentityNo + ", age=" + age + ",userRole=" + userRole + ", film=" + film + ",filmCategory="
				+ filmCategory + ",subscFilm=" + subscFilm + ",cards=" + cards + ",carts=" + carts + ",login=" + login
				+ ",customer=" + customer + ",admin=" + admin + ",pm=" + pm + "]";
	}

}
