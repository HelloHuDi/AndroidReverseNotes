package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fz extends com.tencent.mm.sdk.b.b {
    public a cAe;
    public b cAf;

    public static final class a {
        public String cAg;
        public String cAh;
    }

    public static final class b {
        public boolean cAi = true;
    }

    public fz() {
        this((byte) 0);
    }

    private fz(byte b) {
        AppMethodBeat.i(73665);
        this.cAe = new a();
        this.cAf = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73665);
    }
}
