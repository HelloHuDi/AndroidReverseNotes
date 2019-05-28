package com.tencent.p177mm.p230g.p231a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.oo */
public final class C9431oo extends C4883b {
    public C9432a cKR;
    public C9433b cKS;

    /* renamed from: com.tencent.mm.g.a.oo$a */
    public static final class C9432a {
        public String cKT;
        public String cKU;
        public Activity czX;
        public String packageName;
        public int requestCode;
        public int scene;
    }

    /* renamed from: com.tencent.mm.g.a.oo$b */
    public static final class C9433b {
        public boolean cKV;
        public Bundle extras;
    }

    public C9431oo() {
        this((byte) 0);
    }

    private C9431oo(byte b) {
        AppMethodBeat.m2504i(77562);
        this.cKR = new C9432a();
        this.cKS = new C9433b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(77562);
    }
}
