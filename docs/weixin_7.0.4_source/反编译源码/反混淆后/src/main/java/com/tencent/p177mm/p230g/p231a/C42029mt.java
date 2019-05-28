package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.mt */
public final class C42029mt extends C4883b {
    public C1558a cIE;
    public C1559b cIF;

    /* renamed from: com.tencent.mm.g.a.mt$a */
    public static final class C1558a {
        public String cIG;
        public Context context;
        public int opType = 0;
    }

    /* renamed from: com.tencent.mm.g.a.mt$b */
    public static final class C1559b {
        public String cIH;
        public boolean cvi = false;
        public String thumbPath;
    }

    public C42029mt() {
        this((byte) 0);
    }

    private C42029mt(byte b) {
        AppMethodBeat.m2504i(135761);
        this.cIE = new C1558a();
        this.cIF = new C1559b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(135761);
    }
}
