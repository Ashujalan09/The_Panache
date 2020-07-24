package com.example.thepanache;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel mViewModel;

    TextView textViewError;
    EditText  editTextPassword, editTextConfirmPassword,editTextEmail;
    Button button_register;
    ImageView loadErrorImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = (EditText) findViewById(R.id.email_ra1);
        textViewError =(TextView) findViewById(R.id.text_view_error_ra);
        editTextPassword = (EditText) findViewById(R.id.password_ra);
        editTextConfirmPassword = (EditText) findViewById(R.id.confirm_password_ra);
        button_register = (Button) findViewById(R.id.register_ra);
        loadErrorImage = (ImageView) findViewById(R.id.image_view_error_ra);


        mViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

    }


    public void registerUser(View view) {

        String email,password,confirmPassword;

        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        confirmPassword = editTextConfirmPassword.getText().toString();

        if (email=="" || password=="" || confirmPassword==""){
            textViewError.setText("Please enter all fields");
            loadErrorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);

        }

        if(!isValidEmail(email)){
            textViewError.setText("Enter a Valid Email");
            loadErrorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);
        }

        if (!password.equals(confirmPassword)){
            textViewError.setText("Confirm password does not match password, please check");
            loadErrorImage.setImageResource(R.drawable.ic_baseline_error_outline_24);
            Log.i("RegisterActivity","passwords not matching " + password + ":" + confirmPassword);
        }

        mViewModel.register(email,password);


    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}