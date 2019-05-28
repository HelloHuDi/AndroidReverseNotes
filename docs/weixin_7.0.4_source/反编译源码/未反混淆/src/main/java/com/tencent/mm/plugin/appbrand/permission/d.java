package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class d {
    private static final LinkedList<Runnable> iwm = new LinkedList();
    private static final a iwn = new a();
    private static boolean iwo = false;
    private final int cBc = this.iwk.getRuntime().ye().hhd.gVt;
    private final b iwj;
    private final h iwk;
    private final String iwl;
    private final String mAppId;

    public interface b {
        void CW(String str);

        void aIX();

        void onCancel();
    }

    static final class a {
        final HashMap<String, HashSet<String>> iwD;

        private a() {
            AppMethodBeat.i(102255);
            this.iwD = new HashMap();
            AppMethodBeat.o(102255);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final boolean cL(String str, String str2) {
            AppMethodBeat.i(102256);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                AppMethodBeat.o(102256);
                return false;
            }
            boolean z;
            synchronized (this) {
                try {
                    HashSet hashSet = (HashSet) this.iwD.get(str);
                    z = hashSet != null && hashSet.contains(str2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102256);
                }
            }
            return z;
        }

        /* Access modifiers changed, original: final */
        public final void put(String str, String str2) {
            AppMethodBeat.i(102257);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                AppMethodBeat.o(102257);
                return;
            }
            synchronized (this) {
                try {
                    HashSet hashSet = (HashSet) this.iwD.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.iwD.put(str, hashSet);
                    }
                    hashSet.add(str2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102257);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void K(String str, String str2) {
            AppMethodBeat.i(102258);
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                AppMethodBeat.o(102258);
                return;
            }
            synchronized (this) {
                try {
                    HashSet hashSet = (HashSet) this.iwD.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102258);
                }
            }
        }
    }

    static final class c implements b {
        private final b iwE;

        /* synthetic */ c(b bVar, byte b) {
            this(bVar);
        }

        private c(b bVar) {
            this.iwE = bVar;
        }

        public final void aIX() {
            AppMethodBeat.i(102260);
            if (this.iwE != null) {
                this.iwE.aIX();
            }
            aKv();
            AppMethodBeat.o(102260);
        }

        public final void CW(String str) {
            AppMethodBeat.i(102261);
            if (this.iwE != null) {
                this.iwE.CW(str);
            }
            aKv();
            AppMethodBeat.o(102261);
        }

        public final void onCancel() {
            AppMethodBeat.i(102262);
            if (this.iwE != null) {
                this.iwE.onCancel();
            }
            aKv();
            AppMethodBeat.o(102262);
        }

        private void aKv() {
            AppMethodBeat.i(102263);
            m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102259);
                    Runnable runnable = (Runnable) d.iwm.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        AppMethodBeat.o(102259);
                        return;
                    }
                    ab.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
                    d.iwo = false;
                    AppMethodBeat.o(102259);
                }
            });
            AppMethodBeat.o(102263);
        }
    }

    private d(b bVar, h hVar, String str) {
        AppMethodBeat.i(102264);
        this.iwj = bVar;
        this.iwk = hVar;
        this.mAppId = hVar.getAppId();
        this.iwl = str;
        AppMethodBeat.o(102264);
    }

    static {
        AppMethodBeat.i(102272);
        AppMethodBeat.o(102272);
    }

    public static boolean cK(String str, String str2) {
        AppMethodBeat.i(102265);
        boolean cL = iwn.cL(str, str2);
        AppMethodBeat.o(102265);
        return cL;
    }

    public static boolean a(h hVar, String str) {
        AppMethodBeat.i(138531);
        if (str.equals(com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME)) {
            boolean z;
            com.tencent.mm.plugin.appbrand.config.h ye = hVar.getRuntime().ye();
            String str2 = "MicroMsg.AppBrandJsApiUserAuth";
            String str3 = "getWifiList jump userauth:%b";
            Object[] objArr = new Object[1];
            if (ye.hha) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.i(str2, str3, objArr);
            if (ye.hha) {
                AppMethodBeat.o(138531);
                return false;
            }
            AppMethodBeat.o(138531);
            return true;
        }
        AppMethodBeat.o(138531);
        return false;
    }

    public static void a(final h hVar, final String str, final b bVar) {
        AppMethodBeat.i(102267);
        final String appId = hVar.getAppId();
        if (bo.isNullOrNil(appId) || bo.isNullOrNil(str)) {
            AppMethodBeat.o(102267);
            return;
        }
        final AnonymousClass6 anonymousClass6 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(102253);
                d.b(hVar, str, new c(bVar, (byte) 0));
                AppMethodBeat.o(102253);
            }
        };
        m.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102254);
                if (d.iwo) {
                    d.iwm.add(anonymousClass6);
                    ab.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", appId, str);
                    AppMethodBeat.o(102254);
                    return;
                }
                d.iwo = true;
                anonymousClass6.run();
                AppMethodBeat.o(102254);
            }
        });
        AppMethodBeat.o(102267);
    }

    public static void Dp(String str) {
        AppMethodBeat.i(102268);
        a aVar = iwn;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102268);
            return;
        }
        synchronized (aVar) {
            try {
                aVar.iwD.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102268);
            }
        }
    }

    static /* synthetic */ void b(h hVar, String str, b bVar) {
        AppMethodBeat.i(102271);
        if (iwn.cL(hVar.getAppId(), str)) {
            ab.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", hVar.getAppId(), str);
            bVar.aIX();
            AppMethodBeat.o(102271);
            return;
        }
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", hVar.getAppId(), str);
        d dVar = new d(bVar, hVar, str);
        ab.i("MicroMsg.AppBrandJsApiUserAuth", "checkAuth appId = %s,mApi = %s", dVar.mAppId, dVar.iwl);
        avw avw = new avw();
        avw.fKh = dVar.mAppId;
        avw.wzI = dVar.iwl;
        avw.wzF = dVar.cBc;
        avw.wzG = new cxh();
        i runtime = dVar.iwk.getRuntime();
        if (runtime instanceof com.tencent.luggage.sdk.b.b) {
            avw.wzG.scene = ((com.tencent.luggage.sdk.b.b) runtime).ya().bQn.scene;
        }
        if (dVar.iwk instanceof q) {
            avw.wzG.xsJ = 1;
        } else if (dVar.iwk instanceof u) {
            avw.wzG.xsJ = 2;
        }
        ((com.tencent.mm.plugin.appbrand.networking.a) dVar.iwk.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/js-authorize", avw, avx.class).c(new com.tencent.mm.vending.c.a<Void, avx>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(102250);
                Void b = b((avx) obj);
                AppMethodBeat.o(102250);
                return b;
            }

            private Void b(avx avx) {
                AppMethodBeat.i(102249);
                try {
                    d.a(d.this, avx);
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", d.this.mAppId, e);
                    f.dMj().cR(e);
                }
                AppMethodBeat.o(102249);
                return null;
            }
        }).a((com.tencent.mm.vending.g.d.b) new com.tencent.mm.vending.g.d.b<Void>() {
            public final /* bridge */ /* synthetic */ void az(Object obj) {
            }
        }).a(new com.tencent.mm.vending.g.d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(102248);
                d.iwn.K(d.this.mAppId, d.this.iwl);
                d.this.iwj.CW(null);
                AppMethodBeat.o(102248);
            }
        });
        AppMethodBeat.o(102271);
    }
}
