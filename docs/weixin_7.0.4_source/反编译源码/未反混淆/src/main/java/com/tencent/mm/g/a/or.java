package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class or extends com.tencent.mm.sdk.b.b {
    public a cLd;
    public b cLe;

    public static final class b {
        public boolean cKV;
        public Bundle extras;
    }

    public static final class a {
        public int cKY;
        public Context context;
        public Bundle extras;
    }

    public or() {
        this((byte) 0);
    }

    private or(byte b) {
        AppMethodBeat.i(77564);
        this.cLd = new a();
        this.cLe = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77564);
    }
}
