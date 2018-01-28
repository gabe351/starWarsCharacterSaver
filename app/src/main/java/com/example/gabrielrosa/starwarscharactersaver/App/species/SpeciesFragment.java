package com.example.gabrielrosa.starwarscharactersaver.App.species;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.SpeciesFragBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class SpeciesFragment extends Fragment implements SpeciesViewContract {

    private SpeciesFragBinding mBinding;

    public SpeciesFragment() {}

    public static SpeciesFragment newInstance() { return new SpeciesFragment(); }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.species_frag,container,false);
        mBinding.setHandler(this);

        mainToolbarSetup();

        return mBinding.getRoot();
    }

    @Override
    public void goToSpeciesDetail(View view) {

    }

    public void mainToolbarSetup(){
        if (mBinding.speciesToolbar != null){
            ((AppCompatActivity) getActivity()).setSupportActionBar(mBinding.speciesToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
            mBinding.speciesToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mBinding.speciesToolbar.setNavigationOnClickListener( View ->{
                getActivity().onBackPressed();
            });
        }
    }
}
