package com.mvpdesign.main.normal_module;

/**
 *
 */
public interface LoginView {

    interface View{
        void attachView();
        void detachView();
    }

    interface Presenter{
        void attachView();
        void detachView();
    }

}
