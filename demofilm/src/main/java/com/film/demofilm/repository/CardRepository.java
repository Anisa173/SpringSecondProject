package com.film.demofilm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.demofilm.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
