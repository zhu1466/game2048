package cn.edu.seufe.stu2017.zhu.game2048.myLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.activity.MainActivity;
import cn.edu.seufe.stu2017.zhu.game2048.config.Values;
import cn.edu.seufe.stu2017.zhu.game2048.activity.GameActivity;
import cn.edu.seufe.stu2017.zhu.game2048.bean.SingleGrid;
import cn.edu.seufe.stu2017.zhu.game2048.function.AnimLayer;

public class gameview extends LinearLayout {

    SingleGrid[][] girdNumber = new SingleGrid[5][5] ;
    AnimLayer animLayer;


//    protected void onSizeChanged(int w, int h, int oldw, int oldh){
//        super.onSizeChanged(w,h,oldw,oldh);
//        //girdWith = (int)(Math.min(w,h)-10)/R.integer.columnNum;
//        addNewGird(girdWith,girdheight);
//
//    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Values.girdWidth = (Math.min(w, h)-10)/Values.columnNum;

        //addCards(30,30);

        gameStart();
    }

    private void addCards(int cardWidth,int cardHeight){

        SingleGrid c;

        LinearLayout line;
        LinearLayout.LayoutParams lineLp;

        for (int y = 0; y < Values.columnNum; y++) {
            line = new LinearLayout(getContext());
            lineLp = new LinearLayout.LayoutParams(-1, cardHeight);
            addView(line, lineLp);

            for (int x = 0; x < Values.columnNum; x++) {
                c = new SingleGrid(getContext());
                line.addView(c, cardWidth, cardHeight);

                girdNumber[x][y] = c;
            }
        }
    }

    private int GetCardWidth()
    {

        //屏幕信息的对象
        DisplayMetrics displayMetrics;
        displayMetrics = getResources().getDisplayMetrics();

        //获取屏幕信息
        int cardWidth;
        cardWidth = displayMetrics.widthPixels;

        //一行有四个卡片，每个卡片占屏幕的四分之一
        return ( cardWidth - 10 ) / 4;

    }




    @SuppressLint("ResourceAsColor")
    public void initGameView(){

        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(0xffbbada0);

        int tem = GetCardWidth();
        addCards(GetCardWidth(),GetCardWidth());

        setOnTouchListener(new View.OnTouchListener() {
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
                                Log.i("TAG:","GO LEFT;testSuccess");
                                moveLeft();
                            }else if(x>5){
                                Log.i("TAG:","GO RIGHT;testSuccess");
                                moveRight();
                            }
                        }else if(x*x<y*y){
                            if(y<-5){
                                Log.i("TAG:","GO UP;testSuccess");
                                moveUp();
                            }else if(y>5){
                                Log.i("TAG:","GO DOWN;testSuccess");
                                moveDown();
                            }
                        }

                        break;
                }

                return true;
            }
        });

    }


    /**
     * 游戏开始
     */
    public void gameStart(){

        GameActivity gameActivity = GameActivity.getGameActivity();
        for(int i = 0; i < Values.columnNum; i++){
            for(int j = 0; j < Values.columnNum; j++){
                girdNumber[i][j] = new SingleGrid(this.getContext());
                girdNumber[i][j].setNumber(0);
            }
        }
        addNewGird();
        addNewGird(); //游戏规则:在游戏一开始加入两个方块
    }


    /**
     * 生成随机格子
     */
    public void addNewGird(){
        List<Point> emptyPonintRecord = new ArrayList<Point>();
        emptyPonintRecord.clear();


        for(int i = 0; i < Values.columnNum; i++){
            for (int j = 0; j < Values.columnNum; j++){
                if(girdNumber[i][j].getNumber()<=0){
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
            SingleGrid singleGrid = new SingleGrid(this.getContext());
            singleGrid.setNumber(newGirdNum);
            girdNumber[newGirdPoint.x][newGirdPoint.y] = singleGrid;

            GameActivity.getGameActivity().getAnimLayer().createGird(singleGrid);
        }


    }

    /**
     * 向左移动
     */
    public void moveLeft(){
        boolean flag = false;
        for(int i = 0; i < Values.columnNum; i++){
            for (int j = 0; j < Values.columnNum; j++){
                for(int x = j + 1; x< Values.columnNum; x++){
                    if(girdNumber[x][i].getNumber()>0){
                        GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][i], girdNumber[j][i], x,j,i,i);
                        girdNumber[j][i].setNumber(girdNumber[x][i].getNumber());
                        girdNumber[x][i].setNumber(0);
                        x--;
                        flag = true;
                    }else if(girdNumber[x][i].getNumber() == girdNumber[j][i].getNumber()&& girdNumber[j][i].getNumber()!=0){
                        GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][i], girdNumber[j][i], x,j,i,i);
                        girdNumber[j][i].setNumber(girdNumber[j][i].getNumber()*2);
                        girdNumber[x][i].setNumber(0);
                        //加分
                        flag = true;
                    }
                }
            }
        }
        if(flag){
            addNewGird();
        }
    }

    public void moveRight(){
        boolean flag = false;
        for(int y = 0; y< Values.columnNum; y++){
            for(int x = Values.columnNum-1; x >= 0 ; x--){
                for(int xx = x-1; xx>=0; xx--){
                    if(girdNumber[xx][y].getNumber()>0){
                        if(girdNumber[x][y].getNumber()<=0){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[xx][y], girdNumber[x][y], xx,x,y,y);
                            girdNumber[x][y].setNumber(girdNumber[xx][y].getNumber());
                            girdNumber[xx][y].setNumber(0);

                            x++;
                            flag = true;
                        }else  if(girdNumber[x][y].getNumber() == girdNumber[xx][y].getNumber()){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[xx][y], girdNumber[x][y], xx,x,y,y);
                            girdNumber[x][y].setNumber(girdNumber[x][y].getNumber()*2);
                            girdNumber[xx][y].setNumber(0);
                            //加分
                            flag = true;
                        }
                        break;
                    }
                }

            }
        }
        if(flag){
            addNewGird();
        }
    }


    public void moveUp(){
        boolean flag = false;
        for(int x = 0; x < Values.columnNum ; x++){
            for(int y = 0 ; y < Values.columnNum ; y++){
                for(int yy = y + 1 ; yy < Values.columnNum; yy++){
                    if(girdNumber[x][yy].getNumber() == 0){
                        if(girdNumber[x][y].getNumber()<=0){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][yy], girdNumber[x][y],x,x,yy,y);
                            girdNumber[x][y].setNumber(girdNumber[x][yy].getNumber());
                            girdNumber[x][yy].setNumber(0);

                            y--;
                            flag = true;
                        }else if(girdNumber[x][y].getNumber() == girdNumber[x][yy].getNumber()){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][yy], girdNumber[x][y],x,x,yy,y);
                            girdNumber[x][y].setNumber(girdNumber[x][y].getNumber()*2);
                            girdNumber[x][yy].setNumber(0);
                            //加分
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }
        if(flag){
            addNewGird();
        }
    }


    public void moveDown(){
        boolean flag = false;
        for(int x = 0; x < Values.columnNum ; x++){
            for(int y = Values.columnNum-1 ; y >=0 ; y--){
                for(int yy = y - 1 ; yy>= 0; yy--){
                    if(girdNumber[x][yy].getNumber() > 0){
                        if(girdNumber[x][y].getNumber()<=0){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][yy], girdNumber[x][y],x,x,yy,y);
                            girdNumber[x][y].setNumber(girdNumber[x][yy].getNumber());
                            girdNumber[x][yy].setNumber(0);

                            flag = true;
                            y++;

                        }else if(girdNumber[x][y].getNumber() == girdNumber[x][yy].getNumber()){
                            GameActivity.getGameActivity().getAnimLayer().girdMove(girdNumber[x][yy], girdNumber[x][y],x,x,yy,y);
                            girdNumber[x][y].setNumber(girdNumber[x][y].getNumber()*2);
                            girdNumber[x][yy].setNumber(0);
                            //加分
                            flag = true;
                        }
                        break;
                    }
                }
            }
        }
        if(flag){
            addNewGird();
        }
    }




    public gameview(Context context) {
        super(context);
        initGameView();
    }

    public gameview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    public gameview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();
    }

    public gameview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initGameView();
    }
}
