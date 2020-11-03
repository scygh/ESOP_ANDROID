package com.scy.main.mvp.presenter;


import com.scy.common.entity.BaseResponse;
import com.scy.common.mvpInterface.BasePresenter;
import com.scy.common.net.RxScheduler;
import com.scy.main.mvp.contract.MainContract;
import com.scy.main.mvp.model.MainModel;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:57
 */
public class MainPresent extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresent() {
        model = new MainModel();
    }

    @Override
    public void getConfig(String key) {
        if (!isViewAttached()) {
            return;
        }
        model.getConfig(key)
                .compose(RxScheduler.<BaseResponse<String>>Obs_io_main())
                .to(mView.<BaseResponse<String>>bindAutoDispose())
                .subscribe(new Observer<BaseResponse<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<String> stringBaseResponse) {
                        mView.onSuccess(stringBaseResponse);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                });
    }
}
