package test.wqj.cn.a20160904;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        et1=(EditText)findViewById(R.id.fil_tv1);
        et2=(EditText)findViewById(R.id.fil_tv2);
        bt1=(Button)findViewById(R.id.fil_bt);
        bt2=(Button)findViewById(R.id.fil_bt1);
        bt3=(Button)findViewById(R.id.fil_tz);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream outputStream = FileActivity.this.openFileOutput("login.txt", Context.MODE_PRIVATE);
                    outputStream.write((et1.getText().toString()+"#"+et2.getText().toString()).getBytes());
                    outputStream.close();
                    Toast.makeText(FileActivity.this,"保存成功",Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("ceshi");
                et2.setText("ceshi");
                try {
                    FileInputStream inputStream =FileActivity.this.openFileInput("login.txt");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int length = -1;
                    while((length=inputStream.read(buffer))!=-1){
                        stream.write(buffer,0,length);
                    }
                    stream.close();
                    inputStream.close();
                    et1.setText(stream.toString().split("#")[0]);
                    et2.setText(stream.toString().split("#")[1]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(FileActivity.this,SQLiteActivity.class);
                startActivity(intent);
            }
        });
    }
}
