package com.brunoeleodoro.org.qletra;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bruno on 24/12/17.
 */

public class Database {
    private SQLiteDatabase db;
    private Context context;

    public Database(Context context)
    {
        this.context = context;
        db = context.openOrCreateDatabase("bruno_DB",context.MODE_PRIVATE,null);
        create_tables();
    }

    public void sql(String sql)
    {
        db.execSQL(sql);
    }

    public Cursor select(String sql)
    {
        return db.rawQuery(sql,null);
    }

    public void create_tables()
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS musicas(" +
                "cod INTEGER not null," +
                "titulo varchar(500) not null," +
                "nome_musica varchar(500) not null," +
                "letra text not null," +
                "Primary Key(cod));");
    }
}
