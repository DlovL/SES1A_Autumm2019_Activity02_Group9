package com.example.administrator.mydairy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainHistoryActivity extends AppCompatActivity {


    private ListView mLvShow;
    private DairyDao dairyDao;
    private MyYuyueAdapter myAdapter;
    private List<Charity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhistory);
        initView();
        initListener();
        Show();
    }
    public void initView(){
        dairyDao = new DairyDao(MainHistoryActivity.this);
        mLvShow = (ListView)findViewById(R.id.lv_show);
    }
    public void initListener(){

    }


    public void Show(){
        list = dairyDao.Query();
        myAdapter = new MyYuyueAdapter(MainHistoryActivity.this,list);
        mLvShow.setAdapter(myAdapter);
    }





}
