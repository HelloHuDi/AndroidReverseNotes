package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kq extends com.tencent.mm.sdk.b.b {
    public a cGy;
    public b cGz;

    public static final class b {
        public int errCode;
    }

    public static final class a {
        public boolean cFT = false;
        public String cGA;
        public String chatroomName;
    }

    public kq() {
        this((byte) 0);
    }

    private kq(byte b) {
        AppMethodBeat.i(128345);
        this.cGy = new a();
        this.cGz = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(128345);
    }
}
