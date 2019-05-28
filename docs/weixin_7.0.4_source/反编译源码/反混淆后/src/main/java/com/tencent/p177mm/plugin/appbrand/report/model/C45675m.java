package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2441a;
import com.tencent.p177mm.protocal.protobuf.cwt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.m */
public final class C45675m {
    private static final C45675m iCa = new C45675m(true, C2440i.iBj);
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
    private final C2440i ikv;
    public int scene;

    private C45675m(boolean z, C2440i c2440i) {
        this.iBw = z;
        this.ikv = c2440i;
    }

    static {
        AppMethodBeat.m2504i(132649);
        AppMethodBeat.m2505o(132649);
    }

    public static C45675m aLw() {
        return iCa;
    }

    /* renamed from: b */
    public static C45675m m84376b(C41243o c41243o, String str, C2440i c2440i) {
        AppMethodBeat.m2504i(132645);
        C45675m c45675m = new C45675m(false, c2440i);
        try {
            c45675m.cvF = str;
            c45675m.appId = c41243o.mAppId;
            AppBrandStatObject appBrandStatObject = c41243o.mo43491ya().bQn;
            c45675m.scene = appBrandStatObject.scene;
            c45675m.cst = appBrandStatObject.cst;
            c45675m.cOq = appBrandStatObject.cOq;
            c45675m.cOr = appBrandStatObject.cOr;
            c45675m.iAo = appBrandStatObject.iAo;
            c45675m.css = c41243o.atI().gVs + 1;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14004", e, "Kv_14004 protect the npe", new Object[0]);
        }
        AppMethodBeat.m2505o(132645);
        return c45675m;
    }

    /* renamed from: p */
    public final void mo73470p(C27242w c27242w) {
        AppMethodBeat.m2504i(132646);
        this.csu = c27242w.aBm();
        C2441a k = this.ikv.mo6357k(c27242w);
        String str = (k == null || k.iBm == null) ? null : k.iBm.path;
        this.iBB = str;
        this.iBG = this.ikv.mo6355DC(this.csu) ? 1 : 0;
        m84375IF();
        AppMethodBeat.m2505o(132646);
    }

    /* renamed from: IF */
    private void m84375IF() {
        AppMethodBeat.m2504i(132647);
        if (this.iBw) {
            AppMethodBeat.m2505o(132647);
            return;
        }
        cwt cwt = new cwt();
        cwt.jCt = 1;
        cwt.fKh = this.appId;
        cwt.xso = this.csu;
        cwt.pXC = 0;
        cwt.lvf = (int) C5046bo.anT();
        cwt.pXD = 1;
        cwt.xsp = "";
        cwt.xsq = this.css;
        cwt.vGA = this.cvF;
        cwt.xsr = C19690c.m30503cV(C4996ah.getContext());
        cwt.ugc = this.scene;
        cwt.xss = this.iAo;
        cwt.xst = this.cst;
        cwt.iBB = this.iBB;
        cwt.cOq = this.cOq;
        cwt.cOr = this.cOr;
        cwt.iBG = this.iBG;
        AppBrandIDKeyBatchReport.m30482a(cwt);
        C4990ab.m7416i("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
        AppMethodBeat.m2505o(132647);
    }

    public final String toString() {
        AppMethodBeat.m2504i(132648);
        String str = "kv_14004{appId='" + this.appId + '\'' + ", sessionId='" + this.cvF + '\'' + ", scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", pagePath='" + this.csu + '\'' + ", usedState=" + this.iAo + ", appState=" + this.css + ", referPagePath='" + this.iBB + '\'' + ", isEntrance=" + this.iBG + '}';
        AppMethodBeat.m2505o(132648);
        return str;
    }
}
