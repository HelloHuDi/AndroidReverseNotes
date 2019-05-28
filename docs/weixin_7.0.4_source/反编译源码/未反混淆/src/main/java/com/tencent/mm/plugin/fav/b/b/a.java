package com.tencent.mm.plugin.fav.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends c<cg> {
    public a() {
        AppMethodBeat.i(5317);
        this.xxI = cg.class.getName().hashCode();
        AppMethodBeat.o(5317);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(5318);
        cg cgVar = (cg) bVar;
        ab.i("MicroMsg.Fav.DelFavoriteItemListener", "do delete favitem, localId %d", Long.valueOf(cgVar.cvt.cvv));
        g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(cgVar.cvt.cvv);
        cgVar.cvu.cvi = com.tencent.mm.plugin.fav.a.b.i(iE);
        AppMethodBeat.o(5318);
        return false;
    }
}
