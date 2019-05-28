package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class j extends c<nc> {
    public j() {
        AppMethodBeat.i(16749);
        this.xxI = nc.class.getName().hashCode();
        AppMethodBeat.o(16749);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(16750);
        nc ncVar = (nc) bVar;
        ab.i("MicroMsg.RcptAddressEventListener", "revent " + ncVar.cJi.cJk);
        aw.ZK();
        e.y(ncVar.cJi.cJk, com.tencent.mm.model.c.getAccPath() + "address");
        AppMethodBeat.o(16750);
        return false;
    }
}
