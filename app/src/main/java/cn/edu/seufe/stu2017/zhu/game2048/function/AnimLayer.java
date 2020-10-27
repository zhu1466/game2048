package cn.edu.seufe.stu2017.zhu.game2048.function;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import cn.edu.seufe.stu2017.zhu.game2048.bean.SingleGrid;

/**
 * 配置卡片的动画动作
 */
public class AnimLayer extends FrameLayout {
    public AnimLayer(@NonNull Context context) {
        super(context);
    }

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

}
