package com.mvpdesign.main.normal_module;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 *
 */
public class LoginModel {

    public void login(LoginView.Presenter listener){
        new Handler().post(() -> {
            listener.attachView();

        });

        new Handler().postDelayed(() -> {
            listener.attachView();
        },3000);

    }

    public void close(Context context){
        Toast.makeText(context, "关闭登录请求", Toast.LENGTH_SHORT).show();
    }

}
