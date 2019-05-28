package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    int[] jEI = null;

    public a(int[] iArr) {
        AppMethodBeat.i(18325);
        if (iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
            AppMethodBeat.o(18325);
            throw nullPointerException;
        }
        this.jEI = iArr;
        AppMethodBeat.o(18325);
    }
}
