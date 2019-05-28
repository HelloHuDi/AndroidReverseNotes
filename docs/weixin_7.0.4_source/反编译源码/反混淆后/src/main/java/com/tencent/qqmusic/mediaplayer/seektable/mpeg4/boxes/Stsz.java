package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stsz extends FullBox {
    int[] entrySize;
    int sampleCount;
    int sampleSize;

    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.m2504i(128482);
        super.parse(parsable, box);
        this.sampleSize = parsable.readInt();
        this.sampleCount = parsable.readInt();
        if (this.sampleSize == 0) {
            this.entrySize = parsable.readIntArray(this.sampleCount);
        }
        if (this.sampleSize == 0 && this.sampleCount == 0) {
            InvalidBoxException invalidBoxException = new InvalidBoxException("invalide stsz: both [sample_count] and [sample_size] is 0!");
            AppMethodBeat.m2505o(128482);
            throw invalidBoxException;
        }
        AppMethodBeat.m2505o(128482);
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public int getSampleCount() {
        return this.sampleCount;
    }

    public int[] getEntrySize() {
        return this.entrySize;
    }
}
