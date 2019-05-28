package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.fe */
public final class C32552fe extends C4883b {
    public C32553a cyA;
    public C32554b cyB;

    /* renamed from: com.tencent.mm.g.a.fe$a */
    public static final class C32553a {
        public String bssid;
        public int cyC;
        public String ssid;
        public int version = 1;
    }

    /* renamed from: com.tencent.mm.g.a.fe$b */
    public static final class C32554b {
        public int cyD = 0;
        public int cyE = 0;
        public String cyF;
    }

    public C32552fe() {
        this((byte) 0);
    }

    private C32552fe(byte b) {
        AppMethodBeat.m2504i(15770);
        this.cyA = new C32553a();
        this.cyB = new C32554b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(15770);
    }
}
