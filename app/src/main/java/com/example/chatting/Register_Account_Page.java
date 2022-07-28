package com.example.chatting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Account_Page extends AppCompatActivity {

        FirebaseAuth mAuth;
        DatabaseReference mDbRef;

        EditText mEmail;
        EditText mPwd;
        EditText mPwd_check;
        TextView notify_diff_pwd;
        TextView notify_exist_email;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_account);

            mAuth = FirebaseAuth.getInstance();
            mDbRef = FirebaseDatabase.getInstance().getReference("HasoyeonChat");

            notify_diff_pwd = findViewById(R.id.notify_diff_pwd);
            notify_exist_email = findViewById(R.id.notify_exist_email);
        }



        public void confirm_clicked(View v) {
            String id = ((EditText) findViewById(R.id.et_email)).getText().toString();
            String pwd = ((EditText) findViewById(R.id.et_pwd)).getText().toString();
            String pwd_check = ((EditText) findViewById(R.id.et_pwd_check)).getText().toString();

            if (pwd.equals(pwd_check)) {
                notify_diff_pwd.setText(" ");

                mAuth.createUserWithEmailAndPassword(id,pwd).addOnCompleteListener(Register_Account_Page.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //회원가입에 성공
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            UserAccount userAccount = new UserAccount();
                            userAccount.setUID(firebaseUser.getUid());
                            userAccount.setEmail(firebaseUser.getEmail());
                            userAccount.setPassword(pwd);

                            mDbRef.child("UserAccount").child(firebaseUser.getUid()).setValue(userAccount);

                            Toast.makeText(Register_Account_Page.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                            notify_exist_email.setText(" ");
                        }
                        else{
                            Toast.makeText(Register_Account_Page.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                            notify_exist_email.setText("이미 존재하는 아이디입니다.");
                        }
                    }
                });
            }
            else {
                notify_diff_pwd.setText("비밀번호와 다릅니다.");
            }
        }

    }