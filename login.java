package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class login extends AppCompatActivity {
Button b1;
EditText ed1,ed2;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=findViewById(R.id.button);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText3);
        mAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=ed1.getText().toString();
                String pass=ed2.getText().toString();
                if(TextUtils.isEmpty(user)){
                    ed1.setError("Username is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    ed2.setError("Password is required");
                    return;
                }
                if(pass.length()<6){
                    ed2.setError("Password must be atleast 6 characters long");
                    return;
                }
                mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            startActivity(new Intent(getApplicationContext(), searchflight.class));
                            finish();
                        }
                        else{
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Toast.makeText(login.this,"Invalid username or password"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }});}}
