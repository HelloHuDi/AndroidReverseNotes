package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gu extends com.tencent.mm.sdk.b.b {
    public a cBw;
    public b cBx;

    public static final class b {
        public String result;
    }

    public static final class a {
        public int Cn = 0;
        public String cBy;
        public Context context;
    }

    public gu() {
        this((byte) 0);
    }

    private gu(byte b) {
        AppMethodBeat.i(54938);
        this.cBw = new a();
        this.cBx = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(54938);
    }
}
