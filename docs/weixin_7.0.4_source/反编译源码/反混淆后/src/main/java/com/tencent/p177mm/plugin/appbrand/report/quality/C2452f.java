package com.tencent.p177mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C26287cq;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.appcache.C19062o;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.C19691d;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandServiceScriptErrorReport;", "", "()V", "reportError", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandServiceWC;", "message", "", "stackTrace", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.f */
public final class C2452f {
    public static final C2452f iCN = new C2452f();

    static {
        AppMethodBeat.m2504i(134947);
        AppMethodBeat.m2505o(134947);
    }

    private C2452f() {
    }

    /* renamed from: a */
    public static final void m4692a(C19722s c19722s, String str, String str2) {
        AppMethodBeat.m2504i(134946);
        C25052j.m39376p(c19722s, "service");
        C26287cq c26287cq = new C26287cq();
        c26287cq.mo44045hx(c19722s.getAppId());
        c26287cq.mo44041ez((long) c19722s.getRuntime().atI().axy);
        c26287cq.mo44039eA((long) (c19722s.getRuntime().asT() + 1));
        c26287cq.mo44038Hj();
        c26287cq.mo44046hy(str);
        c26287cq.mo44047hz(str2);
        C19062o asG = c19722s.asG();
        if (asG == null) {
            C25052j.dWJ();
        }
        c26287cq.mo44042hA(asG.avk());
        c26287cq.mo44040eB(((long) C19691d.m30509Dx(c19722s.getAppId())) + 1000);
        C27242w aun = c19722s.aun();
        C25052j.m39375o(aun, "page");
        String url = aun.getURL();
        String aBm = aun.aBm();
        C25052j.m39375o(aBm, "page.urlWithQuery");
        int length = url.length();
        if (aBm == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(134946);
            throw c44941v;
        }
        aBm = aBm.substring(length);
        C25052j.m39375o(aBm, "(this as java.lang.String).substring(startIndex)");
        c26287cq.mo44043hB(url);
        c26287cq.mo44044hC(aBm);
        c26287cq.ajK();
        AppMethodBeat.m2505o(134946);
    }
}
