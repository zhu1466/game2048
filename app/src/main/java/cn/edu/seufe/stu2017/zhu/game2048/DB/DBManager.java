package cn.edu.seufe.stu2017.zhu.game2048.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.edu.seufe.stu2017.zhu.game2048.R;
import cn.edu.seufe.stu2017.zhu.game2048.bean.Record;

public class DBManager {
    private DBHelper dbHelper;
    private String TBNAME ;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context,"game2048",null,2);
        TBNAME = "userscore";
    }

    public void add(Record item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SCORE", item.getScore());
        values.put("TIME", item.getTime());
        db.insert(TBNAME, null, values);
        db.close();
    }

    public void addAll(List<Record> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (Record item : list) {
            ContentValues values = new ContentValues();
            values.put("SCORE", item.getScore());
            values.put("TIME", item.getTime());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(Record item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SCORE", item.getScore());
        values.put("TIME", item.getTime());
        db.update(TBNAME, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public List<Record> listAll(){
        List<Record> rateList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        if(cursor!=null){
            rateList = new ArrayList<Record>();
            while(cursor.moveToNext()){
                Record item = new Record();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setScore(cursor.getString(cursor.getColumnIndex("SCORE")));
                item.setTime(cursor.getString(cursor.getColumnIndex("TIME")));

                rateList.add(item);
            }
            cursor.close();
        }
        db.close();
        return rateList;

    }

    public Record findById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        Record rateItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            rateItem = new Record();
            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            rateItem.setScore(cursor.getString(cursor.getColumnIndex("SCORE")));
            rateItem.setTime(cursor.getString(cursor.getColumnIndex("TIME")));
            cursor.close();
        }
        db.close();
        return rateItem;
    }

}
