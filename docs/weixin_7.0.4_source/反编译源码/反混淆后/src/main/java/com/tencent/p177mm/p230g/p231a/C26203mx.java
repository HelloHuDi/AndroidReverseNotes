package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.mx */
public final class C26203mx extends C4883b {
    public C26204a cIO;
    public C26202b cIP;

    /* renamed from: com.tencent.mm.g.a.mx$b */
    public static final class C26202b {
        public boolean cvi;
    }

    /* renamed from: com.tencent.mm.g.a.mx$a */
    public static final class C26204a {
        public String cIQ;
        public String cIR;
        public String cIS;
        public int cIT = 0;
        public int cIU = 0;
        public int opType = 0;
    }

    public C26203mx() {
        this((byte) 0);
    }

    private C26203mx(byte b) {
        AppMethodBeat.m2504i(73673);
        this.cIO = new C26204a();
        this.cIP = new C26202b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(73673);
    }
}
