package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gz extends com.tencent.mm.sdk.b.b {
    public a cBH;
    public b cBI;

    public static final class b {
        public String cBJ;
        public boolean cBK = false;
    }

    public static final class a {
        public int Cn = 0;
        public String url;
    }

    public gz() {
        this((byte) 0);
    }

    private gz(byte b) {
        AppMethodBeat.i(54943);
        this.cBH = new a();
        this.cBI = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(54943);
    }
}
