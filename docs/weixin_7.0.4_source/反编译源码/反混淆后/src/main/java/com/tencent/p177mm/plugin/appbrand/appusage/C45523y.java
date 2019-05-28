package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.arj;
import com.tencent.p177mm.protocal.protobuf.ark;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.y */
class C45523y extends C37440a<ark> {
    C45523y(int i, int i2, int i3) {
        this(4, 0, i, i2, i3);
    }

    C45523y(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(129706);
        C1196a c1196a = new C1196a();
        arj arj = new arj();
        arj.boZ = i;
        arj.wvu = i2;
        arj.condition = i3;
        arj.wvs = i4;
        arj.wvt = i5;
        c1196a.fsJ = arj;
        c1196a.fsK = new ark();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        c1196a.fsI = 1148;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(129706);
    }
}
