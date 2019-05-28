package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.g.a.pr */
public final class C6538pr extends C4883b {
    public C6539a cLS;
    public C6540b cLT;

    /* renamed from: com.tencent.mm.g.a.pr$a */
    public static final class C6539a {
        public WeakReference aIq;
        public String cLU;
        public Runnable callback;
        public int scene;
        public int type;
    }

    /* renamed from: com.tencent.mm.g.a.pr$b */
    public static final class C6540b {
        public String aIm;
        public int actionType;
        public String cLV;
    }

    public C6538pr() {
        this((byte) 0);
    }

    private C6538pr(byte b) {
        AppMethodBeat.m2504i(56574);
        this.cLS = new C6539a();
        this.cLT = new C6540b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(56574);
    }
}
