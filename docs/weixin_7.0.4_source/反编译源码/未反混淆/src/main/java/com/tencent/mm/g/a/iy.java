package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class iy extends b {
    public a cEc;

    public static final class a {
        public int bFZ;
        public Intent cEd;
        public int requestCode;
    }

    public iy() {
        this((byte) 0);
    }

    private iy(byte b) {
        AppMethodBeat.i(56563);
        this.cEc = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(56563);
    }
}
