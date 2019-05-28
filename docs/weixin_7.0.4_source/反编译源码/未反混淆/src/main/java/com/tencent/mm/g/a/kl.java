package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kl extends com.tencent.mm.sdk.b.b {
    public a cGf;
    public b cGg;

    public static final class b {
        public int errCode;
    }

    public static final class a {
        public boolean cFT = false;
        public LinkedList<String> cGh;
        public String chatroomName;
        public int scene = 0;
    }

    public kl() {
        this((byte) 0);
    }

    private kl(byte b) {
        AppMethodBeat.i(128343);
        this.cGf = new a();
        this.cGg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(128343);
    }
}
