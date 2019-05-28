package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pm extends com.tencent.mm.sdk.b.b {
    public a cLH;
    public b cLI;

    public static final class a {
        public String userName;
    }

    public static final class b {
    }

    public pm() {
        this((byte) 0);
    }

    private pm(byte b) {
        AppMethodBeat.i(15799);
        this.cLH = new a();
        this.cLI = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15799);
    }
}
