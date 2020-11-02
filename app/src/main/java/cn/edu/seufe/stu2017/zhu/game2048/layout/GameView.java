package cn.edu.seufe.stu2017.zhu.game2048.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.activity.MainActivity;
import cn.edu.seufe.stu2017.zhu.game2048.bean.SingleGrid;
import cn.edu.seufe.stu2017.zhu.game2048.function.AnimLayer;

import static cn.edu.seufe.stu2017.zhu.game2048.R.color.*;

public class GameView extends GridLayout {

    int[][] girdNumber ;
    AnimLayer animLayer;

    public GameView(Context context) {
        super(context);
    }



    @SuppressLint("ResourceAsColor")
    public void initGameView(){
        girdNumber = new int[R.integer.columnNum][R.integer.columnNum];
        setColumnCount(R.integer.columnNum);
        setBackgroundColor(Color0);
        setOnTouchListener(new OnTouchListener() {
            float x0,y0;//用来记录用户初始的手势位置
            float x,y;//用户手势轨迹偏移量
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x0=event.getX();
                        y0=event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        x = event.getX()-x0;
                        y = event.getY()-y0;
                        if(x*x>y*y){
                            if(x<-5){

                            }
                        }
                }

                return false;
            }
        });

    }




    /**
     * 生成随机格子
     */
    public void addNewGird(){
        List<Point> emptyPonintRecord = new ArrayList<Point>();
        emptyPonintRecord.clear();

        for(int i = 0; i < R.integer.columnNum; i++){
            for (int j = 0; j < R.integer.columnNum; j++){
                if(girdNumber[i][j]<=0){
                    emptyPonintRecord.add(new Point(i,j));
                }
            }
        }

        if(emptyPonintRecord.size()>0){
            int newGirdNum;
            Point newGirdPoint;
            if(Math.random()>0.2){
                newGirdNum=2;
            }else {
                newGirdNum=4;
            }
            newGirdPoint = emptyPonintRecord.remove((int)Math.random()*emptyPonintRecord.size());
            girdNumber[newGirdPoint.x][newGirdPoint.y] = newGirdNum;
            SingleGrid singleGrid = new SingleGrid(this.getContext());
            singleGrid.setNumber(newGirdNum);//颜色能否显示？？？？？？
            animLayer.createGird(singleGrid);
        }


    }
}
