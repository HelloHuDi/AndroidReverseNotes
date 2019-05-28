package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class by extends com.tencent.mm.sdk.b.b {
    public a cvf;
    public b cvg;

    public static final class b {
        public boolean cvi = false;
    }

    public static final class a {
        public Context context;
        public String cvh;
        public String username;
    }

    public by() {
        this((byte) 0);
    }

    private by(byte b) {
        AppMethodBeat.i(77539);
        this.cvf = new a();
        this.cvg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77539);
    }
}
