package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.b;

public final class ag implements ae {
    private b qMn;
    private int scene;

    public ag() {
        this.scene = 0;
        this.scene = 2;
    }

    public final int bFf() {
        return this.scene;
    }

    public final b cnj() {
        AppMethodBeat.i(36525);
        if (this.qMn == null) {
            this.qMn = new b();
        }
        b bVar = this.qMn;
        AppMethodBeat.o(36525);
        return bVar;
    }
}
