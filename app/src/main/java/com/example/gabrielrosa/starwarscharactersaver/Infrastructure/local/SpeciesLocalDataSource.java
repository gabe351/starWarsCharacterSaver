package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Specie;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.DBHelper;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.SpecieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by stant02 on 05/02/18.
 */

public class SpeciesLocalDataSource {

    private static SpeciesLocalDataSource INSTANCE;
    private SQLiteDatabase db;
    private DBHelper DBHelper;

    private SpeciesLocalDataSource(Context context) {
        DBHelper = DBHelper.getInstance(context);
        db = DBHelper.getWritableDatabase();
    }

    private static Specie specieCursor(Cursor c) {

        String guid           = c.getString(c.getColumnIndex(SpecieEntry.columns.guid));
        String name           = c.getString(c.getColumnIndex(SpecieEntry.columns.name));
        String classification = c.getString(c.getColumnIndex(SpecieEntry.columns.classification));
        String language       = c.getString(c.getColumnIndex(SpecieEntry.columns.language));

        return new Specie(guid, name, classification, language);
    }

    public static SpeciesLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new SpeciesLocalDataSource(context);
        }
        return INSTANCE;
    }

    public Specie build(Specie specie) {
        if (specie.getGuid() == null || specie.getGuid().isEmpty()) {
            specie = create(specie);
        } else {
            specie = update(specie);
        }
        return specie;
    }

    public Specie create(Specie specie) {
        ContentValues values = new ContentValues();
        values.put(SpecieEntry.columns.guid, UUID.randomUUID().toString());
        values.put(SpecieEntry.columns.name, specie.getName());
        values.put(SpecieEntry.columns.classification, specie.getClassification());
        values.put(SpecieEntry.columns.language, specie.getLanguage());
        long id = db.insert(SpecieEntry.table, null, values);
        if (id > 0) {
            return specie;
        }
        return null;
    }

    public Specie update(Specie specie) {
        ContentValues values = new ContentValues();
        values.put(SpecieEntry.columns.name, specie.getName());
        values.put(SpecieEntry.columns.classification, specie.getClassification());
        values.put(SpecieEntry.columns.language, specie.getLanguage());
        long id = db.update(SpecieEntry.table, values, SpecieEntry.columns.guid+"=?", new String[]{specie.getGuid()});
        if (id > 0) {
            return specie;
        }
        return null;
    }

    public Specie delete(Specie specie) {
        long id = db.delete(SpecieEntry.table, SpecieEntry.columns.guid+"=?", new String[]{specie.getGuid()});
        if (id > 0) {
            return specie;
        }
        return null;
    }

    public Specie findByGuid(String specieGuid) {
        Specie specie = new Specie();

        String[] columns = SpecieEntry.columnList;
        String[] dataSearch = new String[]{specieGuid};

        Cursor c = db.query(
                SpecieEntry.table,
                columns,
                SpecieEntry.columns.guid+"=?",
                dataSearch,
                null,
                null,
                SpecieEntry.columns.name
        );
        if (c.moveToFirst()) {
            do {
                specie = SpeciesLocalDataSource.specieCursor(c);
            } while (c.moveToNext());
        }
        return specie;
    }

    public List<Specie> All() {
        List<Specie> species = new ArrayList<>();
        String[] columns = SpecieEntry.columnList;

        Cursor c = db.query(
                SpecieEntry.table,
                columns,
                null,
                null,
                null,
                null,
                SpecieEntry.columns.name
        );

        if (c.moveToFirst()) {
            do {
                Specie specie = SpeciesLocalDataSource.specieCursor(c);
                species.add(specie);
            } while (c.moveToNext());
        }
        return species;
    }
}
