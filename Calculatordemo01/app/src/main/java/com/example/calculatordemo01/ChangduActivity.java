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

import java.util.ArrayList;
import java.util.List;

public class ChangduActivity extends AppCompatActivity {
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
            Intent intent=new Intent(ChangduActivity.this,HanshuActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(ChangduActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(ChangduActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.danweihuansuan){
            Intent intent=new Intent(ChangduActivity.this,DanWeiHuanSuanActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(ChangduActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changdu);

        EditText edit =findViewById(R.id.edit5);
        Spinner spinner5=(Spinner)findViewById(R.id.spinner5);
        Spinner spinner6=(Spinner)findViewById(R.id.spinner6);
        TextView textView=findViewById(R.id.text5);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                //拿到被选择项的值
                s1 = (String) spinner5.getSelectedItem().toString();
//                d1 = Double.parseDouble(s1);
                Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                System.out.println("spinner1:"+s1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s2 = (String) spinner6.getSelectedItem().toString();
//                d2=Double.parseDouble(s2);
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                System.out.println("spinner2:"+s2);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Button button=findViewById(R.id.queren5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d1=Double.parseDouble(edit.getText().toString());
                System.out.println("第一个数："+d1);
                double ans=ChangduActivity.zhongLiang(d1,s1,s2,res);
                System.out.println("处理后的d1："+ans);
                textView.setText(ans+"");

            }
        });
    }
    public static double zhongLiang(double d1,String s1,String s2,double res){
        res=0;
        if(s1.equals("kg")){
            if(s2.equals("g")){
                res=d1*1000;
            }else if(s2.equals("mg")){
                res=d1*1000000;
            }else if(s2.equals("t")){
                res=d1*0.001;
            }
        }else if(s1.equals("g")){
            if(s2.equals("kg")){
                res=d1*0.001;
            }else if(s2.equals("mg")){
                res=d1*1000;
            }else if(s2.equals("t")){
                res=d1*0.000001;
            }
        }else if(s1.equals("mg")){
            if(s2.equals("kg")){
                res=d1*0.000001;
            }else if(s2.equals("g")){
                res=d1*0.001;
            }else if(s2.equals("t")){
                res=d1*0.00000001;
            }
        }else if(s1.equals("t")){
            if(s2.equals("kg")){
                res=d1*1000;
            }else if(s2.equals("g")){
                res=d1*1000000;
            }else if(s2.equals("mg")){
                res=d1*999999999.999;
            }
        }
        System.out.println("函数中的d1:"+d1);
        System.out.println("函数中的res:"+res);
        return res;
    }

}