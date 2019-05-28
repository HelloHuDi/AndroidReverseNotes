package com.google.android.exoplayer2.p105f.p798a;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.p105f.C32044a;

/* renamed from: com.google.android.exoplayer2.f.a.b */
final class C8670b extends C32044a implements Comparable<C8670b> {
    public final int priority;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C8670b c8670b = (C8670b) obj;
        if (c8670b.priority < this.priority) {
            return -1;
        }
        if (c8670b.priority > this.priority) {
            return 1;
        }
        return 0;
    }

    public C8670b(CharSequence charSequence, Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
        super(charSequence, alignment, f, 0, i, f2, i2, Float.MIN_VALUE, z, i3);
        this.priority = i4;
    }
}
