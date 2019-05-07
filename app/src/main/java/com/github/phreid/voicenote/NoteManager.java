package com.github.phreid.voicenote;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteManager {
    private static final String TAG = "NoteManager";

    private static final String SAMPLE_FOLDER = "sample_audio";

    private AssetManager mAssetManager;
    private List<Note> mNoteList;

    public NoteManager(Context context) {
        mAssetManager = context.getAssets();
        mNoteList = new ArrayList<>();
        loadAudio();
    }

    private void loadAudio() {
        try {
            String[] fileNames = mAssetManager.list(SAMPLE_FOLDER);
            Log.i(TAG, "Found " + fileNames.length + " audio files");

            for (String filename : fileNames) {
                String assetPath = SAMPLE_FOLDER + "/" + filename;
                Note note = new Note(assetPath);
                note.setTitle(assetPath);
                mNoteList.add(note);
            }

        } catch (IOException e) {
            Log.e(TAG, "No assets found");
        }
    }

    public List<Note> getNoteList() {
        return mNoteList;
    }
}
