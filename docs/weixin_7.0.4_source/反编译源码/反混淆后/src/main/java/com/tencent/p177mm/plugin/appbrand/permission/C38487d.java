package com.tencent.p177mm.plugin.appbrand.permission;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.avw;
import com.tencent.p177mm.protocal.protobuf.avx;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vending.p641g.C5698f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.d */
public final class C38487d {
    private static final LinkedList<Runnable> iwm = new LinkedList();
    private static final C19658a iwn = new C19658a();
    private static boolean iwo = false;
    private final int cBc = this.iwk.getRuntime().mo15034ye().hhd.gVt;
    private final C2430b iwj;
    private final C33327h iwk;
    private final String iwl;
    private final String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$b */
    public interface C2430b {
        /* renamed from: CW */
        void mo6342CW(String str);

        void aIX();

        void onCancel();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$3 */
    class C106823 implements C5691b<Void> {
        C106823() {
        }

        /* renamed from: az */
        public final /* bridge */ /* synthetic */ void mo5270az(Object obj) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$4 */
    class C106834 implements C5681a<Void, avx> {
        C106834() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(102250);
            Void b = m18373b((avx) obj);
            AppMethodBeat.m2505o(102250);
            return b;
        }

        /* renamed from: b */
        private Void m18373b(avx avx) {
            AppMethodBeat.m2504i(102249);
            try {
                C38487d.m65123a(C38487d.this, avx);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", C38487d.this.mAppId, e);
                C5698f.dMj().mo11582cR(e);
            }
            AppMethodBeat.m2505o(102249);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$a */
    static final class C19658a {
        final HashMap<String, HashSet<String>> iwD;

        private C19658a() {
            AppMethodBeat.m2504i(102255);
            this.iwD = new HashMap();
            AppMethodBeat.m2505o(102255);
        }

        /* synthetic */ C19658a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cL */
        public final boolean mo34898cL(String str, String str2) {
            AppMethodBeat.m2504i(102256);
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                AppMethodBeat.m2505o(102256);
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
                    AppMethodBeat.m2505o(102256);
                }
            }
            return z;
        }

        /* Access modifiers changed, original: final */
        public final void put(String str, String str2) {
            AppMethodBeat.m2504i(102257);
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                AppMethodBeat.m2505o(102257);
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
                    AppMethodBeat.m2505o(102257);
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: K */
        public final void mo34897K(String str, String str2) {
            AppMethodBeat.m2504i(102258);
            if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                AppMethodBeat.m2505o(102258);
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
                    AppMethodBeat.m2505o(102258);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$c */
    static final class C33490c implements C2430b {
        private final C2430b iwE;

        /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$c$1 */
        class C106871 implements Runnable {
            C106871() {
            }

            public final void run() {
                AppMethodBeat.m2504i(102259);
                Runnable runnable = (Runnable) C38487d.iwm.pollFirst();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.m2505o(102259);
                    return;
                }
                C4990ab.m7416i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
                C38487d.iwo = false;
                AppMethodBeat.m2505o(102259);
            }
        }

        /* synthetic */ C33490c(C2430b c2430b, byte b) {
            this(c2430b);
        }

        private C33490c(C2430b c2430b) {
            this.iwE = c2430b;
        }

        public final void aIX() {
            AppMethodBeat.m2504i(102260);
            if (this.iwE != null) {
                this.iwE.aIX();
            }
            aKv();
            AppMethodBeat.m2505o(102260);
        }

        /* renamed from: CW */
        public final void mo6342CW(String str) {
            AppMethodBeat.m2504i(102261);
            if (this.iwE != null) {
                this.iwE.mo6342CW(str);
            }
            aKv();
            AppMethodBeat.m2505o(102261);
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(102262);
            if (this.iwE != null) {
                this.iwE.onCancel();
            }
            aKv();
            AppMethodBeat.m2505o(102262);
        }

        private void aKv() {
            AppMethodBeat.m2504i(102263);
            C45673m.aNS().mo10302aa(new C106871());
            AppMethodBeat.m2505o(102263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.d$2 */
    class C384882 implements C5690a {
        C384882() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(102248);
            C38487d.iwn.mo34897K(C38487d.this.mAppId, C38487d.this.iwl);
            C38487d.this.iwj.mo6342CW(null);
            AppMethodBeat.m2505o(102248);
        }
    }

    private C38487d(C2430b c2430b, C33327h c33327h, String str) {
        AppMethodBeat.m2504i(102264);
        this.iwj = c2430b;
        this.iwk = c33327h;
        this.mAppId = c33327h.getAppId();
        this.iwl = str;
        AppMethodBeat.m2505o(102264);
    }

    static {
        AppMethodBeat.m2504i(102272);
        AppMethodBeat.m2505o(102272);
    }

    /* renamed from: cK */
    public static boolean m65129cK(String str, String str2) {
        AppMethodBeat.m2504i(102265);
        boolean cL = iwn.mo34898cL(str, str2);
        AppMethodBeat.m2505o(102265);
        return cL;
    }

    /* renamed from: a */
    public static boolean m65125a(C33327h c33327h, String str) {
        AppMethodBeat.m2504i(138531);
        if (str.equals(C16681c.NAME)) {
            boolean z;
            C16597h ye = c33327h.getRuntime().mo15034ye();
            String str2 = "MicroMsg.AppBrandJsApiUserAuth";
            String str3 = "getWifiList jump userauth:%b";
            Object[] objArr = new Object[1];
            if (ye.hha) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            if (ye.hha) {
                AppMethodBeat.m2505o(138531);
                return false;
            }
            AppMethodBeat.m2505o(138531);
            return true;
        }
        AppMethodBeat.m2505o(138531);
        return false;
    }

    /* renamed from: a */
    public static void m65122a(final C33327h c33327h, final String str, final C2430b c2430b) {
        AppMethodBeat.m2504i(102267);
        final String appId = c33327h.getAppId();
        if (C5046bo.isNullOrNil(appId) || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102267);
            return;
        }
        final C106866 c106866 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102253);
                C38487d.m65127b(c33327h, str, new C33490c(c2430b, (byte) 0));
                AppMethodBeat.m2505o(102253);
            }
        };
        C45673m.aNS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102254);
                if (C38487d.iwo) {
                    C38487d.iwm.add(c106866);
                    C4990ab.m7417i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", appId, str);
                    AppMethodBeat.m2505o(102254);
                    return;
                }
                C38487d.iwo = true;
                c106866.run();
                AppMethodBeat.m2505o(102254);
            }
        });
        AppMethodBeat.m2505o(102267);
    }

    /* renamed from: Dp */
    public static void m65120Dp(String str) {
        AppMethodBeat.m2504i(102268);
        C19658a c19658a = iwn;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102268);
            return;
        }
        synchronized (c19658a) {
            try {
                c19658a.iwD.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102268);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m65127b(C33327h c33327h, String str, C2430b c2430b) {
        AppMethodBeat.m2504i(102271);
        if (iwn.mo34898cL(c33327h.getAppId(), str)) {
            C4990ab.m7417i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", c33327h.getAppId(), str);
            c2430b.aIX();
            AppMethodBeat.m2505o(102271);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", c33327h.getAppId(), str);
        C38487d c38487d = new C38487d(c2430b, c33327h, str);
        C4990ab.m7417i("MicroMsg.AppBrandJsApiUserAuth", "checkAuth appId = %s,mApi = %s", c38487d.mAppId, c38487d.iwl);
        avw avw = new avw();
        avw.fKh = c38487d.mAppId;
        avw.wzI = c38487d.iwl;
        avw.wzF = c38487d.cBc;
        avw.wzG = new cxh();
        C6750i runtime = c38487d.iwk.getRuntime();
        if (runtime instanceof C25697b) {
            avw.wzG.scene = ((C25697b) runtime).mo43491ya().bQn.scene;
        }
        if (c38487d.iwk instanceof C38492q) {
            avw.wzG.xsJ = 1;
        } else if (c38487d.iwk instanceof C44709u) {
            avw.wzG.xsJ = 2;
        }
        ((C42637a) c38487d.iwk.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/js-authorize", avw, avx.class).mo15892c(new C106834()).mo11587a((C5691b) new C106823()).mo11586a(new C384882());
        AppMethodBeat.m2505o(102271);
    }
}
