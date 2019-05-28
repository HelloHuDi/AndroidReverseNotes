package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import junit.framework.Assert;

public final class bs implements e {
    public final b b(a aVar) {
        boolean z = true;
        AppMethodBeat.i(16347);
        cm cmVar = aVar.eAB;
        Assert.assertTrue(cmVar != null);
        if (cmVar.vED == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Object obj = (String) br.z(aa.a(cmVar.vED), "tips").get(".tips.tip.url");
        ab.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(obj)));
        aw.ZK();
        c.Ry().set(12308, obj);
        AppMethodBeat.o(16347);
        return null;
    }

    public final void a(c cVar) {
    }
}
