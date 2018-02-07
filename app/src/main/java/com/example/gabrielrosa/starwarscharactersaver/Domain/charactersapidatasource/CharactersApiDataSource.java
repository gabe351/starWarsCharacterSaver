package com.example.gabrielrosa.starwarscharactersaver.Domain.charactersapidatasource;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.PeopleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public interface CharactersApiDataSource {

    @GET("people")
    Call<PeopleResponse> getCharacter();

}
