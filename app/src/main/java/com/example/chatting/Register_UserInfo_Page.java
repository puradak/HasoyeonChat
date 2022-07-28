package com.example.chatting;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Register_UserInfo_Page  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_userinfo);
        ImageView userImage = (ImageView)findViewById(R.id.userImage);
        Drawable roundImage = (Drawable) getDrawable(R.drawable.round_image);
        userImage.setBackground(roundImage);
        userImage.setClipToOutline(true);
        userImage.setScaleX(1.5f);
        userImage.setScaleY(1.5f);
    }

    public void confirm_clicked(View v){

    }
}
