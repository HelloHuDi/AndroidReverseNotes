package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.e;
import java.util.List;

public final class kd extends com.tencent.mm.sdk.b.b {
    public b cFA;
    public a cFz;

    public static final class a {
        public int action;
        public List cAV;
        public e cFB;
        public int cFC;
        public boolean cFD;
        public String cFE;
        public int position;
    }

    public static final class b {
        public List cAV;
        public e cFB;
        public c cFF;
        public String cFG;
        public boolean csN;
    }

    public kd() {
        this((byte) 0);
    }

    private kd(byte b) {
        AppMethodBeat.i(137226);
        this.cFz = new a();
        this.cFA = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(137226);
    }
}
