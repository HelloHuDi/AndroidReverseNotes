package com.tencent.p177mm.p230g.p231a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.qh */
public final class C42041qh extends C4883b {
    public C9450a cMw;
    public C26218b cMx;

    /* renamed from: com.tencent.mm.g.a.qh$a */
    public static final class C9450a {
        public Intent intent;
        public String username;
    }

    /* renamed from: com.tencent.mm.g.a.qh$b */
    public static final class C26218b {
    }

    public C42041qh() {
        this((byte) 0);
    }

    private C42041qh(byte b) {
        AppMethodBeat.m2504i(73674);
        this.cMw = new C9450a();
        this.cMx = new C26218b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(73674);
    }
}
