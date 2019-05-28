package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.p;
import java.util.HashMap;

public final class a extends ah {
    private static final int CTRL_INDEX = 530;
    private static final String NAME = "onLocalServiceEvent";
    private static a hRp = new a();

    static {
        AppMethodBeat.i(108018);
        AppMethodBeat.o(108018);
    }

    public static void a(c cVar, p.c cVar2) {
        AppMethodBeat.i(108013);
        a(cVar, cVar2, "found");
        AppMethodBeat.o(108013);
    }

    public static void b(c cVar, p.c cVar2) {
        AppMethodBeat.i(108014);
        a(cVar, cVar2, "lost");
        AppMethodBeat.o(108014);
    }

    public static void c(c cVar, p.c cVar2) {
        AppMethodBeat.i(108015);
        a(cVar, cVar2, "resolveFail");
        AppMethodBeat.o(108015);
    }

    public static void r(c cVar) {
        AppMethodBeat.i(108016);
        a(cVar, null, "stopScan");
        AppMethodBeat.o(108016);
    }

    private static synchronized void a(c cVar, p.c cVar2, String str) {
        synchronized (a.class) {
            AppMethodBeat.i(108017);
            HashMap hashMap = new HashMap();
            hashMap.put("event", str);
            if (TextUtils.equals(str, "found") || TextUtils.equals(str, "lost") || TextUtils.equals(str, "resolveFail")) {
                hashMap.put("serviceType", cVar2.ipA);
                hashMap.put("serviceName", cVar2.ipz);
                if (!TextUtils.equals(str, "resolveFail")) {
                    hashMap.put("ip", cVar2.ip);
                    hashMap.put("port", Integer.valueOf(cVar2.port));
                    hashMap.put("attributes", cVar2.ipy);
                }
            }
            hRp.t(hashMap).j(cVar).aCj();
            AppMethodBeat.o(108017);
        }
    }
}
