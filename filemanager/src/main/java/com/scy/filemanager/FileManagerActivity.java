package com.scy.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.common.arouter.ARouterConstants;
import com.scy.common.widget.MarqueeTextView;

@Route(path = ARouterConstants.ACTIVITY_URL_FILEMANAGER_FILEMANAGERACTIVITY)
public class FileManagerActivity extends AppCompatActivity {

    MarqueeTextView marqueeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);
        ARouter.getInstance().inject(this);
        marqueeTextView = findViewById(R.id.common_mt);
        marqueeTextView.startScroll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        marqueeTextView.stopScroll();
    }
}
