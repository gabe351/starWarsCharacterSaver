package com.example.gabrielrosa.starwarscharactersaver.App.species;

import android.view.View;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public interface SpeciesViewContract {

    void goToSpeciesDetail(View view);
    void setLocalData(View view);
    void setRemoteData(View view);
}
