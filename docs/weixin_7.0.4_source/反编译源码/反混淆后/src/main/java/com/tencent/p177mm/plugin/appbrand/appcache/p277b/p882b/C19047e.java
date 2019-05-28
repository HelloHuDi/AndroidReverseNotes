package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.protocal.protobuf.cwx;
import com.tencent.p177mm.protocal.protobuf.cwy;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.e */
public class C19047e extends C38108a<Boolean, cxu> {
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        AppMethodBeat.m2504i(129465);
        Boolean a = C19047e.m29619a(str, str2, (cxu) obj);
        AppMethodBeat.m2505o(129465);
        return a;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxu) obj).xsZ;
    }

    /* renamed from: a */
    private static Boolean m29619a(String str, String str2, cxu cxu) {
        AppMethodBeat.m2504i(129464);
        String str3 = cxu.xtm;
        Boolean bool;
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129464);
            return bool;
        }
        try {
            byte[] decode = Base64.decode(str3, 0);
            cwy cwy = new cwy();
            cwy.parseFrom(decode);
            WxaAttributes d = C42340f.auO().mo21572d(str, "versionInfo");
            C31283e ayL = d == null ? null : d.ayL();
            C31283e c31283e = null;
            Iterator it = cwy.vMT.iterator();
            while (it.hasNext()) {
                C31283e zz;
                cwx cwx = (cwx) it.next();
                if ("WxaAppVersionInfo".equals(cwx.vMU)) {
                    zz = C31283e.m50507zz(cwx.pXM);
                } else {
                    zz = c31283e;
                }
                c31283e = zz;
            }
            C19050a c19050a;
            if (c31283e == null) {
                c19050a = C19050a.gWl;
                C19050a.m29623z((long) cxu.xsZ.xsX, 87);
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(129464);
                return bool;
            }
            boolean z;
            c19050a = C19050a.gWl;
            C19050a.m29623z((long) cxu.xsZ.xsX, 88);
            boolean z2 = ayL == null || c31283e == null || ayL.axy < c31283e.axy;
            C19050a c19050a2;
            if (z2) {
                int i;
                C42340f.auO().mo21570a(str, cwy.vMS, cwy.vMT);
                boolean z3 = C42340f.auO().mo21572d(str, new String[0]) != null;
                c19050a2 = C19050a.gWl;
                int i2 = cxu.xsZ.xsX;
                if (z3) {
                    i = 85;
                } else {
                    i = 86;
                }
                C19050a.m29623z((long) i2, (long) i);
                z = z3;
            } else {
                c19050a2 = C19050a.gWl;
                C19050a.m29623z((long) cxu.xsZ.xsX, 84);
                z = false;
            }
            String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueContact";
            String str5 = "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(ayL == null ? -1 : ayL.axy);
            objArr[3] = Integer.valueOf(c31283e == null ? -1 : c31283e.axy);
            objArr[4] = Boolean.valueOf(z2);
            objArr[5] = Boolean.valueOf(z);
            C4990ab.m7417i(str4, str5, objArr);
            bool = Boolean.valueOf(z);
            AppMethodBeat.m2505o(129464);
            return bool;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", e, "call[%s | %s], decode base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129464);
            return bool;
        }
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueContact";
    }
}
