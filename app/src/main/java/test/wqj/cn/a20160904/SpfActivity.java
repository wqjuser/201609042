package test.wqj.cn.a20160904;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SpfActivity extends AppCompatActivity {
    private Button bt;
    private Button bt1;
    private Button bt2;
    private TextView tv1;
    private TextView tv2;
    SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spf);
        bt = (Button) findViewById(R.id.spf_bt);
        bt1 = (Button) findViewById(R.id.spf_bt1);
        bt2 = (Button) findViewById(R.id.spf_tz);
        tv1 = (TextView) findViewById(R.id.spf_tv1);
        tv2 = (TextView) findViewById(R.id.spf_tv2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = tv1.getText().toString().trim();
                String password = tv2.getText().toString().trim();
                s = SpfActivity.this.getSharedPreferences("login", 0);
                SharedPreferences.Editor editor = s.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.commit();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences read = getSharedPreferences("login", 1);
                String value1 = read.getString("username", "");
                String value2 = read.getString("password", "");
                String Username = value1;
                String Password = value2;
                tv1.setText(Username);
                tv2.setText(Password);
                Toast.makeText(SpfActivity.this, "账号是" + Username, Toast.LENGTH_SHORT).show();
                Toast.makeText(SpfActivity.this, "密码是" + Password, Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SpfActivity.this,FileActivity.class);
                startActivity(intent);
            }
        });
    }
}
