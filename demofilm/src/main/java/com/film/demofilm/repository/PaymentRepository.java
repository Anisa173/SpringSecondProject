package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.demofilm.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,String>{

}
