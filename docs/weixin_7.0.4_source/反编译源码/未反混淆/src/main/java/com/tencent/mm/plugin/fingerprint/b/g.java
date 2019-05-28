package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.if;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tenpay.android.wechat.TenpayUtil;

public final class g extends c<if> {
    public g() {
        AppMethodBeat.i(41478);
        this.xxI = if.class.getName().hashCode();
        AppMethodBeat.o(41478);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(41479);
        if ifVar = (if) bVar;
        if (ifVar != null) {
            ifVar.cDm.cDo = TenpayUtil.signWith3Des("passwd=" + ifVar.cDl.cDn);
            ab.v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", ifVar.cDm.cDo);
        }
        AppMethodBeat.o(41479);
        return false;
    }
}
