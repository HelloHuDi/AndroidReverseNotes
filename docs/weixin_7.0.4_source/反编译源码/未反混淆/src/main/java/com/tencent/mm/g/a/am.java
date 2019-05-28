package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class am extends b {
    public a ctA;

    public static final class a {
        public Activity activity;
        public String ctB;
    }

    public am() {
        this((byte) 0);
    }

    private am(byte b) {
        AppMethodBeat.i(70133);
        this.ctA = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70133);
    }
}
