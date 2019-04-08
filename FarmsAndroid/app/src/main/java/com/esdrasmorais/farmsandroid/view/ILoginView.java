package com.esdrasmorais.farmsandroid.view;

public interface ILoginView {
    String getUsername();
    String getPassword();

    void showInputError();

    void setUsername(String username);

    void setPassword(String password);

    void showUserLoggingMessage();

    void updateUserInfoTextView(String info);
    void showProgressBar();
    void hideProgressBar();
}