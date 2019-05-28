package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public enum e implements n {
    ;

    private e(String str) {
    }

    static {
        AppMethodBeat.o(129453);
    }

    public final b a(String str, Map<String, String> map, a aVar) {
        AppMethodBeat.i(129451);
        String str2 = (String) map.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
        if (!bo.isNullOrNil(str2)) {
            g.da(str2).j(new com.tencent.mm.vending.c.a<Void, String>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(129448);
                    Void xQ = AnonymousClass1.xQ((String) obj);
                    AppMethodBeat.o(129448);
                    return xQ;
                }

                private static Void xQ(String str) {
                    AppMethodBeat.i(129447);
                    try {
                        e.xP(str);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", e, "process pbBase64", new Object[0]);
                    }
                    AppMethodBeat.o(129447);
                    return null;
                }
            });
        }
        AppMethodBeat.o(129451);
        return null;
    }
}
