package com.tencent.mm.plugin.radar.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.radar.b.e.a;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] eQZ;
    public static final /* synthetic */ int[] pCY;

    static {
        AppMethodBeat.i(103016);
        int[] iArr = new int[a.values().length];
        eQZ = iArr;
        iArr[a.UnSelected.ordinal()] = 1;
        eQZ[a.Selected.ordinal()] = 2;
        iArr = new int[a.values().length];
        pCY = iArr;
        iArr[a.Selected.ordinal()] = 1;
        pCY[a.UnSelected.ordinal()] = 2;
        AppMethodBeat.o(103016);
    }
}
