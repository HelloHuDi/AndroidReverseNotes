package com.tencent.p177mm.plugin.appbrand.p328r;

import android.content.Context;
import com.tencent.luggage.p1170a.C25681b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.r.q */
public final class C10707q {

    /* renamed from: com.tencent.mm.plugin.appbrand.r.q$a */
    public interface C10708a extends C25681b {
        /* renamed from: xJ */
        String mo22249xJ();

        /* renamed from: xK */
        String mo22250xK();
    }

    /* renamed from: a */
    public static <T extends C10708a> String m18380a(Context context, String str, T t) {
        String xJ;
        AppMethodBeat.m2504i(91177);
        Assert.assertTrue("Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + C5046bo.dpG(), context != null);
        if (str == null) {
            xJ = t.mo22249xJ();
        } else {
            xJ = str + t.mo22249xJ();
        }
        xJ = ((xJ + t.mo22250xK()) + " NetType/" + C5023at.m7471gB(C4996ah.getContext())) + " Language/" + C4988aa.m7403gw(C4996ah.getContext());
        C4990ab.m7416i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = ".concat(String.valueOf(xJ)));
        AppMethodBeat.m2505o(91177);
        return xJ;
    }
}
