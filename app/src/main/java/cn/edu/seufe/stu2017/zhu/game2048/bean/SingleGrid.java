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
        addView(backgroundView,layoutParams);

        show = new TextView(getContext());
        show.setTextSize(28);
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
     * 配置方块的数字大小以及颜色，数字大小和颜色一一对应
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
                show.setBackgroundColor(R.color.Color2);
                break;
            case 4:
                show.setBackgroundColor(R.color.Color4);
                break;
            case 8:
                show.setBackgroundColor(R.color.Color8);
                break;
            case 16:
                show.setBackgroundColor(R.color.Color16);
                break;
            case 32:
                show.setBackgroundColor(R.color.Color32);
                break;
            case 64:
                show.setBackgroundColor(R.color.Color64);
                break;
            case 128:
                show.setBackgroundColor(R.color.Color128);
                break;
            case 256:
                show.setBackgroundColor(R.color.Color256);
                break;
            case 512:
                show.setBackgroundColor(R.color.Color512);
                break;
            case 1024:
                show.setBackgroundColor(R.color.Color1024);
                break;
            case 2048:
                show.setBackgroundColor(R.color.Color2048);
                break;
            case 4096:
                show.setBackgroundColor(R.color.Color4096);
                break;
            default:
                show.setBackgroundColor(0xff3c3a32);
                break;


        }
    }

}
