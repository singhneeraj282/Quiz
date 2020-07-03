package com.app.tera.service;

import com.app.tera.dao.QuizDataRepository;
import com.app.tera.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizDataService {
    @Autowired
    QuizDataRepository quizDataRepository;

    public Optional<Quiz> findById(Long id){
        return quizDataRepository.findById(id);
    }
}
