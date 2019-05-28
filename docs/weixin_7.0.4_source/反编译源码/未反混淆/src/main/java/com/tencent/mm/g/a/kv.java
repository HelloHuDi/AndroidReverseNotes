package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class kv extends b {
    public a cGM;

    public static final class a {
        public Activity activity;
        public int cGK = 0;
        public Bundle cGN;
        public String ctB;
    }

    public kv() {
        this((byte) 0);
    }

    private kv(byte b) {
        AppMethodBeat.i(70198);
        this.cGM = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70198);
    }
}
