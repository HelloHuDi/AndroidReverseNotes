package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class j {
    public static final byte[] bqY = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] brl = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object brm = new Object();
    private static int[] brn = new int[10];

    public static final class b {
        public final int bro;
        public final float brq;
        public final boolean brr;
        public final boolean brs;
        public final int brt;
        public final int bru;
        public final int brv;
        public final boolean brw;
        public final int height;
        public final int width;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.bro = i;
            this.width = i2;
            this.height = i3;
            this.brq = f;
            this.brr = z;
            this.brs = z2;
            this.brt = i4;
            this.bru = i5;
            this.brv = i6;
            this.brw = z3;
        }
    }

    public static final class a {
        public final int bcu;
        public final int bro;
        public final boolean brp;

        public a(int i, int i2, boolean z) {
            this.bcu = i;
            this.bro = i2;
            this.brp = z;
        }
    }

    static {
        AppMethodBeat.i(95892);
        AppMethodBeat.o(95892);
    }

    public static int j(byte[] bArr, int i) {
        int i2;
        AppMethodBeat.i(95886);
        synchronized (brm) {
            int i3;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i) {
                while (i5 < i - 2) {
                    try {
                        if (bArr[i5] == (byte) 0 && bArr[i5 + 1] == (byte) 0 && bArr[i5 + 2] == (byte) 3) {
                            break;
                        }
                        i5++;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(95886);
                        }
                    }
                }
                i5 = i;
                if (i5 < i) {
                    if (brn.length <= i4) {
                        int[] iArr = brn;
                        brn = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    i3 = i4 + 1;
                    brn[i4] = i5;
                    i5 += 3;
                    i4 = i3;
                }
            }
            i2 = i - i4;
            i5 = 0;
            int i6 = 0;
            for (i3 = 0; i3 < i4; i3++) {
                int i7 = brn[i3] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i7);
                i5 += i7;
                int i8 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i8 + 1;
                bArr[i8] = (byte) 0;
                i6 += i7 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        AppMethodBeat.o(95886);
        return i2;
    }

    public static void i(ByteBuffer byteBuffer) {
        AppMethodBeat.i(95887);
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (i + 1 < position) {
            int i3 = byteBuffer.get(i) & 255;
            if (i2 == 3) {
                if (i3 == 1 && (byteBuffer.get(i + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(i - 3);
                    duplicate.limit(position);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    AppMethodBeat.o(95887);
                    return;
                }
            } else if (i3 == 0) {
                i2++;
            }
            if (i3 != 0) {
                i2 = 0;
            }
            i++;
        }
        byteBuffer.clear();
        AppMethodBeat.o(95887);
    }

    public static boolean b(String str, byte b) {
        AppMethodBeat.i(95888);
        if (("video/avc".equals(str) && (b & 31) == 6) || ("video/hevc".equals(str) && ((b & 126) >> 1) == 39)) {
            AppMethodBeat.o(95888);
            return true;
        }
        AppMethodBeat.o(95888);
        return false;
    }

    public static int k(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int l(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static b k(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        float f;
        b bVar;
        AppMethodBeat.i(95889);
        m mVar = new m(bArr, i, i2);
        mVar.ee(8);
        int ed = mVar.ed(8);
        mVar.ee(16);
        int tO = mVar.tO();
        int i7 = 1;
        boolean z2 = false;
        if (ed == 100 || ed == 110 || ed == 122 || ed == 244 || ed == 44 || ed == 83 || ed == 86 || ed == 118 || ed == 128 || ed == 138) {
            int tO2 = mVar.tO();
            if (tO2 == 3) {
                z2 = mVar.rl();
            }
            mVar.tO();
            mVar.tO();
            mVar.tz();
            if (mVar.rl()) {
                i7 = tO2 != 3 ? 8 : 12;
                for (i3 = 0; i3 < i7; i3++) {
                    if (mVar.rl()) {
                        int i8;
                        if (i3 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        ed = 8;
                        i4 = 8;
                        for (i5 = 0; i5 < i8; i5++) {
                            if (i4 != 0) {
                                i4 = ((mVar.tN() + ed) + 256) % 256;
                            }
                            if (i4 != 0) {
                                ed = i4;
                            }
                        }
                    }
                }
            }
            z = z2;
            i7 = tO2;
        } else {
            z = false;
        }
        i3 = mVar.tO() + 4;
        i5 = mVar.tO();
        int i9 = 0;
        boolean z3 = false;
        if (i5 == 0) {
            i9 = mVar.tO() + 4;
        } else if (i5 == 1) {
            z3 = mVar.rl();
            mVar.tN();
            mVar.tN();
            long tO3 = (long) mVar.tO();
            for (i6 = 0; ((long) i6) < tO3; i6++) {
                mVar.tO();
            }
        }
        mVar.tO();
        mVar.tz();
        ed = mVar.tO() + 1;
        i4 = mVar.tO() + 1;
        boolean rl = mVar.rl();
        i6 = (2 - (rl ? 1 : 0)) * i4;
        if (!rl) {
            mVar.tz();
        }
        mVar.tz();
        i4 = ed * 16;
        int i10 = i6 * 16;
        if (mVar.rl()) {
            int tO4 = mVar.tO();
            int tO5 = mVar.tO();
            int tO6 = mVar.tO();
            int tO7 = mVar.tO();
            if (i7 == 0) {
                i7 = 1;
                i6 = 2 - (rl ? 1 : 0);
            } else {
                i6 = (2 - (rl ? 1 : 0)) * (i7 == 1 ? 2 : 1);
                i7 = i7 == 3 ? 1 : 2;
            }
            i7 = i4 - (i7 * (tO4 + tO5));
            ed = i10 - (i6 * (tO6 + tO7));
        } else {
            i7 = i4;
            ed = i10;
        }
        float f2 = 1.0f;
        if (mVar.rl() && mVar.rl()) {
            i4 = mVar.ed(8);
            if (i4 == 255) {
                i4 = mVar.ed(16);
                i10 = mVar.ed(16);
                if (!(i4 == 0 || i10 == 0)) {
                    f2 = ((float) i4) / ((float) i10);
                }
                f = f2;
            } else if (i4 < brl.length) {
                f = brl[i4];
            }
            bVar = new b(tO, i7, ed, f, z, rl, i3, i5, i9, z3);
            AppMethodBeat.o(95889);
            return bVar;
        }
        f = 1.0f;
        bVar = new b(tO, i7, ed, f, z, rl, i3, i5, i9, z3);
        AppMethodBeat.o(95889);
        return bVar;
    }

    public static a m(byte[] bArr, int i) {
        AppMethodBeat.i(95890);
        m mVar = new m(bArr, 3, i);
        mVar.ee(8);
        int tO = mVar.tO();
        int tO2 = mVar.tO();
        mVar.tz();
        a aVar = new a(tO, tO2, mVar.rl());
        AppMethodBeat.o(95890);
        return aVar;
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z = true;
        AppMethodBeat.i(95891);
        int i3 = i2 - i;
        a.checkState(i3 >= 0);
        if (i3 == 0) {
            AppMethodBeat.o(95891);
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                b(zArr);
                i2 = i - 3;
                AppMethodBeat.o(95891);
                return i2;
            } else if (i3 > 1 && zArr[1] && bArr[i] == (byte) 1) {
                b(zArr);
                i2 = i - 2;
                AppMethodBeat.o(95891);
                return i2;
            } else if (i3 > 2 && zArr[2] && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 1) {
                b(zArr);
                i2 = i - 1;
                AppMethodBeat.o(95891);
                return i2;
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            if ((bArr[i5] & d.MIC_PTU_ZIPAI_LIGHTRED) == 0) {
                if (bArr[i5 - 2] == (byte) 0 && bArr[i5 - 1] == (byte) 0 && bArr[i5] == (byte) 1) {
                    if (zArr != null) {
                        b(zArr);
                    }
                    i2 = i5 - 2;
                    AppMethodBeat.o(95891);
                    return i2;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr != null) {
            boolean z2 = i3 > 2 ? bArr[i2 + -3] == (byte) 0 && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : i3 == 2 ? zArr[2] && bArr[i2 - 2] == (byte) 0 && bArr[i2 - 1] == (byte) 1 : zArr[1] && bArr[i2 - 1] == (byte) 1;
            zArr[0] = z2;
            z2 = i3 > 1 ? bArr[i2 + -2] == (byte) 0 && bArr[i2 - 1] == (byte) 0 : zArr[2] && bArr[i2 - 1] == (byte) 0;
            zArr[1] = z2;
            if (bArr[i2 - 1] != (byte) 0) {
                z = false;
            }
            zArr[2] = z;
        }
        AppMethodBeat.o(95891);
        return i2;
    }

    public static void b(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
