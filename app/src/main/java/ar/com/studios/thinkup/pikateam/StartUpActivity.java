package ar.com.studios.thinkup.pikateam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.facebook.FacebookSdk;

import bolts.AppLinks;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);

        ImageView go = (ImageView) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartUpActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });

        FacebookSdk.sdkInitialize(getApplicationContext());
        Uri targetUrl = AppLinks.getTargetUrlFromInboundIntent(this, getIntent());
        if (targetUrl != null) {
            Log.i("Activity", "App Link Target URL: " + targetUrl.toString());
        }
    }
}
