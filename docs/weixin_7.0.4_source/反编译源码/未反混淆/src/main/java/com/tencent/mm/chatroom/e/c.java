package com.tencent.mm.chatroom.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public final class c extends b {
    private bor ehH = new bor();

    public c(String str, String str2) {
        super(16);
        AppMethodBeat.i(103959);
        this.ehH.wcB = new bts().alV(bo.nullAsNil(str));
        this.ehH.vEi = new bts().alV(bo.nullAsNil(str2));
        this.oqT = this.ehH;
        AppMethodBeat.o(103959);
    }
}
