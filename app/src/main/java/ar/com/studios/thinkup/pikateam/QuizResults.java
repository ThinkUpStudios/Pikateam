package ar.com.studios.thinkup.pikateam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.studios.thinkup.pikateam.utils.TeamEnum;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        TeamEnum winner = (TeamEnum) this.getIntent().getExtras().getSerializable("TEAM");
        if(winner!=null){
            ImageView winnImage = (ImageView)findViewById(R.id.winnerLogo);
            TextView winnName = (TextView)findViewById(R.id.team);
            switch (winner) {
                case MYSTIC:
                    winnImage.setImageResource(R.drawable.mystic);
                    winnName.setText("Mystic");
                    break;
                case VALOR:
                    winnImage.setImageResource(R.drawable.valor);
                    winnName.setText("Valor");
                    break;
                case INSTINCT:
                    winnImage.setImageResource(R.drawable.instinct);
                    winnName.setText("Instinct");
                    break;
            }
            TextView tShare = (TextView)findViewById(R.id.share);
            tShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

        }

    }
}
