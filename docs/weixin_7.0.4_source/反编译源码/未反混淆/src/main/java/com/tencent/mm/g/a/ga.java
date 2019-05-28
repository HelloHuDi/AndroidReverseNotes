package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ga extends com.tencent.mm.sdk.b.b {
    public a cAj;
    public b cAk;

    public static final class a {
        public String cAg;
        public String cAh;
    }

    public static final class b {
        public String cAl;
    }

    public ga() {
        this((byte) 0);
    }

    private ga(byte b) {
        AppMethodBeat.i(73666);
        this.cAj = new a();
        this.cAk = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73666);
    }
}
