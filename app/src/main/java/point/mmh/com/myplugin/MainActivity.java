package point.mmh.com.myplugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import point.mmh.com.myplugin.voice.IVideoConfig;
import point.mmh.com.myplugin.voice.MMhVoiceManage;
import point.mmh.com.myplugin.workmanager.MmhWorkJobStrategy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MmhWorkJobStrategy.initMMhWorkJob(MainActivity.this);
        findViewById(R.id.tests).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MmhWorkJobStrategy.startWork(MainActivity.this);
                //TTSUtils.getInstance(MainActivity.this).speak(MainActivity.this,"123");
               // MMhVoiceManage.getInstance(MainActivity.this).playVideo("近江时代大厦");
                test();
            }
        });
    }
    public void test(){
        List list=new ArrayList();
        list.add("1个");
        list.add("1个");
        list.add("1个");
        MMhVoiceManage.getInstance(MainActivity.this).playVideo(list);
    }
}
