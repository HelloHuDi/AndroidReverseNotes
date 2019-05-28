package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public final q uRP;
    public int uRQ;
    public int uRR;

    public a(q qVar, int i, int i2) {
        this.uRP = qVar;
        this.uRQ = i;
        this.uRR = i2;
    }

    public final String toString() {
        AppMethodBeat.i(26930);
        String str = this.uRP.name() + " - " + this.uRQ + "/" + this.uRR;
        AppMethodBeat.o(26930);
        return str;
    }
}
