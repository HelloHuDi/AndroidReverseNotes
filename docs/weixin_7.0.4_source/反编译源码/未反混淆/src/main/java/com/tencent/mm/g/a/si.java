package com.tencent.mm.g.a;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class si extends com.tencent.mm.sdk.b.b {
    public a cOC;
    public b cOD;

    public static final class a {
        public Intent cOE;
        public Activity czX;
        public int requestCode;
    }

    public static final class b {
        public boolean cxT;
    }

    public si() {
        this((byte) 0);
    }

    private si(byte b) {
        AppMethodBeat.i(61711);
        this.cOC = new a();
        this.cOD = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(61711);
    }
}
