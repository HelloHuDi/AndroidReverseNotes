package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public final class dn extends com.tencent.mm.sdk.b.b {
    public a cwP;
    public b cwQ;

    public static final class a {
        public Context context;
        public String cwz;
    }

    public static final class b {
        public boolean cwB;
        public JSONArray cwO;
    }

    public dn() {
        this((byte) 0);
    }

    private dn(byte b) {
        AppMethodBeat.i(70150);
        this.cwP = new a();
        this.cwQ = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70150);
    }
}
