package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;

public final class jj extends com.tencent.mm.sdk.b.b {
    public a cEF;
    public b cEG;

    public static final class a {
        public String aOt;
        public int cEA = 0;
        public boolean cEH = false;
        public bi csG;
    }

    public static final class b {
        public String cBp;
        public String cEI;
    }

    public jj() {
        this((byte) 0);
    }

    private jj(byte b) {
        AppMethodBeat.i(113285);
        this.cEF = new a();
        this.cEG = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(113285);
    }
}
