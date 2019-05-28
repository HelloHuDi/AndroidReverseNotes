package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ti extends com.tencent.mm.sdk.b.b {
    public a cPC;
    public b cPD;

    public static final class a {
        public String id;
    }

    public static final class b {
        public boolean cPE;
    }

    public ti() {
        this((byte) 0);
    }

    private ti(byte b) {
        AppMethodBeat.i(70215);
        this.cPC = new a();
        this.cPD = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70215);
    }
}
