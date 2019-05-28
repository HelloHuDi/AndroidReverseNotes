package com.tencent.p177mm.plugin.appbrand.launching.p905a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.protocal.protobuf.cxj;
import com.tencent.p177mm.protocal.protobuf.cyb;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.a.b */
public final class C33431b {
    /* renamed from: b */
    public static cyb m54639b(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        cyb cyb = null;
        AppMethodBeat.m2504i(102110);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.m2505o(102110);
        } else {
            if (2 == appBrandLaunchReferrer.hgQ) {
                cyb = new cyb();
                cyb.vEn = appBrandLaunchReferrer.appId;
                cyb.Url = appBrandLaunchReferrer.url;
            }
            AppMethodBeat.m2505o(102110);
        }
        return cyb;
    }

    /* renamed from: c */
    public static cxj m54640c(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        cxj cxj = null;
        AppMethodBeat.m2504i(102111);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.m2505o(102111);
        } else {
            if (1 == appBrandLaunchReferrer.hgQ) {
                cxj = new cxj();
                cxj.wzy = appBrandLaunchReferrer.appId;
                cxj.wzp = appBrandLaunchReferrer.cvp;
                cxj.xsK = appBrandLaunchReferrer.hgS;
            }
            if (appBrandLaunchReferrer.cvp != 0) {
                if (cxj == null) {
                    cxj = new cxj();
                }
                cxj.wzp = appBrandLaunchReferrer.cvp;
            }
            AppMethodBeat.m2505o(102111);
        }
        return cxj;
    }
}
