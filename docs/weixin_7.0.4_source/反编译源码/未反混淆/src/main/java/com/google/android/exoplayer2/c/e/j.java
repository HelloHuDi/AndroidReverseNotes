package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e.k.b;
import com.google.android.exoplayer2.c.e.k.c;
import com.google.android.exoplayer2.c.e.k.d;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

final class j extends h {
    private a baH;
    private int baI;
    private boolean baJ;
    private d baK;
    private b baL;

    static final class a {
        public final b baL;
        public final d baM;
        public final byte[] baN;
        public final c[] baO;
        public final int baP;

        public a(d dVar, b bVar, byte[] bArr, c[] cVarArr, int i) {
            this.baM = dVar;
            this.baL = bVar;
            this.baN = bArr;
            this.baO = cVarArr;
            this.baP = i;
        }
    }

    j() {
    }

    public static boolean r(l lVar) {
        AppMethodBeat.i(95056);
        try {
            boolean a = k.a(1, lVar, true);
            AppMethodBeat.o(95056);
            return a;
        } catch (o e) {
            AppMethodBeat.o(95056);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.i(95057);
        super.reset(z);
        if (z) {
            this.baH = null;
            this.baK = null;
            this.baL = null;
        }
        this.baI = 0;
        this.baJ = false;
        AppMethodBeat.o(95057);
    }

    /* Access modifiers changed, original: protected|final */
    public final void V(long j) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(95058);
        super.V(j);
        if (j != 0) {
            z = true;
        } else {
            z = false;
        }
        this.baJ = z;
        if (this.baK != null) {
            i = this.baK.bbd;
        }
        this.baI = i;
        AppMethodBeat.o(95058);
    }

    /* Access modifiers changed, original: protected|final */
    public final long s(l lVar) {
        int i = 0;
        AppMethodBeat.i(95059);
        if ((lVar.data[0] & 1) == 1) {
            AppMethodBeat.o(95059);
            return -1;
        }
        int i2;
        byte b = lVar.data[0];
        a aVar = this.baH;
        if (aVar.baO[(b >> 1) & (255 >>> (8 - aVar.baP))].baW) {
            i2 = aVar.baM.bbe;
        } else {
            i2 = aVar.baM.bbd;
        }
        if (this.baJ) {
            i = (this.baI + i2) / 4;
        }
        long j = (long) i;
        lVar.eL(lVar.limit + 4);
        lVar.data[lVar.limit - 4] = (byte) ((int) (j & 255));
        lVar.data[lVar.limit - 3] = (byte) ((int) ((j >>> 8) & 255));
        lVar.data[lVar.limit - 2] = (byte) ((int) ((j >>> 16) & 255));
        lVar.data[lVar.limit - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.baJ = true;
        this.baI = i2;
        long j2 = (long) i;
        AppMethodBeat.o(95059);
        return j2;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(l lVar, long j, a aVar) {
        AppMethodBeat.i(95060);
        if (this.baH != null) {
            AppMethodBeat.o(95060);
            return false;
        }
        a aVar2;
        long tE;
        int tF;
        int tF2;
        int tF3;
        int readUnsignedByte;
        int i;
        o oVar;
        if (this.baK == null) {
            k.a(1, lVar, false);
            long tE2 = lVar.tE();
            int readUnsignedByte2 = lVar.readUnsignedByte();
            tE = lVar.tE();
            tF = lVar.tF();
            tF2 = lVar.tF();
            tF3 = lVar.tF();
            readUnsignedByte = lVar.readUnsignedByte();
            this.baK = new d(tE2, readUnsignedByte2, tE, tF, tF2, tF3, (int) Math.pow(2.0d, (double) (readUnsignedByte & 15)), (int) Math.pow(2.0d, (double) ((readUnsignedByte & 240) >> 4)), (lVar.readUnsignedByte() & 1) > 0, Arrays.copyOf(lVar.data, lVar.limit));
            aVar2 = null;
        } else if (this.baL == null) {
            k.a(3, lVar, false);
            String readString = lVar.readString((int) lVar.tE());
            readUnsignedByte = readString.length() + 11;
            tE = lVar.tE();
            String[] strArr = new String[((int) tE)];
            readUnsignedByte += 4;
            for (i = 0; ((long) i) < tE; i++) {
                readUnsignedByte += 4;
                strArr[i] = lVar.readString((int) lVar.tE());
                readUnsignedByte += strArr[i].length();
            }
            if ((lVar.readUnsignedByte() & 1) == 0) {
                oVar = new o("framing bit expected to be set");
                AppMethodBeat.o(95060);
                throw oVar;
            }
            this.baL = new b(readString, strArr, readUnsignedByte + 1);
            aVar2 = null;
        } else {
            byte[] bArr = new byte[lVar.limit];
            System.arraycopy(lVar.data, 0, bArr, 0, lVar.limit);
            int i2 = this.baK.channels;
            k.a(5, lVar, false);
            int readUnsignedByte3 = lVar.readUnsignedByte() + 1;
            i iVar = new i(lVar.data);
            iVar.ee(lVar.position * 8);
            for (tF3 = 0; tF3 < readUnsignedByte3; tF3++) {
                if (iVar.ed(24) != 5653314) {
                    oVar = new o("expected code book to start with [0x56, 0x43, 0x42] at " + ((iVar.baF * 8) + iVar.baG));
                    AppMethodBeat.o(95060);
                    throw oVar;
                }
                int ed;
                i = iVar.ed(16);
                int ed2 = iVar.ed(24);
                long[] jArr = new long[ed2];
                boolean rl = iVar.rl();
                if (rl) {
                    ed = iVar.ed(5) + 1;
                    readUnsignedByte = 0;
                    while (readUnsignedByte < jArr.length) {
                        tF2 = iVar.ed(k.ef(ed2 - readUnsignedByte));
                        for (tF = 0; tF < tF2 && readUnsignedByte < jArr.length; tF++) {
                            jArr[readUnsignedByte] = (long) ed;
                            readUnsignedByte++;
                        }
                        ed++;
                    }
                } else {
                    boolean rl2 = iVar.rl();
                    for (readUnsignedByte = 0; readUnsignedByte < jArr.length; readUnsignedByte++) {
                        if (!rl2 || iVar.rl()) {
                            jArr[readUnsignedByte] = (long) (iVar.ed(5) + 1);
                        } else {
                            jArr[readUnsignedByte] = 0;
                        }
                    }
                }
                ed = iVar.ed(4);
                if (ed > 2) {
                    oVar = new o("lookup type greater than 2 not decodable: ".concat(String.valueOf(ed)));
                    AppMethodBeat.o(95060);
                    throw oVar;
                }
                if (ed == 1 || ed == 2) {
                    long j2;
                    iVar.ee(32);
                    iVar.ee(32);
                    readUnsignedByte = iVar.ed(4) + 1;
                    iVar.ee(1);
                    if (ed != 1) {
                        j2 = (long) (ed2 * i);
                    } else if (i != 0) {
                        j2 = (long) Math.floor(Math.pow((double) ((long) ed2), 1.0d / ((double) ((long) i))));
                    } else {
                        j2 = 0;
                    }
                    iVar.ee((int) (j2 * ((long) readUnsignedByte)));
                }
                com.google.android.exoplayer2.c.e.k.a aVar3 = new com.google.android.exoplayer2.c.e.k.a(i, ed2, jArr, ed, rl);
            }
            i = iVar.ed(6) + 1;
            for (readUnsignedByte = 0; readUnsignedByte < i; readUnsignedByte++) {
                if (iVar.ed(16) != 0) {
                    oVar = new o("placeholder of time domain transforms not zeroed out");
                    AppMethodBeat.o(95060);
                    throw oVar;
                }
            }
            k.c(iVar);
            k.b(iVar);
            k.a(i2, iVar);
            c[] a = k.a(iVar);
            if (iVar.rl()) {
                aVar2 = new a(this.baK, this.baL, bArr, a, k.ef(a.length - 1));
            } else {
                oVar = new o("framing bit after modes not set as expected");
                AppMethodBeat.o(95060);
                throw oVar;
            }
        }
        this.baH = aVar2;
        if (this.baH == null) {
            AppMethodBeat.o(95060);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.baH.baM.data);
        arrayList.add(this.baH.baN);
        aVar.aOv = Format.a(null, "audio/vorbis", this.baH.baM.bbb, -1, this.baH.baM.channels, (int) this.baH.baM.sampleRate, arrayList, null, null);
        AppMethodBeat.o(95060);
        return true;
    }
}
