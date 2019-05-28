package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.storage.ad;

public final class a implements b {
    public final String getDisplayName(String str, String str2) {
        AppMethodBeat.i(136870);
        String displayName = s.getDisplayName(str, str2);
        AppMethodBeat.o(136870);
        return displayName;
    }

    public final String mJ(String str) {
        AppMethodBeat.i(136871);
        String mJ = s.mJ(str);
        AppMethodBeat.o(136871);
        return mJ;
    }

    public final String a(ad adVar, String str) {
        AppMethodBeat.i(136872);
        String a = s.a(adVar, str);
        AppMethodBeat.o(136872);
        return a;
    }

    public final String mI(String str) {
        AppMethodBeat.i(136873);
        String mI = s.mI(str);
        AppMethodBeat.o(136873);
        return mI;
    }

    public final String c(ad adVar) {
        AppMethodBeat.i(136874);
        String c = s.c(adVar);
        AppMethodBeat.o(136874);
        return c;
    }
}
