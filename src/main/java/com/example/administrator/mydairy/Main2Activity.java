package com.example.administrator.mydairy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public EditText name;
    public EditText address;
    public EditText date;
    public Button button;

    private DairyDao dairydao;

    private Bean bean = new Bean();

    private int a = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intiView();
        Intent intent = getIntent();
        String names = intent.getStringExtra("name");
        String addresss = intent.getStringExtra("address");
        String dates = intent.getStringExtra("date");

        name.setText(names);
        address.setText(addresss);
        date.setText(dates);

        initListener();
    }

    public void intiView() {
        dairydao = new DairyDao(Main2Activity.this);

        name = (EditText) findViewById(R.id.ed_name);
        address = (EditText) findViewById(R.id.ed_address);
        date = (EditText) findViewById(R.id.ed_date);
        button = (Button) findViewById(R.id.bt_sure);

    }

    public void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String names = name.getText().toString();
        String addresss = address.getText().toString();
        String dates = date.getText().toString();
        Charity charity = new Charity(names,addresss,dates);
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String day = sf.format(new Date());

                    if (TextUtils.isEmpty(dates)) {
                        Toast.makeText(Main2Activity.this, "date is null", Toast.LENGTH_SHORT).show();
                    } else {
                        dairydao.Add(charity);
                        if (dairydao.Check == -1) {
                            a = 2;
                            Toast.makeText(Main2Activity.this, "error", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Main2Activity.this, "Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setData(Uri.parse("mailto:"));
                            intent.putExtra(Intent.EXTRA_EMAIL, "");
                            intent.setType("text/plain");
                            startActivity(Intent.createChooser(intent, "Dear "+Common.username+": Book Success!"+names+"  "+addresss+"  "+dates));

//                            Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
//                            startActivity(intent1);
//                            Main2Activity.this.finish();
                        }
                    }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
            Main2Activity.this.finish();
        }
        return false;
    }

}