package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.b.b;

public final class og extends b {
    public a cKA;

    public static final class a {
        public int cKB;
        public SnsAdClick cKz;
        public int errorCode;
        public long timestamp;
        public String url;
    }

    public og() {
        this((byte) 0);
    }

    private og(byte b) {
        AppMethodBeat.i(94428);
        this.cKA = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(94428);
    }
}
