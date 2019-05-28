package com.tencent.mm.g.a;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;

public final class ie extends com.tencent.mm.sdk.b.b {
    public a cDf;
    public b cDg;

    public static final class b {
    }

    public static final class a {
        public ImageView cDh;
        public ImageView cDi;
        public ProgressBar cDj;
        public int cDk;
        public bi csG;
        public int h;
        public int w;
    }

    public ie() {
        this((byte) 0);
    }

    private ie(byte b) {
        AppMethodBeat.i(113284);
        this.cDf = new a();
        this.cDg = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(113284);
    }
}
