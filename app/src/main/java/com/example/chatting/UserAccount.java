package com.example.chatting;

// 사용자 계정 클래스



public class UserAccount {

    private String idToken;     // firebase 고유 아이디(Uid)
    private String email;       // 사용자가 설정한 이메일
    private String password;    // 사용자가 설정한 비밀번호
    private String nickname;    // 사용자가 설정한 닉네임

    public UserAccount(){} // firebase realtimeDB 쓸 때 오류 방지용 빈 생성자

    public String getIdToken() {
        return idToken;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
