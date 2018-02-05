package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.content.Context;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.local.CharactersLocalDataSource;

import java.util.ArrayList;
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
        mView.showFromApiLayout(buildMockList());
    }

    @Override
    public void loadDataFromDataBase() {
        mView.showFromDataBaseLayout(mLocalDataSource.All());
    }

    private List<Character> buildMockList() {

        Character ca = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character cb = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character cc = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character cd = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character ce = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character cf = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character cg = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character ch = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        Character ci = new Character(
                "Guid",
                "Name",
                "mass",
                "hair"
        );

        List<Character> list = new ArrayList<>();

        list.add(ca);
        list.add(cb);
        list.add(cc);
        list.add(cd);
        list.add(ce);
        list.add(cf);
        list.add(cg);
        list.add(ch);
        list.add(ci);

        return list;
    }
}
