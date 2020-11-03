package com.scy.main.mvp.ui.activity;

import android.view.View;
import android.widget.Button;

import com.scy.common.base.BaseMVPActivity;
import com.scy.common.entity.BaseResponse;
import com.scy.main.R;
import com.scy.main.mvp.contract.MainContract;
import com.scy.main.mvp.presenter.MainPresent;


public class MainActivity extends BaseMVPActivity<MainPresent> implements MainContract.View {

    Button getConfig;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresent();
        mPresenter.attachView(this);
        getConfig = findViewById(R.id.getConfig);
        getConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getConfig("a");
            }
        });
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
}
