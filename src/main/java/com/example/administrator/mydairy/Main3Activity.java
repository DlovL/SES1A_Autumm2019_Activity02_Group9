package com.example.administrator.mydairy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {

    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Calendar cl = Calendar.getInstance();
        int day = cl.get(Calendar.DAY_OF_MONTH);
        if(day > 6){
            //finish();
            //return;
        }
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Main3Activity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        timer.schedule(task, 1000 * 3);
//        Date date = new Date();
//        SimpleDateFormat sf = new SimpleDateFormat("dd");
//        int m = Integer.parseInt(sf.format(date));
//        if(m == 3 || m == 4){
//            timer.schedule(task, 1000 * 3);
//        }
    }
}
