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
import android.widget.TextView;
import android.widget.Toast;

public class HanshuActivity extends AppCompatActivity {
    //    结果集
    private TextView editText;

    //数字1-9
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;

    private Button btnlog;
    private Button btnln;
    private Button btnpingfang;
    private Button btnsancifang;
    private Button btnsin;
    private Button btncos;
    private Button btntan;
    private Button btncot;
    private Button btnsec;
    private Button btncosec;

    private Button btndot;

    //运算符
    private  Button btnequ;  //=
    private Button btnfuhao;    //-

    //清除
    private  Button btndel;

    boolean clear_flag;//清空标识

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=super.getMenuInflater();
        menuInflater.inflate(R.menu.hanshu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.danweihuansuan){
            Intent intent=new Intent(HanshuActivity.this,DanWeiHuanSuanActivity.class);
            startActivity(intent);

        }else if(item.getItemId()==R.id.main){
            Intent intent=new Intent(HanshuActivity.this,MainActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.jinzhi){
            Intent intent=new Intent(HanshuActivity.this,JinzhiActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(HanshuActivity.this,"这是一个帮助",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hanshu);

        //数字1-9
        View btn1 = findViewById(R.id.btn1);
        View btn2 = findViewById(R.id.btn2);
        View btn3= findViewById(R.id.btn3);
        View btn4 = findViewById(R.id.btn4);
        View btn5 = findViewById(R.id.btn5);
        View btn6 = findViewById(R.id.btn6);
        View btn7 = findViewById(R.id.btn7);
        View btn8 = findViewById(R.id.btn8);
        View btn9 = findViewById(R.id.btn9);
        View btn0 = findViewById(R.id.btn0);

        btnlog=findViewById(R.id.log);
        btndel=findViewById(R.id.btndel);
        btnpingfang=findViewById(R.id.pingfang);
        btnsancifang=findViewById(R.id.sancifang);
        btnsin=findViewById(R.id.sin);
        btncos=findViewById(R.id.cos);
        btntan=findViewById(R.id.tan);

        btndot = findViewById(R.id.btndot);

        btnequ=findViewById(R.id.btnequ);
        btnfuhao=findViewById(R.id.fuhao);


        editText = (TextView) findViewById(R.id.result);//结果集

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);

        btndel.setOnClickListener(listener);
        btnequ.setOnClickListener(listener);
        btndot.setOnClickListener(listener);
        btnpingfang.setOnClickListener(listener);
        btnsancifang.setOnClickListener(listener);
        btnsin.setOnClickListener(listener);
        btncos.setOnClickListener(listener);
        btntan.setOnClickListener(listener);
        btnfuhao.setOnClickListener(listener);
        btnlog.setOnClickListener(listener);

    }

    View.OnClickListener listener= new View.OnClickListener() {
        //读取每个按钮的点击的内容
        public void onClick(View view) {
            //获取文本内容
            String input = editText.getText().toString();
            switch (view.getId()) {
                case R.id.btn0:
                case R.id.btn1:
                case R.id.btn2:
                case R.id.btn3:
                case R.id.btn4:
                case R.id.btn5:
                case R.id.btn6:
                case R.id.btn7:
                case R.id.btn8:
                case R.id.btn9:
                case R.id.btndot:
                    if (clear_flag) {
                        clear_flag = false;
                        editText.setText("");//赋值为空
                    }
                    editText.setText(input + ((Button) view).getText());//结果集就为本身
                    break;

                case R.id.pingfang:
                    if (clear_flag) {
                        clear_flag = false;
                        input = "";
                        editText.setText("");
                    }
                    editText.setText(input + " " + "^2");
                    break;
                case R.id.sancifang :
                    if (clear_flag) {
                        clear_flag = false;
                        input = "";
                        editText.setText("");
                    }
                    editText.setText(input + " " + "^3");
                    break;
                case R.id.sin:
                case R.id.cos:
                case R.id.tan:
                    if (clear_flag) {
                        clear_flag = false;
                        input = "";
                        editText.setText("");
                    }
                    editText.setText(((Button)view).getText()+" "+input);
                    break;
                case R.id.log:
                    if (clear_flag) {
                        clear_flag = false;
                        input = "";
                        editText.setText("");
                    }
                    editText.setText(((Button)view).getText()+" "+input);
                    break;


                case R.id.btndel:
                    if (clear_flag) {
                        clear_flag = false;
                        input = "";
                        editText.setText("");
                    } else if (input != null || !input.equals("")) {//如果获取到的内容为空
                        if(input.length() - 1 < 0){
                            editText.setText(input.substring(0, 0));//结果集为空
                        } else{
                            editText.setText(input.substring(0, input.length() - 1));//结果集为空
                        }
                    }
                    break;

                case R.id.btnequ://运算结果  =
                    getResult();//调用处理结果集的方法
                    break;
            }
        }
    };

    //运算结果的方法
    private void getResult(){
        String exp = editText.getText().toString();//获取文本框的内容
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;

        //进行截取
        //运算符前的数字
        String s1 = exp.substring(0,exp.indexOf(" "));
        //运算符
        String op = exp.substring(exp.indexOf(" ")+1);


        if(op.equals("tan")||s1.equals("tan")){
            if(s1.equals(0)||op.equals(0)){
                Toast ts = Toast.makeText(getBaseContext(),"正切函数自定义不包含0！",Toast.LENGTH_SHORT);
                ts.show();
                result = 0; //则结果是0
            }
        }

        if(op.equals("log")){
            double d1 = Double.parseDouble(s1);
            if(d1<=0){
                Toast ts = Toast.makeText(getBaseContext(),"LOG函数定义域>0！",Toast.LENGTH_SHORT);
                ts.show();
                result = 0; //则结果是0
            }
        }
        if(s1.equals("log")){
            double d2 = Double.parseDouble(op);
            if(d2<=0){
                Toast ts = Toast.makeText(getBaseContext(),"LOG函数定义域>0！",Toast.LENGTH_SHORT);
                ts.show();
                result = 0; //则结果是0
            }
        }

        if(op.equals("^2")){
            double d1=Double.parseDouble(s1);
            result=Math.pow(d1,2);
            editText.setText(result+"");
        }
        else if(op.equals("^3")){
            double d1=Double.parseDouble(s1);
            result=Math.pow(d1,3);
            editText.setText(result+"");
        }
        else if(s1.equals("log")){
            double d1=Double.parseDouble(op);
            result=Math.log(d1);
            editText.setText(result+"");
        }else if(s1.equals("sin")){
            double d1=Double.parseDouble(op);
            result=Math.sin(d1);
            editText.setText(result+"");
        }
        else if(s1.equals("cos")){
            double d1=Double.parseDouble(op);
            result=Math.cos(d1);
            editText.setText(result+"");
        }else if(s1.equals("tan")){
            double d1=Double.parseDouble(op);
            result=Math.tan(d1);
            editText.setText(result+"");
        }else{
            Toast.makeText(getBaseContext(),"表达式有误",Toast.LENGTH_LONG).show();
        }

    }

}