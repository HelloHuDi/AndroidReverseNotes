package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nd extends com.tencent.mm.sdk.b.b {
    public a cJl;
    public b cJm;

    public static final class a {
        public String appId;
        public String url;
    }

    public static final class b {
        public boolean cJn = false;
        public String cJo;
        public String cJp;
        public String cJq;
        public String cJr;
        public String cJs;
        public String cJt;
        public String cJu;
        public int errCode = 0;
        public String userName;
    }

    public nd() {
        this((byte) 0);
    }

    private nd(byte b) {
        AppMethodBeat.i(56565);
        this.cJl = new a();
        this.cJm = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56565);
    }
}
