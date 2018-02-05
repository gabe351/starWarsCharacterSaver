package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.support.annotation.NonNull;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;

import java.util.List;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public interface CharactersContract {

    interface View {
        void setLocalData(android.view.View view);
        void setRemoteData(android.view.View view);

        void showFromDataBaseLayout(List<Character> characters);
        void showFromApiLayout(List<Character> characters);

        void goToAddCharacterScreen();
    }

    interface Presenter {
        void loadDataFromApi();
        void loadDataFromDataBase();
    }
}
