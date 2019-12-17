package com.example.five;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
Button bu1,bu2,bu3,bu4,bu5;
EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu1=findViewById(R.id.bu1);
        bu2=findViewById(R.id.bu2);
        bu3=findViewById(R.id.bu3);
        bu4=findViewById(R.id.bu4);
        bu5=findViewById(R.id.bu5);
        bu1.setOnClickListener(this);
        bu2.setOnClickListener(this);
        bu3.setOnClickListener(this);
        bu4.setOnClickListener(this);
        bu5.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu1:
    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
    LayoutInflater inflater=getLayoutInflater();
    final View view=inflater.inflate(R.layout.login,null);
                builder.setView(view).setTitle("登录")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                et1 = view.findViewById(R.id.et1);
                                et2 = view.findViewById(R.id.et2);
                                if(et1.getText().toString().equals("abc")&&et2.getText().toString().equals("123")){
                                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(MainActivity.this, "用户名和密码错误", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                builder.show();
                break;
            case R.id.bu2:
                Intent in=new Intent(MainActivity.this, chuandi1.class);
                startActivity(in);
                break;
            case R.id.bu3:
                Intent intent = new Intent("com.example.five.ACTION_START");
                intent.addCategory("acom.example.five.category_MYCATEGORY");
                startActivity(intent);
                break;
            case R.id.bu4:
                Intent intent2 = new Intent(MainActivity.this,file.class);
                startActivity(intent2);
                break;
            case R.id.bu5:
                Intent intent3 = new Intent(MainActivity.this,handler.class);
                startActivity(intent3);
                break;
        }
    }
}