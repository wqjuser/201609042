package test.wqj.cn.a20160904;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestBufterActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.toggleButton)
    ToggleButton toggleButton;
    @Bind(R.id.checkBox)
    CheckBox checkBox;
    @Bind(R.id.radioButton)
    RadioButton radioButton;
    @Bind(R.id.content_test_bufter)
    RelativeLayout contentTestBufter;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bufter);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick({R.id.toolbar, R.id.textView2, R.id.button2, R.id.toggleButton, R.id.checkBox, R.id.radioButton, R.id.content_test_bufter, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                break;
            case R.id.textView2:
                break;
            case R.id.button2:
                break;
            case R.id.toggleButton:
                break;
            case R.id.checkBox:
                break;
            case R.id.radioButton:
                break;
            case R.id.content_test_bufter:
                break;
            case R.id.fab:
                break;
        }
    }
}
