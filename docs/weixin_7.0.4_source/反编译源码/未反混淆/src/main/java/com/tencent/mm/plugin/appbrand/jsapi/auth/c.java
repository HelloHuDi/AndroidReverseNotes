package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

class c extends h<a> implements b, d {
    private static final Map<String, c> hBH = new android.support.v4.f.a();
    private static final c hBI = new c() {
        public final /* synthetic */ void bu(Object obj) {
            AppMethodBeat.i(130816);
            super.a((a) obj);
            AppMethodBeat.o(130816);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean aCC() {
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean aCD() {
            return true;
        }
    };

    interface a {
        void aqU();
    }

    /* synthetic */ c() {
        this(null);
    }

    public /* synthetic */ boolean aCD() {
        AppMethodBeat.i(130826);
        boolean aCC = aCC();
        AppMethodBeat.o(130826);
        return aCC;
    }

    public /* synthetic */ void bu(Object obj) {
        AppMethodBeat.i(130825);
        a((a) obj);
        AppMethodBeat.o(130825);
    }

    static {
        AppMethodBeat.i(130828);
        AppMethodBeat.o(130828);
    }

    public static c v(i iVar) {
        AppMethodBeat.i(130820);
        c cVar;
        if (iVar == null || iVar.mFinished) {
            cVar = hBI;
            AppMethodBeat.o(130820);
            return cVar;
        }
        synchronized (hBH) {
            try {
                cVar = (c) hBH.get(iVar.mAppId);
                if (cVar == null) {
                    cVar = new c(iVar);
                    hBH.put(iVar.mAppId, cVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130820);
            }
        }
        return cVar;
    }

    private c(i iVar) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("MicroMsg.AppBrandAuthJsApiQueue");
        if (iVar == null) {
            str = "|DUMMY";
        } else {
            str = "|" + iVar.mAppId;
        }
        super(stringBuilder.append(str).toString(), Looper.getMainLooper());
        AppMethodBeat.i(130821);
        if (iVar == null) {
            AppMethodBeat.o(130821);
            return;
        }
        iVar.gNN.a(new com.tencent.mm.plugin.appbrand.b.c.a() {
            public final void a(String str, b bVar) {
                AppMethodBeat.i(130817);
                if (bVar == b.DESTROYED) {
                    c.a(c.this);
                    synchronized (c.hBH) {
                        try {
                            c.hBH.remove(str);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(130817);
                        }
                    }
                    return;
                }
                AppMethodBeat.o(130817);
            }
        });
        AppMethodBeat.o(130821);
    }

    /* Access modifiers changed, original: protected */
    public boolean aCC() {
        return false;
    }

    public final void a(f fVar, com.tencent.mm.plugin.appbrand.jsapi.h hVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130824);
        ab.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", fVar.getName(), Integer.valueOf(i), hVar.getAppId());
        final com.tencent.mm.plugin.appbrand.jsapi.h hVar2 = hVar;
        final f fVar2 = fVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        super.bF(new a() {
            public final void aqU() {
                AppMethodBeat.i(130818);
                ab.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", c.this.mName);
                if (hVar2.isRunning()) {
                    fVar2.a(hVar2, jSONObject2, i2, this);
                    AppMethodBeat.o(130818);
                    return;
                }
                ab.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", fVar2.getName());
                this.sendMessage(2);
                AppMethodBeat.o(130818);
            }

            public final String toString() {
                AppMethodBeat.i(130819);
                String str = hashCode() + "|" + fVar2.getName();
                AppMethodBeat.o(130819);
                return str;
            }
        });
        AppMethodBeat.o(130824);
    }

    public final void aCB() {
        AppMethodBeat.i(130822);
        sendMessage(2);
        AppMethodBeat.o(130822);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(130823);
        ab.d(this.mName, "about to executeTask %s", aVar.toString());
        aVar.aqU();
        AppMethodBeat.o(130823);
    }
}
