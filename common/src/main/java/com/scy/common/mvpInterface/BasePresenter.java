package com.scy.common.mvpInterface;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:05
 */
public class BasePresenter<V extends BaseView> {
    protected V mView;

    /**
    * descirption: 绑定View，一般在初始化中调用该方法
    */
    public void attachView(V view) {
        this.mView = view;
    }

    /**
     * descirption: 解除绑定View，一般在onDestroy调用该方法
     */
    public void detachView() {
        this.mView = null;
    }

    /**
     * descirption: 是否绑定View
     */
    public boolean isViewAttached() {
        return mView != null;
    }
}
