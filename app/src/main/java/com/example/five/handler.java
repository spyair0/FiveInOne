package com.example.five;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class handler extends AppCompatActivity implements View.OnClickListener {
    int index = 0;
    Button buh;
    public static final int UPDATE = 1;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE:
                    init();
                    break;
                default:
                    break;
            }
        }
    };

    public void init() {
        index++;
        TextView tvh = findViewById(R.id.tvh);
        tvh.setText("线程已更新" + index + "次");
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler);
        init();
        buh = findViewById(R.id.buh);
        buh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buh:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        message.what=UPDATE;
                        handler.sendMessage(message);
                    }
                }).start();
        }
        }
    }

