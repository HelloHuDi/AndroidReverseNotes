package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;

public final class dc extends com.tencent.mm.sdk.b.b {
    public a cwj;
    public b cwk;

    public static final class b {
        public m cwn;
    }

    public static final class a {
        public String cwl;
        public int cwm = 0;
        public m cwn;
        public int opType = 0;
    }

    public dc() {
        this((byte) 0);
    }

    private dc(byte b) {
        AppMethodBeat.i(70139);
        this.cwj = new a();
        this.cwk = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70139);
    }
}
