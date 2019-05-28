package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ao */
public final class C38253ao extends C26917an {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Map<String, Object> mo44663a(C2119d c2119d) {
        AppMethodBeat.m2504i(130434);
        Map a = super.mo44663a(c2119d);
        a.put("clientVersion", Integer.valueOf(C7243d.vxo));
        a.put("x5Version", Integer.valueOf(C24544d.getTbsVersion(C4996ah.getContext())));
        AppMethodBeat.m2505o(130434);
        return a;
    }
}
