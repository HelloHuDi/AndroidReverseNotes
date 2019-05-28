package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "OpenIMAccTypeInfo")};
    public h fni;

    static {
        AppMethodBeat.i(78984);
        AppMethodBeat.o(78984);
    }

    public b(h hVar) {
        super(hVar, a.ccO, "OpenIMAccTypeInfo", null);
        this.fni = hVar;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(78982);
        aVar.field_updateTime = bo.anT();
        boolean a = super.a(aVar);
        AppMethodBeat.o(78982);
        return a;
    }
}
