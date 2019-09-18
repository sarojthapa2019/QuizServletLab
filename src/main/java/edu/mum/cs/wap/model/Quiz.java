package edu.mum.cs.wap.model;

import edu.mum.cs.wap.dataaccess.DbSimulator;

import java.util.Random;

public class Quiz {
    String question;
    String answer;
    int score = 0;

    public Quiz(String question, String answer){
        this.question = question;
        this.answer = answer;

    }
    public Quiz(){

    }

    private static String[] questions = {
            "3, 1, 4, 1, 5", //pi
            "1, 1, 2, 3, 5" , // fibonacci
            "1, 4, 9, 16, 25", //square
            "2, 3, 5 , 7, 11", //primes
            "1, 2, 4, 8, 16" //power of2
    };
    private static int[] answers = {9,8,36,13,32};

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addScore(){
       this.score = this.score + 1;
    }

    public void checkQuiz(){
        for(int i = 0; i<questions.length; i++){
          if(questions[i].equals(this.question) && Integer.parseInt(this.answer)==(answers[i])){
              addScore();
          }

        }

    }
    public  String getRandomQuestion(){
        Random r = new Random();
        int random = r.nextInt(questions.length);
        return questions[random];
    }



}
