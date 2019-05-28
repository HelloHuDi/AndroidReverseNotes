package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.report.model.i.a;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    private static final m iCa = new m(true, i.iBj);
    public String appId;
    public int cOq;
    public String cOr;
    public int css;
    public String cst;
    public String csu;
    public String cvF;
    public int iAo;
    public String iBB;
    public int iBG;
    private final boolean iBw;
    private final i ikv;
    public int scene;

    private m(boolean z, i iVar) {
        this.iBw = z;
        this.ikv = iVar;
    }

    static {
        AppMethodBeat.i(132649);
        AppMethodBeat.o(132649);
    }

    public static m aLw() {
        return iCa;
    }

    public static m b(o oVar, String str, i iVar) {
        AppMethodBeat.i(132645);
        m mVar = new m(false, iVar);
        try {
            mVar.cvF = str;
            mVar.appId = oVar.mAppId;
            AppBrandStatObject appBrandStatObject = oVar.ya().bQn;
            mVar.scene = appBrandStatObject.scene;
            mVar.cst = appBrandStatObject.cst;
            mVar.cOq = appBrandStatObject.cOq;
            mVar.cOr = appBrandStatObject.cOr;
            mVar.iAo = appBrandStatObject.iAo;
            mVar.css = oVar.atI().gVs + 1;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", e, "Kv_14004 protect the npe", new Object[0]);
        }
        AppMethodBeat.o(132645);
        return mVar;
    }

    public final void p(w wVar) {
        AppMethodBeat.i(132646);
        this.csu = wVar.aBm();
        a k = this.ikv.k(wVar);
        String str = (k == null || k.iBm == null) ? null : k.iBm.path;
        this.iBB = str;
        this.iBG = this.ikv.DC(this.csu) ? 1 : 0;
        IF();
        AppMethodBeat.o(132646);
    }

    private void IF() {
        AppMethodBeat.i(132647);
        if (this.iBw) {
            AppMethodBeat.o(132647);
            return;
        }
        cwt cwt = new cwt();
        cwt.jCt = 1;
        cwt.fKh = this.appId;
        cwt.xso = this.csu;
        cwt.pXC = 0;
        cwt.lvf = (int) bo.anT();
        cwt.pXD = 1;
        cwt.xsp = "";
        cwt.xsq = this.css;
        cwt.vGA = this.cvF;
        cwt.xsr = c.cV(ah.getContext());
        cwt.ugc = this.scene;
        cwt.xss = this.iAo;
        cwt.xst = this.cst;
        cwt.iBB = this.iBB;
        cwt.cOq = this.cOq;
        cwt.cOr = this.cOr;
        cwt.iBG = this.iBG;
        AppBrandIDKeyBatchReport.a(cwt);
        ab.i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        AppMethodBeat.o(132647);
    }

    public final String toString() {
        AppMethodBeat.i(132648);
        String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.cvF + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", pagePath='" + this.csu + '\'' + ", usedState=" + this.iAo + ", appState=" + this.css + ", referPagePath='" + this.iBB + '\'' + ", isEntrance=" + this.iBG + '}';
        AppMethodBeat.o(132648);
        return str;
    }
}
