package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mi extends com.tencent.mm.sdk.b.b {
    public a cIm;
    public b cIn;

    public static final class b {
        public boolean cIl = false;
    }

    public static final class a {
        public int type;
    }

    public mi() {
        this((byte) 0);
    }

    private mi(byte b) {
        AppMethodBeat.i(55783);
        this.cIm = new a();
        this.cIn = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(55783);
    }
}
