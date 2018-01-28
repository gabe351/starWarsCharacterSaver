package com.example.gabrielrosa.starwarscharactersaver.App.species;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gabrielrosa.starwarscharactersaver.App.util.ActivityUtils;
import com.example.gabrielrosa.starwarscharactersaver.R;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class SpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.species_act);

        SpeciesFragment speciesFragment = (SpeciesFragment) getSupportFragmentManager().findFragmentById(R.id.species_content_frame);

        if (speciesFragment == null ) {
            speciesFragment = SpeciesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), speciesFragment, R.id.species_content_frame);
        }
    }
}
