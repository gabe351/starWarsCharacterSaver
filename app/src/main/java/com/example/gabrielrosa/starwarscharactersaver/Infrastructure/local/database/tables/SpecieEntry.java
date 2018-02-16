package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class SpecieEntry {

    public static final String table = "specie";

    public static final class columns {
        public static final String guid           = "guid";
        public static final String name           = "name";
        public static final String classification = "classification";
        public static final String language       = "language";
    }

    public static final String[] columnList = {
            SpecieEntry.columns.guid,
            SpecieEntry.columns.name,
            SpecieEntry.columns.classification,
            SpecieEntry.columns.language
    };
}
