package com.google.android.exoplayer2.p101c.p102d;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.d.d */
final class C0840d {

    /* renamed from: com.google.android.exoplayer2.c.d.d$a */
    public static final class C0841a {
        public final int[] aSB;
        public final int aXU;
        public final long[] aXV;
        public final int[] aXW;
        public final long[] offsets;

        /* synthetic */ C0841a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, byte b) {
            this(jArr, iArr, i, jArr2, iArr2);
        }

        private C0841a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.offsets = jArr;
            this.aSB = iArr;
            this.aXU = i;
            this.aXV = jArr2;
            this.aXW = iArr2;
        }
    }

    /* renamed from: a */
    public static C0841a m1922a(int i, long[] jArr, int[] iArr, long j) {
        AppMethodBeat.m2504i(94959);
        int i2 = Utility.DEFAULT_STREAM_BUFFER_SIZE / i;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iArr.length) {
            i3++;
            i4 = C17675v.m27565bi(iArr[i3], i2) + i4;
        }
        long[] jArr2 = new long[i4];
        int[] iArr2 = new int[i4];
        int i5 = 0;
        long[] jArr3 = new long[i4];
        int[] iArr3 = new int[i4];
        int i6 = 0;
        int i7 = 0;
        for (i3 = 0; i3 < iArr.length; i3++) {
            int i8 = iArr[i3];
            long j2 = jArr[i3];
            while (i8 > 0) {
                int min = Math.min(i2, i8);
                jArr2[i7] = j2;
                iArr2[i7] = i * min;
                i5 = Math.max(i5, iArr2[i7]);
                jArr3[i7] = ((long) i6) * j;
                iArr3[i7] = 1;
                j2 += (long) iArr2[i7];
                i6 += min;
                i8 -= min;
                i7++;
            }
        }
        C0841a c0841a = new C0841a(jArr2, iArr2, i5, jArr3, iArr3, (byte) 0);
        AppMethodBeat.m2505o(94959);
        return c0841a;
    }
}
