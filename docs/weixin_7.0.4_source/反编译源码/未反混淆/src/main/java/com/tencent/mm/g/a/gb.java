package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gb extends com.tencent.mm.sdk.b.b {
    public a cAm;
    public b cAn;

    public static final class a {
        public String aeskey;
        public String cAo;
        public String cAp;
        public int cuy;
        public String cvZ;
        public String cwg;
        public String name;
        public String thumbUrl;
    }

    public static final class b {
        public String path;
    }

    public gb() {
        this((byte) 0);
    }

    private gb(byte b) {
        AppMethodBeat.i(62223);
        this.cAm = new a();
        this.cAn = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(62223);
    }
}
