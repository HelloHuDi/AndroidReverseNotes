package com.google.android.exoplayer2.f.e;

import android.support.v4.widget.j;

final class c {
    public final float bkW;
    public final int bkX;
    public final float bkY;
    public final String id;
    public final int lineType;
    public final float width;

    public c() {
        this(null, Float.MIN_VALUE, Float.MIN_VALUE, j.INVALID_ID, j.INVALID_ID, Float.MIN_VALUE);
    }

    public c(String str, float f, float f2, int i, int i2, float f3) {
        this.id = str;
        this.bkY = f;
        this.bkW = f2;
        this.lineType = i;
        this.bkX = i2;
        this.width = f3;
    }
}
