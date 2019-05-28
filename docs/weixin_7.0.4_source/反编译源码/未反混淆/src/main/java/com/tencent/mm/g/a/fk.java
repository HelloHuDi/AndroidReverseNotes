package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fk extends com.tencent.mm.sdk.b.b {
    public a czf;
    public b czg;

    public static final class a {
        public boolean com;
        public boolean czh = false;
        public com.tencent.mm.ai.h.a czi;
        public com.tencent.mm.ai.h.b czj;
        public String fileName;
        public int op;
    }

    public static final class b {
        public boolean cvi = false;
    }

    public fk() {
        this((byte) 0);
    }

    private fk(byte b) {
        AppMethodBeat.i(70183);
        this.czf = new a();
        this.czg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70183);
    }
}
