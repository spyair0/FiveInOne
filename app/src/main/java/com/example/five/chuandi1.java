package com.example.five;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class chuandi1 extends AppCompatActivity implements View.OnClickListener{
    Button buc1,bur1;
    TextView tv1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chaundi1);
        buc1=findViewById(R.id.buc1);
        bur1=findViewById(R.id.bur1);
        bur1.setOnClickListener(this);
        tv1=findViewById(R.id.tv1);
        buc1.setOnClickListener(this);
        try {
            Bundle bundle=getIntent().getExtras();
            tv1.setText(bundle.getString("text2"));
        }catch (Exception e){
            tv1.setText("传输为空");
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buc1:
            Bundle bundle = new Bundle();
            bundle.putString("text1", "当前为传递1的页面，接收传递2的消息");
            Intent intent = new Intent(chuandi1.this, chuandi2.class);
            intent.putExtras(bundle);  //传输bundle--intent
            startActivity(intent);
            break;
            case R.id.bur1:
                Intent intent2 = new Intent(chuandi1.this, MainActivity.class);
                //传输bundle--intent
                startActivity(intent2);
                break;
        }
    }
}