package com.mvpdesign.main.doubleproxy_pattern.base;

/**
 * 抽象类
 */
public class BasePresenter<V extends BaseView> {

    private V mView;

    public V getView() {
        return this.mView;
    }

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView() {
        if (mView != null) {
            mView=null;
        }
    }
}
