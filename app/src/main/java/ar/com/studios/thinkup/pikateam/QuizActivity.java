package ar.com.studios.thinkup.pikateam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ar.com.studios.thinkup.pikateam.utils.Question;
import ar.com.studios.thinkup.pikateam.utils.Questions;
import ar.com.studios.thinkup.pikateam.utils.TeamEnum;

public class QuizActivity extends AppCompatActivity {

    private Questions questions;

    private Question current;
    protected Map<Integer, TeamEnum> options;
    protected Map<TeamEnum, Integer> score;

    protected ImageView optionView1;
    protected ImageView optionView2;
    protected ImageView optionView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (options == null) {
            options = new HashMap<>();
        }
        if (score == null) {
            score = new HashMap<>();
            score.put(TeamEnum.INSTINCT, 0);
            score.put(TeamEnum.VALOR, 0);
            score.put(TeamEnum.MYSTIC, 0);
            score.put(TeamEnum.NEUTRAL, 0);
        }

        this.questions = new Questions(this);
        setContentView(R.layout.activity_quiz);
        if (this.current == null) {
            this.current = questions.getFirst();
        }

        updateQuestion();

        ImageView go = (ImageView) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (options.containsKey(current.getNumeroPregunta())) {
                    if (questions.getQuestionsCount() - 1 > current.getNumeroPregunta()) {
                        score.put(options.get(current.getNumeroPregunta()), (score.get(options.get(current.getNumeroPregunta())) + 1));
                        current = questions.getNextQuestion(current.getNumeroPregunta());
                        updateQuestion();
                    } else {
                        goToResults();
                    }
                }
            }
        });
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void goToResults() {
        Intent i = new Intent(QuizActivity.this, QuizResults.class);
        Bundle b = new Bundle();
        b.putSerializable("TEAM", getWinningTeam());
        i.putExtras(b);
        startActivity(i);
        finish();
    }

    private Serializable getWinningTeam() {
        TeamEnum winner = null;
        for (Map.Entry<TeamEnum, Integer> item : this.score.entrySet()) {
            if (winner == null) {
                winner = item.getKey();
            } else {
                if (score.get(winner) < item.getValue()) {
                    winner = item.getKey();
                }
            }

        }

        return winner;
    }

    private void updateQuestion() {

        TextView tQ = (TextView) findViewById(R.id.question);
        if (tQ != null) {
            tQ.setText(current.getQuestion());
        }
        TextView tQop1 = (TextView) findViewById(R.id.txtOp1);
        if (tQop1 != null) {
            tQop1.setText(current.getAnswers().get(0).getResponse());
        }
        TextView tQop2 = (TextView) findViewById(R.id.txtOp2);
        if (tQop2 != null) {
            tQop2.setText(current.getAnswers().get(1).getResponse());
        }
        TextView tQop3 = (TextView) findViewById(R.id.txtOp3);
        if (tQop3 != null) {
            tQop3.setText(current.getAnswers().get(2).getResponse());
        }

        optionView1 = (ImageView) findViewById(R.id.opt1Img);
        optionView1.setImageResource(R.drawable.white_pokeball);
        optionView2 = (ImageView) findViewById(R.id.opt2Img);
        optionView2.setImageResource(R.drawable.white_pokeball);
        optionView3 = (ImageView) findViewById(R.id.opt3Img);
        optionView3.setImageResource(R.drawable.white_pokeball);

        LinearLayout option1 = (LinearLayout) findViewById(R.id.option1);
        option1.setOnClickListener(new OnOptionClickListener(this.current.getAnswers().get(0).getTeam(), 1));
        LinearLayout option2 = (LinearLayout) findViewById(R.id.option2);
        option2.setOnClickListener(new OnOptionClickListener(this.current.getAnswers().get(1).getTeam(), 2));
        LinearLayout option3 = (LinearLayout) findViewById(R.id.option3);
        option3.setOnClickListener(new OnOptionClickListener(this.current.getAnswers().get(2).getTeam(), 3));
    }

    class OnOptionClickListener implements View.OnClickListener {
        private TeamEnum team;
        private Integer option;

        public OnOptionClickListener(TeamEnum team, Integer option) {
            this.team = team;
            this.option = option;
        }

        @Override
        public void onClick(View v) {
            QuizActivity.this.options.put(QuizActivity.this.current.getNumeroPregunta(), this.team);
            QuizActivity.this.selectOption(this.option);
        }
    }

    private void selectOption(Integer option) {
        switch (option) {
            case 1:
                this.optionView1.setImageResource(R.drawable.color_pokeball);
                this.optionView2.setImageResource(R.drawable.white_pokeball);
                this.optionView3.setImageResource(R.drawable.white_pokeball);
                break;
            case 2:
                this.optionView1.setImageResource(R.drawable.white_pokeball);
                this.optionView2.setImageResource(R.drawable.color_pokeball);
                this.optionView3.setImageResource(R.drawable.white_pokeball);
                break;
            case 3:
                this.optionView1.setImageResource(R.drawable.white_pokeball);
                this.optionView2.setImageResource(R.drawable.white_pokeball);
                this.optionView3.setImageResource(R.drawable.color_pokeball);
                break;
        }

    }

}
