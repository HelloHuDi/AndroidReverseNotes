package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class e extends b {
    private vv fLz = new vv();

    public e(String str, long j) {
        super(9);
        AppMethodBeat.i(16519);
        this.fLz.wcB = new bts().alV(bo.nullAsNil(str));
        this.fLz.wcH.add(Integer.valueOf((int) j));
        this.fLz.jBv = 1;
        this.oqT = this.fLz;
        AppMethodBeat.o(16519);
    }
}
