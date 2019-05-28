package com.google.android.exoplayer2.b;

import android.support.v4.widget.j;

public abstract class a {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    public final boolean qF() {
        return dC(j.INVALID_ID);
    }

    public final boolean qG() {
        return dC(4);
    }

    public final boolean qH() {
        return dC(1);
    }

    public final void dB(int i) {
        this.flags |= i;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean dC(int i) {
        return (this.flags & i) == i;
    }
}
