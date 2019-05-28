package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ui extends com.tencent.mm.sdk.b.b {
    public a cQx;
    public b cQy;

    public static final class a {
        public int cAd = 0;
        public byte[] cQr;
        public int cQs = 0;
        public String content;
        public Context context;
        public String talker;
    }

    public static final class b {
        public boolean cQA = false;
        public boolean cQz = false;
        public int type = 0;
    }

    public ui() {
        this((byte) 0);
    }

    private ui(byte b) {
        AppMethodBeat.i(77575);
        this.cQx = new a();
        this.cQy = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77575);
    }
}
