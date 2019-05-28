package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mx extends com.tencent.mm.sdk.b.b {
    public a cIO;
    public b cIP;

    public static final class b {
        public boolean cvi;
    }

    public static final class a {
        public String cIQ;
        public String cIR;
        public String cIS;
        public int cIT = 0;
        public int cIU = 0;
        public int opType = 0;
    }

    public mx() {
        this((byte) 0);
    }

    private mx(byte b) {
        AppMethodBeat.i(73673);
        this.cIO = new a();
        this.cIP = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73673);
    }
}
