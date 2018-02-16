package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by gabrielrosa on 16/02/18.
 */

@Entity (tableName = "character_entry")
public class CharacterEntry {

    @PrimaryKey
    @NonNull
    private String guid;

    private String name;
    private String mass;
    private String hair;

    public CharacterEntry(@NonNull String guid,
                          String name,
                          String mass,
                          String hair) {
        this.guid = guid;
        this.name = name;
        this.mass = mass;
        this.hair = hair;
    }

    @NonNull
    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getHair() {
        return hair;
    }
}
