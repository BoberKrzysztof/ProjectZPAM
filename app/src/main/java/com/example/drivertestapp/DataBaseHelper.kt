package com.example.drivertestapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.lang.Exception
import java.util.ArrayList

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "users.db"
        private const val TAB_USERS = "users"
        private const val NAME = "name"
        private const val SURNAME = "surname"
        private const val LOGIN = "login"
        private const val PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE " + TAB_USERS + "(" + LOGIN + " TEXT PRIMARY KEY, " + NAME
                    + " TEXT, " + SURNAME + " TEXT, " + PASSWORD + " TEXT" + ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TAB_USERS")
        onCreate(db)
    }

    fun insertUser(user: Users): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, user.name)
        contentValues.put(SURNAME, user.surname)
        contentValues.put(LOGIN, user.login)
        contentValues.put(PASSWORD, user.password)
        val result: Long = db.insert(TAB_USERS, null, contentValues)
        return result != -1L
    }

    fun checkLogin(l: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT login FROM users WHERE login = ?", arrayOf(l))
        return cursor.count <= 0
    }

    fun signIn(l: String, p: String): Boolean {
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM users WHERE login = ? AND password = ?", arrayOf(l, p))
        return cursor.count > 0
    }

}