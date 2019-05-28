package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ur extends com.tencent.mm.sdk.b.b {
    public a cRv;
    public b cRw;

    public static final class a {
        public Activity activity;
        public int cRx;
    }

    public static final class b {
        public Object data = Integer.valueOf(0);

        public b() {
            AppMethodBeat.i(61712);
            AppMethodBeat.o(61712);
        }
    }

    public ur() {
        this((byte) 0);
    }

    private ur(byte b) {
        AppMethodBeat.i(61713);
        this.cRv = new a();
        this.cRw = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(61713);
    }
}
