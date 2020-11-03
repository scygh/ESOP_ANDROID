package com.scy.common.base;

import android.app.Application;
import android.content.Context;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/21 10:19
 */
public class BaseApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
