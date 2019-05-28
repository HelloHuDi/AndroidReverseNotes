package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.a */
public final class C27283a {
    /* renamed from: d */
    public static String m43315d(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer == null) {
            return null;
        }
        String str = "";
        if (1 == appBrandLaunchReferrer.hgQ || 3 == appBrandLaunchReferrer.hgQ) {
            return appBrandLaunchReferrer.appId;
        }
        if (2 == appBrandLaunchReferrer.hgQ) {
            return appBrandLaunchReferrer.url;
        }
        return str;
    }
}
