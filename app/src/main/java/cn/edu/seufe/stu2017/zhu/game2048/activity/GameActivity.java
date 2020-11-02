package cn.edu.seufe.stu2017.zhu.game2048.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.layout.GameView;

/**
 * 游戏界面
 */

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameView gameView = new GameView(this.getBaseContext());
        gameView.initGameView();
        setContentView(gameView);
    }
}