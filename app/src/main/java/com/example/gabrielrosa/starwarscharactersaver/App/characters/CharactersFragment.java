package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharactersFragBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersFragment extends Fragment implements CharactersContract.View {

    private CharactersFragBinding mBinding;
    private CharactersAdapter mAdapter;

    public CharactersFragment() {}

    public static CharactersFragment newInstance() { return new CharactersFragment(); }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new CharactersAdapter(getContext(), new ArrayList<Character>(0), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.characters_frag,container,false);
        mBinding.setHandler(this);

        mainToolbarSetup();

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.charactersRecycler.setLayoutManager(layout);
        mBinding.charactersRecycler.setNestedScrollingEnabled(false);
        mBinding.charactersRecycler.setAdapter(mAdapter);

        return mBinding.getRoot();
    }

    @Override
    public void setLocalData(View view) {
        mAdapter.replaceData(buildMockList());
        mBinding.charactersListTitle.setText(R.string.characters_screen_locallyObjects);
    }

    @Override
    public void setRemoteData(View view) {
        mAdapter.replaceData(buildMockList());
        mBinding.charactersListTitle.setText(R.string.characters_screen_remoteObjects);
    }

    private List<Character> buildMockList() {

        Character ca = new Character(
                "guid",
                "Dan",
                "height",
                "mass",
                "hair color",
                "eita",
                "esqueci",
                "ano de nascimento",
                "ender"
        );

        Character cb = new Character(
                "guid",
                "Gabe",
                "height",
                "mass",
                "hair color",
                "eita",
                "esqueci",
                "ano de nascimento",
                "ender"
        );

        Character cc = new Character(
                "guid",
                "Luke",
                "height",
                "mass",
                "hair color",
                "eita",
                "esqueci",
                "ano de nascimento",
                "ender"
        );

        List<Character> list = new ArrayList<>();

        list.add(ca);
        list.add(cb);
        list.add(cc);

        return list;
    }

    private void mainToolbarSetup(){
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