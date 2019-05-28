package com.tencent.p177mm.loader.p864g;

import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.loader.g.i */
public final class C18541i implements Runnable {
    private C9576b eQR;
    private C26365c eRp;
    private C18542a eRq;

    /* renamed from: com.tencent.mm.loader.g.i$a */
    public interface C18542a {
        /* renamed from: b */
        void mo33793b(C26365c c26365c, C45423h c45423h);
    }

    public C18541i(C26365c c26365c, C9576b c9576b, C18542a c18542a) {
        this.eRp = c26365c;
        this.eQR = c9576b;
        this.eRq = c18542a;
    }

    public final void run() {
        C26365c c26365c = this.eRp;
        C9576b c9576b = this.eQR;
        C18542a c18542a = this.eRq;
        C25052j.m39376p(c9576b, "loader");
        C25052j.m39376p(c18542a, "watch");
        c26365c.eQR = c9576b;
        c26365c.eQS = c18542a;
        c26365c.mo9026Pa();
    }
}
