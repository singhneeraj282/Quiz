package com.app.tera.quizData.controller;

import com.app.tera.quizData.model.Quiz;
import com.app.tera.quizData.service.QuizDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/app/tera")
public class QuizDataController {

    @Autowired
    QuizDataService quizDataService;

    @GetMapping("/data")
    public ResponseEntity<String> getALlData(){
        return new ResponseEntity("hello", HttpStatus.OK);
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<Quiz> getALlData(@PathVariable Long id){
        return new ResponseEntity(quizDataService.findById(id).isPresent() ? quizDataService.findById(id).get(): null , HttpStatus.OK);
    }

}
