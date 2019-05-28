package com.tencent.mm.plugin.appbrand.report.quality;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cq;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.s;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandServiceScriptErrorReport;", "", "()V", "reportError", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandServiceWC;", "message", "", "stackTrace", "plugin-appbrand-integration_release"})
public final class f {
    public static final f iCN = new f();

    static {
        AppMethodBeat.i(134947);
        AppMethodBeat.o(134947);
    }

    private f() {
    }

    public static final void a(s sVar, String str, String str2) {
        AppMethodBeat.i(134946);
        j.p(sVar, "service");
        cq cqVar = new cq();
        cqVar.hx(sVar.getAppId());
        cqVar.ez((long) sVar.getRuntime().atI().axy);
        cqVar.eA((long) (sVar.getRuntime().asT() + 1));
        cqVar.Hj();
        cqVar.hy(str);
        cqVar.hz(str2);
        o asG = sVar.asG();
        if (asG == null) {
            j.dWJ();
        }
        cqVar.hA(asG.avk());
        cqVar.eB(((long) d.Dx(sVar.getAppId())) + 1000);
        w aun = sVar.aun();
        j.o(aun, "page");
        String url = aun.getURL();
        String aBm = aun.aBm();
        j.o(aBm, "page.urlWithQuery");
        int length = url.length();
        if (aBm == null) {
            v vVar = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(134946);
            throw vVar;
        }
        aBm = aBm.substring(length);
        j.o(aBm, "(this as java.lang.String).substring(startIndex)");
        cqVar.hB(url);
        cqVar.hC(aBm);
        cqVar.ajK();
        AppMethodBeat.o(134946);
    }
}
