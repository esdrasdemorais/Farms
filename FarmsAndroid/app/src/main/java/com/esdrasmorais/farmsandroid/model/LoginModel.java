package com.esdrasmorais.farmsandroid.model;

import com.esdrasmorais.farmsandroid.repository.ILoginRepository;

public class LoginModel implements ILoginModel {

    private ILoginRepository repository;

    public LoginModel(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String userName, String password) {
        repository.saveUser(new User(userName, password));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }

    @Override public void isValid() throws Exception {
//        Assertion assertion = new Assertion();
//        assertion.isNull(username).isEmpty(username).errors("Username");
//        assertion.isNull(password).isEmpty(password).lengthMin(password, 6).errors("Password");
    }
}