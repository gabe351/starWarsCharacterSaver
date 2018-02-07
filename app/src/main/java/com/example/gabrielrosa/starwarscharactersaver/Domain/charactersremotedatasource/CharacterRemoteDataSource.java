package com.example.gabrielrosa.starwarscharactersaver.Domain.charactersremotedatasource;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util.BaseCallback;

import java.util.List;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public interface CharacterRemoteDataSource {
    void getCharacters(BaseCallback.ApiCaseCallback<List<Character>> apiCallback);
}
