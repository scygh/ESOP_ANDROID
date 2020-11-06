package com.scy.main.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.common.arouter.ARouterConstants;
import com.scy.common.base.BaseMVPActivity;
import com.scy.common.entity.BaseResponse;
import com.scy.common.widget.MarqueeTextView;
import com.scy.main.R;
import com.scy.main.mvp.contract.MainContract;
import com.scy.main.mvp.presenter.MainPresent;

@Route(path = ARouterConstants.ACTIVITY_URL_MAIN_MAINACTIVITY)
public class MainActivity extends BaseMVPActivity<MainPresent> implements MainContract.View, View.OnClickListener {


    Button btnTaskNumber;
    Button btnFileManager;
    Button btnSOP;
    Button btnSetting;
    Button btnProduction;
    MarqueeTextView marqueeTextView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresent();
        mPresenter.attachView(this);
        ARouter.getInstance().inject(this);
        btnTaskNumber = findViewById(R.id.main_taskNumber);
        btnFileManager = findViewById(R.id.main_fileManager);
        btnSOP = findViewById(R.id.main_SOP);
        btnProduction = findViewById(R.id.main_production);
        btnSetting = findViewById(R.id.main_setting);
        btnTaskNumber.setOnClickListener(this);
        btnFileManager.setOnClickListener(this);
        btnSOP.setOnClickListener(this);
        btnProduction.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        marqueeTextView = findViewById(R.id.common_mt);
        marqueeTextView.startScroll();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.main_fileManager) {
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_FILEMANAGER_FILEMANAGERACTIVITY)
                    .navigation();
        } else if (view.getId() == R.id.main_production) {
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_PRODUCTION_PRODUCTIONACTIVITY)
                    .navigation();
        } else if (view.getId() == R.id.main_SOP) {
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_MYSOP_SOPACTIVITY)
                    .navigation();
        } else if (view.getId() == R.id.main_setting) {
            ARouter.getInstance().build(ARouterConstants.ACTIVITY_URL_SETTING_SETTINGACTIVITY)
                    .navigation();
        } else if (view.getId() == R.id.main_taskNumber) {
            startActivityForResult(new Intent(MainActivity.this,TaskListActivity.class),1);
        }
    }

    @Override
    public void onSuccess(BaseResponse<String> baseResponse) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        marqueeTextView.stopScroll();
    }
}
