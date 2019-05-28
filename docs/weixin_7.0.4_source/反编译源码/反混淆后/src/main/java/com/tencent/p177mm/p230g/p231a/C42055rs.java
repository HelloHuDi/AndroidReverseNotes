package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.C28508d;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.rs */
public final class C42055rs extends C4883b {
    public C26236a cNH;
    public C42054b cNI;

    /* renamed from: com.tencent.mm.g.a.rs$a */
    public static final class C26236a {
        public baa cNJ;
        public Runnable cNK;
        public C28508d cNL;
        public String cNp;
        public int scene;
    }

    /* renamed from: com.tencent.mm.g.a.rs$b */
    public static final class C42054b {
        public int result;
    }

    public C42055rs() {
        this((byte) 0);
    }

    private C42055rs(byte b) {
        AppMethodBeat.m2504i(60266);
        this.cNH = new C26236a();
        this.cNI = new C42054b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(60266);
    }
}
