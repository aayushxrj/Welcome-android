package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText text1,text2;
    Button login;
    ProgressBar loading;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();

        text1 = findViewById(R.id.editTextTextPersonName);
        text2 = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);
        loading = findViewById(R.id.loading);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this,HomePage.class) ;

                //countdown
                CountDownTimer count_login = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long l) {}

                    @Override
                    public void onFinish() {

                        startActivity(intent);
                        finish();

                    }
                };

                //code for buttonOnClickListener
                if(text1 != null && text1.getText().length() > 0 && text2 != null && text2.getText().length() > 0){
                    if(text1.getText().toString().equals("aayushxrj") && text2.getText().toString().equals("gungun")){
                        Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();

                        // for loading progress bar and redirecting
                        login.setVisibility(View.GONE);
                        loading.setVisibility(View.VISIBLE);
                        count_login.start();

                    }
                    else if(!text1.getText().toString().equals("aayushxrj")){
                        Toast.makeText(getApplicationContext(), "Username wrong!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Username or Password can't be blank", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}