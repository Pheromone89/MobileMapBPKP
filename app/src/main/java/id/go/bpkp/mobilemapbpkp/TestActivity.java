package id.go.bpkp.mobilemapbpkp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent i = getIntent();
        String nice = i.getStringExtra(LoginActivity.LOGGED_USER);

        message = (TextView) findViewById(R.id.text_view);
        message.setText(nice);

    }
}
