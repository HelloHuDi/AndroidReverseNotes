package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uk extends com.tencent.mm.sdk.b.b {
    public a cQC;
    public b cQD;

    public static final class a {
        public String action;
        public String appId;
        public String buffer;
        public String cQE;
        public String cQF;
        public int cQG;
        public String cvO;
        public String nonceStr;
        public String signType;
        public String url;
    }

    public static final class b {
        public String buffer;
        public Runnable cQH;
        public int retCode;
    }

    public uk() {
        this((byte) 0);
    }

    private uk(byte b) {
        AppMethodBeat.i(5472);
        this.cQC = new a();
        this.cQD = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(5472);
    }
}
