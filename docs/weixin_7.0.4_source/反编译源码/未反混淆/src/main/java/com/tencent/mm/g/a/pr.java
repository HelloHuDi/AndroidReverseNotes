package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class pr extends com.tencent.mm.sdk.b.b {
    public a cLS;
    public b cLT;

    public static final class a {
        public WeakReference aIq;
        public String cLU;
        public Runnable callback;
        public int scene;
        public int type;
    }

    public static final class b {
        public String aIm;
        public int actionType;
        public String cLV;
    }

    public pr() {
        this((byte) 0);
    }

    private pr(byte b) {
        AppMethodBeat.i(56574);
        this.cLS = new a();
        this.cLT = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56574);
    }
}
