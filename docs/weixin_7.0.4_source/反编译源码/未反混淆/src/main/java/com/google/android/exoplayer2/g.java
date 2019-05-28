package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    @Deprecated
    public static v a(Context context, h hVar, m mVar) {
        AppMethodBeat.i(94774);
        v a = a(new d(context), hVar, mVar);
        AppMethodBeat.o(94774);
        return a;
    }

    public static v a(Context context, h hVar) {
        AppMethodBeat.i(94775);
        v a = a(new d(context), hVar, new c());
        AppMethodBeat.o(94775);
        return a;
    }

    private static v a(u uVar, h hVar, m mVar) {
        AppMethodBeat.i(94776);
        v vVar = new v(uVar, hVar, mVar);
        AppMethodBeat.o(94776);
        return vVar;
    }
}
