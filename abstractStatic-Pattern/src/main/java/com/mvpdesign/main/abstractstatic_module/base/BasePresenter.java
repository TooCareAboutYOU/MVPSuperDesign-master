package com.mvpdesign.main.abstractstatic_module.base;

/**
 * 抽象类
 */
public class BasePresenter<V extends BaseView> {

    private V mView;

    public V getView() {
        if (this.mView == null) {
            throw new NullPointerException("the mView is null");
        }
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
