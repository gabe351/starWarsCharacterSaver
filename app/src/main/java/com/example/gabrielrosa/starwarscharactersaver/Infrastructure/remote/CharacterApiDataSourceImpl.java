package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.remote;

import com.example.gabrielrosa.starwarscharactersaver.Domain.charactersapidatasource.CharactersApiDataSource;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public class CharacterApiDataSourceImpl {

    private static CharacterApiDataSourceImpl INSTANCE;


    private CharacterApiDataSourceImpl () {}

    public static CharacterApiDataSourceImpl getInstance() {
        if (INSTANCE == null)
            INSTANCE = new CharacterApiDataSourceImpl();
        return INSTANCE;
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CharactersApiDataSource create() {
        return retrofit.create(CharactersApiDataSource.class);
    }
}
