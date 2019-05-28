package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Ftyp extends Box {
    int[] compatibleBrands;
    int majorBrand;
    int minorVersion;

    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.m2504i(128486);
        super.parse(parsable, box);
        this.majorBrand = parsable.readInt();
        this.minorVersion = parsable.readInt();
        int available = ((int) parsable.available()) / 4;
        if (available > 0) {
            this.compatibleBrands = parsable.readIntArray(available);
        }
        AppMethodBeat.m2505o(128486);
    }
}
