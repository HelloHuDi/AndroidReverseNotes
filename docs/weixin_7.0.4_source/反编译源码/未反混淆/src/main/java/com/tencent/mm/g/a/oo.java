package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oo extends com.tencent.mm.sdk.b.b {
    public a cKR;
    public b cKS;

    public static final class a {
        public String cKT;
        public String cKU;
        public Activity czX;
        public String packageName;
        public int requestCode;
        public int scene;
    }

    public static final class b {
        public boolean cKV;
        public Bundle extras;
    }

    public oo() {
        this((byte) 0);
    }

    private oo(byte b) {
        AppMethodBeat.i(77562);
        this.cKR = new a();
        this.cKS = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(77562);
    }
}
