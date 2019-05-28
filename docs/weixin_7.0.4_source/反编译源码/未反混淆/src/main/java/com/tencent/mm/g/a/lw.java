package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class lw extends b {
    public a cHK;

    public static final class a {
        public int cHL;
        public Context context;
        public String extraInfo;
        public int jumpType;
    }

    public lw() {
        this((byte) 0);
    }

    private lw(byte b) {
        AppMethodBeat.i(54946);
        this.cHK = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(54946);
    }
}
