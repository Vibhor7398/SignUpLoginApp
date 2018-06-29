package com.example.vibho.loginsignup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final SharedPreferences preferences = this.getSharedPreferences("Preference", Context.MODE_PRIVATE);
        Button signup = findViewById(R.id.button3);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText uname = findViewById(R.id.uname);
                EditText pwd = findViewById(R.id.pwd);

                try {
                    preferences.edit().putString(uname.getText().toString(), pwd.getText().toString()).apply();
                }
                catch (Exception e)
                {
                    Toast.makeText(SignUp.this, "Unsuccessful", Toast.LENGTH_LONG).show();
                }

                Toast.makeText(SignUp.this,"User successfully created.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
