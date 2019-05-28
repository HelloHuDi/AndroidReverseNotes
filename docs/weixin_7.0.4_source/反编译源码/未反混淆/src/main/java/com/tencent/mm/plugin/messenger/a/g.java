package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class g {
    public static d opT;

    public static d bOk() {
        AppMethodBeat.i(111118);
        if (opT == null) {
            opT = new b();
        }
        if (opT instanceof b) {
            ab.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        d dVar = opT;
        AppMethodBeat.o(111118);
        return dVar;
    }
}
