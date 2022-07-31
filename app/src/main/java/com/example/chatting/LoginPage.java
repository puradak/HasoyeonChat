package com.example.chatting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginPage extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();
        mDbRef = FirebaseDatabase.getInstance().getReference("HasoyeonChat");

    }

    public void register_clicked(View v){
        Intent intent = new Intent(LoginPage.this, Register_Account_Page.class);
        startActivity(intent);
    }

    public void login_clicked(View v){
        String email = ((EditText)findViewById(R.id.et_login_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.et_login_pwd)).getText().toString();
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(LoginPage.this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(LoginPage.this, ChatListPage.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginPage.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}