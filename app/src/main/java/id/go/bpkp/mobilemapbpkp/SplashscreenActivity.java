package id.go.bpkp.mobilemapbpkp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity {
    //Set waktu lama splashscreen
    private static int splashInterval = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);

        ImageView splashBottom, splashLogo;
        Animation downtoup, uptodown;
        TextView splashTitle;

        splashBottom = (ImageView) findViewById(R.id.splash_bottom);
        splashLogo = (ImageView) findViewById(R.id.splash_logo) ;
        splashTitle = (TextView) findViewById(R.id.splash_title);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        splashBottom.setAnimation(downtoup);
        splashLogo.setAnimation(uptodown);
        splashTitle.setAnimation(downtoup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                startActivity(new Intent(SplashscreenActivity.this,LoginActivity.class));
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub
            }
        }, splashInterval);
    }
}
