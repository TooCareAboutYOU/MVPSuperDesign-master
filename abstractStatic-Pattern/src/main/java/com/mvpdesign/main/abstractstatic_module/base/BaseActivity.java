package com.mvpdesign.main.abstractstatic_module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 *
 */
public abstract class BaseActivity<V extends BaseView,P extends BasePresenter<V>> extends AppCompatActivity {

    private V mBaseView;
    private P mBasePresenter;

    public V getView() {  return mBaseView;  }

    public P getPresenter() {  return mBasePresenter;  }

    public abstract V createView();
    public abstract P createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.mBasePresenter == null) {
            this.mBasePresenter=createPresenter();
        }

        if (this.mBaseView == null) {
            this.mBaseView=createView();
        }

        if(this.mBasePresenter != null && this.mBaseView != null) {
            this.mBasePresenter.attachView(this.mBaseView);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(this.mBasePresenter != null ) {
            this.mBasePresenter.detachView();
        }
    }
}
