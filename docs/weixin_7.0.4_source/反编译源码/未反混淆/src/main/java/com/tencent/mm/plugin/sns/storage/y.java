package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class y extends j<x> {
    public static final String[] fnj = new String[]{j.a(x.ccO, "UxCanvasInfo")};

    static {
        AppMethodBeat.i(38034);
        AppMethodBeat.o(38034);
    }

    public y(e eVar) {
        this(eVar, x.ccO, "UxCanvasInfo");
    }

    private y(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
    }

    public final void a(x xVar) {
        AppMethodBeat.i(38033);
        if (xVar == null || bo.isNullOrNil(xVar.field_canvasXml)) {
            AppMethodBeat.o(38033);
            return;
        }
        xVar.field_createTime = System.currentTimeMillis();
        if (!b((c) xVar)) {
            c(xVar, new String[0]);
        }
        AppMethodBeat.o(38033);
    }
}
