package com.tencent.mm.g.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fh extends com.tencent.mm.sdk.b.b {
    public a cyW;
    public b cyX;

    public static final class a {
        public String[] cyY;
    }

    public static final class b {
        public int cyD = 0;
        public MatrixCursor cyZ;
    }

    public fh() {
        this((byte) 0);
    }

    private fh(byte b) {
        AppMethodBeat.i(15771);
        this.cyW = new a();
        this.cyX = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(15771);
    }
}
