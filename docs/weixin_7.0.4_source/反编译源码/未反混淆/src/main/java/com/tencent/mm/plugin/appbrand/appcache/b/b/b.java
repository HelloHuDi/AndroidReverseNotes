package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.b.e.a;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public class b extends a<Boolean, cxq> {
    /* Access modifiers changed, original: final|synthetic */
    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z;
        int i = -1;
        AppMethodBeat.i(129460);
        cxq cxq = (cxq) obj;
        com.tencent.mm.plugin.appbrand.appcache.b.e.b bVar = (com.tencent.mm.plugin.appbrand.appcache.b.e.b) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class);
        if (bo.ek(cxq.xkP) || bo.ek(cxq.xta)) {
            int i2;
            String str3 = "MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage";
            String str4 = "saveBlockList with username(%s) appId(%s) sceneList.size(%d), blockCgi.size(%d), skip";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            if (cxq.xkP == null) {
                i2 = -1;
            } else {
                i2 = cxq.xkP.size();
            }
            objArr[2] = Integer.valueOf(i2);
            if (cxq.xta != null) {
                i = cxq.xta.size();
            }
            objArr[3] = Integer.valueOf(i);
            ab.e(str3, str4, objArr);
            z = false;
        } else {
            a aVar = new a();
            aVar.field_username = str;
            boolean b = bVar.b((c) aVar, new String[0]);
            aVar.field_appId = str2;
            aVar.field_startTime = (long) cxq.xtb;
            aVar.field_endTime = (long) cxq.xtc;
            StringBuilder stringBuilder = new StringBuilder(";");
            Iterator it = cxq.xkP.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            aVar.field_sceneList = stringBuilder.toString();
            stringBuilder = new StringBuilder(";");
            it = cxq.xta.iterator();
            while (it.hasNext()) {
                stringBuilder.append(((Integer) it.next()).intValue()).append(";");
            }
            aVar.field_cgiList = stringBuilder.toString();
            aVar.field_reportId = cxq.xsZ.xsX;
            ab.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiPersistentStorage", "saveBlockList, record( %s ), doUpdate %b", aVar, Boolean.valueOf(b));
            z = b ? bVar.c(aVar, new String[0]) : bVar.b((c) aVar);
        }
        ab.i("MicroMsg.AppBrand.Predownload.CmdBlockCgiRequest", "saveBlockList with username(%s) appId(%s), ret %b", str, str2, Boolean.valueOf(z));
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(129460);
        return valueOf;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxq) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdBlockCgiRequest";
    }
}
