package ar.com.studios.thinkup.pikateam;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import ar.com.studios.thinkup.pikateam.utils.TeamEnum;

public class QuizResults extends AppCompatActivity {
    private TeamEnum winner;
    CallbackManager callbackManager;
    ShareDialog shareDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_quiz_results);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
        winner = (TeamEnum) this.getIntent().getExtras().getSerializable("TEAM");
        if (winner != null) {
            ImageView winnImage = (ImageView) findViewById(R.id.winnerLogo);
            winnImage.setVisibility(View.INVISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.fadein);
            Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.fadein_no_scale);
            anim.setFillAfter(true);
            anim.setStartOffset(1000);
            anim2.setFillAfter(true);
            winnImage.setAnimation(anim);
            anim2.setStartOffset(1500);
            TextView winnName = (TextView) findViewById(R.id.team);
            winnName.setVisibility(View.INVISIBLE);

            winnName.setAnimation(anim2);



            switch (winner) {
                case MYSTIC:
                    winnImage.setImageResource(R.drawable.mystic);
                    winnName.setText("Mystic");
                    winnName.setTextColor(ContextCompat.getColor(this,R.color.articuno_blue));
                    break;
                case VALOR:
                    winnImage.setImageResource(R.drawable.valor);
                    winnName.setText("Valor");
                    winnName.setTextColor(ContextCompat.getColor(this,R.color.moltres_red));
                    break;
                case INSTINCT:
                    winnImage.setImageResource(R.drawable.instinct);
                    winnName.setText("Instinct");
                    winnName.setTextColor(ContextCompat.getColor(this,R.color.zapdos_yellow));
                    break;
            }
            TextView tShare = (TextView) findViewById(R.id.share);
            tShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri url = Uri.parse("");
                    String title = "";
                    String contentLink = "";
                    switch (winner) {

                        case MYSTIC:
                            url = Uri.parse("http://i.imgur.com/6ZHDTyK.png");
                            title = "Team Mystic";
                            contentLink = getString(R.string.mystic_desc);
                            break;
                        case VALOR:
                            url = Uri.parse("http://i.imgur.com/wAtP1SU.png");
                            title = "Team Valor";
                            contentLink = getString(R.string.valor_desc);
                            break;
                        case INSTINCT:
                            url = Uri.parse("http://i.imgur.com/B5Ab4BX.png");
                            title = "Team Instinct";
                            contentLink = getString(R.string.instinct_desc);

                            break;
                        case NEUTRAL:
                            break;
                    }
                    if (ShareDialog.canShow(ShareLinkContent.class)) {
                        ShareLinkContent content = new ShareLinkContent.Builder()
                                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                                .setImageUrl(url)
                                .setContentTitle(title)
                                .setContentDescription(contentLink)
                                .build();

                        shareDialog.show(content);
                    }
                }
            });

        }

    }

}
