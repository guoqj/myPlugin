package point.mmh.com.myplugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
            }
        });
    }
}
