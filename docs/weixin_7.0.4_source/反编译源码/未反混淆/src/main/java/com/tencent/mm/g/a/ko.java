package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayb;
import java.util.LinkedList;

public final class ko extends com.tencent.mm.sdk.b.b {
    public a cGu;
    public b cGv;

    public static final class a {
        public String cEw;
        public boolean cFT = false;
    }

    public static final class b {
        public int cEX = 0;
        public LinkedList<ayb> cGh;
    }

    public ko() {
        this((byte) 0);
    }

    private ko(byte b) {
        AppMethodBeat.i(118261);
        this.cGu = new a();
        this.cGv = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(118261);
    }
}
