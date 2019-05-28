package com.tencent.mm.g.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.sdk.b.b;

public final class oq extends b {
    public a cKZ;

    public static final class a {
        public byte[] cLa;
        public Rect cLb;
        public r cLc;
        public int height = -1;
        public int rotate = 90;
        public int width = -1;
    }

    public oq() {
        this((byte) 0);
    }

    private oq(byte b) {
        AppMethodBeat.i(28);
        this.cKZ = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(28);
    }
}
