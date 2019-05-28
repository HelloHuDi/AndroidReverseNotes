package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.model.i.a;
import com.tencent.mm.plugin.appbrand.report.model.i.b;
import com.tencent.mm.plugin.appbrand.report.model.i.c;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    private static final k iBx = new k(true, null);
    public String appId;
    public int apptype;
    public int axy;
    public int cOq;
    public String cOr;
    public int css;
    public String cst;
    public String csu;
    public String cvF;
    public i gPI;
    public int hgP;
    public int iAo;
    public long iBA;
    public String iBB;
    public int iBC;
    public String iBD;
    public long iBE;
    public int iBF;
    public int iBG;
    public String iBH;
    public String iBI;
    public long iBv;
    private final boolean iBw;
    boolean iBy = false;
    public String iBz;
    private final i ikv;
    public int scene;

    private k(boolean z, i iVar) {
        this.iBw = z;
        this.ikv = iVar;
    }

    static {
        AppMethodBeat.i(132636);
        AppMethodBeat.o(132636);
    }

    public static k aLv() {
        return iBx;
    }

    public static k a(o oVar, String str, i iVar) {
        AppMethodBeat.i(132631);
        k kVar = new k(false, iVar);
        kVar.cvF = str;
        AppBrandStatObject appBrandStatObject = oVar.ya().bQn;
        kVar.scene = appBrandStatObject.scene;
        kVar.cst = appBrandStatObject.cst;
        kVar.appId = oVar.mAppId;
        kVar.gPI = oVar;
        kVar.css = oVar.atI().gVs + 1;
        kVar.axy = oVar.atI().axy;
        kVar.iAo = appBrandStatObject.iAo;
        kVar.cOq = appBrandStatObject.cOq;
        kVar.cOr = appBrandStatObject.cOr;
        AppMethodBeat.o(132631);
        return kVar;
    }

    public final void n(w wVar) {
        AppMethodBeat.i(132632);
        o(wVar);
        IF();
        AppMethodBeat.o(132632);
    }

    /* Access modifiers changed, original: final */
    public final void o(w wVar) {
        c cVar;
        b bVar;
        int i;
        AppBrandInitConfigWC appBrandInitConfigWC = null;
        AppMethodBeat.i(132633);
        AppBrandSysConfigWC atH = wVar.getRuntime().atH();
        if (atH != null) {
            this.axy = atH.hhd.gVu;
            this.iBF = WxaCommLibRuntimeReader.avQ().gVu;
        }
        this.iBE = wVar.ito.iAU;
        this.iBv = wVar.ito.aLi();
        this.iBA = wVar.ito.aLk();
        this.csu = wVar.getURL();
        this.iBH = wVar.aBm();
        this.iBz = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
        this.iAo = wVar.getRuntime().ya().bQn.iAo;
        a k = this.ikv.k(wVar);
        if (k == null) {
            ab.e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", wVar.aBm());
            cVar = null;
            bVar = null;
        } else {
            c cVar2 = k.iBl;
            bVar = k.iBm;
            cVar = cVar2;
        }
        this.iBC = cVar == null ? 0 : cVar.type;
        this.iBD = cVar == null ? null : cVar.path;
        this.iBB = bVar == null ? null : bVar.path;
        if (this.ikv.DC(this.iBH)) {
            i = 1;
        } else {
            i = 0;
        }
        this.iBG = i;
        o runtime = wVar.getRuntime();
        if (runtime != null) {
            appBrandInitConfigWC = runtime.atI();
        }
        if (appBrandInitConfigWC != null) {
            this.apptype = appBrandInitConfigWC.bQe;
        } else {
            this.apptype = d.Dy(this.appId);
            ab.i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        this.hgP = wVar.getRuntime().atI().hgP;
        if (appBrandInitConfigWC != null) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = appBrandInitConfigWC.hgF;
            if (!(appBrandLaunchReferrer == null || bo.isNullOrNil(appBrandLaunchReferrer.businessType))) {
                this.iBI = appBrandLaunchReferrer.businessType;
            }
        }
        AppMethodBeat.o(132633);
    }

    public final String toString() {
        AppMethodBeat.i(132634);
        String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", sessionId='" + this.cvF + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.axy + ", appState=" + this.css + ", usedState=" + this.iAo + ", pagePath='" + this.csu + '\'' + ", networkType='" + this.iBz + '\'' + ", costTime=" + this.iBv + ", stayTime=" + this.iBA + ", referPagePath='" + this.iBB + '\'' + ", targetAction=" + this.iBC + ", targetPagePath='" + this.iBD + '\'' + ", clickTimestamp=" + this.iBE + ", publicLibVersion=" + this.iBF + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", isEntrance=" + this.iBG + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.hgP + ", referAction=" + this.iBI + '}';
        AppMethodBeat.o(132634);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final void IF() {
        AppMethodBeat.i(132635);
        if (this.iBw) {
            AppMethodBeat.o(132635);
            return;
        }
        ab.d("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
        final Object[] objArr = new Object[]{Integer.valueOf(this.scene), this.cst, this.cvF, this.appId, Integer.valueOf(this.axy), Integer.valueOf(this.css), Integer.valueOf(this.iAo), this.csu, this.iBz, Long.valueOf(this.iBv), Long.valueOf(this.iBA), this.iBB, Integer.valueOf(this.iBC), this.iBD, Long.valueOf(this.iBE), Integer.valueOf(this.iBF), Integer.valueOf(this.cOq), this.cOr, Integer.valueOf(this.iBG), this.iBH, Integer.valueOf(this.apptype), Integer.valueOf(this.hgP), this.iBI};
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(132630);
                try {
                    String str = (String) objArr[19];
                    if (!bo.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            str = "";
                        } else {
                            str = q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[19] = str;
                    }
                } catch (Exception e) {
                    objArr[19] = "";
                }
                h.pYm.e(13536, com.tencent.mm.plugin.appbrand.report.i.k(objArr));
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(132630);
            }
        };
        if (this.iBy) {
            anonymousClass1.run();
            try {
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(132635);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e, "sendKV", new Object[0]);
                AppMethodBeat.o(132635);
                return;
            }
        }
        e.aNS().aa(anonymousClass1);
        AppMethodBeat.o(132635);
    }
}
