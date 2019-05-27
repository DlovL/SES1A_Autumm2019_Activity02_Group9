package com.example.administrator.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    private Button search;
    private Button mBtnDelete;
    private Button mBtnSearch,history;
    private EditText keyword;
    private ListView mLvShow;
    private DairyDao dairyDao;
    private MyAdapter myAdapter;
    public List<Charity> ordata = new ArrayList<>();

    public List<Charity> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Charity charity1 = new Charity("AIME","Gadigal House,166,George St",1);
        Charity charity2 = new Charity("Sisters of Charity Outreach Centre","438 victoria St",2);
        Charity charity3 = new Charity("Sisters of Charity","35 Grafton St",4);
        Charity charity4 = new Charity("People for Nuclear Disarmament","499 Elizabeth St",5);
        Charity charity5 = new Charity("CanTeen","75 King St",6);
        Charity charity6 = new Charity("Father Chris Riley's Youth Off The Streets","36 Elizabeth St",10);
        Charity charity7 = new Charity("The Smith Family","252 Marrickville Rd",12);
        Charity charity8 = new Charity("The Charitable Works Fund","133 Liverpool St",25);
        Charity charity9 = new Charity("A Start in Life","suite 702/703 Pitt St",26);
        Charity charity10 = new Charity("Ending HIV","414 Elizabeth St",26);
        Charity charity11 = new Charity("By Indigenous","no address",30);
        Charity charity12 = new Charity("NAPCAN","9/162 Goulburn St",32);
        Charity charity13 = new Charity("Bargain Bazaar Charity Shop","434 Cleveland St",34);
        Charity charity14 = new Charity("Philanthropy Australia","120B Underwood St",35);
        Charity charity15 = new Charity("Dress for Success Sydney Inc","132 Marrickville Rd",60);
        ordata.add(charity1);
        ordata.add(charity2);
        ordata.add(charity3);
        ordata.add(charity4);
        ordata.add(charity5);
        ordata.add(charity6);
        ordata.add(charity7);
        ordata.add(charity8);
        ordata.add(charity9);
        ordata.add(charity10);
        ordata.add(charity11);
        ordata.add(charity12);
        ordata.add(charity13);
        ordata.add(charity14);
        ordata.add(charity15);
        data.clear();
        data.addAll(ordata);
        initView();
        initListener();
        Show();
    }
    public void initView(){
        keyword = (EditText)findViewById(R.id.keyword);
        mBtnDelete = (Button)findViewById(R.id.bt_delete);
        search = (Button)findViewById(R.id.search);
        dairyDao = new DairyDao(MainActivity.this);
        mBtnSearch = (Button)findViewById(R.id.bt_search) ;
        mLvShow = (ListView)findViewById(R.id.lv_show);
        history = (Button)findViewById(R.id.bt_history);
    }
    public void initListener(){
        mBtnSearch.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mLvShow.setOnItemClickListener(this);
        search.setOnClickListener(this);
        history.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_history:
                Intent intent0 = new Intent(MainActivity.this,MainHistoryActivity.class);
                startActivity(intent0);
                break;
            case R.id.search:
                String key = keyword.getText().toString();
                data.clear();
                for(int i = 0;i<ordata.size();i++){
                    if(ordata.get(i).getAddress().contains(key)||ordata.get(i).getName().contains(key)){
                        data.add(ordata.get(i));
                    }
                }
                myAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_delete:
                Toast.makeText(MainActivity.this,"long click to delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_search:
                Intent intent1 = new Intent(MainActivity.this,MainYuyueActivity.class);
                startActivity(intent1);
                break;

        }
    }
    public void Show(){
        myAdapter = new MyAdapter(MainActivity.this,data);
        mLvShow.setAdapter(myAdapter);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);

        intent.putExtra("name",data.get(i).getName());
        intent.putExtra("address",data.get(i).getAddress());
        startActivity(intent);
        MainActivity.this.finish();
    }


}
