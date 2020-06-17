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

public class signup extends AppCompatActivity {
Button b2,b1;
EditText ed1,ed2,ed3,ed4;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        b2=findViewById(R.id.button2);
        b1=findViewById(R.id.button);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);
        ed4=findViewById(R.id.editText4);
        mAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=ed1.getText().toString();
                String email=ed2.getText().toString();
                String pass=ed3.getText().toString();
                String pass1=ed4.getText().toString();
                if(TextUtils.isEmpty(user)){
                   ed1.setError("Username is required");
                   return;
                }
                if(TextUtils.isEmpty(email)){
                    ed2.setError("Email is required");
                    return;
                }
                if(pass.length()<6){
                    ed3.setError("Password must be atleast 6 characters long");
                    return;
                }
                if(!pass.equals(pass1)){
                    ed4.setError("Password doesn't match");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this,"Account created",Toast.LENGTH_LONG).show();
                        }
                        else{
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Toast.makeText(signup.this,"Couldn't create new account"+e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent=new Intent(signup.this, login.class);
                startActivity(homeIntent);
                finish();
            }});

    }}
