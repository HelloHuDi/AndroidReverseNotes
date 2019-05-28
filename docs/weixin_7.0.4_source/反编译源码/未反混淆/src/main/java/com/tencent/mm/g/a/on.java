package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class on extends b {
    public a cKQ;

    public static final class a {
        public Context context;
        public Intent intent;
    }

    public on() {
        this((byte) 0);
    }

    private on(byte b) {
        AppMethodBeat.i(56571);
        this.cKQ = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56571);
    }
}
