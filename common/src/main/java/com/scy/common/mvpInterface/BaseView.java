package com.scy.common.mvpInterface;


import autodispose2.AutoDisposeConverter;

/**
 * description ：作为contract 中view的基类
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/26 10:01
 */
public interface BaseView {

    /**
    * descirption: 显示加载中
    */
    void showLoading();

    /**
    * descirption: 隐藏加载
    */
    void hideLoading();

    /**
    * descirption: 数据获取失败
    */
    void onError(Throwable throwable);

    /**
    * descirption: 绑定Android生命周期，防止RxJava内存泄漏
    */
    <T> AutoDisposeConverter<T> bindAutoDispose();

}
