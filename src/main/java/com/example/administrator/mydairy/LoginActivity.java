package com.example.administrator.mydairy;


        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editText1,getEditText;
    private Button button;
    private DairyDao dao;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((getEditText.getText().toString()).equals(dao.Querycount(editText1.getText().toString(),getEditText.getText().toString()))){
                    Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_SHORT).show();
                    Common.username = editText1.getText().toString();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"please regist",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void initview(){
        editText1 = (EditText)findViewById(R.id.username);
        getEditText = (EditText)findViewById(R.id.pwd);
        button = (Button)findViewById(R.id.login);
        dao = new DairyDao(LoginActivity.this);
        textView = (TextView)findViewById(R.id.textView);
    }
}
