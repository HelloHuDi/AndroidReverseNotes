package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modelcache.r.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    private static final SparseArray<g> uIE = new SparseArray();
    private static volatile g uIF = null;

    private h() {
    }

    static {
        AppMethodBeat.i(9809);
        AppMethodBeat.o(9809);
    }

    @Deprecated
    public static g dcN() {
        AppMethodBeat.i(9806);
        if (uIF == null) {
            uIF = new g(0);
        }
        g gVar = uIF;
        AppMethodBeat.o(9806);
        return gVar;
    }

    public static g JR(int i) {
        g gVar;
        AppMethodBeat.i(9807);
        synchronized (h.class) {
            try {
                if (uIE.get(i) == null) {
                    uIE.put(i, new g(i));
                }
                gVar = (g) uIE.get(i);
                uIF = gVar;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(9807);
            }
        }
        return gVar;
    }

    public static void detach() {
        AppMethodBeat.i(9808);
        ab.i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (h.class) {
            int i = 0;
            while (i < uIE.size()) {
                try {
                    g gVar = (g) uIE.valueAt(i);
                    int keyAt = uIE.keyAt(i);
                    if (gVar != null) {
                        a.uor.IP(keyAt);
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(9808);
                    }
                }
            }
            uIE.clear();
        }
        if (uIF != null) {
            a.uor.IP(0);
            uIF = null;
        }
        AppMethodBeat.o(9808);
    }
}
