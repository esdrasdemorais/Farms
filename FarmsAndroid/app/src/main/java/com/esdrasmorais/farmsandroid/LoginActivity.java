package com.esdrasmorais.farmsandroid;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.esdrasmorais.farmsandroid.application.App;
import com.esdrasmorais.farmsandroid.presenter.ILoginPresenter;
import com.esdrasmorais.farmsandroid.view.ILoginView;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    @Inject
    ILoginPresenter presenter;

    private EditText username;
    private EditText password;
    private Button login;
    private ProgressBar progressBar;
    private TextView myTextView;
    private Toolbar toolbar;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((App) getApplication()).getComponent().inject(this);

        username = (EditText) findViewById(R.id.loginActivity_userName_editText);
        password = (EditText) findViewById(R.id.loginActivity_password_editText);
        login = (Button) findViewById(R.id.loginActivity_login_button);

        //initProgressBar();

//        username.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.v("teste u", "teste u");
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                presenter.updateUsername(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                hideProgressBar();
//            }
//        });
//
//        password.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                Log.v("teste p", "teste p");
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                presenter.updatePassword(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                hideProgressBar();
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
                showHome();
            }
        });
    }

    private void showHome() {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.loginActivity_userName_editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            Resources.getSystem().getDisplayMetrics().widthPixels, 250
        );
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressBar();
    }

    @Override
    public void updateUserInfoTextView(String info) {
        myTextView.setText(info);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
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
    public void showUserLoggingMessage() {
        Toast.makeText(this, "User logging...", Toast.LENGTH_SHORT).show();
    }
}