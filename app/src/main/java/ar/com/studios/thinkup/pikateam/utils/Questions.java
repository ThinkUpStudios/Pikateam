package ar.com.studios.thinkup.pikateam.utils;

import android.content.Context;

import java.util.List;
import java.util.Vector;

import ar.com.studios.thinkup.pikateam.R;

/**
 * Created by Facundo on 15/07/2016.
 */

public class Questions {

    public Questions(Context c){

        List<Response> options;
        Question q;

        q = new Question();
        q.setNumeroPregunta(0);
        q.setQuestion(c.getString(R.string.question1));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q1o1),TeamEnum.MYSTIC));
        options.add(new Response(2,c.getString(R.string.q1o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q1o3),TeamEnum.INSTINCT));
        q.setAnswers(options);
        this.addQuestion(q);


        q = new Question();
        q.setNumeroPregunta(1);
        q.setQuestion(c.getString(R.string.question2));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q2o1),TeamEnum.MYSTIC));
        options.add(new Response(2,c.getString(R.string.q2o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q2o3),TeamEnum.INSTINCT));
        q.setAnswers(options);
        this.addQuestion(q);


        q = new Question();
        q.setNumeroPregunta(2);
        q.setQuestion(c.getString(R.string.question3));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q3o1),TeamEnum.VALOR));
        options.add(new Response(2,c.getString(R.string.q3o2),TeamEnum.MYSTIC));
        options.add(new Response(3,c.getString(R.string.q3o3),TeamEnum.INSTINCT));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(3);
        q.setQuestion(c.getString(R.string.question4));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q4o1),TeamEnum.INSTINCT));
        options.add(new Response(2,c.getString(R.string.q4o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q4o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(4);
        q.setQuestion(c.getString(R.string.question5));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q5o1),TeamEnum.NEUTRAL));
        options.add(new Response(2,c.getString(R.string.q5o2),TeamEnum.NEUTRAL));
        options.add(new Response(3,c.getString(R.string.q5o3),TeamEnum.NEUTRAL));
        q.setAnswers(options);
        this.addQuestion(q);


        q = new Question();
        q.setNumeroPregunta(5);
        q.setQuestion(c.getString(R.string.question6));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q6o3),TeamEnum.INSTINCT));
        options.add(new Response(2,c.getString(R.string.q6o1),TeamEnum.MYSTIC));
        options.add(new Response(3,c.getString(R.string.q6o2),TeamEnum.VALOR));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(6);
        q.setQuestion(c.getString(R.string.question7));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q7o1),TeamEnum.VALOR));
        options.add(new Response(2,c.getString(R.string.q7o2),TeamEnum.INSTINCT));
        options.add(new Response(3,c.getString(R.string.q7o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(7);
        q.setQuestion(c.getString(R.string.question8));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q8o1),TeamEnum.VALOR));
        options.add(new Response(2,c.getString(R.string.q8o2),TeamEnum.INSTINCT));
        options.add(new Response(3,c.getString(R.string.q8o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);


        q = new Question();
        q.setNumeroPregunta(8);
        q.setQuestion(c.getString(R.string.question9));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q9o1),TeamEnum.INSTINCT));
        options.add(new Response(2,c.getString(R.string.q9o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q9o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(9);
        q.setQuestion(c.getString(R.string.question10));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q10o1),TeamEnum.MYSTIC));
        options.add(new Response(2,c.getString(R.string.q10o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q10o3),TeamEnum.INSTINCT));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(10);
        q.setQuestion(c.getString(R.string.question11));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q11o1),TeamEnum.INSTINCT));
        options.add(new Response(2,c.getString(R.string.q11o2),TeamEnum.VALOR));
        options.add(new Response(3,c.getString(R.string.q11o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);

        q = new Question();
        q.setNumeroPregunta(11);
        q.setQuestion(c.getString(R.string.question12));
        options = new Vector<>();
        options.add(new Response(1,c.getString(R.string.q12o1),TeamEnum.VALOR));
        options.add(new Response(2,c.getString(R.string.q12o2),TeamEnum.INSTINCT));
        options.add(new Response(3,c.getString(R.string.q12o3),TeamEnum.MYSTIC));
        q.setAnswers(options);
        this.addQuestion(q);

    }



    private List<Question> questions = new Vector<>();
    private Integer current = -1;

    public void addQuestion(Question q) {
        this.questions.add(q);

    }

    public Integer getQuestionsCount(){
        return this.questions.size();
    }


    public Question getNextQuestion(Integer current) {
        if (current + 1 >= this.questions.size()) {
            return this.questions.get(current);
        }
        if (this.questions.get(current + 1) != null) {
            return this.questions.get(current + 1);
        } else {
            if (this.questions.size() > 0) {
                return this.questions.get(0);
            } else {
                return null;
            }
        }

    }

    public Question getFirst() {
        return this.questions.get(0);
    }
}
