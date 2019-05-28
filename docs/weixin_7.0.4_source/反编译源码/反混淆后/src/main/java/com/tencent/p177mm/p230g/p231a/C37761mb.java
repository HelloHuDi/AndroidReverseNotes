package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.mb */
public final class C37761mb extends C4883b {
    public C26194a cHS;

    /* renamed from: com.tencent.mm.g.a.mb$a */
    public static final class C26194a {
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

    public C37761mb() {
        this((byte) 0);
    }

    private C37761mb(byte b) {
        AppMethodBeat.m2504i(105580);
        this.cHS = new C26194a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(105580);
    }
}
