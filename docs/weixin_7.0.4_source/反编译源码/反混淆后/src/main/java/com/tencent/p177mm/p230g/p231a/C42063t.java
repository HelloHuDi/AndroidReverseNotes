package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C17874a;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C41729d;

/* renamed from: com.tencent.mm.g.a.t */
public final class C42063t {
    public Runnable callback;
    public C42064a csI;
    public C37800b csJ;

    /* renamed from: com.tencent.mm.g.a.t$b */
    public static final class C37800b {
        public int count;
        public boolean csN;
        public C41729d csO;
    }

    /* renamed from: com.tencent.mm.g.a.t$a */
    public static final class C42064a {
        public int action;
        public String appId;
        public String ckD;
        public int csK;
        public C17875b csL;
        public C17874a csM;
        public String processName;
    }

    public C42063t() {
        this((byte) 0);
    }

    private C42063t(byte b) {
        AppMethodBeat.m2504i(137223);
        this.callback = null;
        this.csI = new C42064a();
        this.csJ = new C37800b();
        this.callback = null;
        AppMethodBeat.m2505o(137223);
    }
}
