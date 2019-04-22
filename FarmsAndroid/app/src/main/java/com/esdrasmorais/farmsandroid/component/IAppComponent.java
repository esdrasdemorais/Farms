package com.esdrasmorais.farmsandroid.component;

import com.esdrasmorais.farmsandroid.view.LoginActivity;
import com.esdrasmorais.farmsandroid.module.AppModule;
import com.esdrasmorais.farmsandroid.module.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, LoginModule.class})
public interface IAppComponent {
    void inject(LoginActivity target);
}