package com.google.android.exoplayer2.p100b;

import android.support.p057v4.widget.C8415j;

/* renamed from: com.google.android.exoplayer2.b.a */
public abstract class C25513a {
    public int flags;

    public void clear() {
        this.flags = 0;
    }

    /* renamed from: qF */
    public final boolean mo42773qF() {
        return mo42772dC(C8415j.INVALID_ID);
    }

    /* renamed from: qG */
    public final boolean mo42774qG() {
        return mo42772dC(4);
    }

    /* renamed from: qH */
    public final boolean mo42775qH() {
        return mo42772dC(1);
    }

    /* renamed from: dB */
    public final void mo42771dB(int i) {
        this.flags |= i;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dC */
    public final boolean mo42772dC(int i) {
        return (this.flags & i) == i;
    }
}
