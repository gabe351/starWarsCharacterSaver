package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.content.Intent;
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

import com.example.gabrielrosa.starwarscharactersaver.App.addcharacter.AddCharacterActivity;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharactersFragBinding;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by gabrielrosa on 28/01/18.
 */

public class CharactersFragment extends Fragment implements CharactersContract.View {

    private CharactersFragBinding mBinding;
    private CharactersAdapter mAdapter;
    private CharactersContract.Presenter mPresenter;

    public CharactersFragment() {}

    public static CharactersFragment newInstance() { return new CharactersFragment(); }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter   = new CharactersAdapter(getContext(), new ArrayList<Character>(0), this);
        mPresenter = new CharactersPresenter(this, getContext());
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

        mBinding.addCharacterFloatActionButton.setVisibility(View.GONE);
        mBinding.addCharacterFloatActionButton.setOnClickListener(view -> {
            goToAddCharacterScreen();
        });

        return mBinding.getRoot();
    }

    @Override
    public void setLocalData(View view) {
        mPresenter.loadDataFromDataBase();
    }

    @Override
    public void setRemoteData(View view) {
        mPresenter.loadDataFromApi();
    }

    @Override
    public void showFromDataBaseLayout(List<Character> characters) {
        mAdapter.replaceData(characters);
        mAdapter.setIsFromApi(false);
        mBinding.addCharacterFloatActionButton.setVisibility(View.VISIBLE);
        mBinding.charactersListTitle.setText(R.string.characters_screen_locallyObjects);
    }

    @Override
    public void showFromApiLayout(List<Character> characters) {
        mAdapter.replaceData(characters);
        mAdapter.setIsFromApi(true);
        mBinding.addCharacterFloatActionButton.setVisibility(View.GONE);
        mBinding.charactersListTitle.setText(R.string.characters_screen_remoteObjects);
    }

    @Override
    public void goToAddCharacterScreen() {
        Intent intent = new Intent(getContext(), AddCharacterActivity.class);
        intent.putExtra(AddCharacterActivity.IS_EDITING, false);
        startActivity(intent);
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