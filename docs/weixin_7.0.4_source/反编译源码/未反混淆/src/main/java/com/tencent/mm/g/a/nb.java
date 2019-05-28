package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nb extends com.tencent.mm.sdk.b.b {
    public a cJf;
    public b cJg;

    public static final class b {
        public boolean cvi = false;
    }

    public static final class a {
        public String cJh;
        public String talker;
    }

    public nb() {
        this((byte) 0);
    }

    private nb(byte b) {
        AppMethodBeat.i(102510);
        this.cJf = new a();
        this.cJg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(102510);
    }
}
