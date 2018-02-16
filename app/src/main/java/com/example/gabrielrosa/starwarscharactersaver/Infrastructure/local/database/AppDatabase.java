package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables.CharacterEntry;

/**
 * Created by gabrielrosa on 16/02/18.
 */

@Database(entities = {CharacterEntry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
}
