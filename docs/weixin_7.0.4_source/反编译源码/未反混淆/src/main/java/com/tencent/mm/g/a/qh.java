package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qh extends com.tencent.mm.sdk.b.b {
    public a cMw;
    public b cMx;

    public static final class a {
        public Intent intent;
        public String username;
    }

    public static final class b {
    }

    public qh() {
        this((byte) 0);
    }

    private qh(byte b) {
        AppMethodBeat.i(73674);
        this.cMw = new a();
        this.cMx = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(73674);
    }
}
