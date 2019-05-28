package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.d.m */
final class C25519m {
    public final int[] aSB;
    public final int aXU;
    public final int[] aXW;
    public final long[] aZO;
    public final long[] offsets;
    public final int sampleCount;

    public C25519m(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(95016);
        C45039a.checkArgument(iArr.length == jArr2.length);
        if (jArr.length == jArr2.length) {
            z = true;
        } else {
            z = false;
        }
        C45039a.checkArgument(z);
        if (iArr2.length != jArr2.length) {
            z2 = false;
        }
        C45039a.checkArgument(z2);
        this.offsets = jArr;
        this.aSB = iArr;
        this.aXU = i;
        this.aZO = jArr2;
        this.aXW = iArr2;
        this.sampleCount = jArr.length;
        AppMethodBeat.m2505o(95016);
    }

    /* renamed from: Q */
    public final int mo42778Q(long j) {
        AppMethodBeat.m2504i(95017);
        for (int a = C17675v.m27553a(this.aZO, j, false); a >= 0; a--) {
            if ((this.aXW[a] & 1) != 0) {
                AppMethodBeat.m2505o(95017);
                return a;
            }
        }
        AppMethodBeat.m2505o(95017);
        return -1;
    }

    /* renamed from: R */
    public final int mo42779R(long j) {
        AppMethodBeat.m2504i(95018);
        for (int a = C17675v.m27554a(this.aZO, j, true, false); a < this.aZO.length; a++) {
            if ((this.aXW[a] & 1) != 0) {
                AppMethodBeat.m2505o(95018);
                return a;
            }
        }
        AppMethodBeat.m2505o(95018);
        return -1;
    }
}
