package com.mvpdesign.main.doubleproxy_pattern;

import android.content.Context;
import android.os.Handler;

import com.mvpdesign.main.doubleproxy_pattern.base.BasePresenter;
import com.mvpdesign.main.doubleproxy_pattern.base.BaseView;

/**
 *
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private Context mContext;
    private LoginModel mModel;

    public LoginPresenter(Context context) {
        this.mContext=context;
        mModel=new LoginModel();
    }

    public void attachView(){
        this.mModel.login(new BaseView() {
            @Override
            public void attachView() {
                getView().attachView();
            }
            @Override
            public void detachView() {
                getView().detachView();
            }
        });
    }

    public void detachView(){
        this.mModel.close(this.mContext);
        detachView();
    }


}
