package com.app.tera.quizData.service;

import com.app.tera.quizData.dao.QuizDataRepository;
import com.app.tera.quizData.model.Quiz;
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
