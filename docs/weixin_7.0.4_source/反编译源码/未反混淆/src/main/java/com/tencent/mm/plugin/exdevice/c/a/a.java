package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.a.a<ub, uc> {
    String appId;
    String ceI;
    String cws;
    String lqT;
    private WeakReference<b<a>> lqU;

    public final /* bridge */ /* synthetic */ void g(com.tencent.mm.bt.a aVar) {
        ub ubVar = (ub) aVar;
        ubVar.wbq = this.ceI;
        ubVar.vIk = this.cws;
        ubVar.wbr = this.lqT;
        ubVar.fKh = this.appId;
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        AppMethodBeat.i(19067);
        this.ceI = bo.nullAsNil(str);
        this.cws = bo.nullAsNil(str2);
        this.lqT = bo.nullAsNil(str3);
        this.appId = bo.nullAsNil(str4);
        this.lqU = new WeakReference(bVar);
        AppMethodBeat.o(19067);
    }

    public final int getType() {
        return 1799;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19068);
        ab.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString());
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lqU.get();
        if (bVar != null) {
            bVar.a(i2, i3, str, this);
        }
        AppMethodBeat.o(19068);
    }

    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }

    public final /* synthetic */ com.tencent.mm.bt.a boo() {
        AppMethodBeat.i(19069);
        uc ucVar = new uc();
        AppMethodBeat.o(19069);
        return ucVar;
    }

    public final /* synthetic */ com.tencent.mm.bt.a bon() {
        AppMethodBeat.i(19070);
        ub ubVar = new ub();
        AppMethodBeat.o(19070);
        return ubVar;
    }
}
