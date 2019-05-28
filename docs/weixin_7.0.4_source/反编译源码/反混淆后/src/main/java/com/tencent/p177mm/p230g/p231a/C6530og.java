package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.og */
public final class C6530og extends C4883b {
    public C6531a cKA;

    /* renamed from: com.tencent.mm.g.a.og$a */
    public static final class C6531a {
        public int cKB;
        public SnsAdClick cKz;
        public int errorCode;
        public long timestamp;
        public String url;
    }

    public C6530og() {
        this((byte) 0);
    }

    private C6530og(byte b) {
        AppMethodBeat.m2504i(94428);
        this.cKA = new C6531a();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(94428);
    }
}
