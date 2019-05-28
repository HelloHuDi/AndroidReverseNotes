package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.g.a.cr */
public final class C32527cr extends C4883b {
    public C26106a cvM;
    public C32528b cvN;

    /* renamed from: com.tencent.mm.g.a.cr$a */
    public static final class C26106a {
        public WeakReference aIq;
        public String appId;
        public Runnable callback;
        public String cvO;
        public String cvP;
        public String cvQ;
        public String cvR;
        public int cvS = 0;
        public String nonceStr;
        public String packageExt;
        public String signType;
        public String signature;
        public String token;
    }

    /* renamed from: com.tencent.mm.g.a.cr$b */
    public static final class C32528b {
        public int retCode = 0;
    }

    public C32527cr() {
        this((byte) 0);
    }

    private C32527cr(byte b) {
        AppMethodBeat.m2504i(5468);
        this.cvM = new C26106a();
        this.cvN = new C32528b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(5468);
    }
}
