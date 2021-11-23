package com.example.b07_project;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.b07_project.databinding.ActivitySignUpBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import encryption.MD5Encryption;

public class signUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }

    public void createAccount(View view){

        TextView emailText = findViewById(R.id.SignUpUserEmailAddress);
        TextView passwordText = findViewById(R.id.SignUpUserPassword);
        TextView confirmPasswordText = findViewById(R.id.signUpConfirmPassword);

        boolean passwordEqual = false;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();
        
        //https://www.javatpoint.com/java-email-validation
        String validEmail = ("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\" +
                ".[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");

        Pattern pattern = Pattern.compile(validEmail);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            emailText.setError("please enter a valid email address");

            return;
        }


        //TODO check if email is already in the account



        if (!password.equals(confirmPassword) ){
            confirmPasswordText.setError("does not equal password");
            confirmPasswordText.setText("");
            return;
        }

        if (password.equals("")){
            passwordText.setError("can not be empty");
            return;
        }


        MD5Encryption encrypt = new MD5Encryption();
        String encryptedPassword = encrypt.encrypt(password);

        //TODO add the encrypted password and email as a new account
    }
}