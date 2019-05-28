package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19691d;
import com.tencent.p177mm.plugin.appbrand.report.C42673i;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2441a;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2442b;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2444c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.k */
public final class C2450k {
    private static final C2450k iBx = new C2450k(true, null);
    public String appId;
    public int apptype;
    public int axy;
    public int cOq;
    public String cOr;
    public int css;
    public String cst;
    public String csu;
    public String cvF;
    public C6750i gPI;
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
    private final C2440i ikv;
    public int scene;

    private C2450k(boolean z, C2440i c2440i) {
        this.iBw = z;
        this.ikv = c2440i;
    }

    static {
        AppMethodBeat.m2504i(132636);
        AppMethodBeat.m2505o(132636);
    }

    public static C2450k aLv() {
        return iBx;
    }

    /* renamed from: a */
    public static C2450k m4688a(C41243o c41243o, String str, C2440i c2440i) {
        AppMethodBeat.m2504i(132631);
        C2450k c2450k = new C2450k(false, c2440i);
        c2450k.cvF = str;
        AppBrandStatObject appBrandStatObject = c41243o.mo43491ya().bQn;
        c2450k.scene = appBrandStatObject.scene;
        c2450k.cst = appBrandStatObject.cst;
        c2450k.appId = c41243o.mAppId;
        c2450k.gPI = c41243o;
        c2450k.css = c41243o.atI().gVs + 1;
        c2450k.axy = c41243o.atI().axy;
        c2450k.iAo = appBrandStatObject.iAo;
        c2450k.cOq = appBrandStatObject.cOq;
        c2450k.cOr = appBrandStatObject.cOr;
        AppMethodBeat.m2505o(132631);
        return c2450k;
    }

    /* renamed from: n */
    public final void mo6369n(C27242w c27242w) {
        AppMethodBeat.m2504i(132632);
        mo6370o(c27242w);
        mo6368IF();
        AppMethodBeat.m2505o(132632);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final void mo6370o(C27242w c27242w) {
        C2444c c2444c;
        C2442b c2442b;
        int i;
        AppBrandInitConfigWC appBrandInitConfigWC = null;
        AppMethodBeat.m2504i(132633);
        AppBrandSysConfigWC atH = c27242w.getRuntime().atH();
        if (atH != null) {
            this.axy = atH.hhd.gVu;
            this.iBF = WxaCommLibRuntimeReader.avQ().gVu;
        }
        this.iBE = c27242w.ito.iAU;
        this.iBv = c27242w.ito.aLi();
        this.iBA = c27242w.ito.aLk();
        this.csu = c27242w.getURL();
        this.iBH = c27242w.aBm();
        this.iBz = C19690c.m30503cV(C4996ah.getContext());
        this.iAo = c27242w.getRuntime().mo43491ya().bQn.iAo;
        C2441a k = this.ikv.mo6357k(c27242w);
        if (k == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", c27242w.aBm());
            c2444c = null;
            c2442b = null;
        } else {
            C2444c c2444c2 = k.iBl;
            c2442b = k.iBm;
            c2444c = c2444c2;
        }
        this.iBC = c2444c == null ? 0 : c2444c.type;
        this.iBD = c2444c == null ? null : c2444c.path;
        this.iBB = c2442b == null ? null : c2442b.path;
        if (this.ikv.mo6355DC(this.iBH)) {
            i = 1;
        } else {
            i = 0;
        }
        this.iBG = i;
        C41243o runtime = c27242w.getRuntime();
        if (runtime != null) {
            appBrandInitConfigWC = runtime.atI();
        }
        if (appBrandInitConfigWC != null) {
            this.apptype = appBrandInitConfigWC.bQe;
        } else {
            this.apptype = C19691d.m30510Dy(this.appId);
            C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        this.hgP = c27242w.getRuntime().atI().hgP;
        if (appBrandInitConfigWC != null) {
            AppBrandLaunchReferrer appBrandLaunchReferrer = appBrandInitConfigWC.hgF;
            if (!(appBrandLaunchReferrer == null || C5046bo.isNullOrNil(appBrandLaunchReferrer.businessType))) {
                this.iBI = appBrandLaunchReferrer.businessType;
            }
        }
        AppMethodBeat.m2505o(132633);
    }

    public final String toString() {
        AppMethodBeat.m2504i(132634);
        String str = "kv_13536{scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", sessionId='" + this.cvF + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.axy + ", appState=" + this.css + ", usedState=" + this.iAo + ", pagePath='" + this.csu + '\'' + ", networkType='" + this.iBz + '\'' + ", costTime=" + this.iBv + ", stayTime=" + this.iBA + ", referPagePath='" + this.iBB + '\'' + ", targetAction=" + this.iBC + ", targetPagePath='" + this.iBD + '\'' + ", clickTimestamp=" + this.iBE + ", publicLibVersion=" + this.iBF + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", isEntrance=" + this.iBG + ", apptype=" + this.apptype + ", systemRecentsReason=" + this.hgP + ", referAction=" + this.iBI + '}';
        AppMethodBeat.m2505o(132634);
        return str;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: IF */
    public final void mo6368IF() {
        AppMethodBeat.m2504i(132635);
        if (this.iBw) {
            AppMethodBeat.m2505o(132635);
            return;
        }
        C4990ab.m7410d("MicroMsg.AppBrand.Report.kv_13536", "report " + toString());
        final Object[] objArr = new Object[]{Integer.valueOf(this.scene), this.cst, this.cvF, this.appId, Integer.valueOf(this.axy), Integer.valueOf(this.css), Integer.valueOf(this.iAo), this.csu, this.iBz, Long.valueOf(this.iBv), Long.valueOf(this.iBA), this.iBB, Integer.valueOf(this.iBC), this.iBD, Long.valueOf(this.iBE), Integer.valueOf(this.iBF), Integer.valueOf(this.cOq), this.cOr, Integer.valueOf(this.iBG), this.iBH, Integer.valueOf(this.apptype), Integer.valueOf(this.hgP), this.iBI};
        C24511 c24511 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132630);
                try {
                    String str = (String) objArr[19];
                    if (!C5046bo.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            str = "";
                        } else {
                            str = C18178q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[19] = str;
                    }
                } catch (Exception e) {
                    objArr[19] = "";
                }
                C7060h.pYm.mo8381e(13536, C42673i.m75575k(objArr));
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.m2505o(132630);
            }
        };
        if (this.iBy) {
            c24511.run();
            try {
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.m2505o(132635);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_13536", e, "sendKV", new Object[0]);
                AppMethodBeat.m2505o(132635);
                return;
            }
        }
        C42677e.aNS().mo10302aa(c24511);
        AppMethodBeat.m2505o(132635);
    }
}
