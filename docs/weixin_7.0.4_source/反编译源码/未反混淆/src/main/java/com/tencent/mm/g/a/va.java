package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class va extends com.tencent.mm.sdk.b.b {
    public a cRQ;
    public b cRR;

    public static final class a {
        public String cRS;
    }

    public static final class b {
        public int cRT = -1;
        public int cRU = -1;
        public int cRV = -1;
    }

    public va() {
        this((byte) 0);
    }

    private va(byte b) {
        AppMethodBeat.i(70219);
        this.cRQ = new a();
        this.cRR = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70219);
    }
}
