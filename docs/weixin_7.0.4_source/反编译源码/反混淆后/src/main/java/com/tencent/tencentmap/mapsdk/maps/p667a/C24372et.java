package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.et */
public final class C24372et {
    /* renamed from: a */
    private static byte[] f4681a = new byte[]{Byte.MIN_VALUE, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: b */
    private long[] f4682b = new long[4];
    /* renamed from: c */
    private long[] f4683c = new long[2];
    /* renamed from: d */
    private byte[] f4684d = new byte[64];
    /* renamed from: e */
    private byte[] f4685e = new byte[16];

    public C24372et() {
        AppMethodBeat.m2504i(98828);
        m37722a();
        AppMethodBeat.m2505o(98828);
    }

    /* renamed from: a */
    private void m37722a() {
        this.f4683c[0] = 0;
        this.f4683c[1] = 0;
        this.f4682b[0] = 1732584193;
        this.f4682b[1] = 4023233417L;
        this.f4682b[2] = 2562383102L;
        this.f4682b[3] = 271733878;
    }

    /* renamed from: a */
    private static void m37725a(byte[] bArr, long[] jArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            bArr[i2] = (byte) ((int) (jArr[i3] & 255));
            bArr[i2 + 1] = (byte) ((int) ((jArr[i3] >>> 8) & 255));
            bArr[i2 + 2] = (byte) ((int) ((jArr[i3] >>> 16) & 255));
            bArr[i2 + 3] = (byte) ((int) ((jArr[i3] >>> 24) & 255));
            i2 += 4;
            i3++;
        }
    }

    /* renamed from: a */
    private long m37720a(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j3) | ((-1 ^ j2) & j4)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    /* renamed from: b */
    private long m37727b(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 & j4) | ((-1 ^ j4) & j3)) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    /* renamed from: c */
    private long m37728c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = ((((j2 ^ j3) ^ j4) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    /* renamed from: d */
    private long m37729d(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = (((((-1 ^ j4) | j2) ^ j3) + j5) + j7) + j;
        return ((long) ((((int) j8) >>> ((int) (32 - j6))) | (((int) j8) << ((int) j6)))) + j2;
    }

    /* renamed from: a */
    private boolean m37726a(InputStream inputStream, long j) {
        int i = 0;
        AppMethodBeat.m2504i(98829);
        byte[] bArr = new byte[64];
        int i2 = ((int) (this.f4683c[0] >>> 3)) & 63;
        long[] jArr = this.f4683c;
        long j2 = jArr[0] + (j << 3);
        jArr[0] = j2;
        if (j2 < (j << 3)) {
            jArr = this.f4683c;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.f4683c;
        jArr[1] = jArr[1] + (j >>> 29);
        int i3 = 64 - i2;
        if (j >= ((long) i3)) {
            byte[] bArr2 = new byte[i3];
            try {
                inputStream.read(bArr2, 0, i3);
                byte[] bArr3 = this.f4684d;
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr3[i2 + i4] = bArr2[i4 + 0];
                }
                m37723a(this.f4684d);
                while (((long) (i3 + 63)) < j) {
                    try {
                        inputStream.read(bArr);
                        m37723a(bArr);
                        i3 += 64;
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(98829);
                        return false;
                    }
                }
                i2 = 0;
            } catch (Exception e2) {
                AppMethodBeat.m2505o(98829);
                return false;
            }
        }
        i3 = 0;
        byte[] bArr4 = new byte[((int) (j - ((long) i3)))];
        try {
            inputStream.read(bArr4);
            byte[] bArr5 = this.f4684d;
            int length = bArr4.length;
            while (i < length) {
                bArr5[i2 + i] = bArr4[i + 0];
                i++;
            }
            AppMethodBeat.m2505o(98829);
            return true;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(98829);
            return false;
        }
    }

    /* renamed from: a */
    private void m37724a(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(98830);
        byte[] bArr2 = new byte[64];
        int i3 = ((int) (this.f4683c[0] >>> 3)) & 63;
        long[] jArr = this.f4683c;
        long j = jArr[0] + ((long) (i << 3));
        jArr[0] = j;
        if (j < ((long) (i << 3))) {
            jArr = this.f4683c;
            jArr[1] = jArr[1] + 1;
        }
        jArr = this.f4683c;
        jArr[1] = jArr[1] + ((long) (i >>> 29));
        int i4 = 64 - i3;
        if (i >= i4) {
            byte[] bArr3 = this.f4684d;
            for (int i5 = 0; i5 < i4; i5++) {
                bArr3[i3 + i5] = bArr[i5 + 0];
            }
            m37723a(this.f4684d);
            while (i4 + 63 < i) {
                for (i3 = 0; i3 < 64; i3++) {
                    bArr2[i3 + 0] = bArr[i4 + i3];
                }
                m37723a(bArr2);
                i4 += 64;
            }
            i3 = 0;
        } else {
            i4 = 0;
        }
        byte[] bArr4 = this.f4684d;
        int i6 = i - i4;
        while (i2 < i6) {
            bArr4[i3 + i2] = bArr[i4 + i2];
            i2++;
        }
        AppMethodBeat.m2505o(98830);
    }

    /* renamed from: a */
    private void m37723a(byte[] bArr) {
        AppMethodBeat.m2504i(98831);
        long j = this.f4682b[0];
        long j2 = this.f4682b[1];
        long j3 = this.f4682b[2];
        long j4 = this.f4682b[3];
        long[] jArr = new long[16];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            long j5;
            long j6;
            if (i3 < 64) {
                byte b = bArr[i3];
                if (b < (byte) 0) {
                    j5 = (long) (b & 255);
                } else {
                    j5 = (long) b;
                }
                byte b2 = bArr[i3 + 1];
                if (b2 < (byte) 0) {
                    j6 = (long) (b2 & 255);
                } else {
                    j6 = (long) b2;
                }
                j6 = (j6 << 8) | j5;
                b = bArr[i3 + 2];
                if (b < (byte) 0) {
                    j5 = (long) (b & 255);
                } else {
                    j5 = (long) b;
                }
                j6 |= j5 << 16;
                i2 = bArr[i3 + 3];
                if (i2 < 0) {
                    i2 &= 255;
                }
                jArr[i4] = (((long) i2) << 24) | j6;
                i = i4 + 1;
                i2 = i3 + 4;
            } else {
                long a = m37720a(j, j2, j3, j4, jArr[0], 7, 3614090360L);
                long a2 = m37720a(j4, a, j2, j3, jArr[1], 12, 3905402710L);
                j6 = m37720a(j3, a2, a, j2, jArr[2], 17, 606105819);
                long a3 = m37720a(j2, j6, a2, a, jArr[3], 22, 3250441966L);
                long a4 = m37720a(a, a3, j6, a2, jArr[4], 7, 4118548399L);
                long a5 = m37720a(a2, a4, a3, j6, jArr[5], 12, 1200080426);
                j2 = m37720a(j6, a5, a4, a3, jArr[6], 17, 2821735955L);
                long a6 = m37720a(a3, j2, a5, a4, jArr[7], 22, 4249261313L);
                long a7 = m37720a(a4, a6, j2, a5, jArr[8], 7, 1770035416);
                a3 = m37720a(a5, a7, a6, j2, jArr[9], 12, 2336552879L);
                j2 = m37720a(j2, a3, a7, a6, jArr[10], 17, 4294925233L);
                long a8 = m37720a(a6, j2, a3, a7, jArr[11], 22, 2304563134L);
                long a9 = m37720a(a7, a8, j2, a3, jArr[12], 7, 1804603682);
                a6 = m37720a(a3, a9, a8, j2, jArr[13], 12, 4254626195L);
                j2 = m37720a(j2, a6, a9, a8, jArr[14], 17, 2792965006L);
                j6 = m37720a(a8, j2, a6, a9, jArr[15], 22, 1236535329);
                a9 = m37727b(a9, j6, j2, a6, jArr[1], 5, 4129170786L);
                j3 = m37727b(a6, a9, j6, j2, jArr[6], 9, 3225465664L);
                a2 = m37727b(j2, j3, a9, j6, jArr[11], 14, 643717713);
                a8 = m37727b(j6, a2, j3, a9, jArr[0], 20, 3921069994L);
                j4 = m37727b(a9, a8, a2, j3, jArr[5], 5, 3593408605L);
                a = m37727b(j3, j4, a8, a2, jArr[10], 9, 38016083);
                long b3 = m37727b(a2, a, j4, a8, jArr[15], 14, 3634488961L);
                j6 = m37727b(a8, b3, a, j4, jArr[4], 20, 3889429448L);
                a5 = m37727b(j4, j6, b3, a, jArr[9], 5, 568446438);
                long b4 = m37727b(a, a5, j6, b3, jArr[14], 9, 3275163606L);
                a2 = m37727b(b3, b4, a5, j6, jArr[3], 14, 4107603335L);
                a4 = m37727b(j6, a2, b4, a5, jArr[8], 20, 1163531501);
                long b5 = m37727b(a5, a4, a2, b4, jArr[13], 5, 2850285829L);
                a = m37727b(b4, b5, a4, a2, jArr[2], 9, 4243563512L);
                a3 = m37727b(a2, a, b5, a4, jArr[7], 14, 1735328473);
                long b6 = m37727b(a4, a3, a, b5, jArr[12], 20, 2368359562L);
                a5 = m37728c(b5, b6, a3, a, jArr[5], 4, 4294588738L);
                a7 = m37728c(a, a5, b6, a3, jArr[8], 11, 2272392833L);
                long c = m37728c(a3, a7, a5, b6, jArr[11], 16, 1839030562);
                a4 = m37728c(b6, c, a7, a5, jArr[14], 23, 4259657740L);
                a6 = m37728c(a5, a4, c, a7, jArr[1], 4, 2763975236L);
                long c2 = m37728c(a7, a6, a4, c, jArr[4], 11, 1272893353);
                a3 = m37728c(c, c2, a6, a4, jArr[7], 16, 4139469664L);
                a9 = m37728c(a4, a3, c2, a6, jArr[10], 23, 3200236656L);
                long c3 = m37728c(a6, a9, a3, c2, jArr[13], 4, 681279174);
                a7 = m37728c(c2, c3, a9, a3, jArr[0], 11, 3936430074L);
                a8 = m37728c(a3, a7, c3, a9, jArr[3], 16, 3572445317L);
                long c4 = m37728c(a9, a8, a7, c3, jArr[6], 23, 76029189);
                a6 = m37728c(c3, c4, a8, a7, jArr[9], 4, 3654602809L);
                b3 = m37728c(a7, a6, c4, a8, jArr[12], 11, 3873151461L);
                long c5 = m37728c(a8, b3, a6, c4, jArr[15], 16, 530742520);
                a9 = m37728c(c4, c5, b3, a6, jArr[2], 23, 3299628645L);
                b4 = m37729d(a6, a9, c5, b3, jArr[0], 6, 4096336452L);
                long d = m37729d(b3, b4, a9, c5, jArr[7], 10, 1126891415);
                a8 = m37729d(c5, d, b4, a9, jArr[14], 15, 2878612391L);
                b5 = m37729d(a9, a8, d, b4, jArr[5], 21, 4237533241L);
                long d2 = m37729d(b4, b5, a8, d, jArr[12], 6, 1700485571);
                b3 = m37729d(d, d2, b5, a8, jArr[3], 10, 2399980690L);
                b6 = m37729d(a8, b3, d2, b5, jArr[10], 15, 4293915773L);
                long d3 = m37729d(b5, b6, b3, d2, jArr[1], 21, 2240044497L);
                b4 = m37729d(d2, d3, b6, b3, jArr[8], 6, 1873313359);
                c = m37729d(b3, b4, d3, b6, jArr[15], 10, 4264355552L);
                long d4 = m37729d(b6, c, b4, d3, jArr[6], 15, 2734768916L);
                b5 = m37729d(d3, d4, c, b4, jArr[13], 21, 1309151649);
                c2 = m37729d(b4, b5, d4, c, jArr[4], 6, 4149444226L);
                long d5 = m37729d(c, c2, b5, d4, jArr[11], 10, 3174756917L);
                b6 = m37729d(d4, d5, c2, b5, jArr[2], 15, 718787259);
                j5 = m37729d(b5, b6, d5, c2, jArr[9], 21, 3951481745L);
                long[] jArr2 = this.f4682b;
                jArr2[0] = jArr2[0] + c2;
                jArr2 = this.f4682b;
                jArr2[1] = j5 + jArr2[1];
                long[] jArr3 = this.f4682b;
                jArr3[2] = jArr3[2] + b6;
                jArr3 = this.f4682b;
                jArr3[3] = jArr3[3] + d5;
                AppMethodBeat.m2505o(98831);
                return;
            }
        }
    }

    /* renamed from: a */
    public static String m37721a(String str) {
        byte[] bytes;
        AppMethodBeat.m2504i(98832);
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        C24372et c24372et = new C24372et();
        c24372et.m37722a();
        c24372et.m37726a(new ByteArrayInputStream(bytes), (long) bytes.length);
        byte[] bArr = new byte[8];
        C24372et.m37725a(bArr, c24372et.f4683c, 8);
        int i = ((int) (c24372et.f4683c[0] >>> 3)) & 63;
        if (i < 56) {
            i = 56 - i;
        } else {
            i = 120 - i;
        }
        c24372et.m37724a(f4681a, i);
        c24372et.m37724a(bArr, 8);
        C24372et.m37725a(c24372et.f4685e, c24372et.f4682b, 16);
        byte[] bArr2 = c24372et.f4685e;
        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < 16; i++) {
            byte b = bArr2[i];
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            stringBuilder.append(new String(new char[]{cArr[(b >>> 4) & 15], cArr[b & 15]}));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98832);
        return stringBuilder2;
    }
}
