package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMActivity;

public final class c extends b {
    public a crO;

    public static final class a {
        public MMActivity crP;
        public int errCode;
        public int errType;
    }

    public c() {
        this((byte) 0);
    }

    private c(byte b) {
        AppMethodBeat.i(77527);
        this.crO = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77527);
    }
}
