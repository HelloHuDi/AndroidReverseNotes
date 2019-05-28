package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bau;

public final class no extends com.tencent.mm.sdk.b.b {
    public a cJO;
    public b cJP;

    public static final class a {
        public String username;
    }

    public static final class b {
        public bau cJQ;
        public bau cJR;
        public bau cJS;
        public bau cJT;
    }

    public no() {
        this((byte) 0);
    }

    private no(byte b) {
        AppMethodBeat.i(94425);
        this.cJO = new a();
        this.cJP = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(94425);
    }
}
