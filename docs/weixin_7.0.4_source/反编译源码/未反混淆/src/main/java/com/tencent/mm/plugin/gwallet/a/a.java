package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;

public final class a extends Exception {
    c npI;

    private a(c cVar) {
        this(cVar, null);
    }

    public a(int i, String str) {
        this(new c(i, str));
        AppMethodBeat.i(41689);
        AppMethodBeat.o(41689);
    }

    public a(String str, Exception exception) {
        this(new c(VError.ERROR_FACE_TXT_INIT, str), exception);
        AppMethodBeat.i(41690);
        AppMethodBeat.o(41690);
    }

    private a(c cVar, Exception exception) {
        super(cVar.nqb, exception);
        this.npI = cVar;
    }
}
