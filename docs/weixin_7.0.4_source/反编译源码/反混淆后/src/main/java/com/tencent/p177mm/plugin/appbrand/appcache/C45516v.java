package com.tencent.p177mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.v */
public final class C45516v {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.v$1 */
    static class C381191 implements Runnable {
        C381191() {
        }

        public final void run() {
            AppMethodBeat.m2504i(129397);
            try {
                String str;
                String str2 = AppBrandGlobalSystemConfig.ayC().hfO;
                if (C5046bo.isNullOrNil(str2)) {
                    str = "res.servicewechat.com";
                } else {
                    str2 = Uri.parse(str2).getHost();
                    str = C5046bo.isNullOrNil(str2) ? "res.servicewechat.com" : str2;
                }
                ArrayList arrayList = new ArrayList();
                C1720g.m3535RO().eJo.ftA.getHostByName(str, arrayList);
                CdnLogic.triggerPreConnect(str, (String[]) arrayList.toArray(new String[0]), true);
                C4990ab.m7417i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", str);
                AppMethodBeat.m2505o(129397);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.PkgNetworkOpt", e, "triggerPreConnect", new Object[0]);
                AppMethodBeat.m2505o(129397);
            }
        }
    }

    public static void avL() {
        AppMethodBeat.m2504i(129398);
        C7305d.post(new C381191(), "PkgNetworkOpt.triggerPreConnect");
        AppMethodBeat.m2505o(129398);
    }
}
