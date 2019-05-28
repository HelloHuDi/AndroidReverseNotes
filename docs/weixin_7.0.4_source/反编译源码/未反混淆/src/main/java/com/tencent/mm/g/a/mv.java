package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mv extends com.tencent.mm.sdk.b.b {
    public a cIL;
    public b cIM;

    public static final class a {
        public int bJt = 0;
        public int cIN = 0;
        public String scanResult;
    }

    public static final class b {
        public int ret = 0;
    }

    public mv() {
        this((byte) 0);
    }

    private mv(byte b) {
        AppMethodBeat.i(77559);
        this.cIL = new a();
        this.cIM = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77559);
    }
}
