package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class f {
    private int pos;
    private char[] sOB = new char[50];

    public f() {
        AppMethodBeat.i(4353);
        AppMethodBeat.o(4353);
    }

    public final String toString() {
        AppMethodBeat.i(4354);
        String str = new String(this.sOB, 0, this.pos);
        AppMethodBeat.o(4354);
        return str;
    }
}
