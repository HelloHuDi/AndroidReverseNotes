package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mb extends b {
    public a cHS;

    public static final class a {
        public String aIm;
        public int action;
        public String appId;
        public boolean cHT;
        public int duration;
        public int errCode;
        public String filePath;
        public int fileSize;
        public byte[] frameBuffer;
        public String state;
    }

    public mb() {
        this((byte) 0);
    }

    private mb(byte b) {
        AppMethodBeat.i(105580);
        this.cHS = new a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.o(105580);
    }
}
