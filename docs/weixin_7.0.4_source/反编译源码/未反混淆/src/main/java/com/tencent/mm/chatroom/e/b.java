package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class b extends com.tencent.mm.plugin.messenger.foundation.a.a.j.b {
    private bbt ehG = new bbt();

    public b(String str, int i) {
        super(20);
        AppMethodBeat.i(103958);
        this.ehG.vEi = new bts().alV(bo.nullAsNil(str));
        this.ehG.jBT = i;
        this.oqT = this.ehG;
        AppMethodBeat.o(103958);
    }
}
