package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class vg extends com.tencent.mm.sdk.b.b {
    public a cSe;
    public b cSf;

    public static final class a {
        public int action;
        public int cSg;
        public String content;
        public long cuQ;
    }

    public static final class b {
        public int cSg;
        public long cSh;
        public String cSi;
        public List cSj;
        public byte[] cSk;
        public byte[] cSl;
        public String cSm;
        public String cSn;
        public long cuQ;
    }

    public vg() {
        this((byte) 0);
    }

    private vg(byte b) {
        AppMethodBeat.i(56588);
        this.cSe = new a();
        this.cSf = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56588);
    }
}
