package cn.edu.seufe.stu2017.zhu.game2048.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        TextView textView = findViewById(R.id.textView2);
        textView.setText("最高分"+String.valueOf(getBestScore()));
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

    public int getBestScore(){
        SharedPreferences sp = getSharedPreferences("bestScoreRecord", Activity.MODE_PRIVATE);
        PreferenceManager.getDefaultSharedPreferences(this);
        return sp.getInt("bestScore",0);
    }
}