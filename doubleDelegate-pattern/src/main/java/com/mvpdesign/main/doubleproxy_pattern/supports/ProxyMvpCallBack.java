package com.mvpdesign.main.doubleproxy_pattern.supports;

import com.mvpdesign.main.doubleproxy_pattern.base.BasePresenter;
import com.mvpdesign.main.doubleproxy_pattern.base.BaseView;

/**
 * 第二重代理-> 第三个角色 -> 代理对象 高度抽象的绑定和解绑
 */
public class ProxyMvpCallBack<V extends BaseView, P extends BasePresenter<V>> implements MvpCallBack<V,P> {

    //持有目标对象的引用->BaseActivity
    private MvpCallBack<V,P> mMvpCallBack;

    public ProxyMvpCallBack(MvpCallBack<V,P> mvpCallBack) {
        this.mMvpCallBack=mvpCallBack;
    }

    @Override
    public P createPresenter() {
        P p=this.mMvpCallBack.getMvpPresenter();
        if (p == null) {
            p=this.mMvpCallBack.createPresenter();
        }
        if (p == null) {
            throw new NullPointerException("presenter is null");
        }

        this.mMvpCallBack.setMvpPresenter(p);
        return p;
    }

    @Override
    public P getMvpPresenter() {
        return this.mMvpCallBack.getMvpPresenter();
    }

    @Override
    public void setMvpPresenter(P presenter) {
        this.mMvpCallBack.setMvpPresenter(presenter);
    }

    @Override
    public V createView() {
        V v=this.mMvpCallBack.getMvpView();
        if (v == null) {
            v=this.mMvpCallBack.createView();
        }
        if (v == null) {
            throw new NullPointerException("p is null");
        }

        this.mMvpCallBack.setMvpView(v);
        return v;
    }

    @Override
    public V getMvpView() {
        return this.mMvpCallBack.getMvpView();
    }

    @Override
    public void setMvpView(V view) {
        this.mMvpCallBack.setMvpView(view);
    }

    public void attachView(){
        this.getMvpPresenter().attachView(getMvpView());
    }

    public void detachView(){
        this.getMvpPresenter().detachView();
    }
}
