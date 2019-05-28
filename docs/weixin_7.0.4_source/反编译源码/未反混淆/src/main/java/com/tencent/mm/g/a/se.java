package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;

public final class se extends com.tencent.mm.sdk.b.b {
    public a cOf;
    public b cOg;

    public static final class a {
        public String appId;
        public int axy;
        public String cOh;
        public int cOi;
        public String cOj;
        public String cOk;
        public boolean cOl;
        public boolean cOm = true;
        public LaunchParamsOptional cOn = new LaunchParamsOptional();
        public int cOo;
        public Runnable cOp;
        public int cOq;
        public String cOr;
        public String cOs;
        public String cOt;
        public String cOu;
        public String cOv;
        public Context context;
        public String cst;
        public Bundle cvs;
        public int scene;
        public String userName;

        public a() {
            AppMethodBeat.i(114900);
            AppMethodBeat.o(114900);
        }
    }

    public static final class b {
        public boolean cOw;
        public String cOx;
    }

    public se() {
        this((byte) 0);
    }

    private se(byte b) {
        AppMethodBeat.i(114901);
        this.cOf = new a();
        this.cOg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(114901);
    }
}
