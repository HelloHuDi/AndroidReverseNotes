package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class op extends com.tencent.mm.sdk.b.b {
    public a cKW;
    public b cKX;

    public static final class b {
        public boolean cKV;
        public Bundle extras;
    }

    public static final class a {
        public int cKY;
        public Context context;
        public Bundle extras;
    }

    public op() {
        this((byte) 0);
    }

    private op(byte b) {
        AppMethodBeat.i(77563);
        this.cKW = new a();
        this.cKX = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77563);
    }
}
