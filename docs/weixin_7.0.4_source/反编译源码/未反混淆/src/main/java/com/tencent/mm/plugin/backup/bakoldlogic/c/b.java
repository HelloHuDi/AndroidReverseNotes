package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;

public final class b extends com.tencent.mm.plugin.backup.g.b {
    private ab jAg = new ab();
    private ac jAh = new ac();

    public b(int i) {
        AppMethodBeat.i(17881);
        this.jAg.jBh = i;
        AppMethodBeat.o(17881);
    }

    public final a aTS() {
        return this.jAh;
    }

    public final a aTT() {
        return this.jAg;
    }

    public final void rw(int i) {
        AppMethodBeat.i(17882);
        if (this.jAh.jBT == 0) {
            l(0, 0, "ok");
            AppMethodBeat.o(17882);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", Integer.valueOf(this.jAg.jBh), Integer.valueOf(this.jAh.jBT));
        l(4, this.jAh.jBT, "fail");
        AppMethodBeat.o(17882);
    }

    public final int getType() {
        return 3;
    }
}
