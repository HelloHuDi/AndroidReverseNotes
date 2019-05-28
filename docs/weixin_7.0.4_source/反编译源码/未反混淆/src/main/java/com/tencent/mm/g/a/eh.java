package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eh extends com.tencent.mm.sdk.b.b {
    public a cxL;
    public b cxM;

    public static final class b {
        public boolean cwB;
    }

    public static final class a {
        public String ceI;
        public String cwz;
        public byte[] data;
    }

    public eh() {
        this((byte) 0);
    }

    private eh(byte b) {
        AppMethodBeat.i(70170);
        this.cxL = new a();
        this.cxM = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70170);
    }
}
