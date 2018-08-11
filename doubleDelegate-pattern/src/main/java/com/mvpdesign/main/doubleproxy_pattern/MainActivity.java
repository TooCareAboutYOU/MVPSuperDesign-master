package com.mvpdesign.main.doubleproxy_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mvpdesign.main.doubleproxy_pattern.base.BaseActivity;

/**
 * 双重代理模式-
 * 第一重代理：代理各个模块的生命周期
 *      第一个角色：目标接口-> ActivityMvpDelegate->定义了Activity的生命周期
 *      第二个角色：目标对象-> ActivityMvpDelegateImpl->生命周期的实现
 *      第三个角色: 代理对象 BaseActivity
 *          特点： 1、要实现目标接口
 *                2、持有目标对象的引用
 * 第二重代理：代理各个模块的MVP的实现(即绑定与解绑)
 *      第一个角色：目标接口-> BaseCallBack：定义绑定和解绑的各个模块高度抽象的规范
 *      第二个角色：目标对象-> BaseActivity(具体的Activity)
 *                绑定具体的P层和V层回调是由具体的Activity决定
*       第三个角色：代理对象-> ProxyMvpCallBack 高度抽象的绑定和解绑
 *            特点： 1、要实现目标接口
 *                  2、持有目标对象的引用

 * 注：第一重代理为第二重代理做准备
 */

/**
 * 将第一重代理和第二重代理关联
 * 第二重代基于第一重代理
 */

public class MainActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginView createView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void attachView() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void detachView() {
        Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpPresenter().detachView();
    }

    public void touchClick(View view) {
        getMvpPresenter().attachView();
    }
}
