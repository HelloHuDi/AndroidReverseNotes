package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bv;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.ci.a;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.task.AppBrandPreloadProfiler;

public final class b extends c {
    public static void a(String str, AppBrandPreloadProfiler appBrandPreloadProfiler) {
        AppMethodBeat.i(132686);
        ci ciVar = new ci();
        QualitySessionRuntime DG = a.DG(str);
        if (DG == null) {
            AppMethodBeat.o(132686);
            return;
        }
        ciVar.hg(DG.appId);
        ciVar.hf(DG.igT);
        ciVar.dgp = a.hj(DG.iCZ);
        ciVar.ddz = (long) DG.apptype;
        ciVar.ddd = (long) DG.iDa;
        ciVar.en(appBrandPreloadProfiler.aLN());
        ciVar.eo(appBrandPreloadProfiler.aLM());
        ciVar.ajK();
        AppMethodBeat.o(132686);
    }

    public static void a(boolean z, String str, long j, g gVar) {
        AppMethodBeat.i(132687);
        ck ckVar = new ck();
        if (z) {
            ckVar.ddg = 1;
        } else {
            QualitySessionRuntime DG = a.DG(str);
            if (DG == null) {
                AppMethodBeat.o(132687);
                return;
            }
            long j2;
            ckVar.hk(DG.appId);
            ckVar.hj(DG.igT);
            ckVar.dgL = ck.a.hl(DG.iCZ);
            ckVar.ddz = (long) DG.apptype;
            ckVar.ddd = (long) DG.iDa;
            ckVar.cVR = (long) DG.scene;
            if (DG.iDj) {
                j2 = 2;
            } else {
                j2 = 0;
            }
            ckVar.ddg = j2;
        }
        ckVar.es(j);
        ckVar.Hh();
        ckVar.er(ckVar.ddC - j);
        switch (gVar) {
            case X5:
                ckVar.dbX = 2;
                break;
            case Sys:
                ckVar.dbX = 4;
                break;
            case XWalk:
                ckVar.dbX = 3;
                break;
            default:
                ckVar.dbX = 2147483647L;
                break;
        }
        ckVar.ajK();
        AppMethodBeat.o(132687);
    }

    public static void a(com.tencent.mm.plugin.appbrand.task.g gVar, String str, long j, com.tencent.mm.plugin.appbrand.report.a aVar) {
        long j2 = 0;
        AppMethodBeat.i(132688);
        bv bvVar = new bv();
        if ((gVar != null ? 1 : null) == null) {
            QualitySessionRuntime DG = a.DG(str);
            if (DG == null) {
                AppMethodBeat.o(132688);
                return;
            }
            long j3;
            bvVar.gy(DG.appId);
            bvVar.gx(DG.igT);
            bvVar.ded = bv.a.gW(DG.iCZ);
            bvVar.ddz = (long) DG.apptype;
            bvVar.ddd = (long) DG.iDa;
            bvVar.cVR = (long) DG.scene;
            if (DG.iDj) {
                j3 = 2;
            } else {
                j3 = 0;
            }
            bvVar.ddg = j3;
            if (DG.hrs) {
                j2 = 1;
            }
            bvVar.dee = j2;
        } else {
            bvVar.ddg = 1;
            if (gVar == com.tencent.mm.plugin.appbrand.task.g.WAGAME) {
                j2 = 1;
            }
            bvVar.dee = j2;
        }
        bvVar.dL(j);
        bvVar.GY();
        bvVar.dK(bvVar.ddC - j);
        switch (aVar) {
            case X5:
                bvVar.dbX = 1;
                break;
            case MMV8:
                bvVar.dbX = 2;
                break;
            case WebViewBased:
                bvVar.dbX = 3;
                break;
            case NativeScript:
                bvVar.dbX = 4;
                break;
            case J2V8:
                bvVar.dbX = 5;
                break;
            case NodeJS:
                bvVar.dbX = 6;
                break;
            default:
                bvVar.dbX = 2147483647L;
                break;
        }
        bvVar.ajK();
        AppMethodBeat.o(132688);
    }

    public static void a(boolean z, String str, long j, String str2, long j2) {
        AppMethodBeat.i(132689);
        ca caVar = new ca();
        if (z) {
            caVar.ddg = 1;
        } else {
            QualitySessionRuntime DG = a.DG(str);
            if (DG == null) {
                AppMethodBeat.o(132689);
                return;
            }
            long j3;
            caVar.gN(DG.appId);
            caVar.gM(DG.igT);
            caVar.deJ = ca.a.hb(DG.iCZ);
            caVar.ddz = (long) DG.apptype;
            caVar.ddd = (long) DG.iDa;
            caVar.cVR = (long) DG.scene;
            if (DG.iDj) {
                j3 = 2;
            } else {
                j3 = 0;
            }
            caVar.ddg = j3;
        }
        caVar.dT(j);
        caVar.Hc();
        caVar.dS(caVar.ddC - j);
        caVar.gO(str2);
        caVar.dep = j2;
        caVar.gP(WxaCommLibRuntimeReader.getVersionName());
        caVar.ajK();
        AppMethodBeat.o(132689);
    }
}
