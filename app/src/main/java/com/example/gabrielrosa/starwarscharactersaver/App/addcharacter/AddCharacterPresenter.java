package com.example.gabrielrosa.starwarscharactersaver.App.addcharacter;

import android.content.Context;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.CharactersLocalDataSource;

/**
 * Created by stant02 on 05/02/18.
 */

public class AddCharacterPresenter implements AddCharacterContract.Presenter {

    private AddCharacterContract.View mView;
    private CharactersLocalDataSource mLocalDataSource;

    public AddCharacterPresenter(AddCharacterContract.View view, Context context) {

        mView = view;
        mLocalDataSource = CharactersLocalDataSource.getInstance(context);
    }

    @Override
    public void saveCharacter(Character character) {
        mLocalDataSource.build(character);
        mView.showSaveSuccess();
    }
}
