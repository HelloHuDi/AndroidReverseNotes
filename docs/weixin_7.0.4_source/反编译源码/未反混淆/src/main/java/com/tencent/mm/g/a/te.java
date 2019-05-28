package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chn;

public final class te extends com.tencent.mm.sdk.b.b {
    public a cPr;
    public b cPs;

    public static final class a {
        public int actionType;
    }

    public static final class b {
        public boolean cPt;
        public chn cPu;
    }

    public te() {
        this((byte) 0);
    }

    private te(byte b) {
        AppMethodBeat.i(55698);
        this.cPr = new a();
        this.cPs = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(55698);
    }
}
