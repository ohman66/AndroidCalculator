package com.example.calculatordemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ReliangActivity extends AppCompatActivity {
    String s1;
    String s2;
    double res=0;
    double d1,d2;

    private Spinner spinner;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=super.getMenuInflater();
        menuInflater.inflate(R.menu.danweihuansuan,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.hanshu){
            Intent intent=new Intent(ReliangActivity.this,HanshuActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.danweihuansuan){
            Intent intent=new Intent(ReliangActivity.this,DanWeiHuanSuanActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(ReliangActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(ReliangActivity.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ReliangActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huilv);

        EditText edit =findViewById(R.id.edit7);
        Spinner spinner7=(Spinner)findViewById(R.id.spinner7);
        Spinner spinner8=(Spinner)findViewById(R.id.spinner8);
        TextView textView=findViewById(R.id.text7);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s1 = (String) spinner7.getSelectedItem().toString();
//                d1 = Double.parseDouble(s1);
                Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                System.out.println("spinner1:"+s1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s2 = (String) spinner8.getSelectedItem().toString();
//                d2=Double.parseDouble(s2);
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                System.out.println("spinner2:"+s2);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Button button=findViewById(R.id.queren7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d1=Double.parseDouble(edit.getText().toString());
                System.out.println("第一个数："+d1);
                double ans=ReliangActivity.huiLv(d1,s1,s2,res);
                System.out.println("处理后的d1："+ans);
                textView.setText(ans+"");

            }
        });
    }
    public static double huiLv(double d1,String s1,String s2,double res){
        res=0;
        if(s1.equals("人民币")){
            if(s2.equals("美元")){
                res=d1*0.16;
            }else if(s2.equals("比特币")){
                res=d1*0.0000033;
            }else if(s2.equals("英镑")){
                res=d1*0.11;
            }
        }else if(s1.equals("美元")){
            if(s2.equals("人民币")){
                res=d1*6.44;
            }else if(s2.equals("比特币")){
                res=d1*0.000022;
            }else if(s2.equals("英镑")){
                res=d1*0.70448;
            }
        }else if(s1.equals("比特币")){
            if(s2.equals("人民币")){
                res=d1*290160.36;
            }else if(s2.equals("美元")){
                res=d1*45002;
            }else if(s2.equals("英镑")){
                res=d1*2741.6;
            }
        }else if(s1.equals("英镑")){
            if(s2.equals("人民币")){
                res=d1*8.89;
            }else if(s2.equals("美元")){
                res=d1*1.38;
            }else if(s2.equals("比特币")){
                res=d1*0.00003036;
            }
        }
        System.out.println("函数中的d1:"+d1);
        System.out.println("函数中的res:"+res);
        return res;
    }
}