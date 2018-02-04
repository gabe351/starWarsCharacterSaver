package com.example.gabrielrosa.starwarscharactersaver.App.characters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gabrielrosa.starwarscharactersaver.App.charactersdetail.CharactersDetailActivity;
import com.example.gabrielrosa.starwarscharactersaver.Domain.entities.Character;
import com.example.gabrielrosa.starwarscharactersaver.R;
import com.example.gabrielrosa.starwarscharactersaver.databinding.CharactersItemBinding;

import java.util.List;

/**
 * Created by gabrielrosa on 03/02/18.
 */

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ItemViewHolder> {


    private final CharactersContract.View mCharactersView;
    private List<Character> mCharacters;
    private Context mContext;
    private ItemViewHolder mViewHolder;

    public CharactersAdapter(Context context,
                             List<Character> characters,
                             CharactersContract.View charactersView) {
        this.mContext        = context;
        this.mCharacters     = characters;
        this.mCharactersView = charactersView;
    }

    public void replaceData(List list) {
        mCharacters = list;
        notifyDataSetChanged();
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CharactersItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.characters_item,
                parent,
                false);

        final ItemViewHolder vh = new ItemViewHolder(binding);
        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        mViewHolder = holder;

        Character currentCharacter = mCharacters.get(position);
        mViewHolder.mItemBinding.characterNameTextView.setText(currentCharacter.getName());

        mViewHolder.mItemBinding.charactersItemCardView.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, CharactersDetailActivity.class);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private CharactersItemBinding mItemBinding;

        public ItemViewHolder(CharactersItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.mItemBinding = itemBinding;

        }
    }
}
