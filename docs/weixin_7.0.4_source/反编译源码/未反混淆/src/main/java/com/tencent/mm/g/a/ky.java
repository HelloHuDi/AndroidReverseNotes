package com.tencent.mm.g.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ky extends b {
    public a cGQ;

    public static final class a {
        public Context context;
        public String group;
        public Intent intent;
        public int type = 0;
    }

    public ky() {
        this((byte) 0);
    }

    private ky(byte b) {
        AppMethodBeat.i(54945);
        this.cGQ = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(54945);
    }
}
