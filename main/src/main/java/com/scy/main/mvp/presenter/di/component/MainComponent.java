package com.scy.main.mvp.presenter.di.component;

import com.scy.main.mvp.presenter.di.module.MainModule;
import com.scy.main.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:55
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
