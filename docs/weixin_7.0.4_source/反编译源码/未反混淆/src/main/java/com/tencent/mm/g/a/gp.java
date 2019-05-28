package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gp extends com.tencent.mm.sdk.b.b {
    public a cBm;
    public b cBn;

    public static final class a {
        public Intent intent;
    }

    public static final class b {
        public int cyE = 0;
    }

    public gp() {
        this((byte) 0);
    }

    private gp(byte b) {
        AppMethodBeat.i(15776);
        this.cBm = new a();
        this.cBn = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15776);
    }
}
