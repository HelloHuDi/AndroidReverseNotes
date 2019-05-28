package com.tencent.p177mm.plugin.appbrand.app;

import com.tencent.luggage.bridge.p814a.C8852a.C8851a;
import com.tencent.luggage.bridge.p814a.C8852a.C8854b;
import com.tencent.luggage.bridge.p814a.C8852a.C8855c;
import com.tencent.luggage.p1433c.p1434a.C31256a;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.p147g.C45124d.C32191a;
import com.tencent.luggage.p815f.p816a.C8865a;
import com.tencent.luggage.sdk.C17825a;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.luggage.sdk.customize.C45127a;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38402w;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C31303c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C42562j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C45612a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C38401e;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C41238n;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.luggage.C33440a;
import com.tencent.p177mm.plugin.appbrand.luggage.C33441b;
import com.tencent.p177mm.plugin.appbrand.luggage.p1538c.C38434a;
import com.tencent.p177mm.plugin.appbrand.luggage.p1538c.C42624b;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C19587a;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C19588f;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C19592h;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C19593i;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C42621b;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C42622c;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C42623e;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C45643l;
import com.tencent.p177mm.plugin.appbrand.luggage.p908b.C45644n;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p326n.C33458b;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.plugin.appbrand.p336ui.C27331i;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38565u;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1237a.C19859b;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27415e.C27416b;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C31332b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.app.g */
final class C42344g extends C17825a {
    private C8854b gRZ = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.app.g$1 */
    class C100611 implements C8854b {
        C100611() {
        }

        /* renamed from: a */
        public final void mo20026a(C8855c c8855c) {
        }

        /* renamed from: a */
        public final void mo20025a(C8851a c8851a) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.app.g$a */
    static final class C36709a implements C32191a {
        private final Xlog gSb;

        private C36709a() {
            AppMethodBeat.m2504i(129304);
            this.gSb = new Xlog();
            AppMethodBeat.m2505o(129304);
        }

        /* synthetic */ C36709a(byte b) {
            this();
        }

        public final void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(129305);
            this.gSb.logV(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.m2505o(129305);
        }

        public final void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(129306);
            this.gSb.logI(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.m2505o(129306);
        }

        public final void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(129307);
            this.gSb.logD(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.m2505o(129307);
        }

        public final void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(129308);
            this.gSb.logW(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.m2505o(129308);
        }

        public final void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
            AppMethodBeat.m2504i(129309);
            this.gSb.logE(str, str2, str3, i, i2, j, j2, str4);
            AppMethodBeat.m2505o(129309);
        }

        public final int getLogLevel() {
            AppMethodBeat.m2504i(129310);
            int logLevel = this.gSb.getLogLevel();
            AppMethodBeat.m2505o(129310);
            return logLevel;
        }
    }

    public C42344g() {
        AppMethodBeat.m2504i(129311);
        C45124d.m82922a(new C36709a());
        if (C4996ah.doF() || C4996ah.doG() || PluginAppBrand.isAppBrandProcess()) {
            this.gRZ = new C33440a();
            AppMethodBeat.m2505o(129311);
        } else if (PluginAppBrand.isSupportProcess()) {
            this.gRZ = new C33441b();
            AppMethodBeat.m2505o(129311);
        } else {
            this.gRZ = new C100611();
            AppMethodBeat.m2505o(129311);
        }
    }

    /* renamed from: a */
    public final void mo20026a(C8855c c8855c) {
        AppMethodBeat.m2504i(129312);
        super.mo20026a(c8855c);
        this.gRZ.mo20026a(c8855c);
        c8855c.mo20023a(C38565u.class, new C27331i());
        c8855c.mo20023a(C31256a.class, new C19593i());
        c8855c.mo20023a(C10708a.class, new C19592h(C4996ah.getContext()));
        c8855c.mo20023a(C38401e.class, new C41238n());
        c8855c.mo20023a(C33523a.class, new C8865a());
        c8855c.mo20024a(C2402a.class, new C38434a());
        c8855c.mo20024a(C33458b.class, new C42624b());
        c8855c.mo20023a(C19859b.class, new C42623e());
        c8855c.mo20023a(C27416b.class, new C19588f());
        c8855c.mo20023a(C45612a.class, new C42562j());
        c8855c.mo20023a(C0997b.class, new C42622c());
        c8855c.mo20023a(C45127a.class, C10600f.ijT);
        c8855c.mo20023a(C38402w.class, new C42621b());
        c8855c.mo20023a(C31303c.class, new C45644n());
        c8855c.mo20023a(C31282o.class, C19587a.ikd);
        c8855c.mo20023a(C31332b.class, new C45643l());
        AppMethodBeat.m2505o(129312);
    }

    /* renamed from: a */
    public final void mo20025a(C8851a c8851a) {
        AppMethodBeat.m2504i(129313);
        super.mo20025a(c8851a);
        this.gRZ.mo20025a(c8851a);
        AppMethodBeat.m2505o(129313);
    }
}
