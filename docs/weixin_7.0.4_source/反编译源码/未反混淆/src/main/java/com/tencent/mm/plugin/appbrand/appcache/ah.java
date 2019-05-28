package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class ah extends c<ag> {
    public static final String[] fjY = new String[]{j.a(ag.fjX, "PushWxaPkgDecryptKeyTable")};

    static {
        AppMethodBeat.i(59453);
        AppMethodBeat.o(59453);
    }

    public ah(e eVar) {
        super(eVar, ag.fjX, "PushWxaPkgDecryptKeyTable", ag.diI);
    }

    public final ag ap(String str, int i) {
        AppMethodBeat.i(59452);
        ag agVar = new ag();
        agVar.field_appId = str;
        agVar.field_appVersion = i;
        if (b(agVar, new String[0])) {
            AppMethodBeat.o(59452);
            return agVar;
        }
        AppMethodBeat.o(59452);
        return null;
    }
}
