package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables.CharacterEntry;

import java.util.List;

/**
 * Created by gabrielrosa on 16/02/18.
 */

@Dao
public interface CharacterDao {

    @Query("SELECT * FROM character_entry")
    List<CharacterEntry> getAll();

    @Query("SELECT * FROM character_entry WHERE guid = :guid")
    CharacterEntry findByGuid(String guid);

    @Insert
    void insert(CharacterEntry characterEntry);

    @Update
    void update(CharacterEntry characterEntry);

    @Delete
    void delete(CharacterEntry characterEntry);

}
