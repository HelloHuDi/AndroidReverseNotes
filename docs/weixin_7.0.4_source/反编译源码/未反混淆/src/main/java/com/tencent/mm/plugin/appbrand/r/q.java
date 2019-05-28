package com.tencent.mm.plugin.appbrand.r;

import android.content.Context;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class q {

    public interface a extends b {
        String xJ();

        String xK();
    }

    public static <T extends a> String a(Context context, String str, T t) {
        String xJ;
        AppMethodBeat.i(91177);
        Assert.assertTrue("Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = " + bo.dpG(), context != null);
        if (str == null) {
            xJ = t.xJ();
        } else {
            xJ = str + t.xJ();
        }
        xJ = ((xJ + t.xK()) + " NetType/" + at.gB(ah.getContext())) + " Language/" + aa.gw(ah.getContext());
        ab.i("Luggage.UserAgentUtil", "appendUserAgent, uaStr = ".concat(String.valueOf(xJ)));
        AppMethodBeat.o(91177);
        return xJ;
    }
}
