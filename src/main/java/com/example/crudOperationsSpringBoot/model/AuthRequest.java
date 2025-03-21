package com.example.crudOperationsSpringBoot.model;

public class AuthRequest {
    private  String user;
    private String password;

    public String getUser() {
        return user;
    }

    public AuthRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
