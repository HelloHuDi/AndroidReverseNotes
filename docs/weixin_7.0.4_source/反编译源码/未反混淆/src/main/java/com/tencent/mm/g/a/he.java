package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class he extends com.tencent.mm.sdk.b.b {
    public a cBW;
    public b cBX;

    public static final class b {
        public int ret = 0;
    }

    public static final class a {
        public int actionCode;
        public Bundle cBY;
        public Context context;
        public String result;
        public String username;
    }

    public he() {
        this((byte) 0);
    }

    private he(byte b) {
        AppMethodBeat.i(135758);
        this.cBW = new a();
        this.cBX = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(135758);
    }
}
