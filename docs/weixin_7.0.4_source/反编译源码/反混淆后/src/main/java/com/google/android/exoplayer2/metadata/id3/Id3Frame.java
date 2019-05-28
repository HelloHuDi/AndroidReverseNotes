package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.p111i.C45039a;

public abstract class Id3Frame implements Entry {
    /* renamed from: id */
    public final String f17724id;

    public Id3Frame(String str) {
        this.f17724id = (String) C45039a.checkNotNull(str);
    }

    public int describeContents() {
        return 0;
    }
}
