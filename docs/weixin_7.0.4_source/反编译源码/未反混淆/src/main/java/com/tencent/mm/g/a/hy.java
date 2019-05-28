package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hy extends com.tencent.mm.sdk.b.b {
    public a cCS;
    public b cCT;

    public static final class a {
        public Context context;
    }

    public static final class b {
        public String cCU;
    }

    public hy() {
        this((byte) 0);
    }

    private hy(byte b) {
        AppMethodBeat.i(73669);
        this.cCS = new a();
        this.cCT = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73669);
    }
}
