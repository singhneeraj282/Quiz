package com.app.tera.quizData.dao;

import com.app.tera.quizData.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuizDataRepository extends JpaRepository<Quiz,Long> {
}
