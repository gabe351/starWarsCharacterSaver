package com.example.gabrielrosa.starwarscharactersaver.Domain.entities;

/**
 * Created by gabrielrosa on 28/01/18.
 */

//https://swapi.co/api/people
public class Character {

    private String guid;
    private String name;
    private String mass;
    private String hairColor;


    public Character() {}

    public Character(String guid,
                     String name,
                     String mass,
                     String hairColor) {

        this.guid      = guid;
        this.name      = name;
        this.mass      = mass;
        this.hairColor = hairColor;

    }

    public String getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }
}