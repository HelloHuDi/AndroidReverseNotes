package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.a;

final class b extends a implements Comparable<b> {
    public final int priority;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (bVar.priority < this.priority) {
            return -1;
        }
        if (bVar.priority > this.priority) {
            return 1;
        }
        return 0;
    }

    public b(CharSequence charSequence, Alignment alignment, float f, int i, float f2, int i2, boolean z, int i3, int i4) {
        super(charSequence, alignment, f, 0, i, f2, i2, Float.MIN_VALUE, z, i3);
        this.priority = i4;
    }
}
