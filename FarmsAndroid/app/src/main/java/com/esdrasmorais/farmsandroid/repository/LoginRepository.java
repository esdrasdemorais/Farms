package com.esdrasmorais.farmsandroid.repository;

import com.esdrasmorais.farmsandroid.model.User;

public class LoginRepository implements ILoginRepository {
    private User user;

    @Override
    public User getUser() {
        if (user == null) {
            User user = new User("PTRural", "PTRur4l");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.user = user;
    }
}
