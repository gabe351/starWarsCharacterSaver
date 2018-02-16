package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.database.tables.CharacterEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabrielrosa on 16/02/18.
 */

public class CharacterConverter {

    public static Character convertFromEntry(CharacterEntry entry) {
        return new Character(
                entry.getGuid(),
                entry.getName(),
                entry.getMass(),
                entry.getHair()
        );
    }

    public static CharacterEntry convertFromEntity(Character character) {
        return new CharacterEntry(
                character.getGuid(),
                character.getName(),
                character.getMass(),
                character.getHairColor()
        );
    }

    public static List<Character> convertFromEntries(List<CharacterEntry> entries) {
        List<Character> converted = new ArrayList<>();
        for (CharacterEntry entry:
             entries) {
            converted.add(convertFromEntry(entry));
        }

        return converted;
    }

    public static List<CharacterEntry> convertFromEntities(List<Character> entites) {
        List<CharacterEntry> converted = new ArrayList<>();

        for (Character entity: entites) {
            converted.add(convertFromEntity(entity));
        }

        return converted;
    }
}
