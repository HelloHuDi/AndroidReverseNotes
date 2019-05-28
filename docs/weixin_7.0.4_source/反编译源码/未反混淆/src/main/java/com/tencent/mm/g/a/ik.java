package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik extends com.tencent.mm.sdk.b.b {
    public b cDA;
    public a cDz;

    public static final class a {
        public int cDB = 0;
        public Context context;
        public int scene = 0;
    }

    public static final class b {
        public String targetActivity;
    }

    public ik() {
        this((byte) 0);
    }

    private ik(byte b) {
        AppMethodBeat.i(114427);
        this.cDz = new a();
        this.cDA = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(114427);
    }
}
