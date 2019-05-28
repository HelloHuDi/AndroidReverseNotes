package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.protocal.protobuf.cww;
import com.tencent.p177mm.protocal.protobuf.cwy;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.config.k */
public final class C41226k extends C37440a<cwy> {
    final C7472b ehh;

    public C41226k(String str, String str2) {
        C1332b c1332b;
        AppMethodBeat.m2504i(129851);
        C1196a c1196a = new C1196a();
        cww cww = new cww();
        cww.xfb = str;
        if (C5046bo.isNullOrNil(str)) {
            String str3;
            WxaAttributes e = C42340f.auO().mo21573e(str2, "syncVersion");
            if (e == null) {
                str3 = "";
            } else {
                str3 = C5046bo.nullAsNil(e.field_syncVersion);
            }
            c1332b = new C1332b(str3.getBytes());
        } else {
            c1332b = C42340f.auO().mo21576zf(str);
        }
        cww.vMS = c1332b;
        cww.xsB = str2;
        c1196a.fsJ = cww;
        c1196a.fsK = new cwy();
        c1196a.fsI = 1151;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.m2505o(129851);
    }
}
