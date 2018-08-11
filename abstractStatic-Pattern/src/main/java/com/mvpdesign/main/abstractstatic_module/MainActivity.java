package com.mvpdesign.main.abstractstatic_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mvpdesign.main.abstractstatic_module.base.BaseActivity;

public class MainActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{

    @Override
    public LoginView createView() { return this; }

    @Override
    public LoginPresenter createPresenter() {  return new LoginPresenter(this);  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TouchAbstractStatic(View view) {
        getPresenter().attachView();
    }

    @Override
    public void loginMethod() {
        Toast.makeText(this, "调用了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void attachView() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void detachView() {
        Toast.makeText(this, "登录取消", Toast.LENGTH_SHORT).show();
    }
}
