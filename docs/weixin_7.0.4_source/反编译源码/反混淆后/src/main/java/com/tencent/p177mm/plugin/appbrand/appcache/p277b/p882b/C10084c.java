package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C42346af;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C38113c;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45514d;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.launching.C19573h;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxs;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.c */
public class C10084c extends C38108a<Boolean, cxs> {
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        boolean z = true;
        AppMethodBeat.m2504i(129461);
        cxs cxs = (cxs) obj;
        Object obj2;
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode nil appId");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129461);
            return bool;
        } else if (C5046bo.isNullOrNil(cxs.Md5)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode(%s | %s), nil md5", str, str2);
            obj2 = Boolean.FALSE;
            AppMethodBeat.m2505o(129461);
            return obj2;
        } else {
            WxaPkgWrappingInfo bm = C19573h.m30345bm(str2, 0);
            C19050a c19050a;
            if (bm != null && bm.gVu >= cxs.vMG) {
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call, localUsage(%d) ok, cmd_appId(%s), cmd_version(%d)", Integer.valueOf(bm.gVu), str2, Integer.valueOf(cxs.vMG));
                c19050a = C19050a.gWl;
                C19050a.m29623z((long) cxs.xsZ.xsX, 44);
                obj2 = Boolean.FALSE;
                AppMethodBeat.m2505o(129461);
                return obj2;
            } else if (!cxs.xtl || ((C42346af) C42340f.m74878E(C42346af.class)).mo67860s(str2, 1, cxs.vMG) == null) {
                C38113c c38113c;
                C45514d c45514d = (C45514d) C42340f.m74878E(C45514d.class);
                if (C5046bo.isNullOrNil(str2) || cxs == null) {
                    c38113c = null;
                } else {
                    C38113c c38113c2 = new C38113c();
                    c38113c2.field_appId = str2;
                    c38113c2.field_version = cxs.vMG;
                    c38113c2.field_type = cxs.xtl ? 1 : 0;
                    boolean b = c45514d.mo10102b(c38113c2, new String[0]);
                    c38113c2.field_firstTimeTried = false;
                    c38113c2.field_lastRetryTime = 0;
                    c38113c2.field_retriedCount = 0;
                    c38113c2.field_retryTimes = cxs.wUZ;
                    c38113c2.field_retryInterval = (long) cxs.wVb;
                    c38113c2.field_networkType = cxs.xtk;
                    c38113c2.field_pkgMd5 = cxs.Md5;
                    c38113c2.field_reportId = cxs.xsZ.xsX;
                    if (b ? c45514d.mo10103c(c38113c2, new String[0]) : c45514d.mo10101b((C4925c) c38113c2)) {
                        c38113c = c38113c2;
                    } else {
                        c38113c = null;
                    }
                }
                String str3 = "MicroMsg.AppBrand.Predownload.CmdGetCode";
                String str4 = "getCode, writeCmd %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(c38113c != null);
                C4990ab.m7417i(str3, str4, objArr);
                if (c38113c == null) {
                    z = false;
                }
                obj2 = Boolean.valueOf(z);
                AppMethodBeat.m2505o(129461);
                return obj2;
            } else {
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call IsEncrypt=true, encryptPkg ok, cmd_appId(%s), cmd_version(%d)", str2, Integer.valueOf(cxs.vMG));
                c19050a = C19050a.gWl;
                C19050a.m29623z((long) cxs.xsZ.xsX, 45);
                obj2 = Boolean.FALSE;
                AppMethodBeat.m2505o(129461);
                return obj2;
            }
        }
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxs) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdGetCode";
    }
}
