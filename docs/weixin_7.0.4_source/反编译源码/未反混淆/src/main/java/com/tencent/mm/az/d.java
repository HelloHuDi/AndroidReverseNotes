package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class d extends b {
    private vo fLy = new vo();

    public d(String str, long j) {
        super(8);
        AppMethodBeat.i(16518);
        this.fLy.wcB = new bts().alV(bo.nullAsNil(str));
        this.fLy.ptF = j;
        this.oqT = this.fLy;
        AppMethodBeat.o(16518);
    }
}
