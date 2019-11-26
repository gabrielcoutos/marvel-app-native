package br.com.couto.marvel.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.couto.marvel.databinding.CharacterCardBinding;
import br.com.couto.marvel.model.Character;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {

    private final List<Character> characterList;
    private EndListListener mOnEndListListener;



    public CharactersAdapter(List<Character> characterList) {
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CharacterCardBinding binding = CharacterCardBinding.inflate(layoutInflater,parent,false);
        return new CharacterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.binding.setCharacter(character);
        if(position == characterList.size() -1){
            if(mOnEndListListener!= null) mOnEndListListener.onEndListListener();
        }
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void setmOnEndListListener(EndListListener mOnEndListListener) {
        this.mOnEndListListener = mOnEndListListener;
    }



    class CharacterViewHolder extends RecyclerView.ViewHolder{
        private CharacterCardBinding binding;

        public CharacterViewHolder(@NonNull CharacterCardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
