package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.view.View;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public interface CharactersContract {

    interface View {
        void setLocalData(android.view.View view);
        void setRemoteData(android.view.View view);
    }

    interface presenter{
    }
}
