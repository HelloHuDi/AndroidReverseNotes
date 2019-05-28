package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;

class aj extends af<aa> {
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

    aj(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4, QualitySession qualitySession) {
        int i5 = 0;
        AppMethodBeat.i(131985);
        this.appId = str;
        this.har = i;
        this.cOq = i2;
        this.cDB = i3;
        this.hgC = str2;
        this.hgF = appBrandLaunchReferrer;
        this.igH = str3;
        at a = f.auV().a(str, i, "version");
        if (a != null) {
            i5 = a.field_version;
        }
        this.axy = i5;
        if (i4 < 0) {
            i4 = ai.avM();
        }
        this.hCY = i4;
        this.hgN = qualitySession;
        AppMethodBeat.o(131985);
    }

    /* Access modifiers changed, original: 0000 */
    public void atT() {
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
    }

    public /* synthetic */ Object call() {
        AppMethodBeat.i(131986);
        aa aaVar = new aa();
        aaVar.field_appId = this.appId;
        z auP = f.auP();
        if (auP == null) {
            AppMethodBeat.o(131986);
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
        cyb b = b.b(this.hgF);
        cxj c = b.c(this.hgF);
        if (1055 == this.cDB) {
            i = 1;
        } else if (FilterEnum4Shaka.MIC_SHAKA_ADD2_2 == this.cDB) {
            i = 1;
        } else {
            int[] iArr = AppBrandGlobalSystemConfig.ayC().hfQ;
            i = (iArr == null || !a.contains(iArr, this.cDB)) ? 0 : 1;
        }
        if (i == 0) {
            if (auP.a(aaVar, "appId")) {
                if (aaVar.field_jsapiInfo != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (!(i == 0 || aaVar.field_launchAction == null || 1 != aaVar.field_launchAction.vAS)) {
                    new com.tencent.mm.plugin.appbrand.launching.a.a(this.appId, false, cwf, b, c, this.igH, this.hCY, this.hgN).aHF();
                    AppMethodBeat.o(131986);
                    return aaVar;
                }
            }
        }
        atT();
        long anU = bo.anU();
        com.tencent.mm.plugin.appbrand.launching.a.a aVar = new com.tencent.mm.plugin.appbrand.launching.a.a(this.appId, true, cwf, b, c, this.igH, this.hCY, this.hgN);
        aVar.ihY = true;
        x.a(aVar);
        y.a(y.b.SYNC_LAUNCH, this.appId, this.axy, this.har, this.cDB, bo.anU() - anU);
        Object obj = aVar.iiW;
        AppMethodBeat.o(131986);
        return obj;
    }
}
