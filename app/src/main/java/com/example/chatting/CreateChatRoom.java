package com.example.chatting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateChatRoom extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mChatRoom;
    // 만들어질 채팅방
    FirebaseUser mUser;
    // 사용자(나)
    DatabaseReference mDbRef;
    UserAccount me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chat_room);

        mAuth = FirebaseAuth.getInstance();
        mDbRef = FirebaseDatabase.getInstance().getReference("HasoyeonChat");
    }

    public void create_room_clicked(View v){
        String roomName = ((EditText)findViewById(R.id.et_new_chatroom_name)).getText().toString();
        String email = roomName+"@chat.room";
        String password = "password";
        if(roomName.isEmpty()) {
            Toast.makeText(this, "채팅방 이름을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mChatRoom = mAuth.getCurrentUser();
                    me = LoginPage.getMyAccount();

                    HashMap<String, String> userList = new HashMap<>();
                    ChatRoom newRoom = new ChatRoom();

                    userList.put(me.getNickname(),me.getUID());

                    newRoom.setUID(mChatRoom.getUid());
                    newRoom.setChatName(roomName);
                    newRoom.setUsers(userList);
                    newRoom.setTotalNumber(""+userList.size());
                    // 채팅방 설정
                    mDbRef.child("ChatList").child(roomName).setValue(newRoom);
                    // DB에 방이름으로 된 항목 개설



                    // + 새로운 채팅방으로 넘어가는 코드 작성(intent)
                    finish();
                }
                else

                    Toast.makeText(CreateChatRoom.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void cancel_clicked(View v){
        finish();
    }
}