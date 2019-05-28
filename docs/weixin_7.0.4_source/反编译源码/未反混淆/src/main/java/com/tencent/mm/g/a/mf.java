package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mf extends com.tencent.mm.sdk.b.b {
    public a cHZ;
    public b cIa;

    public static final class a {
        public int cIb;
        public Context context;
        public int cvp = 0;
        public int scene;
        public String source;
        public String url;
    }

    public static final class b {
        public int ret = 0;
    }

    public mf() {
        this((byte) 0);
    }

    private mf(byte b) {
        AppMethodBeat.i(56564);
        this.cHZ = new a();
        this.cIa = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56564);
    }
}
