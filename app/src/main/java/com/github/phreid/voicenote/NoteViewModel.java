package com.github.phreid.voicenote;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class NoteViewModel extends BaseObservable {
    private Note mNote;
    private NoteManager mNoteManager;

    public NoteViewModel(NoteManager noteManager) {
        mNoteManager = noteManager;
    }

    public Note getNote() {
        return mNote;
    }

    public void setNote(Note note) {
        mNote = note;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return mNote.getTitle();
    }
}
