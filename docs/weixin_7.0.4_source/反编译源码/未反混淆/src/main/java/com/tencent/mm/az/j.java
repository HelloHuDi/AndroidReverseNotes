package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bcl;

@Deprecated
public final class j extends b {
    private bcl fLE = new bcl();

    public j(String str, int i) {
        super(64);
        AppMethodBeat.i(59998);
        this.fLE.pXM = str;
        this.fLE.nbk = i;
        this.oqT = this.fLE;
        AppMethodBeat.o(59998);
    }
}
