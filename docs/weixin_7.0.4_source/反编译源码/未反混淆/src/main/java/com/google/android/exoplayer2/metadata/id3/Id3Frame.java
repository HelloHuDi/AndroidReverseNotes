package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.metadata.Metadata.Entry;

public abstract class Id3Frame implements Entry {
    public final String id;

    public Id3Frame(String str) {
        this.id = (String) a.checkNotNull(str);
    }

    public int describeContents() {
        return 0;
    }
}
