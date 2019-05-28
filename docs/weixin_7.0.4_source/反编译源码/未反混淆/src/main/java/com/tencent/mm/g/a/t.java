package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.d;

public final class t {
    public Runnable callback;
    public a csI;
    public b csJ;

    public static final class b {
        public int count;
        public boolean csN;
        public d csO;
    }

    public static final class a {
        public int action;
        public String appId;
        public String ckD;
        public int csK;
        public com.tencent.mm.ag.b csL;
        public com.tencent.mm.ag.a csM;
        public String processName;
    }

    public t() {
        this((byte) 0);
    }

    private t(byte b) {
        AppMethodBeat.i(137223);
        this.callback = null;
        this.csI = new a();
        this.csJ = new b();
        this.callback = null;
        AppMethodBeat.o(137223);
    }
}
