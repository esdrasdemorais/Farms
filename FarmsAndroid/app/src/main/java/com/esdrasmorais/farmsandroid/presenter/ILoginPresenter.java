package com.esdrasmorais.farmsandroid.presenter;

import com.esdrasmorais.farmsandroid.view.ILoginView;

public interface ILoginPresenter {
    void setView(ILoginView view);

    void loginButtonClicked();

    void getCurrentUser();

    void updateUsername(String username);

    void updatePassword(String password);
}