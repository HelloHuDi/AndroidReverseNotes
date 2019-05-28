package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gx extends com.tencent.mm.sdk.b.b {
    public a cBD;
    public b cBE;

    public static final class a {
        public int Cn = 0;
        public String cBy;
    }

    public static final class b {
        public String cBF;
    }

    public gx() {
        this((byte) 0);
    }

    private gx(byte b) {
        AppMethodBeat.i(54941);
        this.cBD = new a();
        this.cBE = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(54941);
    }
}
