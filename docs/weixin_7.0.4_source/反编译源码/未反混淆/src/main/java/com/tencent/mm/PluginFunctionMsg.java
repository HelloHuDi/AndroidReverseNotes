package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;

public class PluginFunctionMsg extends f implements q, a {
    private static HashMap<Integer, d> cbO = new HashMap();

    public com.tencent.mm.u.a getReceiver() {
        return com.tencent.mm.u.a.eAA;
    }

    public void configure(g gVar) {
        AppMethodBeat.i(35442);
        super.configure(gVar);
        com.tencent.mm.kernel.g.a(h.class, getReceiver());
        AppMethodBeat.o(35442);
    }

    public void execute(g gVar) {
    }

    static {
        AppMethodBeat.i(35444);
        final String[] strArr = new String[]{j.a(com.tencent.mm.api.f.ccO, "FunctionMsgItem")};
        cbO.put(Integer.valueOf("FunctionMsgItem".hashCode()), new d() {
            public final String[] Af() {
                return strArr;
            }
        });
        AppMethodBeat.o(35444);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return cbO;
    }
}
