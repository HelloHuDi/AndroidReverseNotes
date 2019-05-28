package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class bc extends j<bb> implements n {
    public static final String[] fnj = new String[]{j.a(bb.ccO, "GetSysCmdMsgInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(1303);
        AppMethodBeat.o(1303);
    }

    public bc(h hVar) {
        super(hVar, bb.ccO, "GetSysCmdMsgInfo", null);
        this.bSd = hVar;
    }
}
