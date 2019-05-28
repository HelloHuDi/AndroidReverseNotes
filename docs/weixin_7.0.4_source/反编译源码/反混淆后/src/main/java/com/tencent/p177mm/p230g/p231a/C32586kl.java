package com.tencent.p177mm.p230g.p231a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.g.a.kl */
public final class C32586kl extends C4883b {
    public C32587a cGf;
    public C26182b cGg;

    /* renamed from: com.tencent.mm.g.a.kl$b */
    public static final class C26182b {
        public int errCode;
    }

    /* renamed from: com.tencent.mm.g.a.kl$a */
    public static final class C32587a {
        public boolean cFT = false;
        public LinkedList<String> cGh;
        public String chatroomName;
        public int scene = 0;
    }

    public C32586kl() {
        this((byte) 0);
    }

    private C32586kl(byte b) {
        AppMethodBeat.m2504i(128343);
        this.cGf = new C32587a();
        this.cGg = new C26182b();
        this.xxG = false;
        this.callback = null;
        AppMethodBeat.m2505o(128343);
    }
}
