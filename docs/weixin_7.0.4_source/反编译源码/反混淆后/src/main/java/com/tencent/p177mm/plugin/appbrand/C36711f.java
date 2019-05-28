package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p297h.C38235g;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o;
import com.tencent.p177mm.plugin.appbrand.p329s.C19716o.C19718a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42681l;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42685u;
import com.tencent.p177mm.plugin.appbrand.p329s.C45686m;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.f */
public final class C36711f extends C33176e {
    C36711f(C38492q c38492q, C38237q c38237q) {
        super(c38492q, c38237q);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53709a(C38235g c38235g, String str, String str2, C42683a c42683a) {
        AppMethodBeat.m2504i(128933);
        final long currentTimeMillis = System.currentTimeMillis();
        final String str3 = str;
        final String str4 = str2;
        final C42683a c42683a2 = c42683a;
        C19716o.m30527a(this.gMN.getRuntime(), (C6747i) c38235g, str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.cvZ, str2, C19718a.USR, (C42683a) new C42683a() {
            public final void onSuccess(String str) {
                int i = -1;
                AppMethodBeat.m2504i(128928);
                if (C36711f.this.gMN.atU() || C36711f.this.gMN.isRunning()) {
                    C6750i runtime = C36711f.this.gMN.getRuntime();
                    String str2 = "MicroMsg.AppBrandJSContextInterfaceWC";
                    String str3 = "[QualitySystem] app-service.js runtime.hashCode = [%d]";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(runtime != null ? runtime.hashCode() : -1);
                    C4990ab.m7417i(str2, str3, objArr);
                    str2 = C36711f.this.gMN.getAppId();
                    str3 = str3;
                    String str4 = str4;
                    long j = currentTimeMillis;
                    if (runtime != null) {
                        i = runtime.hashCode();
                    }
                    C27285a.m43322a(str2, str3, str4, j, i);
                }
                if (c42683a2 != null) {
                    c42683a2.onSuccess(str);
                }
                AppMethodBeat.m2505o(128928);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                AppMethodBeat.m2504i(128929);
                if (c42683a2 != null) {
                    c42683a2.mo5987lo(str);
                }
                AppMethodBeat.m2505o(128929);
            }
        });
        AppMethodBeat.m2505o(128933);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53708a(C38235g c38235g, String str, String str2) {
        AppMethodBeat.m2504i(128934);
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: injectSdkScript %s", str);
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean atU = this.gMN.atU();
        final String str3 = str;
        final String str4 = str2;
        C19716o.m30529a(this.gMN, (C6747i) c38235g, str, str, "v" + WxaCommLibRuntimeReader.avQ().gVu, str2, C19718a.LIB, (C42683a) new C42683a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(128930);
                if (C36711f.this.gMN.atU() || C36711f.this.gMN.isRunning()) {
                    C27285a.aLz();
                    C38501b.m65164a(atU, C36711f.this.gMN.getAppId(), currentTimeMillis, str3, (long) str4.length());
                }
                C4990ab.m7417i("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", C36711f.this.gMN.getAppId(), str3);
                C36711f.this.mo53720ds(true);
                AppMethodBeat.m2505o(128930);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                AppMethodBeat.m2504i(128931);
                C4990ab.m7413e("MicroMsg.AppBrandJSContextInterfaceWC", "create with appID(%s), scriptPath(%s), sdkScript inject failed", C36711f.this.gMN.getAppId(), str3);
                C36711f.this.mo53720ds(false);
                AppMethodBeat.m2505o(128931);
            }
        });
        C42685u.m75595a(this.gMN.getRuntime(), c38235g);
        AppMethodBeat.m2505o(128934);
    }

    /* Access modifiers changed, original: protected|final */
    public final String asJ() {
        return "WASubContext.js";
    }

    /* Access modifiers changed, original: protected|final */
    public final String asK() {
        AppMethodBeat.m2504i(128935);
        String xu = WxaCommLibRuntimeReader.m42569xu("WASubContext.js");
        AppMethodBeat.m2505o(128935);
        return xu;
    }

    /* Access modifiers changed, original: protected|final */
    public final int asL() {
        AppMethodBeat.m2504i(139117);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.m2505o(139117);
        return i;
    }

    public final int create(String str) {
        AppMethodBeat.m2504i(128937);
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on create new context, id is %d", Integer.valueOf(super.create(str)));
        AppMethodBeat.m2505o(128937);
        return super.create(str);
    }

    /* Access modifiers changed, original: protected|final */
    public final C38235g asI() {
        AppMethodBeat.m2504i(128938);
        final C38235g asI = super.asI();
        if (asI != null) {
            asI.setJsExceptionHandler(new C33211h() {
                /* renamed from: C */
                public final void mo5989C(String str, String str2) {
                    AppMethodBeat.m2504i(128932);
                    C4990ab.m7413e("MicroMsg.AppBrandJSContextInterfaceWC", "hy: on exception! message: %s, stacktrace %s", str, str2);
                    C45686m.m84388a(asI, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[]{C42681l.m75588Ej(str), C42681l.m75588Ej(str2)}));
                    AppMethodBeat.m2505o(128932);
                }
            });
        }
        AppMethodBeat.m2505o(128938);
        return asI;
    }

    /* Access modifiers changed, original: protected|final */
    public final void asM() {
        AppMethodBeat.m2504i(128939);
        C7060h.pYm.mo8378a(370, 39, 1, false);
        C19690c.m30497a(this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.gVu, this.gMN.getRuntime().mo15034ye().hhd.gVt, 370, 39);
        AppMethodBeat.m2505o(128939);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ds */
    public final void mo53720ds(boolean z) {
        AppMethodBeat.m2504i(128940);
        C7060h.pYm.mo8378a(370, 40, 1, false);
        if (z) {
            C7060h.pYm.mo8378a(370, 41, 1, false);
            AppMethodBeat.m2505o(128940);
            return;
        }
        C7060h.pYm.mo8378a(370, 42, 1, false);
        if (this.gMN.getRuntime() == null) {
            AppMethodBeat.m2505o(128940);
            return;
        }
        C19690c.m30497a(this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.gVu, this.gMN.getRuntime().mo15034ye().hhd.gVt, 370, 42);
        AppMethodBeat.m2505o(128940);
    }

    /* Access modifiers changed, original: protected|final */
    public final void asN() {
        AppMethodBeat.m2504i(128941);
        C7060h.pYm.mo8378a(370, 48, 1, false);
        C19690c.m30497a(this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.gVu, this.gMN.getRuntime().mo15034ye().hhd.gVt, 370, 48);
        AppMethodBeat.m2505o(128941);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dt */
    public final void mo53721dt(boolean z) {
        AppMethodBeat.m2504i(128942);
        C7060h.pYm.mo8378a(370, 44, 1, false);
        if (z) {
            C7060h.pYm.mo8378a(370, 45, 1, false);
            AppMethodBeat.m2505o(128942);
            return;
        }
        C7060h.pYm.mo8378a(370, 46, 1, false);
        C19690c.m30497a(this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.gVu, this.gMN.getRuntime().mo15034ye().hhd.gVt, 370, 46);
        AppMethodBeat.m2505o(128942);
    }
}
