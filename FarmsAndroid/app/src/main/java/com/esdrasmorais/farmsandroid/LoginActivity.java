package com.esdrasmorais.farmsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esdrasmorais.farmsandroid.presenter.ILoginPresenter;
import com.esdrasmorais.farmsandroid.view.ILoginView;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @Inject
    ILoginPresenter presenter;

    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        username = (EditText) findViewById(R.id.loginActivity_userName_editText);
        password = (EditText) findViewById(R.id.loginActivity_password_editText);
        login = (Button) findViewById(R.id.loginActivity_login_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Fill all fields.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setUsername(String username) {
        this.username.setText(username);
    }

    @Override
    public void setPassword(String password) {
        this.username.setText(password);
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User logging...", Toast.LENGTH_SHORT).show();
    }
}
