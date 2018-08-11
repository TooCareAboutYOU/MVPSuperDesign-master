package com.mvpdesign.main.proxy_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mvpdesign.main.proxy_pattern.base.BaseActivity;

/**
 * 代理模式
 */
public class MainActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void TouchEvent(View view) {
        getPresenter().attachView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }
}
