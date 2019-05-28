package com.tencent.mm.plugin.appbrand.e;

import com.tencent.luggage.i.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.a.a;

public final class c implements d<g> {
    public static c hpL;

    public final /* synthetic */ com.tencent.luggage.i.a.c bS(String str) {
        AppMethodBeat.i(117338);
        Object obj = -1;
        switch (str.hashCode()) {
            case 107868:
                if (str.equals("map")) {
                    obj = 1;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    obj = null;
                    break;
                }
                break;
        }
        com.tencent.luggage.i.a.c cVar;
        switch (obj) {
            case null:
                cVar = new com.tencent.mm.plugin.appbrand.jsapi.u.b.c();
                AppMethodBeat.o(117338);
                return cVar;
            case 1:
                cVar = new a();
                AppMethodBeat.o(117338);
                return cVar;
            default:
                AppMethodBeat.o(117338);
                return null;
        }
    }
}
