package com.tencent.p177mm.p230g.p231a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.gp */
public final class C32562gp extends C4883b {
    public C32563a cBm;
    public C32564b cBn;

    /* renamed from: com.tencent.mm.g.a.gp$a */
    public static final class C32563a {
        public Intent intent;
    }

    /* renamed from: com.tencent.mm.g.a.gp$b */
    public static final class C32564b {
        public int cyE = 0;
    }

    public C32562gp() {
        this((byte) 0);
    }

    private C32562gp(byte b) {
        AppMethodBeat.m2504i(15776);
        this.cBm = new C32563a();
        this.cBn = new C32564b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15776);
    }
}
