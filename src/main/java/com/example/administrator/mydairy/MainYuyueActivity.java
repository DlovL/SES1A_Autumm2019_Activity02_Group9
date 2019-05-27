package com.example.administrator.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MainYuyueActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{


    private ListView mLvShow;
    private DairyDao dairyDao;
    private MyYuyueAdapter myAdapter;
    private List<Charity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainyuyue);
        initView();
        initListener();
        Show();
    }
    public void initView(){
        dairyDao = new DairyDao(MainYuyueActivity.this);
        mLvShow = (ListView)findViewById(R.id.lv_show);
    }
    public void initListener(){
        mLvShow.setOnItemLongClickListener(this);
    }


    public void Show(){
        list = dairyDao.Query();
        myAdapter = new MyYuyueAdapter(MainYuyueActivity.this,list);
        mLvShow.setAdapter(myAdapter);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            dairyDao.Delete(list.get(list.size()-1-i).getId()+"");
            Toast.makeText(MainYuyueActivity.this, "success", Toast.LENGTH_SHORT).show();

            Show();


        return true;
    }



}
