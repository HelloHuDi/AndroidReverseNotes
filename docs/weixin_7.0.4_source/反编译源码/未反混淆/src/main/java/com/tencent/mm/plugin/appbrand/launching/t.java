package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.az.a;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

abstract class t implements a {
    final int har;

    public abstract String aHr();

    public abstract void d(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    public final /* synthetic */ void a(String str, b.a.a aVar, Object obj) {
        az.b bVar = (az.b) obj;
        ab.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, appId = %s, return = %s", aHr(), str, aVar.name());
        if (b.a.a.OK.equals(aVar)) {
            WxaPkgWrappingInfo xM;
            if (bo.isNullOrNil(str) || !str.endsWith("__CODELIB__")) {
                xM = WxaPkgWrappingInfo.xM(bVar.filePath);
            } else {
                xM = WxaPkgWrappingInfo.xN(bVar.filePath);
            }
            if (xM == null) {
                ab.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                xM.gVu = bVar.version;
                xM.gVv = e.aNY();
                xM.gVt = bVar.gVs;
            }
            d(xM);
            return;
        }
        if (b.a.a.SEVER_FILE_NOT_FOUND.equals(aVar)) {
            ag.oZ(R.string.me);
            c.K(str, 23, this.har + 1);
        } else {
            ag.Ck(e.getMMString(R.string.ma, Integer.valueOf(2), Integer.valueOf(aVar.code)));
        }
        d(null);
    }

    public final /* synthetic */ void bl(Object obj) {
        ab.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "hy: onPkgUpdateProgress: %s", ((WxaPkgLoadProgress) obj).toString());
        b(r6);
    }

    t(int i) {
        this.har = i;
    }

    /* Access modifiers changed, original: protected */
    public void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
    }
}
