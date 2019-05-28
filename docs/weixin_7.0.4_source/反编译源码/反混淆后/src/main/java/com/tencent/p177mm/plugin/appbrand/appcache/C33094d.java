package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p230g.p231a.C26269vx;
import com.tencent.p177mm.protocal.protobuf.arb;
import com.tencent.p177mm.protocal.protobuf.arc;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.d */
public final class C33094d extends C37440a<arc> {
    public final C7472b ehh;

    public C33094d(String str, int i, String str2, int i2, int i3) {
        arb arb = new arb();
        arb.vOP = i;
        arb.csB = str;
        arb.wuL = str2;
        arb.wtb = i2;
        arb.wuM = i3;
        this(arb);
        AppMethodBeat.m2504i(59428);
        AppMethodBeat.m2505o(59428);
    }

    public C33094d(arb arb) {
        AppMethodBeat.m2504i(59429);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1139;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        c1196a.fsJ = arb;
        c1196a.fsK = new arc();
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        AppMethodBeat.m2505o(59429);
    }

    public C33094d(String str, int i, String str2, int i2) {
        this(str, i, str2, i2, 0);
    }

    public final synchronized C37654f<C37441a<arc>> acy() {
        C37654f b;
        AppMethodBeat.m2504i(59430);
        final long anU = C5046bo.anU();
        b = super.acy().mo60487b(new C5681a<C37441a<arc>, C37441a<arc>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(59427);
                C37441a c37441a = (C37441a) obj;
                C26269vx c26269vx = new C26269vx();
                c26269vx.cTe.cTf = C33094d.this;
                c26269vx.cTe.cTh = anU;
                c26269vx.cTe.bZJ = C5046bo.anU();
                c26269vx.cTe.cTg = c37441a;
                C4879a.xxA.mo10055m(c26269vx);
                AppMethodBeat.m2505o(59427);
                return c37441a;
            }
        });
        AppMethodBeat.m2505o(59430);
        return b;
    }

    public final int avn() {
        return ((arb) this.ehh.fsG.fsP).wtb;
    }
}
