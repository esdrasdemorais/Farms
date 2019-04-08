package com.esdrasmorais.farmsandroid.application;

import android.app.Application;

import com.esdrasmorais.farmsandroid.component.DaggerIAppComponent;
import com.esdrasmorais.farmsandroid.component.IAppComponent;
import com.esdrasmorais.farmsandroid.module.AppModule;
import com.esdrasmorais.farmsandroid.module.LoginModule;

public class App extends Application {
    private IAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerIAppComponent.builder()
            .appModule(new AppModule(this))
            .loginModule(new LoginModule())
            .build();
    }

    public IAppComponent getComponent() {
        return component;
    }
}