package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ty extends com.tencent.mm.sdk.b.b {
    public a cQc;
    public b cQd;

    public static final class b {
        public boolean cQe;
    }

    public static final class a {
        public Context context;
        public int type;
    }

    public ty() {
        this((byte) 0);
    }

    private ty(byte b) {
        AppMethodBeat.i(70217);
        this.cQc = new a();
        this.cQd = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70217);
    }
}
