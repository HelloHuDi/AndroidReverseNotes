package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lv extends com.tencent.mm.sdk.b.b {
    public a cHD;
    public b cHE;

    public static final class b {
        public String aIm;
        public int cBS = 0;
        public String cBU;
        public String cBV;
        public String cHI;
        public int cHJ = 0;
        public int errCode = -1;
    }

    public static final class a {
        public String cBT;
        public int cHF = 0;
        public int cHG = 0;
        public Runnable cHH;
    }

    public lv() {
        this((byte) 0);
    }

    private lv(byte b) {
        AppMethodBeat.i(114182);
        this.cHD = new a();
        this.cHE = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(114182);
    }
}
