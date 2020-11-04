package cn.edu.seufe.stu2017.zhu.game2048.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}