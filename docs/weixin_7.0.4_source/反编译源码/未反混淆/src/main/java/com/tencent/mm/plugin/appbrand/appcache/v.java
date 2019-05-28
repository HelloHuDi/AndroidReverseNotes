package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class v {
    public static void avL() {
        AppMethodBeat.i(129398);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(129397);
                try {
                    String str;
                    String str2 = AppBrandGlobalSystemConfig.ayC().hfO;
                    if (bo.isNullOrNil(str2)) {
                        str = "res.servicewechat.com";
                    } else {
                        str2 = Uri.parse(str2).getHost();
                        str = bo.isNullOrNil(str2) ? "res.servicewechat.com" : str2;
                    }
                    ArrayList arrayList = new ArrayList();
                    g.RO().eJo.ftA.getHostByName(str, arrayList);
                    CdnLogic.triggerPreConnect(str, (String[]) arrayList.toArray(new String[0]), true);
                    ab.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, host %s", str);
                    AppMethodBeat.o(129397);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.PkgNetworkOpt", e, "triggerPreConnect", new Object[0]);
                    AppMethodBeat.o(129397);
                }
            }
        }, "PkgNetworkOpt.triggerPreConnect");
        AppMethodBeat.o(129398);
    }
}
