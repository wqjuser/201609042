package test.wqj.cn.a20160904;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private Button bt1;
    private Button bt2;
    private Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        et1 = (EditText) findViewById(R.id.sql_et1);
        et2 = (EditText) findViewById(R.id.sql_et2);
        bt1 = (Button) findViewById(R.id.sql_bt1);
        bt2 = (Button) findViewById(R.id.sql_bt2);
        bt3 = (Button) findViewById(R.id.sql_bt3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbOpenHelper mydb = new MyDbOpenHelper(SQLiteActivity.this);
                SQLiteDatabase so = mydb.getWritableDatabase();
                so.execSQL("insert into user(username,password) values(?,?)", new Object[]{et1.getText().toString(), et2.getText().toString()});
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbOpenHelper mydb = new MyDbOpenHelper(SQLiteActivity.this);
                SQLiteDatabase so = mydb.getReadableDatabase();
                Cursor cursor = so.rawQuery("select * from user", null);
                while (cursor.moveToNext()) {
                    String username = cursor.getString(0);
                    String password = cursor.getString(1);
                    Toast.makeText(SQLiteActivity.this, "用户名为" + username, Toast.LENGTH_SHORT).show();
                    Toast.makeText(SQLiteActivity.this, "密码为" + password, Toast.LENGTH_SHORT).show();
                    et1.setText(username);
                    et2.setText(password);
                }
                cursor.close();
                so.close();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbOpenHelper mydb = new MyDbOpenHelper(SQLiteActivity.this);
                SQLiteDatabase so = mydb.getWritableDatabase();
                so.execSQL("delete from user");
                Toast.makeText(SQLiteActivity.this, "数据删除成功" , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SQLiteActivity.this,CustomizedActivity.class);
                startActivity(intent);
                Toast.makeText(SQLiteActivity.this, "这是自定义视图", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
