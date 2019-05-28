package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fy extends com.tencent.mm.sdk.b.b {
    public a cAb;
    public b cAc;

    public static final class a {
        public int cAd = 0;
        public int state = -1;
        public String talker;
    }

    public static final class b {
        public int state = -1;
    }

    public fy() {
        this((byte) 0);
    }

    private fy(byte b) {
        AppMethodBeat.i(102509);
        this.cAb = new a();
        this.cAc = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(102509);
    }
}
