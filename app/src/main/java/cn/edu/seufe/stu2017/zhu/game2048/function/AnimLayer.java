package cn.edu.seufe.stu2017.zhu.game2048.function;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Config;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.bean.SingleGrid;

/**
 * 配置卡片的动画动作
 */
public class AnimLayer extends FrameLayout {
    public AnimLayer(@NonNull Context context) {
        super(context);
    }
    ArrayList<SingleGrid> girdList = new ArrayList<>(); //方块队列，用来规划方块的形成规则，主要用于存放和获取暂时需要移动的方块

    /**
     * 生成方块
     * @param singleGrid
     */
    public void createGird(SingleGrid singleGrid){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f,1,0.1f,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(100);
        singleGrid.setAnimation(null);
        singleGrid.getShow().startAnimation(scaleAnimation);
    }


    /**
     * 从方块队列中获得方块，如果队列为空，则新建生成
     * @param value
     * @return
     */
    public SingleGrid getGird(int value){
        SingleGrid gird;
        if(girdList.size()>0){
            gird = girdList.remove(0);
        }else {
            gird = new SingleGrid(getContext());
            addView(gird);
        }
        gird.setVisibility(View.VISIBLE);
        gird.setNumber(value);
        return gird;
    }

    /**
     * 移动方块
     * @param singleGrid
     */
    public void removeGird(SingleGrid singleGrid){
        singleGrid.setVisibility(View.INVISIBLE);
        singleGrid.setAnimation(null);
        girdList.add(singleGrid);
    }

    /**
     * 方块移动函数
     * @param originGird 初始方块
     * @param finalGird 结果方块
     * @param X1 初始x坐标
     * @param X2 终点x坐标
     * @param Y1 初始y坐标
     * @param Y2 终点y坐标
     */
    public void girdMove(SingleGrid originGird, final SingleGrid finalGird, int X1, int X2, int Y1, int Y2){
        final SingleGrid temGird = getGird(originGird.getNumber());

        LayoutParams layoutParams = new LayoutParams(R.integer.girdWith, R.integer.girdheight);
        layoutParams.leftMargin = Integer.valueOf(R.integer.girdWith)*X1;
        layoutParams.topMargin = Integer.valueOf(R.integer.girdheight)*Y1;
        temGird.setLayoutParams(layoutParams);

        if(finalGird.getNumber()<=0){
            finalGird.getShow().setVisibility(View.INVISIBLE);
        }

        TranslateAnimation translateAnimation = new TranslateAnimation(0,Integer.valueOf(R.integer.girdWith)*(X2-X1),0,Integer.valueOf(R.integer.girdheight)*(Y2-Y1));
        translateAnimation.setDuration(20);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finalGird.getShow().setVisibility(View.VISIBLE);
                removeGird(temGird);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        temGird.startAnimation(translateAnimation);


    }

}
