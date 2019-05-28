package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vk extends com.tencent.mm.sdk.b.b {
    public a cSs;
    public b cSt;

    public static final class a {
        public int cuy;
        public String username;
    }

    public static final class b {
        public int cSu;
    }

    public vk() {
        this((byte) 0);
    }

    private vk(byte b) {
        AppMethodBeat.i(15816);
        this.cSs = new a();
        this.cSt = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15816);
    }
}
