package com.amarmane.pgfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amarmane.pgfinder.databinding.ActivitySignInBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(SignInActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("WLogin to your account");

        binding.btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(binding.txtemailid.getText().toString(),binding.txtpassword.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()){
                                    Intent intent = new Intent(SignInActivity.this ,MainActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        binding.txtcreatenewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this ,SignUpActivity.class);
                startActivity(intent);
            }
        });
        if (auth.getCurrentUser()!=null){
            Intent intent = new Intent(SignInActivity.this ,MainActivity.class);
            startActivity(intent);
        }
    }
}