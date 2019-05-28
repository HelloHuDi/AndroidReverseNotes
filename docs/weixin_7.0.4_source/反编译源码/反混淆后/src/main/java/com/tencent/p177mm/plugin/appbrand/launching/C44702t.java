package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2056b;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.t */
abstract class C44702t implements C2057a {
    final int har;

    public abstract String aHr();

    /* renamed from: d */
    public abstract void mo6276d(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    /* renamed from: a */
    public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
        C2056b c2056b = (C2056b) obj;
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, appId = %s, return = %s", aHr(), str, c10067a.name());
        if (C10067a.OK.equals(c10067a)) {
            WxaPkgWrappingInfo xM;
            if (C5046bo.isNullOrNil(str) || !str.endsWith("__CODELIB__")) {
                xM = WxaPkgWrappingInfo.m54056xM(c2056b.filePath);
            } else {
                xM = WxaPkgWrappingInfo.m54057xN(c2056b.filePath);
            }
            if (xM == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                xM.gVu = c2056b.version;
                xM.gVv = C42677e.aNY();
                xM.gVt = c2056b.gVs;
            }
            mo6276d(xM);
            return;
        }
        if (C10067a.SEVER_FILE_NOT_FOUND.equals(c10067a)) {
            C42608ag.m75435oZ(C25738R.string.f9012me);
            C19690c.m30494K(str, 23, this.har + 1);
        } else {
            C42608ag.m75434Ck(C42677e.getMMString(C25738R.string.f9009ma, Integer.valueOf(2), Integer.valueOf(c10067a.code)));
        }
        mo6276d(null);
    }

    /* renamed from: bl */
    public final /* synthetic */ void mo14966bl(Object obj) {
        C4990ab.m7417i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "hy: onPkgUpdateProgress: %s", ((WxaPkgLoadProgress) obj).toString());
        mo22090b(r6);
    }

    C44702t(int i) {
        this.har = i;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo22090b(WxaPkgLoadProgress wxaPkgLoadProgress) {
    }
}
