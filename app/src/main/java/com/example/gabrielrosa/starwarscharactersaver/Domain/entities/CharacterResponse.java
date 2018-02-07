package com.example.gabrielrosa.starwarscharactersaver.Domain.entities;

/**
 * Created by gabrielrosa on 06/02/18.
 */

public class CharacterResponse {

    private String name;
    private String mass;
    private String hair_color;

    public CharacterResponse (String name,
                              String mass,
                              String hair_color) {
        this.name       = name;
        this.mass       = mass;
        this.hair_color = hair_color;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hair_color;
    }
}
