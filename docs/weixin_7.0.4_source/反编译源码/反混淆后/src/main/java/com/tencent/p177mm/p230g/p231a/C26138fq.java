package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fq */
public final class C26138fq extends C4883b {
    public C1539a czB;
    public C1540b czC;

    /* renamed from: com.tencent.mm.g.a.fq$a */
    public static final class C1539a {
        public String czD;
        public int czE = 0;
        public Runnable czF;
        public String fileName;
        public int from = 0;
        public int scene;
    }

    /* renamed from: com.tencent.mm.g.a.fq$b */
    public static final class C1540b {
        public boolean bcU;
        public String content;
        public int state = 0;
    }

    public C26138fq() {
        this((byte) 0);
    }

    private C26138fq(byte b) {
        AppMethodBeat.m2504i(70187);
        this.czB = new C1539a();
        this.czC = new C1540b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(70187);
    }
}
