package com.mvpdesign.main.doubleproxy_pattern.supports;

import android.os.Bundle;

import com.mvpdesign.main.doubleproxy_pattern.base.BasePresenter;
import com.mvpdesign.main.doubleproxy_pattern.base.BaseView;

/**
 *  第一重代理 -> 第一个角色 ：目标接口
 */
public interface ActivityMvpDelegate<V extends BaseView, P extends BasePresenter<V>> {

    void onCreate(Bundle savedInstanceState);

    void onRestart();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
