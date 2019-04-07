package com.esdrasmorais.farmsandroid.view;

public interface ILoginView {
    String getUsername();
    String getPassword();

    void showInputError();

    void setUsername(String username);

    void setPassword(String password);

    void showUserSavedMessage();
}