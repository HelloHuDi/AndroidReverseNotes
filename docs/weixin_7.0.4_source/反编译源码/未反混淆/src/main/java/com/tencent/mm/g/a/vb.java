package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vb extends com.tencent.mm.sdk.b.b {
    public a cRW;
    public b cRX;

    public static final class a {
        public String cEa;
    }

    public static final class b {
        public boolean cRY;
        public int status;
    }

    public vb() {
        this((byte) 0);
    }

    private vb(byte b) {
        AppMethodBeat.i(70220);
        this.cRW = new a();
        this.cRX = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70220);
    }
}
