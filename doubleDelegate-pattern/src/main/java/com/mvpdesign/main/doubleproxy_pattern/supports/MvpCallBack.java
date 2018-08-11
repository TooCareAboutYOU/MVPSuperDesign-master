package com.mvpdesign.main.doubleproxy_pattern.supports;

import com.mvpdesign.main.doubleproxy_pattern.base.BasePresenter;
import com.mvpdesign.main.doubleproxy_pattern.base.BaseView;

/**
 * 第二重代理 -> 第一个角色：目标接口（定义绑定和解绑的各个模块高度抽象的规范）
 */
public interface MvpCallBack<V extends BaseView, P extends BasePresenter<V>> {

    P createPresenter();
    P getMvpPresenter();
    void setMvpPresenter(P presenter);

    V createView();
    V getMvpView();
    void setMvpView(V view);


}
