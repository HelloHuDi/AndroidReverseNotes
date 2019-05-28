package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ki extends com.tencent.mm.sdk.b.b {
    public a cFO;
    public b cFP;

    public static final class a {
        public Runnable cFQ;
        public Activity czX;
    }

    public static final class b {
        public boolean cvi = false;
    }

    public ki() {
        this((byte) 0);
    }

    private ki(byte b) {
        AppMethodBeat.i(73672);
        this.cFO = new a();
        this.cFP = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73672);
    }
}
