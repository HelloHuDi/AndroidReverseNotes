package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mt extends com.tencent.mm.sdk.b.b {
    public a cIE;
    public b cIF;

    public static final class a {
        public String cIG;
        public Context context;
        public int opType = 0;
    }

    public static final class b {
        public String cIH;
        public boolean cvi = false;
        public String thumbPath;
    }

    public mt() {
        this((byte) 0);
    }

    private mt(byte b) {
        AppMethodBeat.i(135761);
        this.cIE = new a();
        this.cIF = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(135761);
    }
}
