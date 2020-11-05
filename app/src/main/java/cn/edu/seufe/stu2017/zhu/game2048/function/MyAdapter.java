package cn.edu.seufe.stu2017.zhu.game2048.function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.edu.seufe.stu2017.zhu.game2048.R;

public class MyAdapter extends ArrayAdapter  {
    private static final String TAG = "MyAdapter";


    public MyAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String,String>> list) {

        super(context, resource, list);
    }


    public View getView(int position, View v, ViewGroup vp){
        View itemView = v;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, vp,false);

        }
        Map<String,String> map = (Map<String,String>) getItem(position);
        TextView title = (TextView) itemView.findViewById(R.id.textView6);
        TextView detail = (TextView) itemView.findViewById(R.id.textView8);

        title.setText(map.get("ItemTitle"));
        detail.setText(map.get("ItemDetail"));

        return itemView;
    }



}
