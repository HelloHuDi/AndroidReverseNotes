package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.g.d;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.p.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.n;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.luggage.b.f;
import com.tencent.mm.plugin.appbrand.luggage.b.h;
import com.tencent.mm.plugin.appbrand.luggage.b.l;
import com.tencent.mm.plugin.appbrand.ui.i;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.sdk.platformtools.ah;

final class g extends com.tencent.luggage.sdk.a {
    private b gRZ = null;

    static final class a implements com.tencent.luggage.g.d.a {
        private final Xlog gSb;

        private a() {
            AppMethodBeat.i(129304);
            this.gSb = new Xlog();
            AppMethodBeat.o(129304);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.i(129305);
            this.gSb.logV(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.o(129305);
        }

        public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.i(129306);
            this.gSb.logI(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.o(129306);
        }

        public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.i(129307);
            this.gSb.logD(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.o(129307);
        }

        public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.i(129308);
            this.gSb.logW(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.o(129308);
        }

        public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.i(129309);
            this.gSb.logE(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.o(129309);
        }

        public final int getLogLevel() {
            AppMethodBeat.i(129310);
            int logLevel = this.gSb.getLogLevel();
            AppMethodBeat.o(129310);
            return logLevel;
        }
    }

    public g() {
        AppMethodBeat.i(129311);
        d.a(new a());
        if (ah.doF() || ah.doG() || PluginAppBrand.isAppBrandProcess()) {
            this.gRZ = new com.tencent.mm.plugin.appbrand.luggage.a();
            AppMethodBeat.o(129311);
        } else if (PluginAppBrand.isSupportProcess()) {
            this.gRZ = new com.tencent.mm.plugin.appbrand.luggage.b();
            AppMethodBeat.o(129311);
        } else {
            this.gRZ = new b() {
                public final void a(c cVar) {
                }

                public final void a(com.tencent.luggage.bridge.a.a.a aVar) {
                }
            };
            AppMethodBeat.o(129311);
        }
    }

    public final void a(c cVar) {
        AppMethodBeat.i(129312);
        super.a(cVar);
        this.gRZ.a(cVar);
        cVar.a(u.class, new i());
        cVar.a(com.tencent.luggage.c.a.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.i());
        cVar.a(com.tencent.mm.plugin.appbrand.r.q.a.class, new h(ah.getContext()));
        cVar.a(e.class, new n());
        cVar.a(com.tencent.mm.plugin.appbrand.s.b.a.class, new com.tencent.luggage.f.a.a());
        cVar.a(com.tencent.mm.plugin.appbrand.n.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
        cVar.a(com.tencent.mm.plugin.appbrand.n.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
        cVar.a(com.tencent.mm.plugin.appbrand.widget.input.a.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.e());
        cVar.a(com.tencent.mm.plugin.appbrand.widget.input.panel.e.b.class, new f());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.p.a.class, new j());
        cVar.a(com.tencent.luggage.sdk.customize.b.class, new com.tencent.mm.plugin.appbrand.luggage.b.c());
        cVar.a(com.tencent.luggage.sdk.customize.a.class, com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT);
        cVar.a(w.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.g.a.c.class, new com.tencent.mm.plugin.appbrand.luggage.b.n());
        cVar.a(o.class, com.tencent.mm.plugin.appbrand.luggage.b.a.ikd);
        cVar.a(com.tencent.mm.plugin.appbrand.widget.c.b.class, new l());
        AppMethodBeat.o(129312);
    }

    public final void a(com.tencent.luggage.bridge.a.a.a aVar) {
        AppMethodBeat.i(129313);
        super.a(aVar);
        this.gRZ.a(aVar);
        AppMethodBeat.o(129313);
    }
}
