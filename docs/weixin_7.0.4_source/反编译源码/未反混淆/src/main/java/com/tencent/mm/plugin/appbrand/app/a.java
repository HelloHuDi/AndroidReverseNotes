package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.appusage.n;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.sdk.e.e;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

final class a {
    static final Map<a, String[]> gQL = new HashMap();
    private static final Map<Class, Object> gQM = new HashMap();

    public interface a<T> {
        T b(e eVar);
    }

    private static void a(a aVar, String[] strArr) {
        AppMethodBeat.i(129187);
        gQL.put(aVar, strArr);
        AppMethodBeat.o(129187);
    }

    static {
        AppMethodBeat.i(129191);
        a(new a<l>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129172);
                l lVar = new l(eVar);
                AppMethodBeat.o(129172);
                return lVar;
            }
        }, l.fjY);
        a(new a<ad>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129179);
                ad adVar = new ad(eVar);
                AppMethodBeat.o(129179);
                return adVar;
            }
        }, ad.fjY);
        a(new a<n>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129180);
                n nVar = new n(eVar);
                AppMethodBeat.o(129180);
                return nVar;
            }
        }, n.fjY);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.b.e.e>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129181);
                com.tencent.mm.plugin.appbrand.appcache.b.e.e eVar2 = new com.tencent.mm.plugin.appbrand.appcache.b.e.e(eVar);
                AppMethodBeat.o(129181);
                return eVar2;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.b.e.e.fjY);
        a(new a<ah>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129182);
                ah ahVar = new ah(eVar);
                AppMethodBeat.o(129182);
                return ahVar;
            }
        }, ah.fjY);
        a(new a<k>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129183);
                k kVar = new k(eVar);
                AppMethodBeat.o(129183);
                return kVar;
            }
        }, k.fjY);
        a(new a<h>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129184);
                h hVar = new h(eVar);
                AppMethodBeat.o(129184);
                return hVar;
            }
        }, h.fjY);
        a(new a<d>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129185);
                d dVar = new d(eVar);
                AppMethodBeat.o(129185);
                return dVar;
            }
        }, d.fjY);
        a(new a<af>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129186);
                af afVar = new af(eVar);
                AppMethodBeat.o(129186);
                return afVar;
            }
        }, af.fjY);
        a(new a<b>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129173);
                b bVar = new b(eVar);
                AppMethodBeat.o(129173);
                return bVar;
            }
        }, b.fjY);
        a(new a<com.tencent.mm.plugin.appbrand.appusage.a.b>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129174);
                com.tencent.mm.plugin.appbrand.appusage.a.b bVar = new com.tencent.mm.plugin.appbrand.appusage.a.b(eVar);
                AppMethodBeat.o(129174);
                return bVar;
            }
        }, com.tencent.mm.plugin.appbrand.appusage.a.b.fjY);
        a(new a<s>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129175);
                s sVar = new s((com.tencent.mm.cd.h) eVar);
                AppMethodBeat.o(129175);
                return sVar;
            }
        }, s.fjY);
        a(new a<com.tencent.mm.plugin.appbrand.backgroundfetch.d>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129176);
                com.tencent.mm.plugin.appbrand.backgroundfetch.d dVar = new com.tencent.mm.plugin.appbrand.backgroundfetch.d(eVar);
                AppMethodBeat.o(129176);
                return dVar;
            }
        }, com.tencent.mm.plugin.appbrand.backgroundfetch.d.fjY);
        a(new a<com.tencent.mm.plugin.appbrand.appcache.b.d.a>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129177);
                com.tencent.mm.plugin.appbrand.appcache.b.d.a aVar = new com.tencent.mm.plugin.appbrand.appcache.b.d.a(eVar);
                AppMethodBeat.o(129177);
                return aVar;
            }
        }, com.tencent.mm.plugin.appbrand.appcache.b.d.a.fjY);
        a(new a<f>() {
            public final /* synthetic */ Object b(e eVar) {
                AppMethodBeat.i(129178);
                f fVar = new f(eVar);
                AppMethodBeat.o(129178);
                return fVar;
            }
        }, f.fjY);
        AppMethodBeat.o(129191);
    }

    static void a(e eVar) {
        AppMethodBeat.i(129188);
        synchronized (gQM) {
            try {
                gQM.clear();
                for (a b : gQL.keySet()) {
                    Object b2 = b.b(eVar);
                    gQM.put(b2.getClass(), b2);
                }
            } finally {
                AppMethodBeat.o(129188);
            }
        }
    }

    static void auD() {
        AppMethodBeat.i(129189);
        synchronized (gQM) {
            try {
                gQM.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129189);
            }
        }
    }

    static <T> T E(Class<T> cls) {
        T t;
        AppMethodBeat.i(129190);
        Assert.assertTrue("Cant pass Null class here", cls != null);
        synchronized (gQM) {
            try {
                t = gQM.get(cls);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129190);
            }
        }
        return t;
    }
}
