package ar.com.studios.thinkup.pikateam.utils;

import java.util.List;
import java.util.Vector;

/**
 * Created by Facundo on 15/07/2016.
 */

public class Question {

    private Integer numeroPregunta;
    private String question;
    private List<Response> answers = new Vector<>();

    public Integer getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(Integer numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Response> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Response> answers) {
        this.answers = answers;
    }

   }
