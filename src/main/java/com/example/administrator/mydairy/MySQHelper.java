package com.example.administrator.mydairy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MySQHelper extends SQLiteOpenHelper {

    public MySQHelper(Context context) {
        super(context, "my.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Dairy(id integer primary key autoincrement," +
                "username varchar(40),name varchar(40),address varchar(40),date varchar(40))");


        sqLiteDatabase.execSQL("create table user(" +
                "id integer primary key autoincrement," +
                "username varchar(40)," +
                "pwd varhar(40)" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("alter table Dairy add id int(4)");
    }
}
