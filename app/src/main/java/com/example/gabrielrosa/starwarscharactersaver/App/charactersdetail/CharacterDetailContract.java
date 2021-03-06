package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.view.View;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;

/**
 * Created by gabrielrosa on 04/02/18.
 */

public interface CharacterDetailContract {

    interface view {
        void saveCharacter(View view);
        void deleteCharacter(View view);
        void editCharacter(View view);

        void configureFromApiLayout();
        void configureFromDataBaseLayout();

        void showSavedSuccess();
        void showDeleteSuccess();

        void setFields(Character character);
    }

    interface Presenter {
        void setupLayout(boolean isFromApi);
        void delete(Character character);
        void save(Character character);
        void findBy(String guid);
    }

}
