package com.tencent.mm.g.a;

import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class ij extends b {
    public a cDv;

    public static final class a {
        public com.tencent.mm.protocal.b.a.b cDw;
        public OnClickListener cDx;
        public OnClickListener cDy;
        public int type = 0;
    }

    public ij() {
        this((byte) 0);
    }

    private ij(byte b) {
        AppMethodBeat.i(105574);
        this.cDv = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(105574);
    }
}
