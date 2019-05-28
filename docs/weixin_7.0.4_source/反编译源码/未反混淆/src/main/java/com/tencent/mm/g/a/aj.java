package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aj extends com.tencent.mm.sdk.b.b {
    public a cth;
    public b cti;

    public static final class a {
        public int action = 0;
        public Context context;
        public String ctj;
        public long ctk = 0;
        public boolean ctl = false;
        public Runnable ctm;
        public int fromScene = 0;
        public int offset = 0;
        public String title;
    }

    public static final class b {
        public boolean ctn = false;
    }

    public aj() {
        this((byte) 0);
    }

    private aj(byte b) {
        AppMethodBeat.i(114183);
        this.cth = new a();
        this.cti = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(114183);
    }
}
