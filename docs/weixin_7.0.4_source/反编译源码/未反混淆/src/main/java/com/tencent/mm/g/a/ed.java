package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ed extends b {
    public a cxE;

    public static final class a {
        public Context context;
        public int op = 0;
        public String userName;
    }

    public ed() {
        this((byte) 0);
    }

    private ed(byte b) {
        AppMethodBeat.i(70166);
        this.cxE = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70166);
    }
}
