package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axv;
import java.util.List;

public final class kn extends com.tencent.mm.sdk.b.b {
    public a cGk;
    public b cGl;

    public static final class a {
        public float cEB = 0.0f;
        public boolean cFT = false;
        public float cGm = 0.0f;
        public int cGn = 0;
        public int cGo = 0;
        public String cGp;
        public String cGq;
        public int czE = 0;
    }

    public static final class b {
        public boolean cGr = false;
        public List<axv> cGs;
        public int cGt = -1;
        public int czE = 0;
    }

    public kn() {
        this((byte) 0);
    }

    private kn(byte b) {
        AppMethodBeat.i(55347);
        this.cGk = new a();
        this.cGl = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(55347);
    }
}
