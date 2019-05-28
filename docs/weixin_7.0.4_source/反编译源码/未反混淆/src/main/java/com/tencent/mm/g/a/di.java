package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class di extends com.tencent.mm.sdk.b.b {
    public a cwC;
    public b cwD;

    public static final class a {
        public String ceI;
        public boolean cwA = false;
        public String cwz;
    }

    public static final class b {
        public boolean cwB;
    }

    public di() {
        this((byte) 0);
    }

    private di(byte b) {
        AppMethodBeat.i(70145);
        this.cwC = new a();
        this.cwD = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70145);
    }
}
