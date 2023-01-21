package com.asimodabas.movie_detail_app.db.helper

import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileOutputStream
import java.io.IOException

class DatabaseCopyHelper
    (private val myContext: Context) : SQLiteOpenHelper(myContext, DB_NAME, null, 1) {

    private var DB_PATH: String? = null
    private var myDataBase: SQLiteDatabase? = null

    init {
        DB_PATH = "/data/data/" + myContext.packageName + "/" + "databases/"
    }

    @Throws(IOException::class)
    fun createDataBase() {
        val dbExist = checkDataBase()

        if (dbExist) {
        } else {
            this.readableDatabase
            try {
                copyDataBase()
            } catch (e: IOException) {
                throw Error("Error copying database")
            }

        }

    }

    private fun checkDataBase(): Boolean {
        var checkDB: SQLiteDatabase? = null

        try {
            val myPath = DB_PATH!! + DB_NAME
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: SQLiteException) {
            //database does't exist yet.
        }

        checkDB?.close()
        return if (checkDB != null) true else false
    }

    @Throws(IOException::class)
    private fun copyDataBase() {
        val myInput = myContext.assets.open(DB_NAME)
        val outFileName = DB_PATH!! + DB_NAME
        val myOutput = FileOutputStream(outFileName)
        val buffer = ByteArray(1024)
        var length: Int = 0

        while ({ length = myInput.read(buffer);length }() > 0) {
            myOutput.write(buffer, 0, length)
        }

        myOutput.flush()
        myOutput.close()
        myInput.close()
    }

    @Throws(SQLException::class)
    fun openDataBase() {
        val myPath = DB_PATH!! + DB_NAME
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY)
    }

    @Synchronized
    override fun close() {
        if (myDataBase != null) myDataBase!!.close()
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase) {
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    override fun onOpen(db: SQLiteDatabase) {
        super.onOpen(db)
        db.disableWriteAheadLogging()
    }

    companion object {
        private val DB_NAME = "filmler.sqlite"
    }
}
