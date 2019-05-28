package com.bumptech.glide.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b {

    public static class a extends b {
        private volatile boolean aAP;

        public a() {
            super();
        }

        public final void oq() {
            AppMethodBeat.i(92626);
            if (this.aAP) {
                IllegalStateException illegalStateException = new IllegalStateException("Already released");
                AppMethodBeat.o(92626);
                throw illegalStateException;
            }
            AppMethodBeat.o(92626);
        }

        public final void ay(boolean z) {
            this.aAP = z;
        }
    }

    public abstract void ay(boolean z);

    public abstract void oq();

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }
}
