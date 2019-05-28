package com.tencent.mm.g.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;

public final class jh extends com.tencent.mm.sdk.b.b {
    public a cEy;
    public b cEz;

    public static final class b {
        public String path;
    }

    public static final class a {
        public int cEA = 0;
        public float cEB = 0.0f;
        public float cEC = 0.0f;
        public int cED = 0;
        public m cwn;
        public String filename;
        public int height = 0;
        public String imgPath;
        public View view;
        public int width = 0;
    }

    public jh() {
        this((byte) 0);
    }

    private jh(byte b) {
        AppMethodBeat.i(51339);
        this.cEy = new a();
        this.cEz = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51339);
    }
}
