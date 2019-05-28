package com.tencent.p177mm.p230g.p231a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.le */
public final class C26189le extends C4883b {
    public C9409a cHe;
    public C26188b cHf;

    /* renamed from: com.tencent.mm.g.a.le$a */
    public static final class C9409a {
        public int cAO = 0;
        public int cAP = 0;
        public String cGW;
        public Bundle cGZ;
        public String cHg;
        public long cHh = 0;
        public Context context;
        public int itemType = 0;
        public String jsonString;
        public int type = 0;
    }

    /* renamed from: com.tencent.mm.g.a.le$b */
    public static final class C26188b {
        public int ret = 0;
    }

    public C26189le() {
        this((byte) 0);
    }

    private C26189le(byte b) {
        AppMethodBeat.m2504i(51341);
        this.cHe = new C9409a();
        this.cHf = new C26188b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(51341);
    }
}
