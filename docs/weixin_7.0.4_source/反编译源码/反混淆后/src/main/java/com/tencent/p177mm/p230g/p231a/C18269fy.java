package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fy */
public final class C18269fy extends C4883b {
    public C9347a cAb;
    public C18270b cAc;

    /* renamed from: com.tencent.mm.g.a.fy$a */
    public static final class C9347a {
        public int cAd = 0;
        public int state = -1;
        public String talker;
    }

    /* renamed from: com.tencent.mm.g.a.fy$b */
    public static final class C18270b {
        public int state = -1;
    }

    public C18269fy() {
        this((byte) 0);
    }

    private C18269fy(byte b) {
        AppMethodBeat.m2504i(102509);
        this.cAb = new C9347a();
        this.cAc = new C18270b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(102509);
    }
}
