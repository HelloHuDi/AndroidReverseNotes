package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19034ai;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.launching.C33438y.C33439b;
import com.tencent.p177mm.plugin.appbrand.launching.p905a.C33430a;
import com.tencent.p177mm.plugin.appbrand.launching.p905a.C33431b;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.protocal.protobuf.cwf;
import com.tencent.p177mm.protocal.protobuf.cxj;
import com.tencent.p177mm.protocal.protobuf.cyb;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.aj */
class C19561aj extends C42607af<C27157aa> {
    final String appId;
    final int axy;
    final int cDB;
    final int cOq;
    final int hCY;
    final int har;
    final String hgC;
    final AppBrandLaunchReferrer hgF;
    final QualitySession hgN;
    final String igH;

    C19561aj(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4, QualitySession qualitySession) {
        int i5 = 0;
        AppMethodBeat.m2504i(131985);
        this.appId = str;
        this.har = i;
        this.cOq = i2;
        this.cDB = i3;
        this.hgC = str2;
        this.hgF = appBrandLaunchReferrer;
        this.igH = str3;
        C31281at a = C42340f.auV().mo60842a(str, i, "version");
        if (a != null) {
            i5 = a.field_version;
        }
        this.axy = i5;
        if (i4 < 0) {
            i4 = C19034ai.avM();
        }
        this.hCY = i4;
        this.hgN = qualitySession;
        AppMethodBeat.m2505o(131985);
    }

    /* Access modifiers changed, original: 0000 */
    public void atT() {
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }

    public /* synthetic */ Object call() {
        AppMethodBeat.m2504i(131986);
        C27157aa c27157aa = new C27157aa();
        c27157aa.field_appId = this.appId;
        C38432z auP = C42340f.auP();
        if (auP == null) {
            AppMethodBeat.m2505o(131986);
            return null;
        }
        int i;
        cwf cwf = new cwf();
        cwf.wzF = this.har;
        cwf.vMG = this.axy;
        cwf.Scene = this.cDB;
        cwf.wDB = this.hgC;
        cwf.wDA = 0;
        cwf.wDz = this.cOq;
        cyb b = C33431b.m54639b(this.hgF);
        cxj c = C33431b.m54640c(this.hgF);
        if (1055 == this.cDB) {
            i = 1;
        } else if (FilterEnum4Shaka.MIC_SHAKA_ADD2_2 == this.cDB) {
            i = 1;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.ayC().hfQ;
            i = (iArr == null || !C32473a.contains(iArr, this.cDB)) ? 0 : 1;
        }
        if (i == 0) {
            if (auP.mo61133a(c27157aa, "appId")) {
                if (c27157aa.field_jsapiInfo != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (!(i == 0 || c27157aa.field_launchAction == null || 1 != c27157aa.field_launchAction.vAS)) {
                    new C33430a(this.appId, false, cwf, b, c, this.igH, this.hCY, this.hgN).aHF();
                    AppMethodBeat.m2505o(131986);
                    return c27157aa;
                }
            }
        }
        atT();
        long anU = C5046bo.anU();
        C33430a c33430a = new C33430a(this.appId, true, cwf, b, c, this.igH, this.hCY, this.hgN);
        c33430a.ihY = true;
        C8920x.m16081a(c33430a);
        C33438y.m54643a(C33439b.SYNC_LAUNCH, this.appId, this.axy, this.har, this.cDB, C5046bo.anU() - anU);
        Object obj = c33430a.iiW;
        AppMethodBeat.m2505o(131986);
        return obj;
    }
}
