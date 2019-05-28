package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.nd */
public final class C9421nd extends C4883b {
    public C9422a cJl;
    public C9423b cJm;

    /* renamed from: com.tencent.mm.g.a.nd$a */
    public static final class C9422a {
        public String appId;
        public String url;
    }

    /* renamed from: com.tencent.mm.g.a.nd$b */
    public static final class C9423b {
        public boolean cJn = false;
        public String cJo;
        public String cJp;
        public String cJq;
        public String cJr;
        public String cJs;
        public String cJt;
        public String cJu;
        public int errCode = 0;
        public String userName;
    }

    public C9421nd() {
        this((byte) 0);
    }

    private C9421nd(byte b) {
        AppMethodBeat.m2504i(56565);
        this.cJl = new C9422a();
        this.cJm = new C9423b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(56565);
    }
}
