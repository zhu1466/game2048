package cn.edu.seufe.stu2017.zhu.game2048.bean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import cn.edu.seufe.stu2017.zhu.game2048.R;

import static cn.edu.seufe.stu2017.zhu.game2048.R.color.Color0;

public class SingleGrid extends FrameLayout {
    int number=0;
    TextView show;
    View backgroundView;
    @SuppressLint("ResourceAsColor")
    public SingleGrid(@NonNull Context context) {

        super(context);


        LayoutParams layoutParams = null;
        layoutParams = new LayoutParams(-1,-1);
        layoutParams.setMargins(10,10,0,0);

        backgroundView = new View(this.getContext());
        backgroundView.setBackgroundColor(0x33ffffff);
        backgroundView.setVisibility(VISIBLE);
        addView(backgroundView,layoutParams);

        show = new TextView(getContext());
        show.setTextSize(28);
        show.setTextColor(0xFF000000);
        show.setVisibility(View.VISIBLE);
        show.setGravity(Gravity.CENTER);

        layoutParams = new LayoutParams(-1,-1);
        layoutParams.setMargins(10,10,0,0);
        addView(show, layoutParams);

        setNumber(0);


    }

    public int getNumber() {
        return number;
    }

    public TextView getShow() {
        return show;
    }

    public void setShow(TextView show) {
        this.show = show;
    }

    /**
     * 配置方块的数字大小以及颜色，数字大小和颜色一一对应，此色彩选择参考网络资源
     * @param num 配置数字大小
     */
    @SuppressLint("ResourceAsColor")
    public void setNumber(int num){
        this.number = num ;
        if(num<=0){
            show.setText("");
        }
        else {
            show.setText(num + "");
        }
        switch (num){
            case 0:
                show.setBackgroundColor(0x00000000);
                break;
            case 2:
                show.setBackgroundColor(0xffeee4da);
                break;
            case 4:
                show.setBackgroundColor(0xffede0c8);
                break;
            case 8:
                show.setBackgroundColor(0xfff2b179);
                break;
            case 16:
                show.setBackgroundColor(0xfff59563);
                break;
            case 32:
                show.setBackgroundColor(0xfff67c5f);
                break;
            case 64:
                show.setBackgroundColor(0xfff65e3b);
                break;
            case 128:
                show.setBackgroundColor(0xffedcf72);
                break;
            case 256:
                show.setBackgroundColor(0xffedcc61);
                break;
            case 512:
                show.setBackgroundColor(0xffedc850);
                break;
            case 1024:
                show.setBackgroundColor(0xffedc53f);
                break;
            case 2048:
                show.setBackgroundColor(0xffedc22e);
                break;
            default:
                show.setBackgroundColor(0xff3c3a32);
                break;


        }
    }

}
