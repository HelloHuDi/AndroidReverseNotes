package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class a {
    public static String d(AppBrandLaunchReferrer appBrandLaunchReferrer) {
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
