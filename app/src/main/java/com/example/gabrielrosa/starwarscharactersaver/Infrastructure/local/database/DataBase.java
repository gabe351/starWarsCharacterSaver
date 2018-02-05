package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NOME = "AppDb";
    public static final int VERSION    = 1;

    private static DataBase INSTANCE;
    private DataBase(Context context) {
        super(context, DB_NOME, null, VERSION);
    }

    private static final String dropCharacterEntry = "DROP TABLE IF EXISTS" + CharacterEntry.table;
    private static final String dropSpecieEntry    = "DROP TABLE IF EXISTS" + SpecieEntry.table;

    private static final String createCharacterEntry = String.format(
            "CREATE TABLE %s (" +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL)",
            CharacterEntry.table,
            CharacterEntry.columns.guid,
            CharacterEntry.columns.name,
            CharacterEntry.columns.mass,
            CharacterEntry.columns.hair);

    private static final String createSpecieEntry = String.format(
            "CREATE TABLE %s (" +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL," +
                    "%s TEXT NOT NULL)",
            SpecieEntry.table,
            SpecieEntry.columns.guid,
            SpecieEntry.columns.name,
            SpecieEntry.columns.classification,
            SpecieEntry.columns.language);

    public static DataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DataBase(context);
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dropCharacterEntry);
        db.execSQL(dropSpecieEntry);
        db.execSQL(createCharacterEntry);
        db.execSQL(createSpecieEntry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
