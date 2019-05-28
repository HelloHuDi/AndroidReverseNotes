package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sx extends com.tencent.mm.sdk.b.b {
    public a cPa;
    public b cPb;

    public static final class a {
        public String cPc;
        public Context context;
        public int opType = 0;
    }

    public static final class b {
        public String cIH;
        public boolean cvi = false;
        public String thumbPath;
    }

    public sx() {
        this((byte) 0);
    }

    private sx(byte b) {
        AppMethodBeat.i(70213);
        this.cPa = new a();
        this.cPb = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70213);
    }
}
