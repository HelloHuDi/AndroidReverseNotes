package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ok extends b {
    public a cKI;

    public static final class a {
        public String cEV;
        public int cKJ;
        public long cKK;
        public String cKL;
        public Context context;
        public String csB;
        public String cst;
        public String mediaTagName;
        public int msgType;
        public String packageName;
        public int scene;
    }

    public ok() {
        this((byte) 0);
    }

    private ok(byte b) {
        AppMethodBeat.i(70206);
        this.cKI = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70206);
    }
}
