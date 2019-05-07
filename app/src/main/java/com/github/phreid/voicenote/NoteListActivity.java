package com.github.phreid.voicenote;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class NoteListActivity extends SingleFragmentActivity {

    @Override
    Fragment createFragment() {
        return NoteListFragment.newInstance();
    }
}
