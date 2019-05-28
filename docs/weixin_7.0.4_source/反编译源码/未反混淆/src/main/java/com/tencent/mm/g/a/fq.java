package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fq extends com.tencent.mm.sdk.b.b {
    public a czB;
    public b czC;

    public static final class a {
        public String czD;
        public int czE = 0;
        public Runnable czF;
        public String fileName;
        public int from = 0;
        public int scene;
    }

    public static final class b {
        public boolean bcU;
        public String content;
        public int state = 0;
    }

    public fq() {
        this((byte) 0);
    }

    private fq(byte b) {
        AppMethodBeat.i(70187);
        this.czB = new a();
        this.czC = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70187);
    }
}
