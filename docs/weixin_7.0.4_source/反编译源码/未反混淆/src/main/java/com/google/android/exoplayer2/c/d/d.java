package com.google.android.exoplayer2.c.d;

import com.facebook.internal.Utility;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {

    public static final class a {
        public final int[] aSB;
        public final int aXU;
        public final long[] aXV;
        public final int[] aXW;
        public final long[] offsets;

        /* synthetic */ a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, byte b) {
            this(jArr, iArr, i, jArr2, iArr2);
        }

        private a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
            this.offsets = jArr;
            this.aSB = iArr;
            this.aXU = i;
            this.aXV = jArr2;
            this.aXW = iArr2;
        }
    }

    public static a a(int i, long[] jArr, int[] iArr, long j) {
        AppMethodBeat.i(94959);
        int i2 = Utility.DEFAULT_STREAM_BUFFER_SIZE / i;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iArr.length) {
            i3++;
            i4 = v.bi(iArr[i3], i2) + i4;
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
        a aVar = new a(jArr2, iArr2, i5, jArr3, iArr3, (byte) 0);
        AppMethodBeat.o(94959);
        return aVar;
    }
}
