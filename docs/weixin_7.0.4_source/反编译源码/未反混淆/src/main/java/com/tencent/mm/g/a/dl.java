package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dl extends com.tencent.mm.sdk.b.b {
    public a cwJ;
    public b cwK;

    public static final class a {
        public boolean cwA = false;
    }

    public static final class b {
        public boolean cwB;
        public String cwL;
    }

    public dl() {
        this((byte) 0);
    }

    private dl(byte b) {
        AppMethodBeat.i(70148);
        this.cwJ = new a();
        this.cwK = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70148);
    }
}
