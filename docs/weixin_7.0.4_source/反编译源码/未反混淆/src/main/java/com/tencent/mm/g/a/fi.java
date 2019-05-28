package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;

public final class fi extends com.tencent.mm.sdk.b.b {
    public a cza;
    public b czb;

    public static final class a {
        public String content;
        public int flags;
        public String toUserName;
        public int type;
    }

    public static final class b {
        public long cvx = 0;
        public m czc;
    }

    public fi() {
        this((byte) 0);
    }

    private fi(byte b) {
        AppMethodBeat.i(70182);
        this.cza = new a();
        this.czb = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70182);
    }
}
