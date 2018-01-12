package id.go.bpkp.mobilemapbpkp;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String LOGGED_USER = "id.go.bpkp.mobilemapbpkp.extra.LOGGEDUSER";

    EditText usernameInput;
    String username;
    EditText passwordInput;
    String password;
    ImageButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        usernameInput = (EditText) findViewById(R.id.username_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        loginButton = (ImageButton) findViewById(R.id.login_image_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username != ""){
                    Intent i = new Intent (LoginActivity.this, DashboardActivity.class);
                    username = usernameInput.getText().toString();
                    i.putExtra(LOGGED_USER, username);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Masukkan user name Anda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}