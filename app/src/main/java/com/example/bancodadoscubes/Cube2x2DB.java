package com.example.bancodadoscubes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Cube2x2DB extends SQLiteOpenHelper {

    public static final String TAG = "sql";
    public static final  String NOME_BANCO = "BancoCube2X2.db";
    public static final int VERSÃO_BANCO = 1;
    public static final String TABLE_NAME = "cubo2x2";
    public static final String COLUNA0 = "_id";
    public static final String COLUNA1 = "tempo";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " +TABLE_NAME + " ("
                    + COLUNA0 +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUNA1 + " TEXT )";




    public Cube2x2DB(Context context) {
        super(context, NOME_BANCO, null, VERSÃO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);

        Log.d(TAG,"Tabela"+TABLE_NAME+" criada com sucesso" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    //metodos para salvar e apagar
    public long salva2x2(Cube2x2 cube2x2){

        long id = cube2x2.get_id();

        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues valores2x2 = new ContentValues();

            valores2x2.put(COLUNA1, cube2x2.getTempo2x2());
            if (id !=0){
                int count = db.update(TABLE_NAME, valores2x2,"_id =?",new String[]{String.valueOf(id)});
                return count;
            }

            else {
                id = db.insert(TABLE_NAME, null, valores2x2);
                return id;
            }

        }finally {
            db.close();
        }

    }

    public int apagar2x2(String Apagartempo2x2){
        SQLiteDatabase db = getWritableDatabase();
        try {

            int count = db.delete(TABLE_NAME, "tempo=?", new String[]{Apagartempo2x2});
            Log.i(TAG,"deletou registro 2x2 =>" + count);
            return count;

        }finally {
            db.close();
        }
    }

    public ArrayList<Cube2x2> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Cube2x2> lista2x2 = new ArrayList<>();
        try{
            Cursor c2x2 = db.query(TABLE_NAME, null,null,null, null, null, "tempo asc");
            if(c2x2.moveToFirst()){
                do {
                    @SuppressLint("Range") long id = c2x2.getLong(c2x2.getColumnIndex("_id"));
                    @SuppressLint("Range") String tempo = c2x2.getString(c2x2.getColumnIndex("tempo"));

                    Cube2x2 currentContact2x2 = new Cube2x2(id, tempo);
                    lista2x2.add(currentContact2x2);

                }while(c2x2.moveToNext());
            }
            return  lista2x2;
        }finally {
            db.close();
        }


    }











}