package com.example.chatting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Select_userImage extends AppCompatActivity {

    DatabaseReference mDbRef;
    UserAccount userAccount;
    ImageButton imgBtn;
    Register_Account_Page account_page = new Register_Account_Page();
    Register_UserInfo userinfo = new Register_UserInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_userinfo);
        imgBtn = findViewById(R.id.user_image);
        setContentView(R.layout.activity_select_user_image);

        userAccount = account_page.getCurrentUserAccount();
        mDbRef = FirebaseDatabase.getInstance().getReference("HasoyeonChat");
    }

    public void imageClick(View v){
        userAccount.setImage(v.getResources().getResourceEntryName(v.getId()));
        mDbRef.child("UserAccount").child(userAccount.getUID()).setValue(userAccount);

        imgBtn = Register_UserInfo.getImgBtn();

        if(imgBtn != null)  {
            imgBtn.setImageResource(getImageResource(userAccount.getImage()));
            imgBtn.setBackgroundResource(R.drawable.btn_userimage_round);
            imgBtn.setClipToOutline(true);
            Toast.makeText(Select_userImage.this, userAccount.getImage()+" : 사진 설정 완료", Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            Toast.makeText(Select_userImage.this, "이미지 버튼 null", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancel_clicked(View v){
        finish();
    }

    private int getImageResource(String imageName) {
        if(imageName.equals("apeach_1"))    return R.drawable.apeach_1;
        if(imageName.equals("apeach_2"))    return R.drawable.apeach_2;
        if(imageName.equals("neo_1"))       return R.drawable.neo_1;
        if(imageName.equals("prodo_1"))     return R.drawable.prodo_1;
        if(imageName.equals("prodo_2"))     return R.drawable.prodo_2;
        if(imageName.equals("tube_1"))      return R.drawable.tube_1;

        return R.drawable.apeach_2;
    }
}