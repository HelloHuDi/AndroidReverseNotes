package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public class e extends a<Boolean, cxu> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        AppMethodBeat.i(129465);
        Boolean a = a(str, str2, (cxu) obj);
        AppMethodBeat.o(129465);
        return a;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxu) obj).xsZ;
    }

    private static Boolean a(String str, String str2, cxu cxu) {
        AppMethodBeat.i(129464);
        String str3 = cxu.xtm;
        Boolean bool;
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdIssueContact", "call[%s | %s], empty base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.o(129464);
            return bool;
        }
        try {
            byte[] decode = Base64.decode(str3, 0);
            cwy cwy = new cwy();
            cwy.parseFrom(decode);
            WxaAttributes d = f.auO().d(str, "versionInfo");
            com.tencent.mm.plugin.appbrand.config.WxaAttributes.e ayL = d == null ? null : d.ayL();
            com.tencent.mm.plugin.appbrand.config.WxaAttributes.e eVar = null;
            Iterator it = cwy.vMT.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.appbrand.config.WxaAttributes.e zz;
                cwx cwx = (cwx) it.next();
                if ("WxaAppVersionInfo".equals(cwx.vMU)) {
                    zz = com.tencent.mm.plugin.appbrand.config.WxaAttributes.e.zz(cwx.pXM);
                } else {
                    zz = eVar;
                }
                eVar = zz;
            }
            a aVar;
            if (eVar == null) {
                aVar = a.gWl;
                a.z((long) cxu.xsZ.xsX, 87);
                bool = Boolean.FALSE;
                AppMethodBeat.o(129464);
                return bool;
            }
            boolean z;
            aVar = a.gWl;
            a.z((long) cxu.xsZ.xsX, 88);
            boolean z2 = ayL == null || eVar == null || ayL.axy < eVar.axy;
            a aVar2;
            if (z2) {
                int i;
                f.auO().a(str, cwy.vMS, cwy.vMT);
                boolean z3 = f.auO().d(str, new String[0]) != null;
                aVar2 = a.gWl;
                int i2 = cxu.xsZ.xsX;
                if (z3) {
                    i = 85;
                } else {
                    i = 86;
                }
                a.z((long) i2, (long) i);
                z = z3;
            } else {
                aVar2 = a.gWl;
                a.z((long) cxu.xsZ.xsX, 84);
                z = false;
            }
            String str4 = "MicroMsg.AppBrand.Predownload.CmdIssueContact";
            String str5 = "call[%s | %s], record.ver %d, issue.ver %d, doIssue %b, issueRet %b";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(ayL == null ? -1 : ayL.axy);
            objArr[3] = Integer.valueOf(eVar == null ? -1 : eVar.axy);
            objArr[4] = Boolean.valueOf(z2);
            objArr[5] = Boolean.valueOf(z);
            ab.i(str4, str5, objArr);
            bool = Boolean.valueOf(z);
            AppMethodBeat.o(129464);
            return bool;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdIssueContact", e, "call[%s | %s], decode base64", str, str2);
            bool = Boolean.FALSE;
            AppMethodBeat.o(129464);
            return bool;
        }
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueContact";
    }
}
