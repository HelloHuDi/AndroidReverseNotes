package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qt extends com.tencent.mm.sdk.b.b {
    public a cMT;
    public b cMU;

    public static final class b {
        public String cMW;
        public String cMY;
    }

    public static final class a {
        public boolean cMV;
        public String cMW;
        public boolean cMX = false;
        public int type;
        public String videoPath;
    }

    public qt() {
        this((byte) 0);
    }

    private qt(byte b) {
        AppMethodBeat.i(94432);
        this.cMT = new a();
        this.cMU = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(94432);
    }
}
