package com.example.chatting;

public class UserAccount {
    String UID;
    String email;
    String password;
    String nickname;
    String image = "apeach_1";

    public UserAccount() {}

    public UserAccount(String UID, String email, String password, String nickname, String image) {
        this.UID = UID;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
