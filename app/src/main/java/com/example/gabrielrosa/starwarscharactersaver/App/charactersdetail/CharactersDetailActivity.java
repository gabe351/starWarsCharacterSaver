package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.content.Intent;
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

    public static String IS_FROM_API    = "IS_FROM_API";
    public static String CHARACTER_NAME = "CHARACTER_NAME";
    public static String CHARACTER_MASS = "CHARACTER_MASS";
    public static String CHARACTER_HAIR = "CHARACTER_HAIR";

    private Boolean isFromApi;
    private String characterName;
    private String characterMass;
    private String characterHair;

    private CharacterDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.character_detail_act);

        setUpView();

        mPresenter = new CharacterDetailPresenter(this, getApplicationContext());
        mPresenter.setupLayout(isFromApi);
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

    @Override
    public void configureFromApiLayout() {
        mBinding.characterDetailDeleteButton.setVisibility(View.GONE);
        mBinding.characterDetailEditButton.setVisibility(View.GONE);
        mBinding.characterDetailSaveButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void configureFromDataBaseLayout() {
        mBinding.characterDetailDeleteButton.setVisibility(View.VISIBLE);
        mBinding.characterDetailEditButton.setVisibility(View.VISIBLE);
        mBinding.characterDetailSaveButton.setVisibility(View.GONE);
    }

    private void setUpView() {
        setUpIntentValues();
        setUpLabels();
    }

    private void setUpIntentValues() {
        Intent intent = getIntent();
        isFromApi     = intent.getBooleanExtra(IS_FROM_API, false);
        characterName = intent.getStringExtra(CHARACTER_NAME);
        characterMass = intent.getStringExtra(CHARACTER_MASS);
        characterHair = intent.getStringExtra(CHARACTER_HAIR);
    }

    private void setUpLabels() {
        mBinding.characterDetailNameTextView.setText(characterName);
        mBinding.characterDetailHairTextView.setText(characterHair);
        mBinding.characterDetailMassTextView.setText(characterMass);
    }
}
