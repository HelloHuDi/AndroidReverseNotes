package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    public static <T extends a> boolean a(T t, T t2) {
        boolean z = false;
        AppMethodBeat.i(57066);
        if (t == null && t2 == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("both null!!!");
            AppMethodBeat.o(57066);
            throw illegalArgumentException;
        }
        if (t == null) {
            AppMethodBeat.o(57066);
        } else if (t2 == null) {
            AppMethodBeat.o(57066);
        } else {
            try {
                z = bo.isEqual(t.toByteArray(), t2.toByteArray());
                AppMethodBeat.o(57066);
            } catch (Exception e) {
                AppMethodBeat.o(57066);
            }
        }
        return z;
    }
}
