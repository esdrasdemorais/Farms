package com.esdrasmorais.farmsandroid.model;

import com.esdrasmorais.farmsandroid.model.User;

public interface ILoginModel {
    void createUser(String name, String lastName);

    User getUser();

    void isValid() throws Exception;
}
