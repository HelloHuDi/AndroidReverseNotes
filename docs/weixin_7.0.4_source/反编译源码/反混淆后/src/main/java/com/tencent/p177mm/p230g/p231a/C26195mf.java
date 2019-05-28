package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.mf */
public final class C26195mf extends C4883b {
    public C1557a cHZ;
    public C18324b cIa;

    /* renamed from: com.tencent.mm.g.a.mf$a */
    public static final class C1557a {
        public int cIb;
        public Context context;
        public int cvp = 0;
        public int scene;
        public String source;
        public String url;
    }

    /* renamed from: com.tencent.mm.g.a.mf$b */
    public static final class C18324b {
        public int ret = 0;
    }

    public C26195mf() {
        this((byte) 0);
    }

    private C26195mf(byte b) {
        AppMethodBeat.m2504i(56564);
        this.cHZ = new C1557a();
        this.cIa = new C18324b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(56564);
    }
}
