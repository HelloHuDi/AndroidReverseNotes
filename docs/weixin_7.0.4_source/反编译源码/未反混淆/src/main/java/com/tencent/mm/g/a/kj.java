package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

public final class kj extends b {
    public a cFR;

    public static final class a {
        public LinkedList<arz> cFS;
        public boolean cFT = false;
    }

    public kj() {
        this((byte) 0);
    }

    private kj(byte b) {
        AppMethodBeat.i(5500);
        this.cFR = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(5500);
    }
}
