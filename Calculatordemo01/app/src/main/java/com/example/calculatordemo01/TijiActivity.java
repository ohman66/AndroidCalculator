package com.example.calculatordemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class TijiActivity extends AppCompatActivity {
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=super.getMenuInflater();
        menuInflater.inflate(R.menu.danweihuansuan,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.hanshu){
            Intent intent=new Intent(TijiActivity.this,HanshuActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.danweihuansuan){
            Intent intent=new Intent(TijiActivity.this,DanWeiHuanSuanActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(TijiActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(TijiActivity.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(TijiActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiji);
    }
}