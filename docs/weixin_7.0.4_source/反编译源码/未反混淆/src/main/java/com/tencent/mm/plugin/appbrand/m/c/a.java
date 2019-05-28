package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;

public final class a extends d {
    public final int aIT() {
        return 2;
    }

    public final String b(i iVar, c cVar) {
        AppMethodBeat.i(102192);
        q qVar = cVar.gMN;
        HashMap hashMap = new HashMap();
        hashMap.put("state", Integer.valueOf(qVar.getRuntime().gNN.gWy.awz().ordinal()));
        String B = cVar.B(hashMap);
        AppMethodBeat.o(102192);
        return B;
    }
}
