package com.example.thepanache;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import ModelClassPackage.UserData;

public class LoginRepository {


    public Context context;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;
    FirebaseUser user;


    public LoginRepository(Application context) {
        this.context = context;
    }


    public void login(String Email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i("loginActivity", "login Successful");
                    FirebaseUser user = mAuth.getCurrentUser();
                    Intent intent = new Intent(context, MainActivity.class);
                    Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                } else {
                    Log.w("LoginActivity", "onComplete: ", task.getException());
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void register(String Email, String password){
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(Email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("registerActivity","register successful");
                            Toast.makeText(context,"registered",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, RegisterActivity2.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        }
                        else {
                            Log.w("RegisterActivity", "onComplete: ", task.getException());
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    public void setUserData(UserData userData){

        String FirstName;
        String LastName;
        String PhoneNumber;
        String Address;
        String Email;
        String UserId;

        UserId = userData.getUserId();

        db.collection("Users").document(UserId).set(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(context, MainActivity.class);
                        Log.i("RegisterActivity","Details stored Successfully");
                        Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("RegisterActivity","Error");
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                Log.w("RegisterActivity2", "onFailure: ", e.getCause() );
            }
        });

    }

    public LiveData<String> getName(){

        db = FirebaseFirestore.getInstance();

        String userId = mAuth.getCurrentUser().getUid();

        final LiveData<String> NameNavigationHeader = new MutableLiveData<>();

        db.collection("Users").document(userId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()) {
                    UserData details = documentSnapshot.toObject(UserData.class);
                }
                else {
                    UserData details = new UserData("Guest", "User", "null", "null", "null", "null");
                }
                }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("Navigation Header", "onFailure: ",e.getCause() );
            }
        });



    }



}
