package com.tencent.mm.g.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class cf extends b {
    public a cvm;

    public static final class a {
        public Activity activity;
        public String ctB;
        public int cvn;
        public int cvo;
        public int cvp = 0;
        public String cvq;
        public String cvr;
        public Bundle cvs;
        public int from = -1;
        public String imagePath;
        public int scene = -1;
        public String source;
    }

    public cf() {
        this((byte) 0);
    }

    private cf(byte b) {
        AppMethodBeat.i(70137);
        this.cvm = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(70137);
    }
}
