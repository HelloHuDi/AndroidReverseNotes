package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import java.util.List;

public final class tx extends com.tencent.mm.sdk.b.b {
    public a cPY;
    public b cPZ;

    public static final class b {
        public List cQb;
        public int state = 0;
    }

    public static final class a {
        public m cQa;
    }

    public tx() {
        this((byte) 0);
    }

    private tx(byte b) {
        AppMethodBeat.i(94452);
        this.cPY = new a();
        this.cPZ = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(94452);
    }
}
