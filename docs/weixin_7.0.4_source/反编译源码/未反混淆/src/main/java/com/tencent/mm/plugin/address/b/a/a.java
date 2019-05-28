package com.tencent.mm.plugin.address.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import java.util.Iterator;

public final class a {
    public com.tencent.mm.plugin.j.a.a gIF = new com.tencent.mm.plugin.j.a.a();

    public a() {
        AppMethodBeat.i(16719);
        AppMethodBeat.o(16719);
    }

    public final b nd(int i) {
        AppMethodBeat.i(16720);
        Iterator it = this.gIF.nuG.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nuH == i) {
                AppMethodBeat.o(16720);
                return bVar;
            }
        }
        AppMethodBeat.o(16720);
        return null;
    }
}
