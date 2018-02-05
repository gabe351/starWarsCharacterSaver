package com.example.gabrielrosa.starwarscharactersaver.App.addcharacter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.AddCharacterActBinding;

/**
 * Created by gabrielrosa on 04/02/18.
 */

public class AddCharacterActivity extends AppCompatActivity implements AddCharacterContract.View {

    private AddCharacterActBinding mBinding;

    public static String IS_EDITING     = "IS_EDITING";
    public static String CHARACTER_GUID = "CHARACTER_GUID";
    public static String CHARACTER_NAME = "CHARACTER_NAME";
    public static String CHARACTER_MASS = "CHARACTER_MASS";
    public static String CHARACTER_HAIR = "CHARACTER_HAIR";

    private boolean isEditing;
    private String mCharacterGuid;
    private String mCharacterName;
    private String mCharacterMass;
    private String mCharacterHair;

    private AddCharacterContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding   = DataBindingUtil.setContentView(this, R.layout.add_character_act);
        mPresenter = new AddCharacterPresenter(this, getApplicationContext());

        setUpIntentValues();
        mainToolbarSetup();

        mBinding.addCharacterSaveButton.setOnClickListener(view -> {
            saveCharacter();
        });
    }

    private void setUpIntentValues() {
        Intent intent = getIntent();
        isEditing     = intent.getBooleanExtra(IS_EDITING, false);

        if (isEditing) {
            mCharacterGuid = intent.getStringExtra(CHARACTER_GUID);
            mCharacterName = intent.getStringExtra(CHARACTER_NAME);
            mCharacterMass = intent.getStringExtra(CHARACTER_MASS);
            mCharacterHair = intent.getStringExtra(CHARACTER_HAIR);
            setUpLabels();
        }
    }

    private void setUpLabels() {
        mBinding.addCharacterNameEditText.setText(mCharacterName);
        mBinding.addCharacterMassEditText.setText(mCharacterMass);
        mBinding.addCharacterHairEditText.setText(mCharacterHair);
    }

    @Override
    public void saveCharacter() {

        Character character = new Character(
                mCharacterGuid,
                mBinding.addCharacterNameEditText.getText().toString(),
                mBinding.addCharacterMassEditText.getText().toString(),
                mBinding.addCharacterHairEditText.getText().toString()
                );

        mPresenter.saveCharacter(character);
    }

    @Override
    public void showSaveSuccess() {
        Toast.makeText(this, getResources().getString(R.string.saved_success), Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    private void mainToolbarSetup(){
        if (mBinding.addCharactersToolbar != null){
            setSupportActionBar(mBinding.addCharactersToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mBinding.addCharactersToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mBinding.addCharactersToolbar.setNavigationOnClickListener( View ->{
                super.onBackPressed();
            });
        }
    }
}
