package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.t.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class p {
    private static final p iCw = new p(true);
    public String appId;
    public int apptype;
    public int axy;
    public int cOq;
    public String cOr;
    public int css;
    public String cst;
    public String csu;
    public String cvF;
    public o gOq;
    public int iAo;
    public String iBB;
    public int iBC;
    public String iBD;
    public long iBE;
    public int iBF;
    public int iBG;
    public String iBH;
    private final boolean iBw;
    boolean iBy = false;
    public String iBz;
    public boolean iCA = true;
    private String iCx = "";
    public final LinkedList<String> iCy = new LinkedList();
    public String iCz;
    public int scene;

    private p(boolean z) {
        AppMethodBeat.i(132666);
        this.iBw = z;
        AppMethodBeat.o(132666);
    }

    static {
        AppMethodBeat.i(132674);
        AppMethodBeat.o(132674);
    }

    public static p aLy() {
        return iCw;
    }

    public static p a(o oVar, String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(132667);
        p pVar = new p(false);
        pVar.cvF = str;
        AppBrandStatObject appBrandStatObject = oVar.ya().bQn;
        pVar.scene = appBrandStatObject.scene;
        pVar.cst = appBrandStatObject.cst;
        pVar.appId = oVar.mAppId;
        pVar.gOq = oVar;
        if (oVar.atH() == null) {
            pVar.css = oVar.gNB.gVs + 1;
            pVar.axy = oVar.atI().axy;
        } else {
            pVar.css = oVar.atH().hhd.gVt + 1;
            pVar.axy = oVar.atH().hhd.gVu;
        }
        pVar.iAo = appBrandStatObject.iAo;
        pVar.cOq = appBrandStatObject.cOq;
        pVar.cOr = appBrandStatObject.cOr;
        pVar.iCy.addAll(linkedList);
        AppMethodBeat.o(132667);
        return pVar;
    }

    public final void a(w wVar, String str) {
        AppMethodBeat.i(132668);
        this.iBB = (String) this.iCy.peekFirst();
        this.iBC = 2;
        this.iBD = str;
        this.iCy.push(wVar.getURL());
        this.iCx = wVar.getURL();
        q(wVar);
        AppMethodBeat.o(132668);
    }

    public final void a(w wVar, boolean z) {
        AppMethodBeat.i(132669);
        this.iBC = z ? 1 : 7;
        String str = (String) this.iCy.pollFirst();
        this.iBD = str;
        this.iBB = str;
        if (!z) {
            this.iBD = this.iCx;
        }
        q(wVar);
        AppMethodBeat.o(132669);
    }

    public final void q(w wVar) {
        AppMethodBeat.i(132670);
        a aJS = wVar.aJS();
        if (aJS == null) {
            AppMethodBeat.o(132670);
            return;
        }
        a(wVar, aJS);
        IF();
        AppMethodBeat.o(132670);
    }

    private void a(w wVar, a aVar) {
        AppMethodBeat.i(132671);
        AppBrandSysConfigWC atH = wVar.getRuntime().atH();
        if (atH != null) {
            this.axy = atH.hhd.gVu;
            this.iBF = WxaCommLibRuntimeReader.avQ().gVu;
        }
        this.iBE = System.currentTimeMillis();
        String url = aVar.getWebView().getUrl();
        if (url == null) {
            url = "";
        }
        this.iCz = q.encode(url);
        this.csu = wVar.getURL();
        this.iBH = wVar.aBm();
        this.iBz = c.cV(ah.getContext());
        this.iBG = this.iCA ? 1 : 0;
        this.iCA = false;
        o runtime = wVar.getRuntime();
        AppBrandInitConfigWC atI = runtime == null ? null : runtime.atI();
        if (atI != null) {
            this.apptype = atI.bQe;
        } else {
            this.apptype = d.Dy(this.appId);
            ab.i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        AppMethodBeat.o(132671);
    }

    public final String toString() {
        AppMethodBeat.i(132672);
        String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", sessionId='" + this.cvF + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.axy + ", appState=" + this.css + ", usedState=" + this.iAo + ", pagePath='" + this.csu + '\'' + ", currentUrl='" + this.iCz + '\'' + ", networkType='" + this.iBz + '\'' + ", referPagePath='" + this.iBB + '\'' + ", targetAction=" + this.iBC + ", targetPagePath='" + this.iBD + '\'' + ", clickTimestamp=" + this.iBE + ", publicLibVersion=" + this.iBF + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", isEntrance=" + this.iBG + ", apptype=" + this.apptype + '}';
        AppMethodBeat.o(132672);
        return str;
    }

    private void IF() {
        AppMethodBeat.i(132673);
        if (this.iBw) {
            AppMethodBeat.o(132673);
            return;
        }
        ab.i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
        final Object[] objArr = new Object[]{Integer.valueOf(this.scene), this.cst, this.cvF, this.appId, Integer.valueOf(this.axy), Integer.valueOf(this.css), Integer.valueOf(this.iAo), this.csu, this.iCz, this.iBz, this.iBB, Integer.valueOf(this.iBC), this.iBD, Long.valueOf(this.iBE), Integer.valueOf(this.iBF), Integer.valueOf(this.cOq), this.cOr, Integer.valueOf(this.iBG), this.iBH, Integer.valueOf(this.apptype)};
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(132664);
                try {
                    String str = (String) objArr[18];
                    if (!bo.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            str = "";
                        } else {
                            str = q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[18] = str;
                    }
                } catch (Exception e) {
                    objArr[18] = "";
                }
                h.pYm.e(14992, i.k(objArr));
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(132664);
            }
        };
        if (this.iBy) {
            anonymousClass1.run();
            try {
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.o(132673);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", e, "sendKV", new Object[0]);
                AppMethodBeat.o(132673);
                return;
            }
        }
        e.aNS().aa(anonymousClass1);
        AppMethodBeat.o(132673);
    }
}
