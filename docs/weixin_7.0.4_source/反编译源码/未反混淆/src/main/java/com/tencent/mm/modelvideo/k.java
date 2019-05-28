package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    public static final String ale() {
        AppMethodBeat.i(50727);
        String str = g.RP().eJM + "draft/";
        AppMethodBeat.o(50727);
        return str;
    }

    public static final String tX(String str) {
        AppMethodBeat.i(50728);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50728);
            return null;
        }
        String str2 = ale() + str;
        AppMethodBeat.o(50728);
        return str2;
    }

    public static final String tY(String str) {
        AppMethodBeat.i(50729);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50729);
            return null;
        }
        String str2 = ale() + str + ".thumb";
        AppMethodBeat.o(50729);
        return str2;
    }
}
