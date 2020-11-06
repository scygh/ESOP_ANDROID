package com.scy.filemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scy.common.arouter.ARouterConstants;
import com.scy.common.widget.MarqueeTextView;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterConstants.ACTIVITY_URL_FILEMANAGER_FILEMANAGERACTIVITY)
public class FileManagerActivity extends AppCompatActivity {

    MarqueeTextView marqueeTextView;
    RecyclerView filemanagerRv;
    FileManagerAdapter adapter;
    List<ChoiceBean> choiceBeans = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);
        ARouter.getInstance().inject(this);
        marqueeTextView = findViewById(R.id.common_mt);
        marqueeTextView.startScroll();
        filemanagerRv = findViewById(R.id.filemanager_rv);
        filemanagerRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FileManagerAdapter(this);
        filemanagerRv.setAdapter(adapter);
        String[] names = getResources().getStringArray(R.array.choice_array);
        choiceBeans.add(new ChoiceBean(names[0],R.drawable.icon_choicequanbu));
        choiceBeans.add(new ChoiceBean(names[1],R.drawable.icon_choicetupian));
        choiceBeans.add(new ChoiceBean(names[2],R.drawable.icon_choiceshipin));
        choiceBeans.add(new ChoiceBean(names[3],R.drawable.icon_choicetxt));
        choiceBeans.add(new ChoiceBean(names[4],R.drawable.icon_choicepdf));
        choiceBeans.add(new ChoiceBean(names[5],R.drawable.icon_choicewenjian));
        adapter.setAdapterData(choiceBeans);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        marqueeTextView.stopScroll();
    }
}
