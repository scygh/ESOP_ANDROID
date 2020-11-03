package com.scy.main.mvp.presenter.di.module;

import com.scy.main.mvp.contract.MainContract;
import dagger.Module;
import dagger.Provides;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:51
 */
@Module
public class MainModule {

    private MainContract.View iView;

    public MainModule(MainContract.View iView) {
        this.iView = iView;
    }

    @Provides
    public MainContract.View provideView() {
        return this.iView;
    }
}
