package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C45622a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19691d;
import com.tencent.p177mm.plugin.appbrand.report.C42673i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.p */
public final class C38499p {
    private static final C38499p iCw = new C38499p(true);
    public String appId;
    public int apptype;
    public int axy;
    public int cOq;
    public String cOr;
    public int css;
    public String cst;
    public String csu;
    public String cvF;
    public C41243o gOq;
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

    private C38499p(boolean z) {
        AppMethodBeat.m2504i(132666);
        this.iBw = z;
        AppMethodBeat.m2505o(132666);
    }

    static {
        AppMethodBeat.m2504i(132674);
        AppMethodBeat.m2505o(132674);
    }

    public static C38499p aLy() {
        return iCw;
    }

    /* renamed from: a */
    public static C38499p m65156a(C41243o c41243o, String str, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(132667);
        C38499p c38499p = new C38499p(false);
        c38499p.cvF = str;
        AppBrandStatObject appBrandStatObject = c41243o.mo43491ya().bQn;
        c38499p.scene = appBrandStatObject.scene;
        c38499p.cst = appBrandStatObject.cst;
        c38499p.appId = c41243o.mAppId;
        c38499p.gOq = c41243o;
        if (c41243o.atH() == null) {
            c38499p.css = c41243o.gNB.gVs + 1;
            c38499p.axy = c41243o.atI().axy;
        } else {
            c38499p.css = c41243o.atH().hhd.gVt + 1;
            c38499p.axy = c41243o.atH().hhd.gVu;
        }
        c38499p.iAo = appBrandStatObject.iAo;
        c38499p.cOq = appBrandStatObject.cOq;
        c38499p.cOr = appBrandStatObject.cOr;
        c38499p.iCy.addAll(linkedList);
        AppMethodBeat.m2505o(132667);
        return c38499p;
    }

    /* renamed from: a */
    public final void mo61209a(C27242w c27242w, String str) {
        AppMethodBeat.m2504i(132668);
        this.iBB = (String) this.iCy.peekFirst();
        this.iBC = 2;
        this.iBD = str;
        this.iCy.push(c27242w.getURL());
        this.iCx = c27242w.getURL();
        mo61211q(c27242w);
        AppMethodBeat.m2505o(132668);
    }

    /* renamed from: a */
    public final void mo61210a(C27242w c27242w, boolean z) {
        AppMethodBeat.m2504i(132669);
        this.iBC = z ? 1 : 7;
        String str = (String) this.iCy.pollFirst();
        this.iBD = str;
        this.iBB = str;
        if (!z) {
            this.iBD = this.iCx;
        }
        mo61211q(c27242w);
        AppMethodBeat.m2505o(132669);
    }

    /* renamed from: q */
    public final void mo61211q(C27242w c27242w) {
        AppMethodBeat.m2504i(132670);
        C45622a aJS = c27242w.aJS();
        if (aJS == null) {
            AppMethodBeat.m2505o(132670);
            return;
        }
        m65157a(c27242w, aJS);
        m65155IF();
        AppMethodBeat.m2505o(132670);
    }

    /* renamed from: a */
    private void m65157a(C27242w c27242w, C45622a c45622a) {
        AppMethodBeat.m2504i(132671);
        AppBrandSysConfigWC atH = c27242w.getRuntime().atH();
        if (atH != null) {
            this.axy = atH.hhd.gVu;
            this.iBF = WxaCommLibRuntimeReader.avQ().gVu;
        }
        this.iBE = System.currentTimeMillis();
        String url = c45622a.getWebView().getUrl();
        if (url == null) {
            url = "";
        }
        this.iCz = C18178q.encode(url);
        this.csu = c27242w.getURL();
        this.iBH = c27242w.aBm();
        this.iBz = C19690c.m30503cV(C4996ah.getContext());
        this.iBG = this.iCA ? 1 : 0;
        this.iCA = false;
        C41243o runtime = c27242w.getRuntime();
        AppBrandInitConfigWC atI = runtime == null ? null : runtime.atI();
        if (atI != null) {
            this.apptype = atI.bQe;
        } else {
            this.apptype = C19691d.m30510Dy(this.appId);
            C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(this.apptype));
        }
        this.apptype += 1000;
        AppMethodBeat.m2505o(132671);
    }

    public final String toString() {
        AppMethodBeat.m2504i(132672);
        String str = "kv_4992{scene=" + this.scene + ", sceneNote='" + this.cst + '\'' + ", sessionId='" + this.cvF + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.axy + ", appState=" + this.css + ", usedState=" + this.iAo + ", pagePath='" + this.csu + '\'' + ", currentUrl='" + this.iCz + '\'' + ", networkType='" + this.iBz + '\'' + ", referPagePath='" + this.iBB + '\'' + ", targetAction=" + this.iBC + ", targetPagePath='" + this.iBD + '\'' + ", clickTimestamp=" + this.iBE + ", publicLibVersion=" + this.iBF + ", preScene=" + this.cOq + ", preSceneNote='" + this.cOr + '\'' + ", isEntrance=" + this.iBG + ", apptype=" + this.apptype + '}';
        AppMethodBeat.m2505o(132672);
        return str;
    }

    /* renamed from: IF */
    private void m65155IF() {
        AppMethodBeat.m2504i(132673);
        if (this.iBw) {
            AppMethodBeat.m2505o(132673);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
        final Object[] objArr = new Object[]{Integer.valueOf(this.scene), this.cst, this.cvF, this.appId, Integer.valueOf(this.axy), Integer.valueOf(this.css), Integer.valueOf(this.iAo), this.csu, this.iCz, this.iBz, this.iBB, Integer.valueOf(this.iBC), this.iBD, Long.valueOf(this.iBE), Integer.valueOf(this.iBF), Integer.valueOf(this.cOq), this.cOr, Integer.valueOf(this.iBG), this.iBH, Integer.valueOf(this.apptype)};
        C197011 c197011 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132664);
                try {
                    String str = (String) objArr[18];
                    if (!C5046bo.isNullOrNil(str)) {
                        int indexOf = str.indexOf(63);
                        if (indexOf < 0) {
                            str = "";
                        } else {
                            str = C18178q.encode(str.substring(indexOf + 1, str.length()));
                        }
                        objArr[18] = str;
                    }
                } catch (Exception e) {
                    objArr[18] = "";
                }
                C7060h.pYm.mo8381e(14992, C42673i.m75575k(objArr));
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.m2505o(132664);
            }
        };
        if (this.iBy) {
            c197011.run();
            try {
                KVCommCrossProcessReceiver.cgo();
                AppMethodBeat.m2505o(132673);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.Report.kv_14992", e, "sendKV", new Object[0]);
                AppMethodBeat.m2505o(132673);
                return;
            }
        }
        C42677e.aNS().mo10302aa(c197011);
        AppMethodBeat.m2505o(132673);
    }
}
