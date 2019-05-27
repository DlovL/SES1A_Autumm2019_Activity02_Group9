package com.example.administrator.mydairy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
	 private EditText editText,editText1;
	    private Button button;
	    private DairyDao dao;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_regist);
	        initView();
	        button.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	            	
	                dao.AddUser(editText.getText().toString(),editText1.getText().toString());
	                Toast.makeText(Main4Activity.this,"Register Successfully",Toast.LENGTH_SHORT).show();
	                Intent intent1 = new Intent(Main4Activity.this,LoginActivity.class);
	                startActivity(intent1);
	                Main4Activity.this.finish();
	                
	            }
	        });
	    }
	    public void initView(){
	        editText = (EditText)findViewById(R.id.username);
	        editText1 = (EditText)findViewById(R.id.pwd);
	        button = (Button)findViewById(R.id.zhuce);
	        dao = new DairyDao(Main4Activity.this);
	        
	    }
}
