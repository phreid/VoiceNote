package com.github.phreid.voicenote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.phreid.voicenote.databinding.FragmentNoteListBinding;
import com.github.phreid.voicenote.databinding.ListItemNoteBinding;

import java.util.List;

public class NoteListFragment extends Fragment {
    private NoteManager mNoteManager;

    public static Fragment newInstance() {
        return new NoteListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentNoteListBinding binding = FragmentNoteListBinding.inflate(
                inflater, container, false
        );
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mNoteManager = new NoteManager(getActivity().getApplicationContext());
        binding.recyclerView.setAdapter(new NoteAdapter(mNoteManager.getNoteList()));


        return binding.getRoot();
    }

    private class NoteHolder extends RecyclerView.ViewHolder {
        private ListItemNoteBinding mBinding;

        private NoteHolder(ListItemNoteBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new NoteViewModel(mNoteManager));
        }

        public void bind(Note note) {
            mBinding.getViewModel().setNote(note);
            mBinding.executePendingBindings();
        }
    }

    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {
        private List<Note> mNoteList;

        public NoteAdapter(List<Note> noteList) {
            mNoteList = noteList;
        }

        @Override
        public NoteHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemNoteBinding binding = ListItemNoteBinding.inflate(
                    inflater, viewGroup, false);

            return new NoteHolder(binding);
        }

        @Override
        public void onBindViewHolder(NoteHolder noteHolder, int i) {
            Note note = mNoteList.get(i);
            noteHolder.bind(note);
        }

        @Override
        public int getItemCount() {
            return mNoteList.size();
        }
    }
}
