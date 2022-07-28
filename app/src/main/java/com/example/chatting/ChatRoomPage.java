// 채팅방 페이지
package com.example.chatting;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chatting.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatRoomPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room_page);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();        // 데이터베이스 선언, 할당
        DatabaseReference myRef = database.getReference("HasoyeonChat").child("ChatMassages");

        myRef.setValue("Test Message!");
    }
}