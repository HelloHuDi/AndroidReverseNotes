package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k {

    public static final class a {
        public final int baQ;
        public final long[] baR;
        public final int baS;
        public final boolean baT;
        public final int entries;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.baQ = i;
            this.entries = i2;
            this.baR = jArr;
            this.baS = i3;
            this.baT = z;
        }
    }

    public static final class b {
        public final String baU;
        public final String[] baV;
        public final int length;

        public b(String str, String[] strArr, int i) {
            this.baU = str;
            this.baV = strArr;
            this.length = i;
        }
    }

    public static final class c {
        public final boolean baW;
        public final int baX;
        public final int baY;
        public final int transformType;

        public c(boolean z, int i, int i2, int i3) {
            this.baW = z;
            this.baX = i;
            this.transformType = i2;
            this.baY = i3;
        }
    }

    public static final class d {
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

        public d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
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

    public static int ef(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static boolean a(int i, l lVar, boolean z) {
        AppMethodBeat.i(95061);
        o oVar;
        if (lVar.tB() < 7) {
            if (z) {
                AppMethodBeat.o(95061);
                return false;
            }
            oVar = new o("too short header: " + lVar.tB());
            AppMethodBeat.o(95061);
            throw oVar;
        } else if (lVar.readUnsignedByte() != i) {
            if (z) {
                AppMethodBeat.o(95061);
                return false;
            }
            oVar = new o("expected header type " + Integer.toHexString(i));
            AppMethodBeat.o(95061);
            throw oVar;
        } else if (lVar.readUnsignedByte() == 118 && lVar.readUnsignedByte() == 111 && lVar.readUnsignedByte() == 114 && lVar.readUnsignedByte() == 98 && lVar.readUnsignedByte() == 105 && lVar.readUnsignedByte() == 115) {
            AppMethodBeat.o(95061);
            return true;
        } else if (z) {
            AppMethodBeat.o(95061);
            return false;
        } else {
            oVar = new o("expected characters 'vorbis'");
            AppMethodBeat.o(95061);
            throw oVar;
        }
    }

    static c[] a(i iVar) {
        AppMethodBeat.i(95062);
        int ed = iVar.ed(6) + 1;
        c[] cVarArr = new c[ed];
        for (int i = 0; i < ed; i++) {
            cVarArr[i] = new c(iVar.rl(), iVar.ed(16), iVar.ed(16), iVar.ed(8));
        }
        AppMethodBeat.o(95062);
        return cVarArr;
    }

    static void a(int i, i iVar) {
        AppMethodBeat.i(95063);
        int ed = iVar.ed(6) + 1;
        for (int i2 = 0; i2 < ed; i2++) {
            switch (iVar.ed(16)) {
                case 0:
                    int ed2;
                    int i3;
                    if (iVar.rl()) {
                        ed2 = iVar.ed(4) + 1;
                    } else {
                        ed2 = 1;
                    }
                    if (iVar.rl()) {
                        int ed3 = iVar.ed(8) + 1;
                        for (i3 = 0; i3 < ed3; i3++) {
                            iVar.ee(ef(i - 1));
                            iVar.ee(ef(i - 1));
                        }
                    }
                    if (iVar.ed(2) == 0) {
                        if (ed2 > 1) {
                            for (i3 = 0; i3 < i; i3++) {
                                iVar.ee(4);
                            }
                        }
                        for (i3 = 0; i3 < ed2; i3++) {
                            iVar.ee(8);
                            iVar.ee(8);
                            iVar.ee(8);
                        }
                        break;
                    }
                    o oVar = new o("to reserved bits must be zero after mapping coupling steps");
                    AppMethodBeat.o(95063);
                    throw oVar;
                default:
                    break;
            }
        }
        AppMethodBeat.o(95063);
    }

    static void b(i iVar) {
        AppMethodBeat.i(95064);
        int ed = iVar.ed(6) + 1;
        for (int i = 0; i < ed; i++) {
            if (iVar.ed(16) > 2) {
                o oVar = new o("residueType greater than 2 is not decodable");
                AppMethodBeat.o(95064);
                throw oVar;
            }
            int i2;
            int ed2;
            iVar.ee(24);
            iVar.ee(24);
            iVar.ee(24);
            int ed3 = iVar.ed(6) + 1;
            iVar.ee(8);
            int[] iArr = new int[ed3];
            for (i2 = 0; i2 < ed3; i2++) {
                int ed4 = iVar.ed(3);
                if (iVar.rl()) {
                    ed2 = iVar.ed(5);
                } else {
                    ed2 = 0;
                }
                iArr[i2] = (ed2 * 8) + ed4;
            }
            for (i2 = 0; i2 < ed3; i2++) {
                for (ed2 = 0; ed2 < 8; ed2++) {
                    if ((iArr[i2] & (1 << ed2)) != 0) {
                        iVar.ee(8);
                    }
                }
            }
        }
        AppMethodBeat.o(95064);
    }

    static void c(i iVar) {
        AppMethodBeat.i(95065);
        int ed = iVar.ed(6) + 1;
        for (int i = 0; i < ed; i++) {
            int ed2 = iVar.ed(16);
            int ed3;
            switch (ed2) {
                case 0:
                    iVar.ee(8);
                    iVar.ee(16);
                    iVar.ee(16);
                    iVar.ee(6);
                    iVar.ee(8);
                    ed3 = iVar.ed(4) + 1;
                    for (ed2 = 0; ed2 < ed3; ed2++) {
                        iVar.ee(8);
                    }
                    break;
                case 1:
                    int ed4;
                    int ed5 = iVar.ed(5);
                    ed2 = -1;
                    int[] iArr = new int[ed5];
                    for (ed3 = 0; ed3 < ed5; ed3++) {
                        iArr[ed3] = iVar.ed(4);
                        if (iArr[ed3] > ed2) {
                            ed2 = iArr[ed3];
                        }
                    }
                    int[] iArr2 = new int[(ed2 + 1)];
                    for (ed2 = 0; ed2 < iArr2.length; ed2++) {
                        iArr2[ed2] = iVar.ed(3) + 1;
                        ed4 = iVar.ed(2);
                        if (ed4 > 0) {
                            iVar.ee(8);
                        }
                        for (ed3 = 0; ed3 < (1 << ed4); ed3++) {
                            iVar.ee(8);
                        }
                    }
                    iVar.ee(2);
                    int ed6 = iVar.ed(4);
                    ed2 = 0;
                    ed4 = 0;
                    for (ed3 = 0; ed3 < ed5; ed3++) {
                        ed4 += iArr2[iArr[ed3]];
                        while (ed2 < ed4) {
                            iVar.ee(ed6);
                            ed2++;
                        }
                    }
                    break;
                default:
                    o oVar = new o("floor type greater than 1 not decodable: ".concat(String.valueOf(ed2)));
                    AppMethodBeat.o(95065);
                    throw oVar;
            }
        }
        AppMethodBeat.o(95065);
    }
}
