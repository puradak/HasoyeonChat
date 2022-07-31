package com.example.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_UserInfo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference mDbRef;

    private UserAccount user;
    private static ImageButton imgBtn;
    private Register_Account_Page account_page;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_userinfo);

        account_page = new Register_Account_Page();

        imgBtn = this.findViewById(R.id.user_image);
        imgBtn.setClipToOutline(true);
        imgBtn.setBackgroundResource(R.drawable.btn_userimage_round);

        mAuth = account_page.getCurrentFirebaseAuth();
        user = account_page.getCurrentUserAccount();
        firebaseUser = account_page.getCurrentUserReference();
        mDbRef = FirebaseDatabase.getInstance().getReference("HasoyeonChat");
    }

    public void userinfo_confirm_clicked(View v){

        String userNickname = ((EditText)findViewById(R.id.et_nickname)).getText().toString();
        user.setNickname(userNickname);

        mDbRef.child("UserAccount").child(user.getUID()).setValue(user);
        Toast.makeText(Register_UserInfo.this, "닉네임이 설정되었습니다.", Toast.LENGTH_SHORT).show();

    }

    public void imgBtn_clicked(View v){
        Intent intent = new Intent(Register_UserInfo.this,Select_userImage.class);
        startActivity(intent);
    }

    public static ImageButton getImgBtn(){
        return imgBtn;
    }

    public FirebaseAuth getCurrentFirebaseAuth(){
        return mAuth;
    }

    public FirebaseUser getCurrentUserReference(){
        return firebaseUser;
    }

    public UserAccount getCurrentUserAccount(){
        return user;
    }
}
