package com.tencent.mm.plugin.scanner.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.plugin.scanner.a.p;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b extends j {
    public static final String[] fnj = new String[]{j.a(p.ccO, "ScanTranslationResult")};
    private e bSd;

    static {
        AppMethodBeat.i(80897);
        AppMethodBeat.o(80897);
    }

    public b(e eVar) {
        super(eVar, p.ccO, "ScanTranslationResult", null);
        this.bSd = eVar;
    }

    public final eb Wf(String str) {
        AppMethodBeat.i(80896);
        p pVar = new p();
        pVar.field_originMD5 = str;
        if (b((c) pVar, new String[0])) {
            AppMethodBeat.o(80896);
            return pVar;
        }
        AppMethodBeat.o(80896);
        return null;
    }
}
