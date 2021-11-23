package com.example.b07_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import encryption.MD5Encryption;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loginAccount(View view){
        TextView emailText = (TextView) findViewById(R.id.userEmailAddress);
        TextView passwordText = (TextView) findViewById(R.id.userPassword);

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        MD5Encryption encrypt = new MD5Encryption();
        String encryptedPassword = encrypt.encrypt(password);

        //TODO check if encryptedPassword matches with data in the firebase, if yes go into the next page

        emailText.setText("");
        passwordText.setText("");

    }

    public void signupAccount(View view){

        Intent intent = new Intent(this, signUpActivity.class);

        startActivity(intent);
    }
}