package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fe extends com.tencent.mm.sdk.b.b {
    public a cyA;
    public b cyB;

    public static final class a {
        public String bssid;
        public int cyC;
        public String ssid;
        public int version = 1;
    }

    public static final class b {
        public int cyD = 0;
        public int cyE = 0;
        public String cyF;
    }

    public fe() {
        this((byte) 0);
    }

    private fe(byte b) {
        AppMethodBeat.i(15770);
        this.cyA = new a();
        this.cyB = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15770);
    }
}
