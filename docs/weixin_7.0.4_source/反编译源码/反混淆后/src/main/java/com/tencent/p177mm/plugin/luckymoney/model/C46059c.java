package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aoi;
import com.tencent.p177mm.protocal.protobuf.aoj;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.c */
public final class C46059c extends C37440a<aoj> {
    public C46059c(String str) {
        AppMethodBeat.m2504i(42272);
        aoi aoi = new aoi();
        C1196a c1196a = new C1196a();
        c1196a.fsJ = aoi;
        c1196a.fsK = new aoj();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource";
        aoi.wsz = str;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(42272);
    }
}
