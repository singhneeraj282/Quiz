package com.app.tera.quizData.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "QUIZ")
public class Quiz {
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name="question")
    String question;
    @Column(name="option")
    String option;
}
