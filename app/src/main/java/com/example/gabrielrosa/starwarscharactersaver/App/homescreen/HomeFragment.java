package com.example.gabrielrosa.starwarscharactersaver.App.homescreen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.HomeFragBinding;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class HomeFragment extends Fragment {

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
        mBinding= DataBindingUtil.inflate(inflater, R.layout.home_frag,container,false);



        return mBinding.getRoot();
    }
}
