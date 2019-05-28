package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.g.a.kq */
public final class C6507kq extends C4883b {
    public C6509a cGy;
    public C6508b cGz;

    /* renamed from: com.tencent.mm.g.a.kq$b */
    public static final class C6508b {
        public int errCode;
    }

    /* renamed from: com.tencent.mm.g.a.kq$a */
    public static final class C6509a {
        public boolean cFT = false;
        public String cGA;
        public String chatroomName;
    }

    public C6507kq() {
        this((byte) 0);
    }

    private C6507kq(byte b) {
        AppMethodBeat.m2504i(128345);
        this.cGy = new C6509a();
        this.cGz = new C6508b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(128345);
    }
}
