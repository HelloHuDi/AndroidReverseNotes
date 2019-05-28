package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ki */
public final class C9399ki extends C4883b {
    public C9400a cFO;
    public C9401b cFP;

    /* renamed from: com.tencent.mm.g.a.ki$a */
    public static final class C9400a {
        public Runnable cFQ;
        public Activity czX;
    }

    /* renamed from: com.tencent.mm.g.a.ki$b */
    public static final class C9401b {
        public boolean cvi = false;
    }

    public C9399ki() {
        this((byte) 0);
    }

    private C9399ki(byte b) {
        AppMethodBeat.m2504i(73672);
        this.cFO = new C9400a();
        this.cFP = new C9401b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(73672);
    }
}
