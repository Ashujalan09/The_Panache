package com.example.thepanache;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends AndroidViewModel {

    LoginRepository loginRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    public void login(String email, String password){
        loginRepository.login(email,password);
    }
}
