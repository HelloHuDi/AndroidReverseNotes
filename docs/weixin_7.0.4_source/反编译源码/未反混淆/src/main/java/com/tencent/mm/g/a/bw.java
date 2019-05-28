package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bw extends com.tencent.mm.sdk.b.b {
    public a cuV;
    public b cuW;

    public static final class b {
        public String appId;
        public String[] bQQ;
        public String nickname;
    }

    public static final class a {
        public String username;
    }

    public bw() {
        this((byte) 0);
    }

    private bw(byte b) {
        AppMethodBeat.i(128629);
        this.cuV = new a();
        this.cuW = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(128629);
    }
}
