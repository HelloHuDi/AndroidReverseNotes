package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.protocal.protobuf.baa;

public final class rs extends com.tencent.mm.sdk.b.b {
    public a cNH;
    public b cNI;

    public static final class a {
        public baa cNJ;
        public Runnable cNK;
        public d cNL;
        public String cNp;
        public int scene;
    }

    public static final class b {
        public int result;
    }

    public rs() {
        this((byte) 0);
    }

    private rs(byte b) {
        AppMethodBeat.i(60266);
        this.cNH = new a();
        this.cNI = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(60266);
    }
}
