package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mg extends b {
    public a cIc;

    public static final class a {
        public String appId;
        public String cId;
        public String cIe;
        public int cIf;
        public int cIg;
        public int cvS;
        public String nonceStr;
        public String packageExt;
        public String partnerId;
        public String signType;
        public String timeStamp;
        public String url;
    }

    public mg() {
        this((byte) 0);
    }

    private mg(byte b) {
        AppMethodBeat.i(135760);
        this.cIc = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(135760);
    }
}
