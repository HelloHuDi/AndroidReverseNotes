package com.tencent.mm.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aar;

public final class ge extends com.tencent.mm.sdk.b.b {
    public a cAt;
    public b cAu;

    public static final class a {
        public boolean cAA = true;
        public aar cAv;
        public ImageView cAw;
        public int cAx;
        public boolean cAy = false;
        public boolean cAz = false;
        public Context context;
        public long cvv;
        public int height;
        public int maxWidth;
        public int opType = 3;
        public int width;
    }

    public static final class b {
        public Bitmap cAB;
        public int ret = -1;
    }

    public ge() {
        this((byte) 0);
    }

    private ge(byte b) {
        AppMethodBeat.i(51336);
        this.cAt = new a();
        this.cAu = new b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(51336);
    }
}
