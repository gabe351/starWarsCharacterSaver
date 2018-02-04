package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharacterDetailActBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersDetailActivity extends AppCompatActivity implements CharacterDetailContract.view {

    private CharacterDetailActBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.character_detail_act);
    }

    @Override
    public void saveCharacter(View view) {
        Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteCharacter(View view) {
        Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void editCharacter(View view) {
        Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
    }
}
