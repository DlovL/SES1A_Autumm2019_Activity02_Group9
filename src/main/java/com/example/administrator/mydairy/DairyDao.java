package com.example.administrator.mydairy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class DairyDao {

    private MySQHelper sqHelper;
    public Long Check;
    private int sum;
    public List<Bean> data;
    private Bean bean;

    public DairyDao(Context context){
        sqHelper = new MySQHelper(context);
    }

    public void AddUser(String username,String pwd){
        SQLiteDatabase sqLiteDatabase = sqHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("pwd",pwd);
        Check = sqLiteDatabase.insert("user",null,contentValues);
        sqLiteDatabase.close();
    }

    public String Querycount(String username,String pwd) {
        SQLiteDatabase sqLiteDatabase = sqHelper.getReadableDatabase();
        String sqll = "select * from user where username =" + "'" + username + "'" + "and pwd =" + "'" + pwd + "'";
        String mima = null;
        Cursor cursor1 = sqLiteDatabase.rawQuery(sqll, null);
        if (cursor1.moveToNext()) {
            mima = cursor1.getString(cursor1.getColumnIndex("pwd"));
        }
        return mima;
    }

    //"number varchar(40),zhijing varchar(40),bihou varchar(40)," +
    //            "changdu varchar(40),zhongliang varchar(40),shuliang varchar(40)," +
    //                    "pinzhong varchar(40),caizhi varchar(40),weizhi varchar(40),ruku varchar(40))"

    public void Add(Charity bean){
        SQLiteDatabase sqLiteDatabase = sqHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",Common.username);
        contentValues.put("name",bean.getName());
        contentValues.put("address",bean.getAddress());
        contentValues.put("date",bean.getDate());

        Check = sqLiteDatabase.insert("Dairy",null,contentValues);
        sqLiteDatabase.close();
    }

    public void Delete(String id){
        SQLiteDatabase sqLiteDatabase = sqHelper.getWritableDatabase();
        sqLiteDatabase.delete("Dairy","id=?",new String[]{id});
        sqLiteDatabase.close();
    }


    public List<Charity> Query(){
        data = new ArrayList<Bean>();
        SQLiteDatabase sqLiteDatabase = sqHelper.getReadableDatabase();
        String sql = "select Count(*) from Dairy where username='"+Common.username+"'";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();
        sum = cursor.getInt(0);
        String sqll = "select * from Dairy where username='"+Common.username+"'";
        Cursor cursor1 = sqLiteDatabase.rawQuery(sqll,null);
        List<Charity> list = new ArrayList<>();
        for (int i = 1;i<= sum;i++) {
            if (cursor1.moveToNext()) {

                Charity bean = new Charity(cursor1.getString(cursor1.getColumnIndex("name")),cursor1.getString(cursor1.getColumnIndex("address")),cursor1.getString(cursor1.getColumnIndex("date")));
                bean.setId(cursor1.getInt(cursor1.getColumnIndex("id")));
                list.add(bean);
            }
        }
        sqLiteDatabase.close();
        return list;
    }
    public void Update(Bean bean) {
        SQLiteDatabase sqLiteDatabase = sqHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("number",bean.number);
        contentValues.put("zhijing",bean.zhijing);
        contentValues.put("bihou",bean.bihou);
        contentValues.put("changdu",bean.changdu);
        contentValues.put("zhongliang",bean.zhongliang);
        contentValues.put("shuliang",bean.shuliang);
        contentValues.put("pinzhong",bean.pinzhong);
        contentValues.put("caizhi",bean.caizhi);
        contentValues.put("weizhi",bean.weizhi);
        contentValues.put("ruku",bean.ruku);
        contentValues.put("jilu",bean.jilu);
        sqLiteDatabase.update("Dairy", contentValues, "number=?", new String[]{bean.number});
        sqLiteDatabase.close();
    }
}
