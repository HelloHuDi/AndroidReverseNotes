package com.bumptech.glide.p791f.p1156a;

import android.support.p057v4.widget.C8415j;
import com.bumptech.glide.p095h.C45002j;

/* renamed from: com.bumptech.glide.f.a.c */
public abstract class C25456c<Z> extends C45000a<Z> {
    private final int height;
    private final int width;

    public C25456c() {
        this((byte) 0);
    }

    private C25456c(byte b) {
        this.width = C8415j.INVALID_ID;
        this.height = C8415j.INVALID_ID;
    }

    /* renamed from: a */
    public final void mo31976a(C25457d c25457d) {
        if (C45002j.m82415aW(this.width, this.height)) {
            c25457d.mo42496aV(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }
}
