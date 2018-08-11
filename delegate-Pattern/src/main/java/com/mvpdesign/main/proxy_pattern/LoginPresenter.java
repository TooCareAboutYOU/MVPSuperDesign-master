package com.mvpdesign.main.proxy_pattern;

import android.content.Context;
import android.os.Handler;

import com.mvpdesign.main.proxy_pattern.base.BasePresenter;
import com.mvpdesign.main.proxy_pattern.base.BaseView;


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
                getView().loginMethod();
                new Handler().postDelayed(() -> { getView().attachView(); },2000);
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
