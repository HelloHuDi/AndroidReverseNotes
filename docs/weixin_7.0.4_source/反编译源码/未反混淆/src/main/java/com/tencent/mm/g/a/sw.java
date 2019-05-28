package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sw extends com.tencent.mm.sdk.b.b {
    public a cOY;
    public b cOZ;

    public static final class a {
        public String cIS;
        public int cIT = 0;
        public int cIU = 0;
        public int opType = 0;
    }

    public static final class b {
    }

    public sw() {
        this((byte) 0);
    }

    private sw(byte b) {
        AppMethodBeat.i(15806);
        this.cOY = new a();
        this.cOZ = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15806);
    }
}
