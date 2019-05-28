package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import android.net.nsd.NsdManager;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C195512;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C334251;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C38415b;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C42604a;
import com.tencent.p177mm.plugin.appbrand.p321l.C42603p.C42605c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.i */
public final class C27003i extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 529;
    public static final String NAME = "operateLocalServicesScan";
    final Map<String, C27004a> gPL = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.i$a */
    class C27004a implements C38415b {
        C2241c gMJ;
        AtomicInteger hRN = new AtomicInteger();
        AtomicInteger hRO = new AtomicInteger();

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.i$a$1 */
        class C270051 implements C42604a {
            C270051() {
            }

            /* renamed from: c */
            public final void mo44703c(C42605c c42605c) {
                AppMethodBeat.m2504i(108063);
                C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
                C10432a.m18159c(C27004a.this.gMJ, c42605c);
                AppMethodBeat.m2505o(108063);
            }

            /* renamed from: d */
            public final void mo44704d(C42605c c42605c) {
                AppMethodBeat.m2504i(108064);
                C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
                C10432a.m18156a(C27004a.this.gMJ, c42605c);
                AppMethodBeat.m2505o(108064);
            }
        }

        C27004a(C2241c c2241c) {
            AppMethodBeat.m2504i(108065);
            this.gMJ = c2241c;
            AppMethodBeat.m2505o(108065);
        }

        public final void aEp() {
            AppMethodBeat.m2504i(108066);
            this.gMJ.mo6107M(this.hRN.get(), C27003i.this.mo73394j("fail", null));
            C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
            AppMethodBeat.m2505o(108066);
        }

        public final void aEq() {
            AppMethodBeat.m2504i(108067);
            this.gMJ.mo6107M(this.hRO.get(), C27003i.this.mo73394j("fail", null));
            C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
            AppMethodBeat.m2505o(108067);
        }

        public final void aEr() {
            AppMethodBeat.m2504i(108068);
            this.gMJ.mo6107M(this.hRN.get(), C27003i.this.mo73394j("ok", null));
            C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
            AppMethodBeat.m2505o(108068);
        }

        public final void aEs() {
            AppMethodBeat.m2504i(108069);
            C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
            this.gMJ.mo6107M(this.hRO.get(), C27003i.this.mo73394j("ok", null));
            C10432a.m18160r(this.gMJ);
            AppMethodBeat.m2505o(108069);
        }

        /* renamed from: a */
        public final void mo44697a(C42605c c42605c) {
            AppMethodBeat.m2504i(108070);
            C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
            C7305d.xDG.mo10151b(new C195512(c42605c, new C270051()), "LocalServiceMgr#resolveService");
            AppMethodBeat.m2505o(108070);
        }

        /* renamed from: b */
        public final void mo44702b(C42605c c42605c) {
            AppMethodBeat.m2504i(108071);
            C10432a.m18158b(this.gMJ, c42605c);
            AppMethodBeat.m2505o(108071);
        }
    }

    public C27003i() {
        AppMethodBeat.m2504i(108072);
        AppMethodBeat.m2505o(108072);
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(108073);
        String optString = jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION);
        C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(optString)));
        final C27004a c27004a;
        if (TextUtils.equals("start", optString)) {
            final String optString2 = jSONObject.optString("serviceType");
            if (TextUtils.isEmpty(optString2)) {
                c2241c.mo6107M(i, mo73394j("fail:invalid param", null));
                AppMethodBeat.m2505o(108073);
                return;
            }
            synchronized (this.gPL) {
                try {
                    for (String optString3 : this.gPL.keySet()) {
                        if (optString3.contains(c2241c.getAppId())) {
                            c2241c.mo6107M(i, mo73394j("fail:scan task already exist", null));
                        }
                    }
                    c27004a = new C27004a(c2241c);
                    c27004a.hRN.set(i);
                    this.gPL.put(C27003i.m42945k(c2241c, optString2), c27004a);
                    C42603p c42603p = C42603p.ipp;
                    NsdManager aIN = C42603p.aIN();
                    C334251 c334251 = new C334251(c27004a);
                    c42603p.ipq.put(c27004a, c334251);
                    aIN.discoverServices(optString2, 1, c334251);
                    C5004al.m7442n(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.i$1$1 */
                        class C22931 implements Runnable {
                            C22931() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(108061);
                                synchronized (C27003i.this.gPL) {
                                    try {
                                        if (C27003i.this.gPL.containsKey(C27003i.m42945k(c2241c, optString2))) {
                                            C42603p.ipp.mo68039a(c27004a);
                                            C27003i.this.gPL.remove(C27003i.m42945k(c2241c, optString2));
                                            AppMethodBeat.m2505o(108061);
                                            return;
                                        }
                                        C45124d.m82929i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.m2505o(108061);
                                    }
                                }
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(108062);
                            C7305d.post(new C22931(), "stopScanServices");
                            AppMethodBeat.m2505o(108062);
                        }
                    }, 30000);
                    AppMethodBeat.m2505o(108073);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108073);
                }
            }
        } else if (TextUtils.equals("stop", optString3)) {
            synchronized (this.gPL) {
                try {
                    int i2 = 1;
                    for (C27004a c27004a2 : this.gPL.values()) {
                        c27004a2.hRO.set(i);
                        C42603p.ipp.mo68039a(c27004a2);
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        c2241c.mo6107M(i, mo73394j("fail:task not found", null));
                    }
                    this.gPL.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108073);
                }
            }
        } else {
            c2241c.mo6107M(i, mo73394j("fail:invalid param", null));
            AppMethodBeat.m2505o(108073);
        }
    }

    /* renamed from: k */
    static String m42945k(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(108074);
        String str2 = c2241c.getAppId() + "#" + str;
        AppMethodBeat.m2505o(108074);
        return str2;
    }
}
