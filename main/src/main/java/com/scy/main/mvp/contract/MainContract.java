package com.scy.main.mvp.contract;

import com.scy.common.mvpInterface.BaseView;
import com.scy.common.entity.BaseResponse;

import io.reactivex.rxjava3.core.Observable;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 10:41
 */
public interface MainContract {

    /**
    * descirption: model负责网络请求
    */
    interface Model {
        Observable<BaseResponse<String>> getConfig(String key);
    }

    /**
    * descirption: 界面展示
    */
    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseResponse<String> baseResponse);
    }

    interface Presenter {
        void getConfig(String key);
    }


}
