package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.content.Context;

import com.example.gabrielrosa.starwarscharactersaver.Domain.charactersremotedatasource.CharacterRemoteDataSource;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.CharactersLocalDataSource;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.remote.CharactersRemoteDataSourceImpl;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.util.BaseCallback;

import java.util.List;

/**
 * Created by stant02 on 05/02/18.
 */

public class CharactersPresenter implements CharactersContract.Presenter {

    private CharactersContract.View mView;
    private CharactersLocalDataSource mLocalDataSource;

    public CharactersPresenter(CharactersContract.View view, Context context) {
        mView            = view;
        mLocalDataSource = CharactersLocalDataSource.getInstance(context);
    }


    @Override
    public void loadDataFromApi() {
        CharacterRemoteDataSource characterRemoteDataSource = new CharactersRemoteDataSourceImpl();
        characterRemoteDataSource.getCharacters(new BaseCallback.ApiCaseCallback<List<Character>>() {
            @Override
            public void onSuccess(List<Character> response) {
                mView.showFromApiLayout(response);
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void loadDataFromDataBase() {
        mView.showFromDataBaseLayout(mLocalDataSource.All());
    }
}
