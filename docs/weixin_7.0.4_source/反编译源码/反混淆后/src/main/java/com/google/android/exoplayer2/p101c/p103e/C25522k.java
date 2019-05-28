package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.e.k */
final class C25522k {

    /* renamed from: com.google.android.exoplayer2.c.e.k$a */
    public static final class C8655a {
        public final int baQ;
        public final long[] baR;
        public final int baS;
        public final boolean baT;
        public final int entries;

        public C8655a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.baQ = i;
            this.entries = i2;
            this.baR = jArr;
            this.baS = i3;
            this.baT = z;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k$b */
    public static final class C25523b {
        public final String baU;
        public final String[] baV;
        public final int length;

        public C25523b(String str, String[] strArr, int i) {
            this.baU = str;
            this.baV = strArr;
            this.length = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k$c */
    public static final class C25524c {
        public final boolean baW;
        public final int baX;
        public final int baY;
        public final int transformType;

        public C25524c(boolean z, int i, int i2, int i3) {
            this.baW = z;
            this.baX = i;
            this.transformType = i2;
            this.baY = i3;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.k$d */
    public static final class C25525d {
        public final long baZ;
        public final int bba;
        public final int bbb;
        public final int bbc;
        public final int bbd;
        public final int bbe;
        public final boolean bbf;
        public final int channels;
        public final byte[] data;
        public final long sampleRate;

        public C25525d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.baZ = j;
            this.channels = i;
            this.sampleRate = j2;
            this.bba = i2;
            this.bbb = i3;
            this.bbc = i4;
            this.bbd = i5;
            this.bbe = i6;
            this.bbf = z;
            this.data = bArr;
        }
    }

    /* renamed from: ef */
    public static int m40337ef(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m40333a(int i, C32065l c32065l, boolean z) {
        AppMethodBeat.m2504i(95061);
        C37269o c37269o;
        if (c32065l.mo52382tB() < 7) {
            if (z) {
                AppMethodBeat.m2505o(95061);
                return false;
            }
            c37269o = new C37269o("too short header: " + c32065l.mo52382tB());
            AppMethodBeat.m2505o(95061);
            throw c37269o;
        } else if (c32065l.readUnsignedByte() != i) {
            if (z) {
                AppMethodBeat.m2505o(95061);
                return false;
            }
            c37269o = new C37269o("expected header type " + Integer.toHexString(i));
            AppMethodBeat.m2505o(95061);
            throw c37269o;
        } else if (c32065l.readUnsignedByte() == 118 && c32065l.readUnsignedByte() == 111 && c32065l.readUnsignedByte() == 114 && c32065l.readUnsignedByte() == 98 && c32065l.readUnsignedByte() == 105 && c32065l.readUnsignedByte() == 115) {
            AppMethodBeat.m2505o(95061);
            return true;
        } else if (z) {
            AppMethodBeat.m2505o(95061);
            return false;
        } else {
            c37269o = new C37269o("expected characters 'vorbis'");
            AppMethodBeat.m2505o(95061);
            throw c37269o;
        }
    }

    /* renamed from: a */
    static C25524c[] m40334a(C25521i c25521i) {
        AppMethodBeat.m2504i(95062);
        int ed = c25521i.mo42780ed(6) + 1;
        C25524c[] c25524cArr = new C25524c[ed];
        for (int i = 0; i < ed; i++) {
            c25524cArr[i] = new C25524c(c25521i.mo42782rl(), c25521i.mo42780ed(16), c25521i.mo42780ed(16), c25521i.mo42780ed(8));
        }
        AppMethodBeat.m2505o(95062);
        return c25524cArr;
    }

    /* renamed from: a */
    static void m40332a(int i, C25521i c25521i) {
        AppMethodBeat.m2504i(95063);
        int ed = c25521i.mo42780ed(6) + 1;
        for (int i2 = 0; i2 < ed; i2++) {
            switch (c25521i.mo42780ed(16)) {
                case 0:
                    int ed2;
                    int i3;
                    if (c25521i.mo42782rl()) {
                        ed2 = c25521i.mo42780ed(4) + 1;
                    } else {
                        ed2 = 1;
                    }
                    if (c25521i.mo42782rl()) {
                        int ed3 = c25521i.mo42780ed(8) + 1;
                        for (i3 = 0; i3 < ed3; i3++) {
                            c25521i.mo42781ee(C25522k.m40337ef(i - 1));
                            c25521i.mo42781ee(C25522k.m40337ef(i - 1));
                        }
                    }
                    if (c25521i.mo42780ed(2) == 0) {
                        if (ed2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                c25521i.mo42781ee(4);
                            }
                        }
                        for (i3 = 0; i3 < ed2; i3++) {
                            c25521i.mo42781ee(8);
                            c25521i.mo42781ee(8);
                            c25521i.mo42781ee(8);
                        }
                        break;
                    }
                    C37269o c37269o = new C37269o("to reserved bits must be zero after mapping coupling steps");
                    AppMethodBeat.m2505o(95063);
                    throw c37269o;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95063);
    }

    /* renamed from: b */
    static void m40335b(C25521i c25521i) {
        AppMethodBeat.m2504i(95064);
        int ed = c25521i.mo42780ed(6) + 1;
        for (int i = 0; i < ed; i++) {
            if (c25521i.mo42780ed(16) > 2) {
                C37269o c37269o = new C37269o("residueType greater than 2 is not decodable");
                AppMethodBeat.m2505o(95064);
                throw c37269o;
            }
            int i2;
            int ed2;
            c25521i.mo42781ee(24);
            c25521i.mo42781ee(24);
            c25521i.mo42781ee(24);
            int ed3 = c25521i.mo42780ed(6) + 1;
            c25521i.mo42781ee(8);
            int[] iArr = new int[ed3];
            for (i2 = 0; i2 < ed3; i2++) {
                int ed4 = c25521i.mo42780ed(3);
                if (c25521i.mo42782rl()) {
                    ed2 = c25521i.mo42780ed(5);
                } else {
                    ed2 = 0;
                }
                iArr[i2] = (ed2 * 8) + ed4;
            }
            for (i2 = 0; i2 < ed3; i2++) {
                for (ed2 = 0; ed2 < 8; ed2++) {
                    if ((iArr[i2] & (1 << ed2)) != 0) {
                        c25521i.mo42781ee(8);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(95064);
    }

    /* renamed from: c */
    static void m40336c(C25521i c25521i) {
        AppMethodBeat.m2504i(95065);
        int ed = c25521i.mo42780ed(6) + 1;
        for (int i = 0; i < ed; i++) {
            int ed2 = c25521i.mo42780ed(16);
            int ed3;
            switch (ed2) {
                case 0:
                    c25521i.mo42781ee(8);
                    c25521i.mo42781ee(16);
                    c25521i.mo42781ee(16);
                    c25521i.mo42781ee(6);
                    c25521i.mo42781ee(8);
                    ed3 = c25521i.mo42780ed(4) + 1;
                    for (ed2 = 0; ed2 < ed3; ed2++) {
                        c25521i.mo42781ee(8);
                    }
                    break;
                case 1:
                    int ed4;
                    int ed5 = c25521i.mo42780ed(5);
                    ed2 = -1;
                    int[] iArr = new int[ed5];
                    for (ed3 = 0; ed3 < ed5; ed3++) {
                        iArr[ed3] = c25521i.mo42780ed(4);
                        if (iArr[ed3] > ed2) {
                            ed2 = iArr[ed3];
                        }
                    }
                    int[] iArr2 = new int[(ed2 + 1)];
                    for (ed2 = 0; ed2 < iArr2.length; ed2++) {
                        iArr2[ed2] = c25521i.mo42780ed(3) + 1;
                        ed4 = c25521i.mo42780ed(2);
                        if (ed4 > 0) {
                            c25521i.mo42781ee(8);
                        }
                        for (ed3 = 0; ed3 < (1 << ed4); ed3++) {
                            c25521i.mo42781ee(8);
                        }
                    }
                    c25521i.mo42781ee(2);
                    int ed6 = c25521i.mo42780ed(4);
                    ed2 = 0;
                    ed4 = 0;
                    for (ed3 = 0; ed3 < ed5; ed3++) {
                        ed4 += iArr2[iArr[ed3]];
                        while (ed2 < ed4) {
                            c25521i.mo42781ee(ed6);
                            ed2++;
                        }
                    }
                    break;
                default:
                    C37269o c37269o = new C37269o("floor type greater than 1 not decodable: ".concat(String.valueOf(ed2)));
                    AppMethodBeat.m2505o(95065);
                    throw c37269o;
            }
        }
        AppMethodBeat.m2505o(95065);
    }
}
