package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j extends com.tencent.mm.sdk.b.b {
    public a csb;
    public b csc;

    public static final class b {
        public Bundle csg;
    }

    public static final class a {
        public int actionCode;
        public Context context;
        public String csd;
        public boolean cse;
        public boolean csf;
    }

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        AppMethodBeat.i(77529);
        this.csb = new a();
        this.csc = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77529);
    }
}
