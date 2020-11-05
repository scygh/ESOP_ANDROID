package com.scy.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.common.arouter.ARouterConstants;

@Route(path = ARouterConstants.ACTIVITY_URL_SETTING_SETTINGACTIVITY)
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ARouter.getInstance().inject(this);
    }
}
