package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public final class id extends com.tencent.mm.sdk.b.b {
    public a cDc;
    public b cDd;

    public static final class a {
        public String cwT;
    }

    public static final class b {
        public TimeLineObject cDe;
    }

    public id() {
        this((byte) 0);
    }

    private id(byte b) {
        AppMethodBeat.i(94422);
        this.cDc = new a();
        this.cDd = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(94422);
    }
}
