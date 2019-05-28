package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class c extends b {
    private vl fLx;
    public String username;

    public c(String str) {
        this(str, 0);
        this.username = str;
    }

    public c(String str, int i) {
        super(4);
        AppMethodBeat.i(988);
        this.fLx = new vl();
        this.fLx.wcB = new bts().alV(bo.nullAsNil(str));
        this.fLx.wcC = i;
        this.oqT = this.fLx;
        AppMethodBeat.o(988);
    }
}
