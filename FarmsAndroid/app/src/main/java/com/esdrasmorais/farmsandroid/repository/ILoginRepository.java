package com.esdrasmorais.farmsandroid.repository;

import com.esdrasmorais.farmsandroid.model.User;

public interface ILoginRepository {
    User getUser();

    void saveUser(User user);
}
