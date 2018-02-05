package com.example.gabrielrosa.starwarscharactersaver.App.addcharacter;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;

/**
 * Created by stant02 on 05/02/18.
 */

public interface AddCharacterContract {

    interface View {
        void saveCharacter();
        void showSaveSuccess();
    }

    interface Presenter {
        void saveCharacter(Character character);
    }


}
