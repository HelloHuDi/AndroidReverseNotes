package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p731d.C45998e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.model.x */
public class C39216x {
    /* renamed from: a */
    public static C20992c m66823a(C45998e c45998e) {
        C20992c c20992c = null;
        AppMethodBeat.m2504i(111358);
        if (c45998e == null) {
            C4990ab.m7412e("MicroMsg.GamePBData", "Invalid pb object");
            AppMethodBeat.m2505o(111358);
        } else if (C5046bo.isNullOrNil(c45998e.mZr)) {
            C4990ab.m7412e("MicroMsg.GamePBData", "No AppID field, abort");
            AppMethodBeat.m2505o(111358);
        } else {
            C4990ab.m7417i("MicroMsg.GamePBData", "Parsing AppID: %s", c45998e.mZr);
            c20992c = new C20992c();
            c20992c.field_appId = c45998e.mZr;
            c20992c.field_appName = c45998e.Name;
            c20992c.field_appIconUrl = c45998e.mZs;
            c20992c.field_appType = ",1,";
            c20992c.field_packageName = c45998e.mZu;
            c20992c.field_appVersion = c45998e.Version;
            c20992c.field_appInfoFlag = c45998e.mZx;
            if (c45998e.mZw != null) {
                c20992c.mo44076ih(c45998e.mZw.nac);
                c20992c.mo44079ik(c45998e.mZw.nad);
                c20992c.mo44071hq(c45998e.mZw.nag);
                c20992c.mo44080il(c45998e.mZw.nae);
                c20992c.mVD = c45998e.mZw.nai;
                c20992c.mVE = (long) c45998e.mZw.nah;
                c20992c.cBA = c45998e.mZw.naj;
            }
            if (!(c45998e.mZw == null || c45998e.mZw.naf == null)) {
                c20992c.mo44085iq(c45998e.mZw.naf.nac);
                c20992c.mo44086ir(c45998e.mZw.naf.ndR);
                c20992c.mo44083io(c45998e.mZw.naf.ndS);
                c20992c.mo44084ip(c45998e.mZw.naf.ndT);
                c20992c.mo44072hr(c45998e.mZw.naf.ndV);
            }
            c20992c.mVk = c45998e.Desc;
            c20992c.mVj = c45998e.mZt;
            c20992c.status = c45998e.jBT;
            c20992c.mVm = c45998e.mZm;
            c20992c.versionCode = c45998e.mZv;
            c20992c.ctu = c45998e.mZo;
            c20992c.mVo = c45998e.mZy;
            c20992c.mVw = c45998e.mZD;
            if (!(c45998e.mZw == null || c45998e.mZw.naf == null)) {
                c20992c.mVp = c45998e.mZw.naf.ndU;
                c20992c.mVq = c45998e.mZw.naf.ndW;
                c20992c.mVr = c45998e.mZw.naf.ndX;
            }
            c20992c.egi = c45998e.mZF;
            c20992c.mVF = c45998e.mZG;
            AppMethodBeat.m2505o(111358);
        }
        return c20992c;
    }
}
