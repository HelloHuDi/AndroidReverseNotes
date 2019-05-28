package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.game.d.df;

public final class ag extends x {
    public df mYl;

    public ag(a aVar) {
        AppMethodBeat.i(111389);
        if (aVar == null) {
            this.mYl = new df();
            AppMethodBeat.o(111389);
            return;
        }
        this.mYl = (df) aVar;
        AppMethodBeat.o(111389);
    }
}
