package com.scy.main.mvp.model;

import com.scy.common.entity.BaseResponse;
import com.scy.common.net.RetrofitClient;
import com.scy.common.net.RetrofitService;
import com.scy.main.mvp.contract.MainContract;

import io.reactivex.rxjava3.core.Observable;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:02
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<BaseResponse<String>> getConfig(String key) {
        return RetrofitClient.getClient().create(RetrofitService.class).getConfig("beaffa9a-16e4-4fdd-9f2d-836c3c144816","ServiceProviderWeChatPayMerchantId");
    }
}
