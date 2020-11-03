package com.scy.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.scy.common.mvpInterface.BasePresenter;

import javax.inject.Inject;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/23 11:03
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
    * descirption: 设置布局
    */
    public abstract int getLayoutId();

    /**
    * descirption: 初始化视图
    */
    public abstract void initView();
}
