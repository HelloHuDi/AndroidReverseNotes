package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.uk */
public final class C26252uk extends C4883b {
    public C26253a cQC;
    public C26254b cQD;

    /* renamed from: com.tencent.mm.g.a.uk$a */
    public static final class C26253a {
        public String action;
        public String appId;
        public String buffer;
        public String cQE;
        public String cQF;
        public int cQG;
        public String cvO;
        public String nonceStr;
        public String signType;
        public String url;
    }

    /* renamed from: com.tencent.mm.g.a.uk$b */
    public static final class C26254b {
        public String buffer;
        public Runnable cQH;
        public int retCode;
    }

    public C26252uk() {
        this((byte) 0);
    }

    private C26252uk(byte b) {
        AppMethodBeat.m2504i(5472);
        this.cQC = new C26253a();
        this.cQD = new C26254b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(5472);
    }
}
