package com.esdrasmorais.farmsandroid.presenter;

import android.support.annotation.Nullable;
import com.esdrasmorais.farmsandroid.model.ILoginModel;
import com.esdrasmorais.farmsandroid.model.User;
import com.esdrasmorais.farmsandroid.view.ILoginView;

public class LoginActivityPresenter implements ILoginPresenter {
    @Nullable
    private ILoginView view;
    private ILoginModel model;

    public LoginActivityPresenter(ILoginModel model) {
        this.model = model;
    }

    @Override
    public void setView(ILoginView view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null && (view.getUsername().trim().equals("")
            || view.getPassword().trim().equals(""))
        ) {
            view.showInputError();
        } else {
            model.createUser(view.getUsername(), view.getPassword());
            view.showUserLoggingMessage();
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user != null) {
            if (view != null) {
                view.setUsername(user.getUsername());
                view.setPassword(user.getPassword());
            }
        }
    }

    @Override
    public void updateUsername(String username) {
        if (view != null) {
            view.setUsername(username);
            view.updateUserInfoTextView(view.toString());
        }
    }

    @Override
    public void updatePassword(String password) {
        if (view != null) {
            view.setPassword(password);
            view.updateUserInfoTextView(view.toString());
        }
    }
}