package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uo extends com.tencent.mm.sdk.b.b {
    public a cQJ;
    public b cQK;

    public static final class a {
        public String cQL;
    }

    public static final class b {
        public String cQM;
        public String content;
        public String url;
    }

    public uo() {
        this((byte) 0);
    }

    private uo(byte b) {
        AppMethodBeat.i(56577);
        this.cQJ = new a();
        this.cQK = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56577);
    }
}
