package cn.edu.seufe.stu2017.zhu.game2048.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.function.AnimLayer;
import cn.edu.seufe.stu2017.zhu.game2048.myLayout.gameview;

/**
 * 游戏界面
 */

public class GameActivity extends AppCompatActivity {
    private int score = 0;
    private TextView tvScore,tvBestScore;
    private LinearLayout root = null;
    private Button btnNewGame;
    private gameview gameView ;
    private AnimLayer animLayer = null;
    public static GameActivity gameActivity = null;
    public static final String SP_KEY_BEST_SCORE = "bestScore";

    public GameActivity(){
        this.gameActivity=this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        animLayer = new AnimLayer(getBaseContext());

        root = (LinearLayout) findViewById(R.id.container);
        root.setBackgroundColor(0xfffaf8ef);

        tvScore = (TextView) findViewById(R.id.tvScore);
        tvBestScore = (TextView) findViewById(R.id.tvBestScore);


        gameView = (gameview) findViewById(R.id.gameView);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {
            gameView.gameStart();
        }});

        animLayer = (AnimLayer) findViewById(R.id.animLayer);

    }
    public static GameActivity getGameActivity(){
        return gameActivity;
    }

    public AnimLayer getAnimLayer() {
        return animLayer;
    }


    /**
     * 从sp文件中获取最高分
     * @return
     */
    public int getBestScore(){
        SharedPreferences sp = getSharedPreferences("bestScoreRecord", Activity.MODE_PRIVATE);
        PreferenceManager.getDefaultSharedPreferences(this);
        return sp.getInt("bestScore",0);
    }

    /**
     * 展示最高分
     * @param s
     */
    public void showBestScore(int s){
        tvBestScore.setText(s+"");
    }

    /**
     * 显示游戏分数
     */
    public void showScore(){
        tvScore.setText(score+"");
    }

    /**
     * 加分函数
     * @param s
     */
    public void addScore(int s){
        score+=s;
        showScore();

        int maxScore = Math.max(score, getBestScore());
        saveBestScore(maxScore);
        showBestScore(maxScore);
    }

    /**
     * 保存最高分纪录到文件
     * @param s
     */
    public void saveBestScore(int s){
        SharedPreferences sp = getSharedPreferences("bestScoreRecord", Activity.MODE_PRIVATE);
        int tem=sp.getInt("bestScore",0);
        if(s>tem){
            SharedPreferences.Editor ed = sp.edit();
            ed.putInt("bestScore",s);
            ed.commit();
        }

    }

    /**
     * 清空本次游戏分数数据
     */
    public void clearScore(){
        score = 0;
        showScore();
    }
}