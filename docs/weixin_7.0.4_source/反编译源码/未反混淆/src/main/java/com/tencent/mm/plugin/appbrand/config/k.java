package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.bo;

public final class k extends a<cwy> {
    final b ehh;

    public k(String str, String str2) {
        com.tencent.mm.bt.b bVar;
        AppMethodBeat.i(129851);
        b.a aVar = new b.a();
        cww cww = new cww();
        cww.xfb = str;
        if (bo.isNullOrNil(str)) {
            String str3;
            WxaAttributes e = f.auO().e(str2, "syncVersion");
            if (e == null) {
                str3 = "";
            } else {
                str3 = bo.nullAsNil(e.field_syncVersion);
            }
            bVar = new com.tencent.mm.bt.b(str3.getBytes());
        } else {
            bVar = f.auO().zf(str);
        }
        cww.vMS = bVar;
        cww.xsB = str2;
        aVar.fsJ = cww;
        aVar.fsK = new cwy();
        aVar.fsI = 1151;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.o(129851);
    }
}
