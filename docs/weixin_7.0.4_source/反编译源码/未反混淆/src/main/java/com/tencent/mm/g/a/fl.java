package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fl extends com.tencent.mm.sdk.b.b {
    public a czk;
    public b czl;

    public static final class a {
        public int op;
        public String username;
    }

    public static final class b {
        public boolean cvi = false;
        public String fileName;
    }

    public fl() {
        this((byte) 0);
    }

    private fl(byte b) {
        AppMethodBeat.i(70184);
        this.czk = new a();
        this.czl = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70184);
    }
}
