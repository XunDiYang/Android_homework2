package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 * 包含根节点：7个
 */
public class Exercises2 extends AppCompatActivity {
    static final String TAG = "MainActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countview);
        Button btn1 = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.tv1);
        final View inflate = LayoutInflater.from(this).inflate(R.layout.im_list_item,null);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = getViewCount(inflate);
                tv1.setText(String.valueOf(count));
            }
        });
    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        if(!(view instanceof ViewGroup)){
            return 1;
        }
        else {
            int num = ((ViewGroup) view).getChildCount();
            Log.d(TAG,"num: "+String.valueOf(num));
            int childSum = 0;
            for(int i = 0; i < num ; i++){
                View  child1 = ((ViewGroup) view).getChildAt(i);
                if(child1 instanceof  ViewGroup){
                    int child1Num = getViewCount(child1);
                    Log.d(TAG,"num" + String.valueOf(i) + ": "+ String.valueOf(child1Num));
                    childSum = childSum + child1Num - 1;
                }
            }
           return num + childSum + 1;
        }

    }


}
