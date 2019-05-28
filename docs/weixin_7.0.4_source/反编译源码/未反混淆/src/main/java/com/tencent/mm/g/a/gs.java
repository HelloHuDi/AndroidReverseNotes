package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gs extends com.tencent.mm.sdk.b.b {
    public a cBr;
    public b cBs;

    public static final class b {
        public int ctT = 0;
        public int ctU = 0;
        public int ctV = 0;
        public int ctW = 0;
    }

    public static final class a {
        public int cBt = 0;
        public int cBu = 0;
        public long cvx = -1;
    }

    public gs() {
        this((byte) 0);
    }

    private gs(byte b) {
        AppMethodBeat.i(70193);
        this.cBr = new a();
        this.cBs = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70193);
    }
}
