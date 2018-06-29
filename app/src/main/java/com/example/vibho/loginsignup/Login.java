package com.example.vibho.loginsignup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.button4);
        final SharedPreferences preferences = getSharedPreferences("Preference",0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText uname = findViewById(R.id.uname);
                EditText pwd = findViewById(R.id.pwd);

                String verify = preferences.getString(uname.getText().toString(),"pwd");

                Log.i("shared",verify);

                if(pwd.getText().toString().equals(verify))
                {
                    Intent intent = new Intent(Login.this,Success.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this,"Your details do not match!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
