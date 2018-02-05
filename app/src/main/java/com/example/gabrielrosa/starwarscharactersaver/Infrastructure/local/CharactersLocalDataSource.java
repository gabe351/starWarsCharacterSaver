package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.CharacterEntry;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersLocalDataSource {

    private static CharactersLocalDataSource INSTANCE;
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    private CharactersLocalDataSource(Context context) {
        dbHelper = DBHelper.getInstance(context);
        db       = dbHelper.getWritableDatabase();
    }

    private static Character charactersCursor(Cursor c) {

        String guid = c.getString(c.getColumnIndex(CharacterEntry.columns.guid));
        String name = c.getString(c.getColumnIndex(CharacterEntry.columns.name));
        String mass = c.getString(c.getColumnIndex(CharacterEntry.columns.mass));
        String hair = c.getString(c.getColumnIndex(CharacterEntry.columns.hair));

        return new Character(guid, name, mass, hair);
    }

    public static CharactersLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CharactersLocalDataSource(context);
        }

        return INSTANCE;
    }

    public Character build(Character character) {
        if (character.getGuid() == null || character.getGuid().isEmpty()) {
            character = create(character);
        } else {
            character = update(character);
        }
        return character;
    }

    public Character create(Character character) {
        ContentValues values = new ContentValues();
        values.put(CharacterEntry.columns.guid, UUID.randomUUID().toString());
        values.put(CharacterEntry.columns.name, character.getName());
        values.put(CharacterEntry.columns.mass, character.getMass());
        values.put(CharacterEntry.columns.hair, character.getHairColor());
        long id = db.insert(CharacterEntry.table, null, values);
        if (id > 0) {
            return character;
        }
        return null;
    }

    public Character update(Character character) {
        ContentValues values = new ContentValues();
        values.put(CharacterEntry.columns.name, character.getName());
        values.put(CharacterEntry.columns.mass, character.getMass());
        values.put(CharacterEntry.columns.hair, character.getHairColor());
        long id = db.update(CharacterEntry.table, values, CharacterEntry.columns.guid+"=?", new String[]{character.getGuid()});
        if (id > 0) {
            return character;
        }
        return null;
    }

    public Character delete(Character character) {
        long id = db.delete(CharacterEntry.table, CharacterEntry.columns.guid+"=?", new String[]{character.getGuid()});
        if (id > 0) {
            return character;
        }
        return null;
    }

    public Character findByGuid(String characterGuid) {
        Character character = new Character();

        String[] columns = CharacterEntry.columnList;
        String[] dataSearch = new String[]{characterGuid};

        Cursor c = db.query(
                CharacterEntry.table,
                columns,
                CharacterEntry.columns.guid+"=?",
                dataSearch,
                null,
                null,
                CharacterEntry.columns.name
        );
        if (c.moveToFirst()) {
            do {
                character = CharactersLocalDataSource.charactersCursor(c);
            } while (c.moveToNext());
        }
        return character;
    }

    public List<Character> All() {
        List<Character> people = new ArrayList<>();
        String[] columns = CharacterEntry.columnList;

        Cursor c = db.query(
                CharacterEntry.table,
                columns,
                null,
                null,
                null,
                null,
                CharacterEntry.columns.name
        );

        if (c.moveToFirst()) {
            do {
                Character character = CharactersLocalDataSource.charactersCursor(c);
                people.add(character);
            } while (c.moveToNext());
        }
        return people;
    }
}
