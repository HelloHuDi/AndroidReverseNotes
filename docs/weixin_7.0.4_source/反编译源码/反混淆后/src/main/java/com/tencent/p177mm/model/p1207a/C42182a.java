package com.tencent.p177mm.model.p1207a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3472n;
import java.util.Map;

/* renamed from: com.tencent.mm.model.a.a */
public final class C42182a implements C3472n {
    /* renamed from: a */
    public final C1198b mo7932a(String str, Map<String, String> map, C1197a c1197a) {
        C1198b c1198b = null;
        AppMethodBeat.m2504i(118139);
        if (str != null && str.equals("abtest")) {
            C1201e bg = C1200d.m2638bg(Integer.valueOf(-1879048184));
            if (bg != null) {
                c1198b = bg.mo4453b(c1197a);
            }
        }
        AppMethodBeat.m2505o(118139);
        return c1198b;
    }
}
