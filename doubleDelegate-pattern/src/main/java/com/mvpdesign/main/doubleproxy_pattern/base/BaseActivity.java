package com.mvpdesign.main.doubleproxy_pattern.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mvpdesign.main.doubleproxy_pattern.supports.ActivityMvpDelegate;
import com.mvpdesign.main.doubleproxy_pattern.supports.ActivityMvpDelegateImpl;
import com.mvpdesign.main.doubleproxy_pattern.supports.MvpCallBack;

import java.util.PrimitiveIterator;

/**
 * 父类->基类->动态指定类型->泛型设计(通过泛型指定动态类型->有子类指定、父类只需要规定类型范围即可)
 * 第一重代理-> 第三个角色 -> 代理对象 BaseActivity (1、要实现目标接口; 2、持有目标对象的引用)
 * 第二重代理-> 第二个角色 -> 目标对象 BaseActivity(具体的Activity)（ 绑定具体的P层和V层回调是由具体的Activity决定）
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity implements MvpCallBack<V,P>{

    private ActivityMvpDelegate<V, P> mMvpDelegate;

    private ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (this.mMvpDelegate == null) {
            this.mMvpDelegate = new ActivityMvpDelegateImpl<V,P>(this);
        }
        return this.mMvpDelegate;
    }

    private P mPresenter;
    private V mView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public P createPresenter() {
        return this.mPresenter;
    }

    @Override
    public P getMvpPresenter() {
        return this.mPresenter;
    }

    @Override
    public void setMvpPresenter(P presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public V createView() {
        return this.mView;
    }

    @Override
    public V getMvpView() {
        return this.mView;
    }

    @Override
    public void setMvpView(V view) {
        this.mView=view;
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }




}
