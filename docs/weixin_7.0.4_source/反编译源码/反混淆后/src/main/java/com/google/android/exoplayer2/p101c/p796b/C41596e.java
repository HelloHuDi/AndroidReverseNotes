package com.google.android.exoplayer2.p101c.p796b;

import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.b.e */
final class C41596e {
    final C32065l aTj = new C32065l(8);
    int aVo;

    public C41596e() {
        AppMethodBeat.m2504i(94915);
        AppMethodBeat.m2505o(94915);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final long mo66733d(C45026f c45026f) {
        int i = 0;
        AppMethodBeat.m2504i(94916);
        c45026f.mo59479b(this.aTj.data, 0, 1);
        int i2 = this.aTj.data[0] & 255;
        if (i2 == 0) {
            AppMethodBeat.m2505o(94916);
            return Long.MIN_VALUE;
        }
        int i3 = 0;
        int i4 = 128;
        while ((i2 & i4) == 0) {
            i4 >>= 1;
            i3++;
        }
        int i5 = (i4 ^ -1) & i2;
        c45026f.mo59479b(this.aTj.data, 1, i3);
        while (i < i3) {
            i5 = (i5 << 8) + (this.aTj.data[i + 1] & 255);
            i++;
        }
        this.aVo += i3 + 1;
        long j = (long) i5;
        AppMethodBeat.m2505o(94916);
        return j;
    }
}
