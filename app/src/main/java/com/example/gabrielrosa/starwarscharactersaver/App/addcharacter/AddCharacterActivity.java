package com.example.gabrielrosa.starwarscharactersaver.App.addcharacter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.AddCharacterActBinding;

/**
 * Created by gabrielrosa on 04/02/18.
 */

public class AddCharacterActivity extends AppCompatActivity {

    private AddCharacterActBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.add_character_act);

    }

}
