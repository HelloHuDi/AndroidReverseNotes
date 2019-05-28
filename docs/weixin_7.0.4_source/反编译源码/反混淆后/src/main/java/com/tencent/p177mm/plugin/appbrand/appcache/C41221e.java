package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p230g.p231a.C37815vy;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.launching.C42611l;
import com.tencent.p177mm.protocal.protobuf.aoy;
import com.tencent.p177mm.protocal.protobuf.aoz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.e */
public final class C41221e extends C37440a<aoz> {
    public final C7472b ehh;

    public C41221e(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(129323);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
        aoy aoy = new aoy();
        aoy.csB = str;
        if (i2 != 12) {
            aoy.wsY = str2;
        }
        aoy.wsZ = str3;
        aoy.vSb = i;
        aoy.wtb = i2;
        if (i == 1) {
            try {
                aoy.wta = new C1183p(C41725h.m73457lw(((C42611l) C42340f.m74878E(C42611l.class)).mo68052bn(str, i)).optLong("dev_key")).intValue();
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", e);
            }
        }
        c1196a.fsJ = aoy;
        c1196a.fsK = new aoz();
        C7472b acD = c1196a.acD();
        this.ehh = acD;
        this.ehh = acD;
        C4990ab.m7411d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(129323);
    }

    public final synchronized C37654f<C37441a<aoz>> acy() {
        C37654f b;
        AppMethodBeat.m2504i(129324);
        final long anU = C5046bo.anU();
        b = super.acy().mo60487b(new C5681a<C37441a<aoz>, C37441a<aoz>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129322);
                C37441a c37441a = (C37441a) obj;
                C37815vy c37815vy = new C37815vy();
                c37815vy.cTi.cTj = C41221e.this;
                c37815vy.cTi.cTh = anU;
                c37815vy.cTi.bZJ = C5046bo.anU();
                c37815vy.cTi.cTg = c37441a;
                C4879a.xxA.mo10055m(c37815vy);
                AppMethodBeat.m2505o(129322);
                return c37441a;
            }
        });
        AppMethodBeat.m2505o(129324);
        return b;
    }
}
