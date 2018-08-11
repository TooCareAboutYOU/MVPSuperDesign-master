package com.mvpdesign.main.abstractstatic_module;

import android.content.Context;
import android.os.Handler;

import com.mvpdesign.main.abstractstatic_module.base.BasePresenter;
import com.mvpdesign.main.abstractstatic_module.base.BaseView;

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
        if (this.mModel == null) {
            throw new IllegalArgumentException("the model is not init");
        }
        this.mModel.login(new BaseView() {
            @Override
            public void attachView() {
                if (getView() != null) {
                    getView().loginMethod();
                    new Handler().postDelayed(() -> { getView().attachView(); },2000);
                }
            }
            @Override
            public void detachView() {
                if (getView() != null) {
                    getView().detachView();
                }
            }
        });
    }

    public void detachView(){
        this.mModel.close(this.mContext);
        if (getView() != null) {
            detachView();
        }
    }

}
