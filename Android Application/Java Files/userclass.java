package com.example.samplecheckmap;

public class userclass {

    String name, username, password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public userclass(String name, String username, String password) {
        this.name = name;

        this.username = username;
        this.password = password;
    }
    public userclass() {
    }
}
