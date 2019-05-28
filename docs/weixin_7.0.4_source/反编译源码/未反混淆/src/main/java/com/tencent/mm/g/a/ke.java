package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.sdk.b.b;

public final class ke extends b {
    public a cFH;

    public static final class a {
        public String aIm;
        public int action;
        public String appId;
        public e cFB;
        public String cFI;
        public boolean cFJ;
        public boolean cFK = false;
        public long duration;
        public int errCode;
        public String state;
    }

    public ke() {
        this((byte) 0);
    }

    private ke(byte b) {
        AppMethodBeat.i(137227);
        this.cFH = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(137227);
    }
}
