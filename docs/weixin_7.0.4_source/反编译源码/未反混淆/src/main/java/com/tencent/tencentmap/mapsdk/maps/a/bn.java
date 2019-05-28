package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;

public final class bn implements bk {
    private static bn a = new bn();

    static {
        AppMethodBeat.i(98568);
        AppMethodBeat.o(98568);
    }

    private bn() {
    }

    public static bn a() {
        return a;
    }

    public final bl a(String str, byte[] bArr) {
        AppMethodBeat.i(98565);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("url is empty");
            AppMethodBeat.o(98565);
            throw illegalArgumentException;
        }
        bp bpVar = new bp(str, bArr);
        AppMethodBeat.o(98565);
        return bpVar;
    }

    public final bm a(bl blVar) {
        AppMethodBeat.i(98566);
        RuntimeException runtimeException;
        if (blVar == null) {
            runtimeException = new RuntimeException("execute...IHttpRequest is null");
            AppMethodBeat.o(98566);
            throw runtimeException;
        } else if (blVar instanceof bp) {
            bq a = a(true, (bp) blVar, null);
            AppMethodBeat.o(98566);
            return a;
        } else {
            runtimeException = new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
            AppMethodBeat.o(98566);
            throw runtimeException;
        }
    }

    private bq a(boolean z, bp bpVar, bj bjVar) {
        AppMethodBeat.i(98567);
        bpVar.h = bjVar;
        bpVar.n = System.currentTimeMillis();
        a.a("app_http_use_proxy", 0, 1, 1);
        bs bsVar = new bs(bpVar);
        bpVar.i = bsVar;
        bq bqVar;
        if (z) {
            int i;
            if (bpVar.k <= 0) {
                bpVar.a(bsVar.a());
                i = 0;
            } else {
                ch.a().b().execute(new bo(this, bsVar, bpVar));
                i = !bpVar.a() ? 1 : 0;
            }
            cv c = bpVar.c();
            if (i != 0) {
                bpVar.m = true;
            }
            bqVar = new bq(c == null ? new cv(-14, "force return timeout:" + bpVar.k, 0) : c);
            AppMethodBeat.o(98567);
            return bqVar;
        }
        bqVar = new bq(bsVar.a());
        if (!bpVar.j) {
            bpVar.h.a(bpVar, bqVar);
        }
        AppMethodBeat.o(98567);
        return null;
    }
}
