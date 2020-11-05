package cn.edu.seufe.stu2017.zhu.game2048.activity;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.edu.seufe.stu2017.zhu.game2048.DB.DBHelper;
import cn.edu.seufe.stu2017.zhu.game2048.DB.DBManager;
import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.bean.Record;
import cn.edu.seufe.stu2017.zhu.game2048.function.MyAdapter;

/**
 * 记录界面
 */
public class RecordActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<HashMap<String, String>> listItems = new ArrayList<HashMap<String, String>>();

        DBHelper dbHelper = new DBHelper(this.getBaseContext(), "game2048",null,2);
        SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        String sql = "insert into userscore (SCORE,TIME) values ('3054','2020-11-3')";
        DBManager dbManager =new DBManager(this);
        List<Record> records =  dbManager.listAll();
        sqliteDatabase.execSQL(sql);

        for(int i = 0; i <records.size() ; i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle","分数："+records.get(i).getScore());
            map.put("ItemDetail","时间："+records.get(i).getTime());
            listItems.add(map);
        }

        MyAdapter ma = new MyAdapter(this,R.layout.list_item, (ArrayList<HashMap<String, String>>) listItems);
        this.getListView().setAdapter(ma);




    }
}