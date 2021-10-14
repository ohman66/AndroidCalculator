package com.example.calculatordemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DanWeiHuanSuanActivity extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=super.getMenuInflater();
        menuInflater.inflate(R.menu.danweihuansuan,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.hanshu){
            Intent intent=new Intent(DanWeiHuanSuanActivity.this,HanshuActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(DanWeiHuanSuanActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(DanWeiHuanSuanActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(DanWeiHuanSuanActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danweihuansuan);

        Button btnchangdu=findViewById(R.id.changdu);
        Button btnzhongliang=findViewById(R.id.zhongliang);
        Button btnmian=findViewById(R.id.mianjii);
        Button btntiji=findViewById(R.id.tiji);
        Button btnshijian=findViewById(R.id.shijian);
        Button btnreliang=findViewById(R.id.reliang);

        btnchangdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,ChangduActivity.class);
                startActivity(intent);
            }
        });
        btnzhongliang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,ZhongliangActivity.class);
                startActivity(intent);
            }
        });btnmian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,MianjiActivity.class);
                startActivity(intent);
            }
        });btntiji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,TijiActivity.class);
                startActivity(intent);
            }
        });btnshijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,ShijianActivity.class);
                startActivity(intent);
            }
        });btnreliang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DanWeiHuanSuanActivity.this,ReliangActivity.class);
                startActivity(intent);
            }
        });

    }
}