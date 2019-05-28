package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.lv */
public final class C18316lv extends C4883b {
    public C18318a cHD;
    public C18317b cHE;

    /* renamed from: com.tencent.mm.g.a.lv$b */
    public static final class C18317b {
        public String aIm;
        public int cBS = 0;
        public String cBU;
        public String cBV;
        public String cHI;
        public int cHJ = 0;
        public int errCode = -1;
    }

    /* renamed from: com.tencent.mm.g.a.lv$a */
    public static final class C18318a {
        public String cBT;
        public int cHF = 0;
        public int cHG = 0;
        public Runnable cHH;
    }

    public C18316lv() {
        this((byte) 0);
    }

    private C18316lv(byte b) {
        AppMethodBeat.m2504i(114182);
        this.cHD = new C18318a();
        this.cHE = new C18317b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(114182);
    }
}
