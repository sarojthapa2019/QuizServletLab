package edu.mum.cs.wap.model;

import java.util.Random;

public class Quiz {
    String question;
    String answer;


    public Quiz(String question, String answer){
        this.question = question;
        this.answer = answer;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    public boolean checkQuiz(String answer){
        return this.answer.equals(answer);

        }

    }



