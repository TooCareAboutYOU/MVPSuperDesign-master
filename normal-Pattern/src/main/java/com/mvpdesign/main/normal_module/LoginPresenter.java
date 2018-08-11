package com.mvpdesign.main.normal_module;

import android.content.Context;

/**
 *
 */
public class LoginPresenter {

    private LoginModel mModel;
    private LoginView.View mView;


    public LoginPresenter(LoginView.View view) {
        this.mModel = new LoginModel();
        this.mView=view;
    }

    public void attachView(){
        this.mModel.login(new LoginView.Presenter() {
            @Override
            public void attachView() {
                if (mView != null) {
                    mView.attachView();
                }
            }

            @Override
            public void detachView() {
                if (mView != null) {
                    mView.detachView();
                }
            }
        });
    }

    public void detachView(Context context){
        this.mModel.close(context);
        if (this.mView != null) {
            this.mView=null;
        }
    }

}
