package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharacterEntry {

    public static final String table = "character";

    public static final class columns {
        public static final String guid = "guid";
        public static final String name = "name";
        public static final String mass = "mass";
        public static final String hair = "hair";
    }

    public static final String[] columnList = {
            CharacterEntry.columns.guid,
            CharacterEntry.columns.name,
            CharacterEntry.columns.mass,
            CharacterEntry.columns.hair
    };

}
