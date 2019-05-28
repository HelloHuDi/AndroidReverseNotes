package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cyb;

public final class b {
    public static cyb b(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        cyb cyb = null;
        AppMethodBeat.i(102110);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(102110);
        } else {
            if (2 == appBrandLaunchReferrer.hgQ) {
                cyb = new cyb();
                cyb.vEn = appBrandLaunchReferrer.appId;
                cyb.Url = appBrandLaunchReferrer.url;
            }
            AppMethodBeat.o(102110);
        }
        return cyb;
    }

    public static cxj c(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        cxj cxj = null;
        AppMethodBeat.i(102111);
        if (appBrandLaunchReferrer == null) {
            AppMethodBeat.o(102111);
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
            AppMethodBeat.o(102111);
        }
        return cxj;
    }
}
