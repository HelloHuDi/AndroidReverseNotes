package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.ckd;

@Deprecated
public final class m extends b {
    private ckd fLH = new ckd();

    public m(int i) {
        super(30);
        AppMethodBeat.i(16522);
        this.fLH.OpCode = i;
        this.oqT = this.fLH;
        AppMethodBeat.o(16522);
    }
}
