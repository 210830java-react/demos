package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Quiz;
import org.springframework.stereotype.Repository;

//@Repository is optional since Spring Data will automatically detect extensions of JpaRepository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
