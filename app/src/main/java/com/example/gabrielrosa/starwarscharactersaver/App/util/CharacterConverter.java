package com.example.gabrielrosa.starwarscharactersaver.App.util;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.CharacterResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public class CharacterConverter {

    public static Character convertFromResponse(CharacterResponse response) {
        return new Character("",
                response.getName(),
                response.getMass(),
                response.getHairColor()
                );
    }

    public static List<Character> convertFromResponses(List<CharacterResponse> responses) {
        List<Character> charactersConverted = new ArrayList<>();

        for (CharacterResponse response: responses) {
            Character converted = convertFromResponse(response);
            charactersConverted.add(converted);
        }

        return charactersConverted;
    }
}
