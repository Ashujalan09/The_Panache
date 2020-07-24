package com.example.thepanache;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import ModelClassPackage.UserData;


public class Register2ViewModel extends AndroidViewModel {

    LoginRepository loginRepository;

    public Register2ViewModel(@NonNull Application application) {
        super(application);
        loginRepository = new LoginRepository(application);
    }

    public void setUserData(UserData userData){
        loginRepository.setUserData(userData);
    }


}
