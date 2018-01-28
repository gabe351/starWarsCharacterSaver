package com.example.gabrielrosa.starwarscharactersaver.Domain.entities;

/**
 * Created by gabrielrosa on 28/01/18.
 */

//https://swapi.co/api/species
public class Specie {


    private String name;
    private String classification;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String averageLifespan;
    private String language;

    public Specie(String name,
                  String classification,
                  String averageHeight,
                  String skinColors,
                  String hairColors,
                  String eyeColors,
                  String averageLifespan,
                  String language) {

        this.name            = name;
        this.classification  = classification;
        this.averageHeight   = averageHeight;
        this.skinColors      = skinColors;
        this.hairColors      = hairColors;
        this.eyeColors       = eyeColors;
        this.averageLifespan = averageLifespan;
        this.language        = language;
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public String getLanguage() {
        return language;
    }
}