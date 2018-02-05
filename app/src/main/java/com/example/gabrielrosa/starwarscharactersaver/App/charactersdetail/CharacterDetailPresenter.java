package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.content.Context;

import com.example.gabrielrosa.starwarscharactersaver.App.characters.CharactersContract;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.CharactersLocalDataSource;

/**
 * Created by stant02 on 05/02/18.
 */

public class CharacterDetailPresenter implements CharacterDetailContract.Presenter {

    private CharacterDetailContract.view mView;
    private CharactersLocalDataSource mLocalDataSource;

    public CharacterDetailPresenter(CharacterDetailContract.view view, Context context) {
        mView = view;
        mLocalDataSource = CharactersLocalDataSource.getInstance(context);
    }

    @Override
    public void setupLayout(boolean isFromApi) {
        if (isFromApi) {
            mView.configureFromApiLayout();
        } else {
            mView.configureFromDataBaseLayout();
        }
    }

    @Override
    public void delete(Character character) {
        mLocalDataSource.delete(character);
    }
}
