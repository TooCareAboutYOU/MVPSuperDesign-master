package com.mvpdesign.main.doubleproxy_pattern.supports;

import android.os.Bundle;
import android.util.Log;

import com.mvpdesign.main.doubleproxy_pattern.base.BasePresenter;
import com.mvpdesign.main.doubleproxy_pattern.base.BaseView;

import java.util.PrimitiveIterator;

/**
 * 第一重代理-> 第二个角色：目标对象 -> 生命周期
 */
public class ActivityMvpDelegateImpl<V extends BaseView, P extends BasePresenter<V>> implements ActivityMvpDelegate<V,P> {

    private static final String TAG = "ActivityMvpDelegateImpl";
    
    //调用第二重代理对象
    //第一重已经对整个Activity生命周期进行了代理，所以可直接在此目标对象里面实现功能

    private ProxyMvpCallBack<V,P> mProxyMvpCallBack;

    public ActivityMvpDelegateImpl(MvpCallBack<V,P> mvpCallBack) {
        this.mProxyMvpCallBack=new ProxyMvpCallBack<V,P>(mvpCallBack);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate: ");
        this.mProxyMvpCallBack.createPresenter();
        this.mProxyMvpCallBack.createView();
        this.mProxyMvpCallBack.attachView();
    }

    @Override
    public void onRestart() {
        Log.i(TAG, "onRestart: ");
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        this.mProxyMvpCallBack.detachView();
    }
}
