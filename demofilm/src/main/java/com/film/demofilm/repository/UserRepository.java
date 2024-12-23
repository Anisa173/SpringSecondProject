package com.film.demofilm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.film.demofilm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	User createUserAccount(User entity);

	User updateUserAccount(User update);

	@Modifying
	@Query("Update User c Set deleted = true Where c.id IN( Select c.id ,a.id From User c INNER JOIN User adm ON adm.c.adminId = adm.id"
			+ "Where a.id =: id And c.id =: id )")
	void deleteCustomer(Integer id);

	@Query("Select c.id FROM User c INNER JOIN Cart cart ON c.cart.customerId = c.id Where c.id=:id")
	User findUserCartById(Integer id);

}
