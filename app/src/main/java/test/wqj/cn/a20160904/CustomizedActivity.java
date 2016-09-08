package test.wqj.cn.a20160904;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomizedActivity extends AppCompatActivity {

    @Bind(R.id.tv6)
    TextView tv6;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.myView)
    MyView myView;
    @Bind(R.id.activity_self_defining)
    RelativeLayout activitySelfDefining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_defining);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv6)
    public void onClick() {
        Intent intent = new Intent();
        intent.setClass(CustomizedActivity.this,DrawActivity.class);
        startActivity(intent);
    }
}
