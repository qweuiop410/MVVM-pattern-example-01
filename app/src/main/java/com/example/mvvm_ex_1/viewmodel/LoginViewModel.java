package com.example.mvvm_ex_1.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.mvvm_ex_1.Interface.LoginResultCallBacks;
import com.example.mvvm_ex_1.model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallBacks loginResultCallBacks;

    LoginViewModel(LoginResultCallBacks loginResultCallBacks)
    {
        this.loginResultCallBacks = loginResultCallBacks;
        this.user = new User();
    }

    public TextWatcher getEmailTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setEmail(editable.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher()
    {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                user.setPassword(editable.toString());
            }
        };
    }

    public void onLoginClicked(View view)
    {
        int errorCode =user.isValidData();
        if(errorCode == 0)
            loginResultCallBacks.onError("Must enter email address");
        else if(errorCode ==1)
            loginResultCallBacks.onError("Email is invalid");
        else if(errorCode ==2)
            loginResultCallBacks.onError("Password length must greater than 6 characters");
        else
            loginResultCallBacks.onSuccess("Login Success");
    }
}
