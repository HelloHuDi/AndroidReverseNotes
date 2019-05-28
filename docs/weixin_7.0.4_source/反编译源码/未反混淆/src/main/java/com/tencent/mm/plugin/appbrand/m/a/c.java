package com.tencent.mm.plugin.appbrand.m.a;

import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.b.a;
import com.tencent.mm.plugin.appbrand.q;
import java.util.HashMap;
import java.util.Map;

public final class c {
    public final q gMN;
    private final a ipY;
    private final int ipZ;

    public c(q qVar) {
        this.gMN = qVar;
        this.ipZ = -1;
        this.ipY = null;
    }

    public c(q qVar, int i, a aVar) {
        this.ipY = aVar;
        this.gMN = qVar;
        this.ipZ = i;
    }

    public final String B(Map<String, Object> map) {
        AppMethodBeat.i(102185);
        map.put("ret", Integer.valueOf(0));
        String CV = CV(C(map));
        AppMethodBeat.o(102185);
        return CV;
    }

    public final String aIU() {
        AppMethodBeat.i(102186);
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(2));
        String CV = CV(C(hashMap));
        AppMethodBeat.o(102186);
        return CV;
    }

    private String CV(String str) {
        AppMethodBeat.i(102187);
        if (this.ipY == null) {
            AppMethodBeat.o(102187);
            return str;
        }
        this.ipY.Y(this.ipZ, str);
        AppMethodBeat.o(102187);
        return null;
    }

    private static String C(Map<String, Object> map) {
        AppMethodBeat.i(102188);
        i.d(map);
        String iVar = new com.tencent.mm.aa.i((Map) map).toString();
        AppMethodBeat.o(102188);
        return iVar;
    }
}
