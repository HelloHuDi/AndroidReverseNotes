package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class gt extends b {
    public a cBv;

    public static final class a {
        public int actionCode;
        public String appId;
        public Context context;
        public String extMsg;
        public String messageAction;
        public String messageExt;
        public int scene;
    }

    public gt() {
        this((byte) 0);
    }

    private gt(byte b) {
        AppMethodBeat.i(70194);
        this.cBv = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70194);
    }
}
