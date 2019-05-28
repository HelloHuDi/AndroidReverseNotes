package com.tencent.mm.g.a;

import android.support.v4.app.v.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class w extends b {
    public a csR;

    public static final class a {
        public e csS;
        public String title;
        public String username;
    }

    public w() {
        this((byte) 0);
    }

    private w(byte b) {
        AppMethodBeat.i(15753);
        this.csR = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15753);
    }
}
