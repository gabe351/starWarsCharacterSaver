package com.example.gabrielrosa.starwarscharactersaver.Infrastructure.remote;

import com.example.gabrielrosa.starwarscharactersaver.App.characters.CharactersContract;
import com.example.gabrielrosa.starwarscharactersaver.App.util.CharacterConverter;
import com.example.gabrielrosa.starwarscharactersaver.Domain.charactersremotedatasource.CharacterRemoteDataSource;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.PeopleResponse;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util.BaseCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersRemoteDataSourceImpl implements CharacterRemoteDataSource {

    @Override
    public void getCharacters(BaseCallback.ApiCaseCallback<List<Character>> apiCallback) {
        CharacterApiDataSourceImpl mApiDataSource = CharacterApiDataSourceImpl.getInstance();
        Call<PeopleResponse> call = mApiDataSource.create().getCharacter();

        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                if (response.isSuccessful()) {
                    List<Character> characters = CharacterConverter.convertFromResponses(response.body().getResults());
                    apiCallback.onSuccess(characters);
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                apiCallback.onError();
            }
        });
    }
}
