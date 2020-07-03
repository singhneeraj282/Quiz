package com.app.tera.dao;

import com.app.tera.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface QuizDataRepository extends JpaRepository<Quiz,Long> {
}
