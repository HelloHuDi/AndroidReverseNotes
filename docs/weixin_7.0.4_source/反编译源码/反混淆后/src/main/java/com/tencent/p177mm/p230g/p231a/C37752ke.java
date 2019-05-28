package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ke */
public final class C37752ke extends C4883b {
    public C9394a cFH;

    /* renamed from: com.tencent.mm.g.a.ke$a */
    public static final class C9394a {
        public String aIm;
        public int action;
        public String appId;
        public C9058e cFB;
        public String cFI;
        public boolean cFJ;
        public boolean cFK = false;
        public long duration;
        public int errCode;
        public String state;
    }

    public C37752ke() {
        this((byte) 0);
    }

    private C37752ke(byte b) {
        AppMethodBeat.m2504i(137227);
        this.cFH = new C9394a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(137227);
    }
}
