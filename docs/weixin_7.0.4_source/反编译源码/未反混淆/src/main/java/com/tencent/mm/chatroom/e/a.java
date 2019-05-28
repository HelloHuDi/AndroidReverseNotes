package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class a extends b {
    private vg ehF = new vg();

    public a(String str) {
        super(7);
        AppMethodBeat.i(103957);
        this.ehF.wcB = new bts().alV(bo.nullAsNil(str));
        this.oqT = this.ehF;
        AppMethodBeat.o(103957);
    }
}
