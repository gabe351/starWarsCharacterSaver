package com.example.gabrielrosa.starwarscharactersaver.Domain.entities;

import java.util.List;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public class PeopleResponse {

    private List<CharacterResponse> results;
    private int count;

    PeopleResponse(int count,
                   List<CharacterResponse> results) {
        this.count   = count;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public List<CharacterResponse> getResults() {
        return results;
    }
}
