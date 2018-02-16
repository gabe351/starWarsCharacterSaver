package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharacterEntryOld {

    public static final String table = "character";

    public static final class columns {
        public static final String guid = "guid";
        public static final String name = "name";
        public static final String mass = "mass";
        public static final String hair = "hair";
    }

    public static final String[] columnList = {
            CharacterEntryOld.columns.guid,
            CharacterEntryOld.columns.name,
            CharacterEntryOld.columns.mass,
            CharacterEntryOld.columns.hair
    };

}
