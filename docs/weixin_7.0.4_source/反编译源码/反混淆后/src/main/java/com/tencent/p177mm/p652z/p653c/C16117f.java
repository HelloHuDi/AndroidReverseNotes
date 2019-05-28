package com.tencent.p177mm.p652z.p653c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40954d;
import com.tencent.p177mm.p652z.p654d.C5759a;
import java.util.HashMap;
import junit.framework.Assert;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.z.c.f */
public final class C16117f {
    C5759a eIi;
    C40954d eIt;
    C46728g eIw;

    public C16117f(C40954d c40954d, C46728g c46728g, C5759a c5759a) {
        AppMethodBeat.m2504i(115317);
        Assert.assertNotNull(c40954d);
        Assert.assertNotNull(c46728g);
        Assert.assertNotNull(c5759a);
        this.eIt = c40954d;
        this.eIw = c46728g;
        this.eIi = c5759a;
        AppMethodBeat.m2505o(115317);
    }

    /* renamed from: QB */
    static String m24441QB() {
        AppMethodBeat.m2504i(115318);
        HashMap hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.m2505o(115318);
        return jSONObject;
    }
}
