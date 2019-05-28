package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.by;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<by> {
    public a() {
        AppMethodBeat.i(16070);
        this.xxI = by.class.getName().hashCode();
        AppMethodBeat.o(16070);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(16071);
        by byVar = (by) bVar;
        byVar.cvg.cvi = b.i(byVar.cvf.context, byVar.cvf.cvh, byVar.cvf.username);
        AppMethodBeat.o(16071);
        return false;
    }
}
