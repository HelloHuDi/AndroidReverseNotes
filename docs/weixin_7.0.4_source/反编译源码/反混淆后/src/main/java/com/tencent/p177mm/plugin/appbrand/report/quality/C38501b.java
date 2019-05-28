package com.tencent.p177mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C18441bv;
import com.tencent.p177mm.p230g.p232b.p233a.C18441bv.C18442a;
import com.tencent.p177mm.p230g.p232b.p233a.C18446ci;
import com.tencent.p177mm.p230g.p232b.p233a.C18446ci.C18447a;
import com.tencent.p177mm.p230g.p232b.p233a.C26279ca;
import com.tencent.p177mm.p230g.p232b.p233a.C26279ca.C26280a;
import com.tencent.p177mm.p230g.p232b.p233a.C26286ck;
import com.tencent.p177mm.p230g.p232b.p233a.C26286ck.C26285a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.report.C42669a;
import com.tencent.p177mm.plugin.appbrand.report.C42671g;
import com.tencent.p177mm.plugin.appbrand.task.AppBrandPreloadProfiler;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.b */
public final class C38501b extends C33519c {
    /* renamed from: a */
    public static void m65162a(String str, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.m2504i(132686);
        C18446ci c18446ci = new C18446ci();
        QualitySessionRuntime DG = C27285a.m43319DG(str);
        if (DG == null) {
            AppMethodBeat.m2505o(132686);
            return;
        }
        c18446ci.mo33721hg(DG.appId);
        c18446ci.mo33720hf(DG.igT);
        c18446ci.dgp = C18447a.m28703hj(DG.iCZ);
        c18446ci.ddz = (long) DG.apptype;
        c18446ci.ddd = (long) DG.iDa;
        c18446ci.mo33718en(appBrandPreloadProfiler.aLN());
        c18446ci.mo33719eo(appBrandPreloadProfiler.aLM());
        c18446ci.ajK();
        AppMethodBeat.m2505o(132686);
    }

    /* renamed from: a */
    public static void m65163a(boolean z, String str, long j, C42671g c42671g) {
        AppMethodBeat.m2504i(132687);
        C26286ck c26286ck = new C26286ck();
        if (z) {
            c26286ck.ddg = 1;
        } else {
            QualitySessionRuntime DG = C27285a.m43319DG(str);
            if (DG == null) {
                AppMethodBeat.m2505o(132687);
                return;
            }
            long j2;
            c26286ck.mo44037hk(DG.appId);
            c26286ck.mo44036hj(DG.igT);
            c26286ck.dgL = C26285a.m41749hl(DG.iCZ);
            c26286ck.ddz = (long) DG.apptype;
            c26286ck.ddd = (long) DG.iDa;
            c26286ck.cVR = (long) DG.scene;
            if (DG.iDj) {
                j2 = 2;
            } else {
                j2 = 0;
            }
            c26286ck.ddg = j2;
        }
        c26286ck.mo44035es(j);
        c26286ck.mo44033Hh();
        c26286ck.mo44034er(c26286ck.ddC - j);
        switch (c42671g) {
            case X5:
                c26286ck.dbX = 2;
                break;
            case Sys:
                c26286ck.dbX = 4;
                break;
            case XWalk:
                c26286ck.dbX = 3;
                break;
            default:
                c26286ck.dbX = 2147483647L;
                break;
        }
        c26286ck.ajK();
        AppMethodBeat.m2505o(132687);
    }

    /* renamed from: a */
    public static void m65161a(C38519g c38519g, String str, long j, C42669a c42669a) {
        long j2 = 0;
        AppMethodBeat.m2504i(132688);
        C18441bv c18441bv = new C18441bv();
        if ((c38519g != null ? 1 : null) == null) {
            QualitySessionRuntime DG = C27285a.m43319DG(str);
            if (DG == null) {
                AppMethodBeat.m2505o(132688);
                return;
            }
            long j3;
            c18441bv.mo33708gy(DG.appId);
            c18441bv.mo33707gx(DG.igT);
            c18441bv.ded = C18442a.m28685gW(DG.iCZ);
            c18441bv.ddz = (long) DG.apptype;
            c18441bv.ddd = (long) DG.iDa;
            c18441bv.cVR = (long) DG.scene;
            if (DG.iDj) {
                j3 = 2;
            } else {
                j3 = 0;
            }
            c18441bv.ddg = j3;
            if (DG.hrs) {
                j2 = 1;
            }
            c18441bv.dee = j2;
        } else {
            c18441bv.ddg = 1;
            if (c38519g == C38519g.WAGAME) {
                j2 = 1;
            }
            c18441bv.dee = j2;
        }
        c18441bv.mo33706dL(j);
        c18441bv.mo33704GY();
        c18441bv.mo33705dK(c18441bv.ddC - j);
        switch (c42669a) {
            case X5:
                c18441bv.dbX = 1;
                break;
            case MMV8:
                c18441bv.dbX = 2;
                break;
            case WebViewBased:
                c18441bv.dbX = 3;
                break;
            case NativeScript:
                c18441bv.dbX = 4;
                break;
            case J2V8:
                c18441bv.dbX = 5;
                break;
            case NodeJS:
                c18441bv.dbX = 6;
                break;
            default:
                c18441bv.dbX = 2147483647L;
                break;
        }
        c18441bv.ajK();
        AppMethodBeat.m2505o(132688);
    }

    /* renamed from: a */
    public static void m65164a(boolean z, String str, long j, String str2, long j2) {
        AppMethodBeat.m2504i(132689);
        C26279ca c26279ca = new C26279ca();
        if (z) {
            c26279ca.ddg = 1;
        } else {
            QualitySessionRuntime DG = C27285a.m43319DG(str);
            if (DG == null) {
                AppMethodBeat.m2505o(132689);
                return;
            }
            long j3;
            c26279ca.mo44030gN(DG.appId);
            c26279ca.mo44029gM(DG.igT);
            c26279ca.deJ = C26280a.m41746hb(DG.iCZ);
            c26279ca.ddz = (long) DG.apptype;
            c26279ca.ddd = (long) DG.iDa;
            c26279ca.cVR = (long) DG.scene;
            if (DG.iDj) {
                j3 = 2;
            } else {
                j3 = 0;
            }
            c26279ca.ddg = j3;
        }
        c26279ca.mo44028dT(j);
        c26279ca.mo44026Hc();
        c26279ca.mo44027dS(c26279ca.ddC - j);
        c26279ca.mo44031gO(str2);
        c26279ca.dep = j2;
        c26279ca.mo44032gP(WxaCommLibRuntimeReader.getVersionName());
        c26279ca.ajK();
        AppMethodBeat.m2505o(132689);
    }
}
