package com.example.five;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
public class file extends AppCompatActivity implements View.OnClickListener {
    Button buf1,buf2;
    EditText etf1,etf2;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file);
        buf1=findViewById(R.id.buf1);
        buf2=findViewById(R.id.buf2);
        etf1=findViewById(R.id.etf1);
        etf2=findViewById(R.id.etf2);
        buf1.setOnClickListener(this);
        buf2.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buf1:
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("number",etf1.getText().toString());
                editor.putString("name",etf2.getText().toString());
                editor.apply();
                etf1.setText("");
                etf2.setText("");
                break;
            case R.id.buf2:
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                String number=pref.getString("number","");
                String name=pref.getString("name","");
                etf1.setText(number);
                etf2.setText(name);
                break;
        }
    }
}
