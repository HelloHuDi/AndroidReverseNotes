package com.tencent.mm.plugin.radar.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.i(102917);
        int[] iArr = new int[f.values().length];
        eQZ = iArr;
        iArr[f.Stopped.ordinal()] = 1;
        eQZ[f.Locating.ordinal()] = 2;
        eQZ[f.RadarSearching.ordinal()] = 3;
        eQZ[f.Waiting.ordinal()] = 4;
        AppMethodBeat.o(102917);
    }
}
