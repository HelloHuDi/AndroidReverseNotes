package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class le extends com.tencent.mm.sdk.b.b {
    public a cHe;
    public b cHf;

    public static final class a {
        public int cAO = 0;
        public int cAP = 0;
        public String cGW;
        public Bundle cGZ;
        public String cHg;
        public long cHh = 0;
        public Context context;
        public int itemType = 0;
        public String jsonString;
        public int type = 0;
    }

    public static final class b {
        public int ret = 0;
    }

    public le() {
        this((byte) 0);
    }

    private le(byte b) {
        AppMethodBeat.i(51341);
        this.cHe = new a();
        this.cHf = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51341);
    }
}
