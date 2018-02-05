package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gabrielrosa.starwarscharactersaver.App.util.ActivityUtils;
import com.example.gabrielrosa.starwarscharactersaver.R;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_act);

        CharactersFragment charactersFragment = (CharactersFragment) getSupportFragmentManager().findFragmentById(R.id.characters_content_frame);

        if (charactersFragment == null ) {
            charactersFragment = CharactersFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), charactersFragment, R.id.characters_content_frame);
        }
    }
}
