package com.bumptech.glide.p095h.p1136a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.h.a.b */
public abstract class C41574b {

    /* renamed from: com.bumptech.glide.h.a.b$a */
    public static class C17561a extends C41574b {
        private volatile boolean aAP;

        public C17561a() {
            super();
        }

        /* renamed from: oq */
        public final void mo31993oq() {
            AppMethodBeat.m2504i(92626);
            if (this.aAP) {
                IllegalStateException illegalStateException = new IllegalStateException("Already released");
                AppMethodBeat.m2505o(92626);
                throw illegalStateException;
            }
            AppMethodBeat.m2505o(92626);
        }

        /* renamed from: ay */
        public final void mo31992ay(boolean z) {
            this.aAP = z;
        }
    }

    /* renamed from: ay */
    public abstract void mo31992ay(boolean z);

    /* renamed from: oq */
    public abstract void mo31993oq();

    /* synthetic */ C41574b(byte b) {
        this();
    }

    private C41574b() {
    }
}
