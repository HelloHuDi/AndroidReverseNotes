package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.on */
public final class C6533on extends C4883b {
    public C6534a cKQ;

    /* renamed from: com.tencent.mm.g.a.on$a */
    public static final class C6534a {
        public Context context;
        public Intent intent;
    }

    public C6533on() {
        this((byte) 0);
    }

    private C6533on(byte b) {
        AppMethodBeat.m2504i(56571);
        this.cKQ = new C6534a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(56571);
    }
}
