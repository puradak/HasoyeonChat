package com.example.chatting.ChatPackage;

import java.io.Serializable;

public class ChatData implements Serializable {
    private String msg;         // 채팅 메시지 내용
    private String nickname;    // 닉네임

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
