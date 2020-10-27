package cn.edu.seufe.stu2017.zhu.game2048.bean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import cn.edu.seufe.stu2017.zhu.game2048.R;

public class SingleGrid extends FrameLayout {
    int number;
    TextView show;
    public SingleGrid(@NonNull Context context) {
        super(context);
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
                show.setBackgroundColor(R.color.Color0);
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
                break;


        }
    }

}
