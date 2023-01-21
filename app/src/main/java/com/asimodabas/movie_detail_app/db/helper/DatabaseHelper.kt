package com.asimodabas.movie_detail_app.db.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "filmler.sqlite", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"yonetmenler\" (\n" + "\t\"yonetmen_id\"\tINTEGER,\n" + "\t\"yonetmen_ad\"\tTEXT,\n" + "\tPRIMARY KEY(\"yonetmen_id\" AUTOINCREMENT)\n" + ");"
        )
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"kategoriler\" (\n" + "\t\"kategori_id\"\tINTEGER,\n" + "\t\"kategori_ad\"\tTEXT,\n" + "\tPRIMARY KEY(\"kategori_id\" AUTOINCREMENT)\n" + ");"
        )
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"filmler\" (\n" + "\t\"film_id\"\tINTEGER,\n" + "\t\"film_ad\"\tTEXT,\n" + "\t\"film_yil\"\tINTEGER,\n" + "\t\"film_resim\"\tTEXT,\n" + "\t\"kategori_id\"\tINTEGER,\n" + "\t\"yonetmen_id\"\tINTEGER,\n" + "\tFOREIGN KEY(\"kategori_id\") REFERENCES \"kategoriler\"(\"kategoril_id\"),\n" + "\tFOREIGN KEY(\"yonetmen_id\") REFERENCES \"yonetmenler\"(\"yonetmen_id\"),\n" + "\tPRIMARY KEY(\"film_id\" AUTOINCREMENT)\n" + ");"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS yonetmenler")
        db?.execSQL("DROP TABLE IF EXISTS kategoriler")
        db?.execSQL("DROP TABLE IF EXISTS filmler")
        onCreate(db)
    }
}