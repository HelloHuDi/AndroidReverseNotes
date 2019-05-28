package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.config.C41226k;
import com.tencent.p177mm.plugin.appbrand.p904k.C42597a;
import com.tencent.p177mm.protocal.protobuf.cwy;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.d */
public class C26743d extends C38108a<Boolean, cxt> {
    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(final String str, String str2, Object obj) {
        AppMethodBeat.m2504i(129463);
        cxt cxt = (cxt) obj;
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.AppBrand.Predownload.CmdGetContact", "invalid username & appId");
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129463);
            return bool;
        }
        final C5688b dMj = C5698f.dMj();
        dMj.dMi();
        final int i = cxt.xsZ.xsX;
        C19050a c19050a = C19050a.gWl;
        C19050a.m29623z((long) i, 24);
        new C41226k(str, str2).acy().mo60494j(new C5681a<Void, C37441a<cwy>>() {
            public final /* synthetic */ Object call(Object obj) {
                int i;
                int i2;
                AppMethodBeat.m2504i(129462);
                C37441a c37441a = (C37441a) obj;
                C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdGetContact", "getContact(%s) back, errType %d, errCode %d, errMsg %s", str, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                if (C42597a.m75415b(c37441a)) {
                    boolean a = C42340f.auO().mo21570a(str, ((cwy) c37441a.fsy).vMS, ((cwy) c37441a.fsy).vMT);
                    dMj.mo11581B(Boolean.TRUE);
                    C19050a c19050a = C19050a.gWl;
                    i = i;
                    i2 = a ? 25 : 27;
                } else {
                    dMj.mo11581B(Boolean.FALSE);
                    C19050a c19050a2 = C19050a.gWl;
                    i = i;
                    i2 = 26;
                }
                C19050a.m29623z((long) i, (long) i2);
                Void voidR = zXH;
                AppMethodBeat.m2505o(129462);
                return voidR;
            }
        });
        Object obj2 = Boolean.TRUE;
        AppMethodBeat.m2505o(129463);
        return obj2;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxt) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdGetContact";
    }
}
