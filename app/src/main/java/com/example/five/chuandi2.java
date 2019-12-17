package com.example.five;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class chuandi2 extends AppCompatActivity implements View.OnClickListener{
    Button buc2,bur2;
    TextView tv2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chuandi2);
        buc2 = findViewById(R.id.buc2);
        buc2.setOnClickListener(this);
        bur2=findViewById(R.id.bur2);
        bur2.setOnClickListener(this);
        tv2 = findViewById(R.id.tv2);
        Bundle bundle1 = getIntent().getExtras();
        tv2.setText(bundle1.getString("text1"));
    }
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buc2:
                    Bundle bundle = new Bundle();
                    bundle.putString("text2", "当前为传递2的页面，接受传递1的消息");
                    Intent intent = new Intent(chuandi2.this, chuandi1.class);
                    intent.putExtras(bundle);  //传输bundle--intent
                    startActivity(intent);
                    break;
                case R.id.bur2:
                    Intent intent2 = new Intent(chuandi2.this, MainActivity.class);
                    //传输bundle--intent
                    startActivity(intent2);
                    break;
            }
    }
}
