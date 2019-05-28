package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.h.g;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.h.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.s.n.a;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.plugin.appbrand.s.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.baseutils.IOUtils;

public final class f extends e {
    f(q qVar, q qVar2) {
        super(qVar, qVar2);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(g gVar, String str, String str2, a aVar) {
        AppMethodBeat.i(128933);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str;
        final String str4 = str2;
        final a aVar2 = aVar;
        o.a(this.gMN.getRuntime(), (i) gVar, str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.cvZ, str2, o.a.USR, (a) new a() {
            public final void onSuccess(String str) {
                int i = -1;
                AppMethodBeat.i(128928);
                if (f.this.gMN.atU() || f.this.gMN.isRunning()) {
                    i runtime = f.this.gMN.getRuntime();
                    String str2 = "MicroMsg.AppBrandJSContextInterfaceWC";
                    String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                    ab.i(str2, str3, objArr);
                    str2 = f.this.gMN.getAppId();
                    str3 = str3;
                    String str4 = str4;
                    long j = currentTimeMillis;
                    if (runtime != null) {
                        i = runtime.hashCode();
                    }
                    com.tencent.mm.plugin.appbrand.report.quality.a.a(str2, str3, str4, j, i);
                }
                if (aVar2 != null) {
                    aVar2.onSuccess(str);
                }
                AppMethodBeat.o(128928);
            }

            public final void lo(String str) {
                AppMethodBeat.i(128929);
                if (aVar2 != null) {
                    aVar2.lo(str);
                }
                AppMethodBeat.o(128929);
            }
        });
        AppMethodBeat.o(128933);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(g gVar, String str, String str2) {
        AppMethodBeat.i(128934);
        ab.i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: injectSdkScript %s", str);
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = this.gMN.atU();
        final String str3 = str;
        final String str4 = str2;
        o.a(this.gMN, (i) gVar, str, str, "v" + WxaCommLibRuntimeReader.avQ().gVu, str2, o.a.LIB, (a) new a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(128930);
                if (f.this.gMN.atU() || f.this.gMN.isRunning()) {
                    com.tencent.mm.plugin.appbrand.report.quality.a.aLz();
                    b.a(atU, f.this.gMN.getAppId(), currentTimeMillis, str3, (long) str4.length());
                }
                ab.i("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", f.this.gMN.getAppId(), str3);
                f.this.ds(true);
                AppMethodBeat.o(128930);
            }

            public final void lo(String str) {
                AppMethodBeat.i(128931);
                ab.e("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject failed", f.this.gMN.getAppId(), str3);
                f.this.ds(false);
                AppMethodBeat.o(128931);
            }
        });
        u.a(this.gMN.getRuntime(), gVar);
        AppMethodBeat.o(128934);
    }

    /* Access modifiers changed, original: protected|final */
    public final String asJ() {
        return "WASubContext.js";
    }

    /* Access modifiers changed, original: protected|final */
    public final String asK() {
        AppMethodBeat.i(128935);
        String xu = WxaCommLibRuntimeReader.xu("WASubContext.js");
        AppMethodBeat.o(128935);
        return xu;
    }

    /* Access modifiers changed, original: protected|final */
    public final int asL() {
        AppMethodBeat.i(139117);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.o(139117);
        return i;
    }

    public final int create(String str) {
        AppMethodBeat.i(128937);
        ab.i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on create new context, id is %d", Integer.valueOf(super.create(str)));
        AppMethodBeat.o(128937);
        return super.create(str);
    }

    /* Access modifiers changed, original: protected|final */
    public final g asI() {
        AppMethodBeat.i(128938);
        final g asI = super.asI();
        if (asI != null) {
            asI.setJsExceptionHandler(new h() {
                public final void C(String str, String str2) {
                    AppMethodBeat.i(128932);
                    ab.e("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on exception! message: %s, stacktrace %s", str, str2);
                    m.a(asI, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{l.Ej(str), l.Ej(str2)}));
                    AppMethodBeat.o(128932);
                }
            });
        }
        AppMethodBeat.o(128938);
        return asI;
    }

    /* Access modifiers changed, original: protected|final */
    public final void asM() {
        AppMethodBeat.i(128939);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 39, 1, false);
        c.a(this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.gVu, this.gMN.getRuntime().ye().hhd.gVt, 370, 39);
        AppMethodBeat.o(128939);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ds(boolean z) {
        AppMethodBeat.i(128940);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 40, 1, false);
        if (z) {
            com.tencent.mm.plugin.report.service.h.pYm.a(370, 41, 1, false);
            AppMethodBeat.o(128940);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 42, 1, false);
        if (this.gMN.getRuntime() == null) {
            AppMethodBeat.o(128940);
            return;
        }
        c.a(this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.gVu, this.gMN.getRuntime().ye().hhd.gVt, 370, 42);
        AppMethodBeat.o(128940);
    }

    /* Access modifiers changed, original: protected|final */
    public final void asN() {
        AppMethodBeat.i(128941);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 48, 1, false);
        c.a(this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.gVu, this.gMN.getRuntime().ye().hhd.gVt, 370, 48);
        AppMethodBeat.o(128941);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dt(boolean z) {
        AppMethodBeat.i(128942);
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 44, 1, false);
        if (z) {
            com.tencent.mm.plugin.report.service.h.pYm.a(370, 45, 1, false);
            AppMethodBeat.o(128942);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(370, 46, 1, false);
        c.a(this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.gVu, this.gMN.getRuntime().ye().hhd.gVt, 370, 46);
        AppMethodBeat.o(128942);
    }
}
