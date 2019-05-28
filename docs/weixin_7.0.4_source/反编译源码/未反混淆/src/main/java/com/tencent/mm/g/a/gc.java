package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gc extends com.tencent.mm.sdk.b.b {
    public a cAq;
    public b cAr;

    public static final class a {
        public int state = -1;
    }

    public static final class b {
        public boolean cvi = false;
    }

    public gc() {
        this((byte) 0);
    }

    private gc(byte b) {
        AppMethodBeat.i(70192);
        this.cAq = new a();
        this.cAr = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70192);
    }
}
