package com.example.thepanache;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ModelClassPackage.UserData;

public class RegisterActivity2 extends AppCompatActivity {

    EditText editTextFirstName, editTextLastName, editTextPhoneNumber, editTextAddress;
    Button buttonContinue;

    Register2ViewModel viewModel;
    FirebaseAuth mAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        editTextFirstName = (EditText) findViewById(R.id.first_name_ra2);
        editTextLastName = (EditText) findViewById(R.id.last_name_ra2);
        editTextPhoneNumber = (EditText) findViewById(R.id.phone_number_ra2);
        editTextAddress = (EditText) findViewById(R.id.address_ra2);
        buttonContinue = (Button) findViewById(R.id.continue_ra2);


        viewModel = new ViewModelProvider(this).get(Register2ViewModel.class);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();




        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName;
                String LastName;
                String PhoneNumber;
                String Address;
                String Email;
                String UserId;

                FirstName = editTextFirstName.getText().toString();
                LastName = editTextLastName.getText().toString();
                PhoneNumber = editTextPhoneNumber.getText().toString();
                Address = editTextAddress.getText().toString();
                Email = user.getEmail();
                UserId = user.getUid();

                UserData userData = new UserData(FirstName,LastName,PhoneNumber,Address,Email,UserId);

                viewModel.setUserData(userData);

            }
        });

    }
}