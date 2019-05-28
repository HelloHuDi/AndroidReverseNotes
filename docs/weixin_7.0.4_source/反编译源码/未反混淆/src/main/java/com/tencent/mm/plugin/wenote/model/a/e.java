package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends o {
    public long uOe;

    public e(long j) {
        this.uOe = j;
        this.mnd = "";
        this.uOo = "";
        this.cHg = "";
        this.type = -3;
    }

    public final String ddP() {
        AppMethodBeat.i(26681);
        String ddP = super.ddP();
        AppMethodBeat.o(26681);
        return ddP;
    }

    public final int getType() {
        return this.type;
    }
}
