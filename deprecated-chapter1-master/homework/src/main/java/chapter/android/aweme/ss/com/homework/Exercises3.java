package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.News;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ImageView img_fans = findViewById(R.id.img_fans);
        ImageView img_great = findViewById(R.id.img_great);
        ImageView img_me = findViewById(R.id.img_me);
        ImageView img_comm = findViewById(R.id.img_comm);

        img_fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Exercises3.this, Jump1.class);
               intent.putExtra("position","fans");
               startActivity(intent);
            }
        });
        img_great.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercises3.this, Jump1.class);
                intent.putExtra("position","great");
                startActivity(intent);
            }
        });
        img_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercises3.this, Jump1.class);
                intent.putExtra("position","me");
                startActivity(intent);
            }
        });
        img_comm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercises3.this, Jump1.class);
                intent.putExtra("position","comm");
                startActivity(intent);
            }
        });

        LinkedList mdata = new LinkedList<News>();
        mdata.add(new News("陌生人消息","yaya: 转发[直播]：七舅老爷", "1 min 前",R.drawable.session_stranger));
        mdata.add(new News("系统消息","账号登陆提醒", "2 min 前",R.drawable.session_system_notice));
        mdata.add(new News("抖音小助手","# 收下我的双下巴祝福", "3 min 前",R.drawable.session_robot));
        mdata.add(new News("nono","转发[视频]", "4 min 前",R.mipmap.h));
        mdata.add(new News("yoyo","在吗？接下快递", "5 min 前",R.drawable.icon_girl));
        mdata.add(new News("拉拉","我是拉拉，我们开始聊天吧", "7 min 前",R.mipmap.g));
        mdata.add(new News("df","有时间吗", "10 min 前",R.mipmap.a));
        mdata.add(new News("shannel","[Hi]", "1 天 前",R.mipmap.b));

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ListViewAdapter(mdata,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Exercises3.this, Jump2.class);
                intent.putExtra("position", String.valueOf(position));
//                Intent intent = null;
//                try {
//                    intent = new Intent(ListViewActivity.this, Class.forName("com.ss.android.ugc.chapter1.MainActivity"));
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
                startActivity(intent);
            }
        });
    }

    public static class ListViewAdapter extends BaseAdapter {

        private LinkedList<News> mData;
        private Context mContext;

        public ListViewAdapter(LinkedList<News> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.im_list_item,parent,false);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            TextView msg = (TextView) convertView.findViewById(R.id.message);
            TextView time = (TextView) convertView.findViewById(R.id.time);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            img.setImageResource(mData.get(position).getImg());
            msg.setText(mData.get(position).getMessage());
            time.setText(mData.get(position).getTime());
            title.setText(mData.get(position).getTitle());
            return convertView;
        }
    }
}
