package com.example.thepanache;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thepanache.R;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;
    Button register;
    TextView errorText;
    ImageView errorImage;

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        errorText = findViewById(R.id.text_view_error_login);
        errorImage = findViewById(R.id.image_view_error_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

    }



    public void intentRegisterUser(View view) {

        Log.i("register button pressed","do transfer");
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }


    public void loginUser(View view) {

        String emailId = email.getText().toString();

        String passwordId = password.getText().toString();

        if(emailId.equals("") || passwordId.equals("")){
            errorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);
            errorText.setText("Please enter all required details");
            return;
        }


        if(!isValidEmail(emailId)){
            errorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);
            errorText.setText("Enter a Valid Email");
            return;
        }

        if(passwordId.length()<6){
            errorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);
            errorText.setText("Minimum 6 digit password");
            return;
        }

        loginViewModel.login(emailId,passwordId);

    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}

