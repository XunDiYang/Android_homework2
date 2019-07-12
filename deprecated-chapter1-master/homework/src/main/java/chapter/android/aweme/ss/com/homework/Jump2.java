package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Jump2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump2);
        String position = getIntent().getStringExtra("position");
        String ans = "第" + position + "个item";
        Toast.makeText(Jump2.this, ans, Toast.LENGTH_LONG).show();
    }
}
