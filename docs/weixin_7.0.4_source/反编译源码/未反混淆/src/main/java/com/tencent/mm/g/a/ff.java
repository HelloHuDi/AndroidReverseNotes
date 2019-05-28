package com.tencent.mm.g.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ff extends com.tencent.mm.sdk.b.b {
    public a cyG;
    public b cyH;

    public static final class b {
        public Cursor cyz;
    }

    public static final class a {
        public String cyI;
    }

    public ff() {
        this((byte) 0);
    }

    private ff(byte b) {
        AppMethodBeat.i(70180);
        this.cyG = new a();
        this.cyH = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70180);
    }
}
