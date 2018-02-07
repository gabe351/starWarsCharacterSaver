package com.example.gabrielrosa.starwarscharactersaver.App.homescreen;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabrielrosa.starwarscharactersaver.App.characters.CharactersActivity;
import com.example.gabrielrosa.starwarscharactersaver.App.species.SpeciesActivity;
import com.example.gabrielrosa.starwarscharactersaver.Infrastructure.remote.CharactersRemoteDataSourceImpl;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.HomeFragBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class HomeFragment extends Fragment implements HomeViewContract {

    private HomeFragBinding mBinding;

    public HomeFragment() {}

    public static HomeFragment newInstance() { return new HomeFragment(); }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.home_frag,container,false);
        mBinding.setHandler(this);

        mainToolbarSetup();

        return mBinding.getRoot();
    }

    @Override
    public void goToSpeciesScreen(View view) {
        Intent intent = new Intent(getContext(), SpeciesActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToCharactersScreen(View view) {
        Intent intent = new Intent(getContext(), CharactersActivity.class);
        startActivity(intent);
    }


    public void mainToolbarSetup(){
        if (mBinding.homeScreenToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mBinding.homeScreenToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
