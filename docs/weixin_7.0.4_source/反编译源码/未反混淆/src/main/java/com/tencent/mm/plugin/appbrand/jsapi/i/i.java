package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l.p;
import com.tencent.mm.plugin.appbrand.l.p.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.l.p.b;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.jsapi.a<c> {
    public static final int CTRL_INDEX = 529;
    public static final String NAME = "operateLocalServicesScan";
    final Map<String, a> gPL = new ConcurrentHashMap();

    class a implements b {
        c gMJ;
        AtomicInteger hRN = new AtomicInteger();
        AtomicInteger hRO = new AtomicInteger();

        a(c cVar) {
            AppMethodBeat.i(108065);
            this.gMJ = cVar;
            AppMethodBeat.o(108065);
        }

        public final void aEp() {
            AppMethodBeat.i(108066);
            this.gMJ.M(this.hRN.get(), i.this.j("fail", null));
            d.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
            AppMethodBeat.o(108066);
        }

        public final void aEq() {
            AppMethodBeat.i(108067);
            this.gMJ.M(this.hRO.get(), i.this.j("fail", null));
            d.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
            AppMethodBeat.o(108067);
        }

        public final void aEr() {
            AppMethodBeat.i(108068);
            this.gMJ.M(this.hRN.get(), i.this.j("ok", null));
            d.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
            AppMethodBeat.o(108068);
        }

        public final void aEs() {
            AppMethodBeat.i(108069);
            d.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
            this.gMJ.M(this.hRO.get(), i.this.j("ok", null));
            a.r(this.gMJ);
            AppMethodBeat.o(108069);
        }

        public final void a(p.c cVar) {
            AppMethodBeat.i(108070);
            d.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
            com.tencent.mm.sdk.g.d.xDG.b(new AnonymousClass2(cVar, new com.tencent.mm.plugin.appbrand.l.p.a() {
                public final void c(p.c cVar) {
                    AppMethodBeat.i(108063);
                    d.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
                    a.c(a.this.gMJ, cVar);
                    AppMethodBeat.o(108063);
                }

                public final void d(p.c cVar) {
                    AppMethodBeat.i(108064);
                    d.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
                    a.a(a.this.gMJ, cVar);
                    AppMethodBeat.o(108064);
                }
            }), "LocalServiceMgr#resolveService");
            AppMethodBeat.o(108070);
        }

        public final void b(p.c cVar) {
            AppMethodBeat.i(108071);
            a.b(this.gMJ, cVar);
            AppMethodBeat.o(108071);
        }
    }

    public i() {
        AppMethodBeat.i(108072);
        AppMethodBeat.o(108072);
    }

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(108073);
        String optString = jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION);
        d.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(optString)));
        final a aVar;
        if (TextUtils.equals("start", optString)) {
            final String optString2 = jSONObject.optString("serviceType");
            if (TextUtils.isEmpty(optString2)) {
                cVar.M(i, j("fail:invalid param", null));
                AppMethodBeat.o(108073);
                return;
            }
            synchronized (this.gPL) {
                try {
                    for (String optString3 : this.gPL.keySet()) {
                        if (optString3.contains(cVar.getAppId())) {
                            cVar.M(i, j("fail:scan task already exist", null));
                        }
                    }
                    aVar = new a(cVar);
                    aVar.hRN.set(i);
                    this.gPL.put(k(cVar, optString2), aVar);
                    p pVar = p.ipp;
                    NsdManager aIN = p.aIN();
                    com.tencent.mm.plugin.appbrand.l.p.AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.l.p.AnonymousClass1(aVar);
                    pVar.ipq.put(aVar, anonymousClass1);
                    aIN.discoverServices(optString2, 1, anonymousClass1);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(108062);
                            com.tencent.mm.sdk.g.d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(108061);
                                    synchronized (i.this.gPL) {
                                        try {
                                            if (i.this.gPL.containsKey(i.k(cVar, optString2))) {
                                                p.ipp.a(aVar);
                                                i.this.gPL.remove(i.k(cVar, optString2));
                                                AppMethodBeat.o(108061);
                                                return;
                                            }
                                            d.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                                        } finally {
                                            while (true) {
                                            }
                                            AppMethodBeat.o(108061);
                                        }
                                    }
                                }
                            }, "stopScanServices");
                            AppMethodBeat.o(108062);
                        }
                    }, 30000);
                    AppMethodBeat.o(108073);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108073);
                }
            }
        } else if (TextUtils.equals("stop", optString3)) {
            synchronized (this.gPL) {
                try {
                    int i2 = 1;
                    for (a aVar2 : this.gPL.values()) {
                        aVar2.hRO.set(i);
                        p.ipp.a(aVar2);
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        cVar.M(i, j("fail:task not found", null));
                    }
                    this.gPL.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(108073);
                }
            }
        } else {
            cVar.M(i, j("fail:invalid param", null));
            AppMethodBeat.o(108073);
        }
    }

    static String k(c cVar, String str) {
        AppMethodBeat.i(108074);
        String str2 = cVar.getAppId() + "#" + str;
        AppMethodBeat.o(108074);
        return str2;
    }
}
