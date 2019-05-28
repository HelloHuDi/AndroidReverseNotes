package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;

public final class dm extends com.tencent.mm.sdk.b.b {
    public a cwM;
    public b cwN;

    public static final class a {
        public Context context;
        public String cwz;
    }

    public static final class b {
        public boolean cwB;
        public JSONArray cwO;
    }

    public dm() {
        this((byte) 0);
    }

    private dm(byte b) {
        AppMethodBeat.i(70149);
        this.cwM = new a();
        this.cwN = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70149);
    }
}
