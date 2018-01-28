package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharactersFragBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersFragment extends Fragment implements CharactersViewContract {

    private CharactersFragBinding mBinding;

    public CharactersFragment() {}

    public static CharactersFragment newInstance() { return new CharactersFragment(); }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.characters_frag,container,false);
        mBinding.setHandler(this);

        mainToolbarSetup();

        return mBinding.getRoot();
    }

    @Override
    public void goToCharacterDetailScreen(View view) {

    }

    @Override
    public void setLocalData(View view) {
        mBinding.charactersListTitle.setText(R.string.characters_screen_locallyObjects);
    }

    @Override
    public void setRemoteData(View view) {
        mBinding.charactersListTitle.setText(R.string.characters_screen_remoteObjects);
    }

    public void mainToolbarSetup(){
        if (mBinding.charactersToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mBinding.charactersToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            mBinding.charactersToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mBinding.charactersToolbar.setNavigationOnClickListener( View ->{
                getActivity().onBackPressed();
            });
        }
    }
}