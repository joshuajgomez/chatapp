package com.joshgm3z.chatapp.pages.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import com.joshgm3z.chatapp.InitApplication;
import com.joshgm3z.chatapp.R;
import com.joshgm3z.chatapp.pages.home.HomeActivity;
import com.joshgm3z.chatapp.pages.signup.di.DaggerSignUpComponent;
import com.joshgm3z.chatapp.pages.signup.di.SignUpMvpModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View {

    @Inject
    SignUpContract.Presenter mPresenter;

    @BindView(R.id.et_username_input)
    EditText mEtUserNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        DaggerSignUpComponent.builder()
                .appComponent(InitApplication.getInstance(this).getAppComponent())
                .signUpMvpModule(new SignUpMvpModule(this))
                .build()
                .inject(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_signin)
    void onClick(){
        Editable text = mEtUserNameInput.getText();
        if (text != null && !text.toString().trim().isEmpty()) {
            String userName = text.toString().trim();
            mPresenter.onSignInClick(userName);
        }
    }

    @Override
    public void showLoadingMask(String message) {

    }

    @Override
    public void hideLoadingMask() {

    }

    @Override
    public void showNameInput() {

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void goToHome() {
        finishAffinity();
        HomeActivity.launch(this);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
