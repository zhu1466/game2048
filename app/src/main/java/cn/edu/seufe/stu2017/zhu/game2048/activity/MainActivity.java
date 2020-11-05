package cn.edu.seufe.stu2017.zhu.game2048.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.bean.Record;

/**
 * 主界面
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startB = findViewById(R.id.button);
        Button recordB = findViewById(R.id.button2);
        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        recordB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });
    }
}