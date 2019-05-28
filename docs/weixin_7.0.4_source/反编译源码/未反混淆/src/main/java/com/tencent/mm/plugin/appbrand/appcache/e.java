package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.aa.h;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.launching.l;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends a<aoz> {
    public final b ehh;

    public e(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(129323);
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
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
                aoy.wta = new p(h.lw(((l) f.E(l.class)).bn(str, i)).optLong("dev_key")).intValue();
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", e);
            }
        }
        aVar.fsJ = aoy;
        aVar.fsK = new aoz();
        b acD = aVar.acD();
        this.ehh = acD;
        this.ehh = acD;
        ab.d("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "appid:%s,module_name:%s,code_type:%d,package type:%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(129323);
    }

    public final synchronized com.tencent.mm.ci.f<a.a<aoz>> acy() {
        com.tencent.mm.ci.f b;
        AppMethodBeat.i(129324);
        final long anU = bo.anU();
        b = super.acy().b(new com.tencent.mm.vending.c.a<a.a<aoz>, a.a<aoz>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129322);
                a.a aVar = (a.a) obj;
                vy vyVar = new vy();
                vyVar.cTi.cTj = e.this;
                vyVar.cTi.cTh = anU;
                vyVar.cTi.bZJ = bo.anU();
                vyVar.cTi.cTg = aVar;
                com.tencent.mm.sdk.b.a.xxA.m(vyVar);
                AppMethodBeat.o(129322);
                return aVar;
            }
        });
        AppMethodBeat.o(129324);
        return b;
    }
}
