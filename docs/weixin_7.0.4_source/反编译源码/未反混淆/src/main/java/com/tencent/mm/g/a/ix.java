package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ix extends b {
    public a cDZ;

    public static final class a {
        public String cEa;
        public Long cEb;
        public Context context;
        public String username;
    }

    public ix() {
        this((byte) 0);
    }

    private ix(byte b) {
        AppMethodBeat.i(40555);
        this.cDZ = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(40555);
    }
}
