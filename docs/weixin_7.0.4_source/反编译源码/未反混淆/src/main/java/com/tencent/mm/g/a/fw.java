package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class fw extends b {
    public a czT;

    public static final class a {
        public String czU;
        public int czV;
        public int czW = 0;
        public Activity czX;
    }

    public fw() {
        this((byte) 0);
    }

    private fw(byte b) {
        AppMethodBeat.i(40554);
        this.czT = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(40554);
    }
}
