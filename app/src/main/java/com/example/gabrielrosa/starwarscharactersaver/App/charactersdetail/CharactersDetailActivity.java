package com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.gabrielrosa.starwarscharactersaver.App.addcharacter.AddCharacterActivity;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharacterDetailActBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersDetailActivity extends AppCompatActivity implements CharacterDetailContract.view {

    private CharacterDetailActBinding mBinding;

    public static String IS_FROM_API    = "IS_FROM_API";
    public static String CHARACTER_GUID = "CHARACTER_GUID";
    public static String CHARACTER_NAME = "CHARACTER_NAME";
    public static String CHARACTER_MASS = "CHARACTER_MASS";
    public static String CHARACTER_HAIR = "CHARACTER_HAIR";

    private Boolean isFromApi;
    private String characterGuid;
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
        Character character = new Character(characterGuid, characterName, characterMass, characterHair);
        mPresenter.save(character);
    }

    @Override
    public void deleteCharacter(View view) {
        Character character = new Character(
                characterGuid,
                characterName,
                characterMass,
                characterHair);
        mPresenter.delete(character);
    }

    @Override
    public void editCharacter(View view) {
        Intent intent = new Intent(getApplicationContext(), AddCharacterActivity.class);
        intent.putExtra(AddCharacterActivity.IS_EDITING, true);
        intent.putExtra(AddCharacterActivity.CHARACTER_GUID, characterGuid);
        intent.putExtra(AddCharacterActivity.CHARACTER_NAME, characterName);
        intent.putExtra(AddCharacterActivity.CHARACTER_MASS, characterMass);
        intent.putExtra(AddCharacterActivity.CHARACTER_HAIR, characterHair);
        startActivity(intent);
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

    @Override
    public void showSavedSuccess() {
        Toast.makeText(this, getResources().getString(R.string.saved_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDeleteSuccess() {
        Toast.makeText(this, getResources().getString(R.string.deleted), Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    public void setFields(Character character) {
        mBinding.characterDetailNameTextView.setText(character.getName());
        mBinding.characterDetailHairTextView.setText(character.getHairColor());
        mBinding.characterDetailMassTextView.setText(character.getMass());
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.findBy(characterGuid);
    }

    private void setUpView() {
        setUpIntentValues();
        setUpLabels();
    }

    private void setUpIntentValues() {
        Intent intent = getIntent();
        isFromApi     = intent.getBooleanExtra(IS_FROM_API, false);
        characterGuid = intent.getStringExtra(CHARACTER_GUID);
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
