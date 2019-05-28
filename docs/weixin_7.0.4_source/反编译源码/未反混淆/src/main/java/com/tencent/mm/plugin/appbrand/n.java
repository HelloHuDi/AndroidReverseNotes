package com.tencent.mm.plugin.appbrand;

import android.support.v4.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class n {
    private static final Map<String, n> eGg = new a();
    private static final n gPb = new n();
    public volatile String gPc;
    public final AtomicInteger gPd = new AtomicInteger();
    public final AtomicBoolean gPe = new AtomicBoolean(false);
    public c.a gPf = null;
    public volatile String gPg;
    public volatile String gPh;
    public volatile boolean gPi;
    public volatile boolean gPj;
    public volatile boolean gPk;
    public volatile boolean gPl = false;
    public volatile boolean gPm = false;
    public volatile boolean gPn = false;

    static {
        AppMethodBeat.i(86746);
        AppMethodBeat.o(86746);
    }

    private n() {
        AppMethodBeat.i(86739);
        AppMethodBeat.o(86739);
    }

    public static n wX(String str) {
        AppMethodBeat.i(86740);
        n wY = wY(str);
        AppMethodBeat.o(86740);
        return wY;
    }

    private static n wY(String str) {
        AppMethodBeat.i(86741);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(86741);
            return null;
        }
        n nVar;
        synchronized (eGg) {
            try {
                nVar = (n) eGg.get(str);
                if (nVar == null) {
                    nVar = new n();
                    eGg.put(str, nVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86741);
            }
        }
        return nVar;
    }

    private static n wZ(String str) {
        AppMethodBeat.i(86742);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(86742);
            return null;
        }
        n nVar;
        synchronized (eGg) {
            try {
                nVar = (n) eGg.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86742);
            }
        }
        return nVar;
    }

    static void remove(String str) {
        AppMethodBeat.i(86743);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(86743);
            return;
        }
        synchronized (eGg) {
            try {
                eGg.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86743);
            }
        }
    }

    public static n xa(String str) {
        AppMethodBeat.i(86744);
        n wZ = wZ(str);
        if (wZ == null) {
            wZ = gPb;
            AppMethodBeat.o(86744);
            return wZ;
        }
        AppMethodBeat.o(86744);
        return wZ;
    }

    public static n xb(String str) {
        AppMethodBeat.i(86745);
        n wY = wY(str);
        AppMethodBeat.o(86745);
        return wY;
    }
}
