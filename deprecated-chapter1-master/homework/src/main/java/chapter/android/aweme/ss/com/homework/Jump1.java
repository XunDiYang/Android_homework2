package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Jump1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump1);
        final String position = getIntent().getStringExtra("position");
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans = "";
                switch (position) {
                    case "fans":
                        ans = "显示你的粉丝";
                        break;
                    case "me":
                        ans = "显示你的主页";
                        break;
                    case "great":
                        ans = "显示你点赞的内容";
                        break;
                    case "comm":
                        ans = "显示你的评论";
                        break;
                }
                Toast.makeText(Jump1.this, ans, Toast.LENGTH_LONG).show();
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    //Intent action1 = new Intent("action1");//可以使用构造传入action参数
                    Intent intent = new Intent(Jump1.this, Exercises3.class);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(Jump1.this,"启动失败",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
