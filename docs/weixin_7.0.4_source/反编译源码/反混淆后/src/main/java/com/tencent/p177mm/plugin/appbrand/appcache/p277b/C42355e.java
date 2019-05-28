package com.tencent.p177mm.plugin.appbrand.appcache.p277b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e */
public enum C42355e implements C3472n {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.e$1 */
    class C330921 implements C5681a<Void, String> {
        C330921() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(129448);
            Void xQ = C330921.m54087xQ((String) obj);
            AppMethodBeat.m2505o(129448);
            return xQ;
        }

        /* renamed from: xQ */
        private static Void m54087xQ(String str) {
            AppMethodBeat.m2504i(129447);
            try {
                C42355e.m74910xP(str);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", e, "process pbBase64", new Object[0]);
            }
            AppMethodBeat.m2505o(129447);
            return null;
        }
    }

    private C42355e(String str) {
    }

    static {
        AppMethodBeat.m2505o(129453);
    }

    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        AppMethodBeat.m2504i(129451);
        String str2 = (String) map.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
        if (!C5046bo.isNullOrNil(str2)) {
            C41930g.m74067da(str2).mo60494j(new C330921());
        }
        AppMethodBeat.m2505o(129451);
        return null;
    }
}
