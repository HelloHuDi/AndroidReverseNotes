package com.tencent.mm.plugin.appbrand.s.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a implements e, com.tencent.mm.plugin.appbrand.s.f.a {
    ;
    
    public static final c iRV = null;
    private final e iRW;

    private a(String str) {
        AppMethodBeat.i(126646);
        this.iRW = new b();
        AppMethodBeat.o(126646);
    }

    static {
        iRV = new c();
        AppMethodBeat.o(126652);
    }

    public final void init(Context context) {
        AppMethodBeat.i(126647);
        this.iRW.init(context);
        AppMethodBeat.o(126647);
    }

    public final void release() {
        AppMethodBeat.i(126648);
        this.iRW.release();
        AppMethodBeat.o(126648);
    }

    public final c aOb() {
        AppMethodBeat.i(126649);
        c aOb = this.iRW.aOb();
        AppMethodBeat.o(126649);
        return aOb;
    }

    public final void da(Context context) {
        AppMethodBeat.i(126650);
        init(context);
        AppMethodBeat.o(126650);
    }

    public final void aNZ() {
        AppMethodBeat.i(126651);
        release();
        AppMethodBeat.o(126651);
    }
}
