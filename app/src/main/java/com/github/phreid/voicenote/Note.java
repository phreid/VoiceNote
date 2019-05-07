package com.github.phreid.voicenote;

public class Note {
    private String mAssetPath;
    private String mTitle;

    public Note(String assetPath) {
        mAssetPath = assetPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAssetPath() {
        return mAssetPath;
    }
}
