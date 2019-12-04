package com.example.mvvm_ex_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_ex_1.Interface.LoginResultCallBacks;
import com.example.mvvm_ex_1.viewmodel.LoginViewModel;
import com.example.mvvm_ex_1.viewmodel.LoginViewModelFactory;
import com.example.mvvm_ex_1.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginResultCallBacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setViewmodel(ViewModelProviders.of(
                this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this,message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this,message, Toast.LENGTH_LONG).show();
    }
}
