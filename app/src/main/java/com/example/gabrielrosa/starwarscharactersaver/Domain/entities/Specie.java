package com.example.gabrielrosa.starwarscharactersaver.Domain.entities;

/**
 * Created by gabrielrosa on 28/01/18.
 */

//https://swapi.co/api/species
public class Specie {

    private String guid;
    private String name;
    private String classification;
    private String language;

    public Specie(String guid,
                  String name,
                  String classification,
                  String language) {
        this.guid            = guid;
        this.name            = name;
        this.classification  = classification;
        this.language        = language;
    }

    public String getGuid() { return guid; }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getLanguage() {
        return language;
    }
}