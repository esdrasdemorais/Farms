package com.esdrasmorais.farmsandroid.presenter;

import android.view.View;

public interface ILoginPresenter {
    void setView(View view);

    void loginButtonClicked();

    void getCurrentUser();
}