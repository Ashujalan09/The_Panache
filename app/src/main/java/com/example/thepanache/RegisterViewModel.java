package com.example.thepanache;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class RegisterViewModel extends AndroidViewModel {

    Context context;
    private LoginRepository loginRepository;
    private RegisterDetails registerDetails;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    public void register(String email,String password){
        loginRepository.register(email,password);
    }
}


