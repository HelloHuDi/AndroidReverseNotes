package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mh extends com.tencent.mm.sdk.b.b {
    public a cIh;
    public b cIi;

    public static final class a {
        public boolean cIj = false;
        public boolean cIk = false;
        public int type;
    }

    public static final class b {
        public boolean cIl = false;
    }

    public mh() {
        this((byte) 0);
    }

    private mh(byte b) {
        AppMethodBeat.i(55782);
        this.cIh = new a();
        this.cIi = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(55782);
    }
}
