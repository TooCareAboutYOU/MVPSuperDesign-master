package com.mvpdesign.main.proxy_pattern.base;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 抽象类
 */
public class BasePresenter<V extends BaseView> {

    private V mView;
    private V proxyView;

    public V getView() {
        return this.proxyView;
    }

    public void attachView(V view) {
        this.mView = view;
        //目标接口->LoginView
        ClassLoader classLoader=view.getClass().getClassLoader();
        Class<?>[] classes=view.getClass().getInterfaces();
        //目标对象->Activity（具体实现了LoginView的Activity）
        InvocationHandler invocationHandler=new ViewInvocationHandler(this.mView);
        //代理对象
        proxyView= (V) Proxy.newProxyInstance(classLoader,classes,invocationHandler);
    }

    private class ViewInvocationHandler implements InvocationHandler {

        private V view;

        ViewInvocationHandler(V view) {
            this.view = view;
        }
        //代理对象，控制对目标对象的访问
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (this.view != null) {
               return method.invoke(this.view,args);
            }
            return null;
        }
    }

    public void detachView() {
        if (mView != null) {
            mView=null;
        }
    }
}
