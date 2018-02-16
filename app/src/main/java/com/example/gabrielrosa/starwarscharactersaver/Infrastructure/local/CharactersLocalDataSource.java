package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local;

import android.arch.persistence.room.Room;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.AppDatabase;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables.CharacterEntry;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables.CharacterEntryOld;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.DBHelper;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util.CharacterConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersLocalDataSource {

    private static CharactersLocalDataSource INSTANCE;
    private AppDatabase db;

    private CharactersLocalDataSource(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class,
                "character-db")
                .allowMainThreadQueries()
                .build();
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
        CharacterEntry entry = new CharacterEntry(
                UUID.randomUUID().toString(),
                character.getName(),
                character.getMass(),
                character.getHairColor());
        db.characterDao().insert(entry);

        return new Character(entry.getGuid(), entry.getName(), entry.getMass(), entry.getHair());
    }

    public Character update(Character character) {
        db.characterDao().update(CharacterConverter.convertFromEntity(character));
        return findByGuid(character.getGuid());
    }

    public Character findByGuid(String characterGuid) {
        return CharacterConverter.convertFromEntry(db.characterDao().findByGuid(characterGuid));
    }

    public void delete(Character character) {
        db.characterDao().delete(CharacterConverter.convertFromEntity(character));
    }

    public List<Character> All() {
        return CharacterConverter.convertFromEntries(db.characterDao().getAll());
    }
}
