package com.mvpdesign.main.proxy_pattern;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.mvpdesign.main.proxy_pattern.base.BaseView;


/**
 *
 */
public class LoginModel {

    public void login(BaseView listener){
        new Handler().post(() -> {
            listener.attachView();
        });

        new Handler().postDelayed(() -> {
            listener.detachView();
        },3000);

    }

    public void close(Context context){
        Toast.makeText(context, "关闭登录请求", Toast.LENGTH_SHORT).show();
    }

}
