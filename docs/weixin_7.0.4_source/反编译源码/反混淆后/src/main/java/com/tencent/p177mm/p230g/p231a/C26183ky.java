package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.ky */
public final class C26183ky extends C4883b {
    public C26184a cGQ;

    /* renamed from: com.tencent.mm.g.a.ky$a */
    public static final class C26184a {
        public Context context;
        public String group;
        public Intent intent;
        public int type = 0;
    }

    public C26183ky() {
        this((byte) 0);
    }

    private C26183ky(byte b) {
        AppMethodBeat.m2504i(54945);
        this.cGQ = new C26184a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(54945);
    }
}
