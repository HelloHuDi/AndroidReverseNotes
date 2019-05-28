package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.d;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class c extends a<Boolean, cxs> {
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = true;
        AppMethodBeat.i(129461);
        cxs cxs = (cxs) obj;
        Object obj2;
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode nil appId");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(129461);
            return bool;
        } else if (bo.isNullOrNil(cxs.Md5)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdGetCode", "getCode(%s | %s), nil md5", str, str2);
            obj2 = Boolean.FALSE;
            AppMethodBeat.o(129461);
            return obj2;
        } else {
            WxaPkgWrappingInfo bm = h.bm(str2, 0);
            a aVar;
            if (bm != null && bm.gVu >= cxs.vMG) {
                ab.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call, localUsage(%d) ok, cmd_appId(%s), cmd_version(%d)", Integer.valueOf(bm.gVu), str2, Integer.valueOf(cxs.vMG));
                aVar = a.gWl;
                a.z((long) cxs.xsZ.xsX, 44);
                obj2 = Boolean.FALSE;
                AppMethodBeat.o(129461);
                return obj2;
            } else if (!cxs.xtl || ((af) f.E(af.class)).s(str2, 1, cxs.vMG) == null) {
                com.tencent.mm.plugin.appbrand.appcache.b.e.c cVar;
                d dVar = (d) f.E(d.class);
                if (bo.isNullOrNil(str2) || cxs == null) {
                    cVar = null;
                } else {
                    com.tencent.mm.plugin.appbrand.appcache.b.e.c cVar2 = new com.tencent.mm.plugin.appbrand.appcache.b.e.c();
                    cVar2.field_appId = str2;
                    cVar2.field_version = cxs.vMG;
                    cVar2.field_type = cxs.xtl ? 1 : 0;
                    boolean b = dVar.b(cVar2, new String[0]);
                    cVar2.field_firstTimeTried = false;
                    cVar2.field_lastRetryTime = 0;
                    cVar2.field_retriedCount = 0;
                    cVar2.field_retryTimes = cxs.wUZ;
                    cVar2.field_retryInterval = (long) cxs.wVb;
                    cVar2.field_networkType = cxs.xtk;
                    cVar2.field_pkgMd5 = cxs.Md5;
                    cVar2.field_reportId = cxs.xsZ.xsX;
                    if (b ? dVar.c(cVar2, new String[0]) : dVar.b((com.tencent.mm.sdk.e.c) cVar2)) {
                        cVar = cVar2;
                    } else {
                        cVar = null;
                    }
                }
                String str3 = "MicroMsg.AppBrand.Predownload.CmdGetCode";
                String str4 = "getCode, writeCmd %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(cVar != null);
                ab.i(str3, str4, objArr);
                if (cVar == null) {
                    z = false;
                }
                obj2 = Boolean.valueOf(z);
                AppMethodBeat.o(129461);
                return obj2;
            } else {
                ab.i("MicroMsg.AppBrand.Predownload.CmdGetCode", "call IsEncrypt=true, encryptPkg ok, cmd_appId(%s), cmd_version(%d)", str2, Integer.valueOf(cxs.vMG));
                aVar = a.gWl;
                a.z((long) cxs.xsZ.xsX, 45);
                obj2 = Boolean.FALSE;
                AppMethodBeat.o(129461);
                return obj2;
            }
        }
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxs) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdGetCode";
    }
}
