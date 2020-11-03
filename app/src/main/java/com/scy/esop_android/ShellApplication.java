package com.scy.esop_android;


import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.common.base.BaseApplication;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/14 17:16
 */
public class ShellApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter(this);
    }

    private void initRouter(Application application) {
        if (BuildConfig.DEBUG) {
            //一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(application);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
