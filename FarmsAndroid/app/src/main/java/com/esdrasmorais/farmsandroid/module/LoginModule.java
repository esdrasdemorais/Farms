package com.esdrasmorais.farmsandroid.module;

import com.esdrasmorais.farmsandroid.model.ILoginModel;
import com.esdrasmorais.farmsandroid.model.LoginModel;
import com.esdrasmorais.farmsandroid.presenter.ILoginPresenter;
import com.esdrasmorais.farmsandroid.presenter.LoginActivityPresenter;
import com.esdrasmorais.farmsandroid.repository.ILoginRepository;
import com.esdrasmorais.farmsandroid.repository.LoginRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    public ILoginPresenter provideLoginActivityPresenter(ILoginModel model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    public ILoginModel provideLoginActivityModel(ILoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    public ILoginRepository provideLoginRepository() {
        return new LoginRepository();
    }
}