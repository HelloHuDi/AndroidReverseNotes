package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class iq extends b {
    public a cDO;

    public static final class a {
        public Context cDP;
        public long cDQ;
        public boolean cDR;
    }

    public iq() {
        this((byte) 0);
    }

    private iq(byte b) {
        AppMethodBeat.i(4300);
        this.cDO = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(4300);
    }
}
