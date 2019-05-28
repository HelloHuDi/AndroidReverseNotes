package com.tencent.p177mm.plugin.appbrand.appcache.p277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C10084c;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C19047e;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C26743d;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C33085b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42350f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42351g;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42352h;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b.C42353i;
import com.tencent.p177mm.protocal.protobuf.cgb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.d */
public final class C42354d {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.d$1 */
    static class C267451 implements C5681a<Void, Boolean> {
        C267451() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129445);
            Boolean bool = (Boolean) obj;
            if (bool != null && bool.booleanValue()) {
                C42353i.gWd.awv();
            }
            AppMethodBeat.m2505o(129445);
            return null;
        }
    }

    /* renamed from: aB */
    static void m74909aB(List<cgb> list) {
        AppMethodBeat.m2504i(129446);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(129446);
            return;
        }
        for (cgb cgb : list) {
            if (cgb.xfe == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", cgb.xfb, cgb.vEn);
            } else {
                boolean z;
                String str = "MicroMsg.AppBrand.PredownloadCmdProcessor";
                String str2 = "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)";
                Object[] objArr = new Object[8];
                objArr[0] = cgb.xfb;
                objArr[1] = cgb.vEn;
                objArr[2] = Boolean.valueOf(cgb.xfe.xtd != null);
                if (cgb.xfe.xte != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                if (cgb.xfe.xtf != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                if (cgb.xfe.xtg != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[5] = Boolean.valueOf(z);
                if (cgb.xfe.xth != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[6] = Boolean.valueOf(z);
                if (cgb.xfe.xti != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[7] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str2, objArr);
                if (cgb.xfe.xtd != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xtd).mo60494j(new C26743d());
                }
                if (cgb.xfe.xte != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xte).mo60494j(new C10084c()).mo60491g(new C267451());
                }
                if (cgb.xfe.xtf != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xtf).mo60494j(new C19047e());
                }
                if (cgb.xfe.xtg != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xtg).mo60494j(new C42351g());
                }
                if (cgb.xfe.xth != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xth).mo60494j(new C42350f());
                }
                if (cgb.xfe.xti != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xti).mo60494j(new C42352h());
                }
                if (cgb.xfe.xtj != null) {
                    C41930g.m74068j(cgb.xfb, cgb.vEn, cgb.xfe.xtj).mo60494j(new C33085b());
                }
            }
        }
        AppMethodBeat.m2505o(129446);
    }
}
