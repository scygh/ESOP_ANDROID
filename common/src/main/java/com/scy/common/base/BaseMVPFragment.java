package com.scy.common.base;

import androidx.lifecycle.Lifecycle;

import com.scy.common.mvpInterface.BasePresenter;
import com.scy.common.mvpInterface.BaseView;

import autodispose2.AutoDispose;
import autodispose2.AutoDisposeConverter;
import autodispose2.androidx.lifecycle.AndroidLifecycleScopeProvider;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/26 10:57
 */
public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseFragment implements BaseView {

    protected P mPresenter;

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    /**
     * descirption: 绑定生命周期防止MVP内存泄漏
     */
    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY));
    }
}
