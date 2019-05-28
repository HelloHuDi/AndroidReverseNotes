package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fp extends com.tencent.mm.sdk.b.b {
    public a czu;
    public b czv;

    public static final class a {
        public int action;
        public long baZ;
        public long czw;
        public long czx;
    }

    public static final class b {
        public int czA;
        public String czy;
        public boolean czz = false;
    }

    public fp() {
        this((byte) 0);
    }

    private fp(byte b) {
        AppMethodBeat.i(55715);
        this.czu = new a();
        this.czv = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(55715);
    }
}
