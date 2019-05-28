package com.tencent.mm.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.z.b.d;
import com.tencent.mm.z.d.a;
import java.util.HashMap;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f {
    a eIi;
    d eIt;
    g eIw;

    public f(d dVar, g gVar, a aVar) {
        AppMethodBeat.i(115317);
        Assert.assertNotNull(dVar);
        Assert.assertNotNull(gVar);
        Assert.assertNotNull(aVar);
        this.eIt = dVar;
        this.eIw = gVar;
        this.eIi = aVar;
        AppMethodBeat.o(115317);
    }

    static String QB() {
        AppMethodBeat.i(115318);
        HashMap hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        String jSONObject = new JSONObject(hashMap).toString();
        AppMethodBeat.o(115318);
        return jSONObject;
    }
}
