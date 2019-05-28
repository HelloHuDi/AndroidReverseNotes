package com.bumptech.glide.f.a;

import android.support.v4.widget.j;

public abstract class c<Z> extends a<Z> {
    private final int height;
    private final int width;

    public c() {
        this((byte) 0);
    }

    private c(byte b) {
        this.width = j.INVALID_ID;
        this.height = j.INVALID_ID;
    }

    public final void a(d dVar) {
        if (com.bumptech.glide.h.j.aW(this.width, this.height)) {
            dVar.aV(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }
}
