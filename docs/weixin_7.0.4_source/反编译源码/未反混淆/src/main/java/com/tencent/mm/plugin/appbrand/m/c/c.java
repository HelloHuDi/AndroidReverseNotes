package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.l.j;
import com.tencent.mm.plugin.appbrand.m.a.d;
import java.util.HashMap;

public final class c extends d {
    public final String b(i iVar, com.tencent.mm.plugin.appbrand.m.a.c cVar) {
        AppMethodBeat.i(102194);
        String str = (String) j.CP(iVar.optString("url")).get("host");
        HashMap hashMap = new HashMap();
        hashMap.put("isLANIp", Boolean.valueOf(j.CR(str) == 2));
        str = cVar.B(hashMap);
        AppMethodBeat.o(102194);
        return str;
    }

    public final int aIT() {
        return 6;
    }
}
