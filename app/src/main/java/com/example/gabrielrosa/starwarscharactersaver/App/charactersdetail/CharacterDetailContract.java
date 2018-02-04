package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.view.View;

/**
 * Created by gabrielrosa on 04/02/18.
 */

public interface CharacterDetailContract {

    interface view {
        void saveCharacter(View view);
        void deleteCharacter(View view);
        void editCharacter(View view);
    }

    interface presenter {

    }

}
