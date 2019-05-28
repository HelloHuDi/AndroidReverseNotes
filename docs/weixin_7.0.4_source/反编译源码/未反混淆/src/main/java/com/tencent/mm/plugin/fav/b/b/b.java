package com.tencent.mm.plugin.fav.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends c<gg> {
    public b() {
        AppMethodBeat.i(5319);
        this.xxI = gg.class.getName().hashCode();
        AppMethodBeat.o(5319);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        AppMethodBeat.i(5320);
        gg ggVar = (gg) bVar;
        ab.v("MicroMsg.FavNotifyListener", "deal with fav notify");
        if (((ae) g.M(ae.class)).getSendService().ame()) {
            ab.w("MicroMsg.FavNotifyListener", "sending item, do not do sync");
            AppMethodBeat.o(5320);
        } else {
            int i;
            byte[] bArr = ggVar.cAF.cAG;
            if (bArr == null) {
                i = 1;
            } else {
                i = o.t(bArr, 0);
            }
            g.Rg().a(new aj(i), 0);
            AppMethodBeat.o(5320);
        }
        return false;
    }
}
