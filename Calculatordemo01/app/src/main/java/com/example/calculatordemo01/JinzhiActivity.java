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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class JinzhiActivity extends AppCompatActivity {
    String s1;
    String s2;
    String res = "";
    double d1, d2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = super.getMenuInflater();
        menuInflater.inflate(R.menu.jinzhi, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.main) {
            Intent intent = new Intent(JinzhiActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.hanshu) {
            Intent intent = new Intent(JinzhiActivity.this, HanshuActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.danweihuansuan) {
            Intent intent = new Intent(JinzhiActivity.this, DanWeiHuanSuanActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(JinzhiActivity.this, "这是一个帮助", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jinzhi);

        EditText edit = findViewById(R.id.edit3);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        TextView textView = findViewById(R.id.text3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s1 = (String) spinner3.getSelectedItem().toString();
//                d1 = Double.parseDouble(s1);
                Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
                System.out.println("spinner1:" + s1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                s2 = (String) spinner4.getSelectedItem().toString();
//                d2=Double.parseDouble(s2);
//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                System.out.println("spinner2:" + s2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        Button button = findViewById(R.id.queren3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1 = edit.getText().toString();
                System.out.println("第一个数：" + n1);
                String ans = JinzhiActivity.jinZhi(n1, s1, s2, res);
                System.out.println("处理后的d1：" + ans);
                textView.setText(ans+"");

            }
        });
    }

    static char chs[] = new char[36];

    static {
        for (int i = 0; i < 10; i++) {
            chs[i] = (char) ('0' + i);
        }
        for (int i = 10; i < chs.length; i++) {
            chs[i] = (char) ('A' + (i - 10));
        }
    }

    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(chs[number % toRadix]);
            number = number / toRadix;
        }
        return sb.reverse().toString();

    }

    public static String jinZhi(String d1, String s1, String s2, String res) {
        res = "";
        if (s1.equals("二进制")) {
            if (s2.equals("八进制")) {
                res = transRadix(d1, 2, 8);
            } else if (s2.equals("十进制")) {
                res = transRadix(d1, 2, 10);
            } else if (s2.equals("十六进制")) {
                res = transRadix(d1, 2, 16);
            }
        } else if (s1.equals("八进制")) {
            if (s2.equals("二进制")) {
                res = transRadix(d1, 8, 2);
            } else if (s2.equals("十进制")) {
                res = transRadix(d1, 8, 10);
            } else if (s2.equals("十六进制")) {
                res = transRadix(d1, 8, 16);
            }
        } else if (s1.equals("十进制")) {
            if (s2.equals("二进制")) {
                res = transRadix(d1, 10, 2);
            } else if (s2.equals("八进制")) {
                res = transRadix(d1, 10, 8);
            } else if (s2.equals("十六进制")) {
                res = transRadix(d1, 10, 16);
            }
        } else if (s1.equals("十六进制")) {
            if (s2.equals("二进制")) {
                res = transRadix(d1, 16, 2);
            } else if (s2.equals("八进制")) {
                res = transRadix(d1, 16, 8);
            } else if (s2.equals("十进制")) {
                res = transRadix(d1, 16, 10);
            }
        }
        System.out.println("函数中的d1:" + d1);
        System.out.println("函数中的res:" + res);
        return res;
    }
}