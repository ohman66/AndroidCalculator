package com.example.calculatordemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ZhongliangActivity extends AppCompatActivity {
    String s1;
    String s2;
    double res=0;
    double d1,d2;
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=super.getMenuInflater();
        menuInflater.inflate(R.menu.danweihuansuan,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.hanshu){
            Intent intent=new Intent(ZhongliangActivity.this,HanshuActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(ZhongliangActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.danweihuansuan){
            Intent intent=new Intent(ZhongliangActivity.this,DanWeiHuanSuanActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(ZhongliangActivity.this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ZhongliangActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhongliang);

        EditText edit =findViewById(R.id.edit1);
        Spinner spinner1=(Spinner)findViewById(R.id.spinner1);
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        TextView textView=findViewById(R.id.text);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //拿到被选择项的值
                s1 = (String) spinner1.getSelectedItem().toString();
//                d1 = Double.parseDouble(s1);
                Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                System.out.println("spinner1:"+s1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s2 = (String) spinner2.getSelectedItem().toString();
//                d2=Double.parseDouble(s2);
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                System.out.println("spinner2:"+s2);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Button button=findViewById(R.id.queren);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d1=Double.parseDouble(edit.getText().toString());
                System.out.println("第一个数："+d1);
                double ans=ZhongliangActivity.danWei(d1,s1,s2,res);
                System.out.println("处理后的d1："+ans);
                textView.setText(ans+"");

            }
        });

    }
    public static double danWei(double d1,String s1,String s2,double res){
        res=0;
        if(s1.equals("km")){
            if(s2.equals("m")){
                res=d1*1000;
            }else if(s2.equals("dm")){
                res=d1*10000;
            }else if(s2.equals("cm")){
                res=d1*10000;
            }else if(s2.equals("mm")){
                res=d1*10000000;
            }else if(s2.equals("um")){
                res=d1*999999999.99999;
            }
        }else if(s1.equals("m")){
            if(s2.equals("km")){
                res=d1*0.001;
            }else if(s2.equals("dm")){
                res=d1*10;
            }else if(s2.equals("cm")){
                res=d1*100;
            }else if(s2.equals("mm")){
                res=d1*1000;
            }else if(s2.equals("um")){
                res=d1*1000000;
            }else if(s2.equals("nm")){
                res=d1*999999999.99999;
            }
        }else if(s1.equals("dm")){
            if(s2.equals("km")){
                res=d1*0.0001;
            }else if(s2.equals("m")){
                res=d1*0.1;
            }else if(s2.equals("cm")){
                res=d1*10;
            }else if(s2.equals("mm")){
                res=d1*100;
            }else if(s2.equals("um")){
                res=d1*100000;
            }else if(s2.equals("nm")){
                res=d1*100000000;
            }
        }else if(s1.equals("cm")){
            if(s2.equals("km")){
                res=d1*0.00001;
            }else if(s2.equals("m")){
                res=d1*0.01;
            }else if(s2.equals("dm")){
                res=d1*0.1;
            }else if(s2.equals("mm")){
                res=d1*10;
            }else if(s2.equals("um")){
                res=d1*10000;
            }else if(s2.equals("nm")){
                res=d1*10000000;
            }
        }else if(s1.equals("mm")){
            if(s2.equals("km")){
                res=d1*0.000001;
            }else if(s2.equals("m")){
                res=d1*0.001;
            }else if(s2.equals("dm")){
                res=d1*0.01;
            }else if(s2.equals("cm")){
                res=d1*0.1;
            }else if(s2.equals("um")){
                res=d1*1000;
            }else if(s2.equals("nm")){
                res=d1*1000000;
            }
        }else if(s1.equals("um")){
            if(s2.equals("km")){
                res=d1*0.000000001;
            }else if(s2.equals("m")){
                res=d1*0.000001;
            }else if(s2.equals("dm")){
                res=d1*0.0000009999999;
            }else if(s2.equals("cm")){
                res=d1*0.00009999999;
            }else if(s2.equals("mm")){
                res=d1*0.001;
            }else if(s2.equals("nm")){
                res=d1*999.999;
            }
        }
        System.out.println("函数中的d1:"+d1);
        System.out.println("函数中的res:"+res);
        return res;
    }
}