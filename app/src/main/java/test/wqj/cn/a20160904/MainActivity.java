package test.wqj.cn.a20160904;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
        TextView tv = (TextView) findViewById(R.id.tv1);
        final TextView tv2 = (TextView) findViewById(R.id.tv3);
        Button bt = (Button) findViewById(R.id.button);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View i) {
                    tv2.setText("正在测试。。。。。");
                }
            });
    }
}
