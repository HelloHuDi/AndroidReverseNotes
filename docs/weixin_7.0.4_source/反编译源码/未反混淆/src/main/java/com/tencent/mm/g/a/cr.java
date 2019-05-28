package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class cr extends com.tencent.mm.sdk.b.b {
    public a cvM;
    public b cvN;

    public static final class a {
        public WeakReference aIq;
        public String appId;
        public Runnable callback;
        public String cvO;
        public String cvP;
        public String cvQ;
        public String cvR;
        public int cvS = 0;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String token;
    }

    public static final class b {
        public int retCode = 0;
    }

    public cr() {
        this((byte) 0);
    }

    private cr(byte b) {
        AppMethodBeat.i(5468);
        this.cvM = new a();
        this.cvN = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(5468);
    }
}
