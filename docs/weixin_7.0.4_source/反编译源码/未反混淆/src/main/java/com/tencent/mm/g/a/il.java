package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class il extends b {
    public a cDC;

    public static final class a {
        public Context context;
        public String[] crW;
        public String[] selectionArgs;
    }

    public il() {
        this((byte) 0);
    }

    private il(byte b) {
        AppMethodBeat.i(15778);
        this.cDC = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15778);
    }
}
