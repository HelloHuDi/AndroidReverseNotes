package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {
    private static final int aXA = v.aT("vide");
    private static final int aXB = v.aT("soun");
    private static final int aXC = v.aT("text");
    private static final int aXD = v.aT("sbtl");
    private static final int aXE = v.aT("subt");
    private static final int aXF = v.aT("clcp");
    private static final int aXG = v.aT("cenc");
    private static final int aXi = v.aT("meta");

    static final class a {
        public int aXH;
        private final boolean aXI;
        private final l aXJ;
        private final l aXK;
        private int aXL;
        private int aXM;
        public int index;
        public final int length;
        public long xb;

        public a(l lVar, l lVar2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.i(94941);
            this.aXK = lVar;
            this.aXJ = lVar2;
            this.aXI = z;
            lVar2.setPosition(12);
            this.length = lVar2.tI();
            lVar.setPosition(12);
            this.aXM = lVar.tI();
            if (lVar.readInt() != 1) {
                z2 = false;
            }
            com.google.android.exoplayer2.i.a.checkState(z2, "first_chunk must be 1");
            this.index = -1;
            AppMethodBeat.o(94941);
        }

        public final boolean rf() {
            AppMethodBeat.i(94942);
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                AppMethodBeat.o(94942);
                return false;
            }
            long tK;
            if (this.aXI) {
                tK = this.aXJ.tK();
            } else {
                tK = this.aXJ.cM();
            }
            this.xb = tK;
            if (this.index == this.aXL) {
                this.aXH = this.aXK.tI();
                this.aXK.eM(4);
                i = this.aXM - 1;
                this.aXM = i;
                this.aXL = i > 0 ? this.aXK.tI() - 1 : -1;
            }
            AppMethodBeat.o(94942);
            return true;
        }
    }

    interface b {
        int getSampleCount();

        int rg();

        boolean rh();
    }

    static final class e implements b {
        private final int aXQ = (this.aXz.tI() & 255);
        private int aXR;
        private int aXS;
        private final l aXz;
        private final int sampleCount = this.aXz.tI();

        public e(b bVar) {
            AppMethodBeat.i(94946);
            this.aXz = bVar.aXz;
            this.aXz.setPosition(12);
            AppMethodBeat.o(94946);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int rg() {
            AppMethodBeat.i(94947);
            int readUnsignedByte;
            if (this.aXQ == 8) {
                readUnsignedByte = this.aXz.readUnsignedByte();
                AppMethodBeat.o(94947);
                return readUnsignedByte;
            } else if (this.aXQ == 16) {
                readUnsignedByte = this.aXz.readUnsignedShort();
                AppMethodBeat.o(94947);
                return readUnsignedByte;
            } else {
                readUnsignedByte = this.aXR;
                this.aXR = readUnsignedByte + 1;
                if (readUnsignedByte % 2 == 0) {
                    this.aXS = this.aXz.readUnsignedByte();
                    readUnsignedByte = (this.aXS & 240) >> 4;
                    AppMethodBeat.o(94947);
                    return readUnsignedByte;
                }
                readUnsignedByte = this.aXS & 15;
                AppMethodBeat.o(94947);
                return readUnsignedByte;
            }
        }

        public final boolean rh() {
            return false;
        }
    }

    static final class d implements b {
        private final int aXP = this.aXz.tI();
        private final l aXz;
        private final int sampleCount = this.aXz.tI();

        public d(b bVar) {
            AppMethodBeat.i(94944);
            this.aXz = bVar.aXz;
            this.aXz.setPosition(12);
            AppMethodBeat.o(94944);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        public final int rg() {
            AppMethodBeat.i(94945);
            int tI;
            if (this.aXP == 0) {
                tI = this.aXz.tI();
                AppMethodBeat.o(94945);
                return tI;
            }
            tI = this.aXP;
            AppMethodBeat.o(94945);
            return tI;
        }

        public final boolean rh() {
            return this.aXP != 0;
        }
    }

    static final class c {
        public Format aOv;
        public int aTz;
        public final k[] aXN;
        public int aXO = 0;

        public c(int i) {
            AppMethodBeat.i(94943);
            this.aXN = new k[i];
            AppMethodBeat.o(94943);
        }
    }

    static final class f {
        final int aOi;
        final long duration;
        final int id;

        public f(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.aOi = i2;
        }
    }

    static {
        AppMethodBeat.i(94958);
        AppMethodBeat.o(94958);
    }

    public static j a(a aVar, b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) {
        int i;
        AppMethodBeat.i(94948);
        a dX = aVar.dX(a.aWl);
        l lVar = dX.dW(a.aWz).aXz;
        lVar.setPosition(16);
        int readInt = lVar.readInt();
        if (readInt == aXB) {
            i = 1;
        } else if (readInt == aXA) {
            i = 2;
        } else if (readInt == aXC || readInt == aXD || readInt == aXE || readInt == aXF) {
            i = 3;
        } else if (readInt == aXi) {
            i = 4;
        } else {
            i = -1;
        }
        if (i == -1) {
            AppMethodBeat.o(94948);
            return null;
        }
        int i2;
        long j2;
        long j3;
        l lVar2 = aVar.dW(a.aWv).aXz;
        lVar2.setPosition(8);
        int dT = a.dT(lVar2.readInt());
        lVar2.eM(dT == 0 ? 8 : 16);
        int readInt2 = lVar2.readInt();
        lVar2.eM(4);
        Object obj = 1;
        int i3 = lVar2.position;
        readInt = dT == 0 ? 4 : 8;
        for (i2 = 0; i2 < readInt; i2++) {
            if (lVar2.data[i3 + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            lVar2.eM(readInt);
            j2 = -9223372036854775807L;
        } else {
            j2 = dT == 0 ? lVar2.cM() : lVar2.tK();
            if (j2 == 0) {
                j2 = -9223372036854775807L;
            }
        }
        lVar2.eM(16);
        i2 = lVar2.readInt();
        dT = lVar2.readInt();
        lVar2.eM(4);
        i3 = lVar2.readInt();
        int readInt3 = lVar2.readInt();
        if (i2 == 0 && dT == 65536 && i3 == -65536 && readInt3 == 0) {
            i2 = 90;
        } else if (i2 == 0 && dT == -65536 && i3 == 65536 && readInt3 == 0) {
            i2 = 270;
        } else if (i2 == -65536 && dT == 0 && i3 == 0 && readInt3 == -65536) {
            i2 = 180;
        } else {
            i2 = 0;
        }
        f fVar = new f(readInt2, j2, i2);
        if (j == -9223372036854775807L) {
            j2 = fVar.duration;
        } else {
            j2 = j;
        }
        lVar2 = bVar.aXz;
        lVar2.setPosition(8);
        lVar2.eM(a.dT(lVar2.readInt()) == 0 ? 8 : 16);
        long cM = lVar2.cM();
        if (j2 == -9223372036854775807L) {
            j3 = -9223372036854775807L;
        } else {
            j3 = v.b(j2, 1000000, cM);
        }
        a dX2 = dX.dX(a.aWm).dX(a.aWn);
        l lVar3 = dX.dW(a.aWy).aXz;
        lVar3.setPosition(8);
        readInt3 = a.dT(lVar3.readInt());
        lVar3.eM(readInt3 == 0 ? 8 : 16);
        long cM2 = lVar3.cM();
        lVar3.eM(readInt3 == 0 ? 4 : 8);
        readInt = lVar3.readUnsignedShort();
        Pair create = Pair.create(Long.valueOf(cM2), ((char) (((readInt >> 10) & 31) + 96)) + ((char) (((readInt >> 5) & 31) + 96)) + ((char) ((readInt & 31) + 96)));
        c a = a(dX2.dW(a.aWA).aXz, fVar.id, fVar.aOi, (String) create.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair b = b(aVar.dX(a.aWw));
            jArr2 = (long[]) b.second;
            jArr = (long[]) b.first;
        }
        if (a.aOv == null) {
            AppMethodBeat.o(94948);
            return null;
        }
        j jVar = new j(fVar.id, i, ((Long) create.first).longValue(), cM, j3, a.aOv, a.aXO, a.aXN, a.aTz, jArr, jArr2);
        AppMethodBeat.o(94948);
        return jVar;
    }

    public static m a(j jVar, a aVar, i iVar) {
        b dVar;
        AppMethodBeat.i(94949);
        b dW = aVar.dW(a.aWX);
        if (dW != null) {
            dVar = new d(dW);
        } else {
            dW = aVar.dW(a.aWY);
            if (dW == null) {
                o oVar = new o("Track has no sample table size information");
                AppMethodBeat.o(94949);
                throw oVar;
            }
            dVar = new e(dW);
        }
        int sampleCount = dVar.getSampleCount();
        m mVar;
        if (sampleCount == 0) {
            mVar = new m(new long[0], new int[0], 0, new long[0], new int[0]);
            AppMethodBeat.o(94949);
            return mVar;
        }
        Object obj;
        Object obj2;
        int i;
        int i2;
        Object obj3;
        long[] jArr;
        Object obj4;
        int i3;
        Object obj5;
        boolean z = false;
        dW = aVar.dW(a.aWZ);
        if (dW == null) {
            z = true;
            dW = aVar.dW(a.aXa);
        }
        l lVar = dW.aXz;
        l lVar2 = aVar.dW(a.aWW).aXz;
        l lVar3 = aVar.dW(a.aWT).aXz;
        dW = aVar.dW(a.aWU);
        l lVar4 = dW != null ? dW.aXz : null;
        b dW2 = aVar.dW(a.aWV);
        l lVar5 = dW2 != null ? dW2.aXz : null;
        a aVar2 = new a(lVar2, lVar, z);
        lVar3.setPosition(12);
        int tI = lVar3.tI() - 1;
        int tI2 = lVar3.tI();
        int tI3 = lVar3.tI();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        if (lVar5 != null) {
            lVar5.setPosition(12);
            i5 = lVar5.tI();
        }
        int i7 = -1;
        int i8 = 0;
        if (lVar4 != null) {
            lVar4.setPosition(12);
            i8 = lVar4.tI();
            if (i8 > 0) {
                i7 = lVar4.tI() - 1;
            } else {
                lVar4 = null;
            }
        }
        if (dVar.rh() && "audio/raw".equals(jVar.aOv.aOd) && tI == 0 && r8 == 0 && i8 == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = 0;
        long j = 0;
        if (obj == null) {
            Object obj6 = new long[sampleCount];
            obj2 = new int[sampleCount];
            long[] jArr2 = new long[sampleCount];
            Object obj7 = new int[sampleCount];
            long j2 = 0;
            int i10 = 0;
            i = 0;
            i2 = i8;
            int i11 = i7;
            while (i < sampleCount) {
                int i12;
                while (i10 == 0) {
                    com.google.android.exoplayer2.i.a.checkState(aVar2.rf());
                    j2 = aVar2.xb;
                    i10 = aVar2.aXH;
                }
                if (lVar5 != null) {
                    i8 = i6;
                    i7 = i5;
                    while (i4 == 0 && i7 > 0) {
                        i4 = lVar5.tI();
                        i8 = lVar5.readInt();
                        i7--;
                    }
                    i4--;
                } else {
                    i8 = i6;
                    i7 = i5;
                }
                obj6[i] = j2;
                obj2[i] = dVar.rg();
                if (obj2[i] > i9) {
                    i9 = obj2[i];
                }
                jArr2[i] = ((long) i8) + j;
                obj7[i] = lVar4 == null ? 1 : 0;
                if (i == i11) {
                    obj7[i] = 1;
                    i6 = i2 - 1;
                    if (i6 > 0) {
                        i2 = i6;
                        i11 = lVar4.tI() - 1;
                    } else {
                        i2 = i6;
                    }
                }
                j += (long) tI3;
                i6 = tI2 - 1;
                if (i6 != 0 || tI <= 0) {
                    i12 = i6;
                } else {
                    i5 = lVar3.tI();
                    tI--;
                    tI3 = lVar3.tI();
                    i12 = i5;
                }
                j2 += (long) obj2[i];
                i10--;
                i++;
                i6 = i8;
                i5 = i7;
                tI2 = i12;
            }
            com.google.android.exoplayer2.i.a.checkArgument(i4 == 0);
            while (i5 > 0) {
                com.google.android.exoplayer2.i.a.checkArgument(lVar5.tI() == 0);
                lVar5.readInt();
                i5--;
            }
            if (!(i2 == 0 && tI2 == 0 && i10 == 0 && tI == 0)) {
                new StringBuilder("Inconsistent stbl box for track ").append(jVar.id).append(": remainingSynchronizationSamples ").append(i2).append(", remainingSamplesAtTimestampDelta ").append(tI2).append(", remainingSamplesInChunk ").append(i10).append(", remainingTimestampDeltaChanges ").append(tI);
            }
            obj3 = obj7;
            jArr = jArr2;
            obj4 = obj2;
            i3 = i9;
            obj5 = obj6;
        } else {
            long[] jArr3 = new long[aVar2.length];
            int[] iArr = new int[aVar2.length];
            while (aVar2.rf()) {
                jArr3[aVar2.index] = aVar2.xb;
                iArr[aVar2.index] = aVar2.aXH;
            }
            com.google.android.exoplayer2.c.d.d.a a = d.a(dVar.rg(), jArr3, iArr, (long) tI3);
            obj5 = a.offsets;
            obj4 = a.aSB;
            i3 = a.aXU;
            jArr = a.aXV;
            obj3 = a.aXW;
        }
        if (jVar.aZp == null || iVar.rc()) {
            v.a(jArr, jVar.aZm);
            mVar = new m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.o(94949);
            return mVar;
        }
        long b;
        if (jVar.aZp.length == 1 && jVar.type == 1 && jArr.length >= 2) {
            long j3 = jVar.aZq[0];
            b = v.b(jVar.aZp[0], jVar.aZm, jVar.aZn) + j3;
            if (jArr[0] <= j3 && j3 < jArr[1] && jArr[jArr.length - 1] < b && b <= j) {
                long j4 = j - b;
                j3 = v.b(j3 - jArr[0], (long) jVar.aOv.sampleRate, jVar.aZm);
                b = v.b(j4, (long) jVar.aOv.sampleRate, jVar.aZm);
                if (!(j3 == 0 && b == 0) && j3 <= 2147483647L && b <= 2147483647L) {
                    iVar.aOp = (int) j3;
                    iVar.aOq = (int) b;
                    v.a(jArr, jVar.aZm);
                    mVar = new m(obj5, obj4, i3, jArr, obj3);
                    AppMethodBeat.o(94949);
                    return mVar;
                }
            }
        }
        int i13;
        if (jVar.aZp.length == 1 && jVar.aZp[0] == 0) {
            for (i13 = 0; i13 < jArr.length; i13++) {
                jArr[i13] = v.b(jArr[i13] - jVar.aZq[0], 1000000, jVar.aZm);
            }
            mVar = new m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.o(94949);
            return mVar;
        }
        int i14;
        int i15;
        int i16;
        Object obj8;
        Object obj9;
        boolean z2 = jVar.type == 1;
        i4 = 0;
        tI3 = 0;
        i9 = 0;
        i5 = 0;
        while (true) {
            int i17 = i5;
            i14 = i4;
            i15 = i9;
            i16 = tI3;
            if (i17 >= jVar.aZp.length) {
                break;
            }
            j = jVar.aZq[i17];
            if (j != -1) {
                b = v.b(jVar.aZp[i17], jVar.aZm, jVar.aZn);
                i9 = v.a(jArr, j, true, true);
                tI3 = v.a(jArr, b + j, z2, false);
                i4 = i14 + (tI3 - i9);
                if (i16 != i9) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                i9 = i15 | i5;
            } else {
                i4 = i14;
                i9 = i15;
                tI3 = i16;
            }
            i5 = i17 + 1;
        }
        i = i15 | (i14 != sampleCount ? 1 : 0);
        if (i != 0) {
            obj8 = new long[i14];
        } else {
            obj8 = obj5;
        }
        if (i != 0) {
            obj9 = new int[i14];
        } else {
            obj9 = obj4;
        }
        if (i != 0) {
            i16 = 0;
        } else {
            i16 = i3;
        }
        if (i != 0) {
            obj2 = new int[i14];
        } else {
            obj2 = obj3;
        }
        long[] jArr4 = new long[i14];
        b = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < jVar.aZp.length; i19++) {
            long j5 = jVar.aZq[i19];
            long j6 = jVar.aZp[i19];
            if (j5 != -1) {
                long b2 = j5 + v.b(j6, jVar.aZm, jVar.aZn);
                i9 = v.a(jArr, j5, true, true);
                int a2 = v.a(jArr, b2, z2, false);
                if (i != 0) {
                    tI3 = a2 - i9;
                    System.arraycopy(obj5, i9, obj8, i18, tI3);
                    System.arraycopy(obj4, i9, obj9, i18, tI3);
                    System.arraycopy(obj3, i9, obj2, i18, tI3);
                }
                for (i2 = i9; i2 < a2; i2++) {
                    jArr4[i18] = v.b(jArr[i2] - j5, 1000000, jVar.aZm) + v.b(b, 1000000, jVar.aZn);
                    if (i == 0 || obj9[i18] <= i16) {
                        i9 = i16;
                    } else {
                        i9 = obj4[i2];
                    }
                    i18++;
                    i16 = i9;
                }
            }
            b += j6;
            i18 = i18;
        }
        i5 = 0;
        for (i13 = 0; i13 < obj2.length && i5 == 0; i13++) {
            i5 |= (obj2[i13] & 1) != 0 ? 1 : 0;
        }
        if (i5 == 0) {
            v.a(jArr, jVar.aZm);
            mVar = new m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.o(94949);
            return mVar;
        }
        mVar = new m(obj8, obj9, i16, jArr4, obj2);
        AppMethodBeat.o(94949);
        return mVar;
    }

    public static Metadata a(b bVar, boolean z) {
        AppMethodBeat.i(94950);
        if (z) {
            AppMethodBeat.o(94950);
            return null;
        }
        l lVar = bVar.aXz;
        lVar.setPosition(8);
        while (lVar.tB() >= 8) {
            int i = lVar.position;
            int readInt = lVar.readInt();
            if (lVar.readInt() == a.aXi) {
                lVar.setPosition(i);
                i += readInt;
                lVar.eM(12);
                while (lVar.position < i) {
                    readInt = lVar.position;
                    int readInt2 = lVar.readInt();
                    if (lVar.readInt() == a.aXj) {
                        lVar.setPosition(readInt);
                        i = readInt + readInt2;
                        lVar.eM(8);
                        List arrayList = new ArrayList();
                        while (lVar.position < i) {
                            Entry o = f.o(lVar);
                            if (o != null) {
                                arrayList.add(o);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            AppMethodBeat.o(94950);
                            return metadata;
                        }
                        AppMethodBeat.o(94950);
                        return null;
                    }
                    lVar.eM(readInt2 - 8);
                }
                AppMethodBeat.o(94950);
                return null;
            }
            lVar.eM(readInt - 8);
        }
        AppMethodBeat.o(94950);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:293:0x022e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static c a(l lVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        AppMethodBeat.i(94951);
        lVar.setPosition(12);
        int readInt = lVar.readInt();
        c cVar = new c(readInt);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < readInt) {
                int i5 = lVar.position;
                int readInt2 = lVar.readInt();
                com.google.android.exoplayer2.i.a.checkArgument(readInt2 > 0, "childAtomSize should be positive");
                i3 = lVar.readInt();
                int readUnsignedShort;
                int readUnsignedShort2;
                int i6;
                Pair a;
                int intValue;
                DrmInitData drmInitData2;
                String str2;
                String str3;
                if (i3 == a.aVI || i3 == a.aVJ || i3 == a.aWG || i3 == a.aWS || i3 == a.aVK || i3 == a.aVL || i3 == a.aVM || i3 == a.aXr || i3 == a.aXs) {
                    DrmInitData drmInitData3;
                    lVar.setPosition((i5 + 8) + 8);
                    lVar.eM(16);
                    readUnsignedShort = lVar.readUnsignedShort();
                    readUnsignedShort2 = lVar.readUnsignedShort();
                    Object obj = null;
                    float f = 1.0f;
                    lVar.eM(50);
                    i6 = lVar.position;
                    if (i3 == a.aWG) {
                        a = a(lVar, i5, readInt2);
                        if (a != null) {
                            intValue = ((Integer) a.first).intValue();
                            if (drmInitData == null) {
                                drmInitData2 = null;
                            } else {
                                drmInitData2 = drmInitData.aw(((k) a.second).aZt);
                            }
                            cVar.aXN[i4] = (k) a.second;
                            i3 = intValue;
                        } else {
                            drmInitData2 = drmInitData;
                        }
                        lVar.setPosition(i6);
                        intValue = i3;
                        drmInitData3 = drmInitData2;
                    } else {
                        intValue = i3;
                        drmInitData3 = drmInitData;
                    }
                    List list = null;
                    str2 = null;
                    byte[] bArr = null;
                    int i7 = -1;
                    while (i6 - i5 < readInt2) {
                        lVar.setPosition(i6);
                        int i8 = lVar.position;
                        int readInt3 = lVar.readInt();
                        if (readInt3 != 0 || lVar.position - i5 != readInt2) {
                            com.google.android.exoplayer2.i.a.checkArgument(readInt3 > 0, "childAtomSize should be positive");
                            i3 = lVar.readInt();
                            if (i3 == a.aWo) {
                                com.google.android.exoplayer2.i.a.checkState(str2 == null);
                                str2 = "video/avc";
                                lVar.setPosition(i8 + 8);
                                com.google.android.exoplayer2.video.a K = com.google.android.exoplayer2.video.a.K(lVar);
                                list = K.aOf;
                                cVar.aTz = K.aTz;
                                if (obj == null) {
                                    f = K.brq;
                                }
                            } else if (i3 == a.aWp) {
                                com.google.android.exoplayer2.i.a.checkState(str2 == null);
                                str2 = "video/hevc";
                                lVar.setPosition(i8 + 8);
                                com.google.android.exoplayer2.video.b M = com.google.android.exoplayer2.video.b.M(lVar);
                                list = M.aOf;
                                cVar.aTz = M.aTz;
                            } else if (i3 == a.aXt) {
                                com.google.android.exoplayer2.i.a.checkState(str2 == null);
                                str2 = intValue == a.aXr ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            } else if (i3 == a.aVN) {
                                com.google.android.exoplayer2.i.a.checkState(str2 == null);
                                str2 = "video/3gpp";
                            } else if (i3 == a.aWq) {
                                com.google.android.exoplayer2.i.a.checkState(str2 == null);
                                Pair c = c(lVar, i8);
                                str3 = (String) c.first;
                                list = Collections.singletonList(c.second);
                                str2 = str3;
                            } else if (i3 == a.aWP) {
                                lVar.setPosition(i8 + 8);
                                f = ((float) lVar.tI()) / ((float) lVar.tI());
                                int obj2 = 1;
                            } else if (i3 == a.aXp) {
                                i3 = i8 + 8;
                                while (i3 - i8 < readInt3) {
                                    lVar.setPosition(i3);
                                    int readInt4 = lVar.readInt();
                                    if (lVar.readInt() == a.aXq) {
                                        bArr = Arrays.copyOfRange(lVar.data, i3, readInt4 + i3);
                                    } else {
                                        i3 += readInt4;
                                    }
                                }
                                bArr = null;
                            } else if (i3 == a.aXo) {
                                i3 = lVar.readUnsignedByte();
                                lVar.eM(3);
                                if (i3 == 0) {
                                    switch (lVar.readUnsignedByte()) {
                                        case 0:
                                            i7 = 0;
                                            break;
                                        case 1:
                                            i7 = 1;
                                            break;
                                        case 2:
                                            i7 = 2;
                                            break;
                                        case 3:
                                            i7 = 3;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            i6 += readInt3;
                        } else if (str2 == null) {
                            cVar.aOv = Format.a(Integer.toString(i), str2, -1, readUnsignedShort, readUnsignedShort2, list, i2, f, bArr, i7, null, drmInitData3);
                        }
                    }
                    if (str2 == null) {
                    }
                } else if (i3 == a.aVP || i3 == a.aWH || i3 == a.aVU || i3 == a.aVW || i3 == a.aVY || i3 == a.aWb || i3 == a.aVZ || i3 == a.aWa || i3 == a.aXf || i3 == a.aXg || i3 == a.aVS || i3 == a.aVT || i3 == a.aVQ || i3 == a.aXv) {
                    int readUnsignedShort3;
                    int i9;
                    DrmInitData drmInitData4;
                    lVar.setPosition((i5 + 8) + 8);
                    if (z) {
                        readUnsignedShort3 = lVar.readUnsignedShort();
                        lVar.eM(6);
                        intValue = readUnsignedShort3;
                    } else {
                        lVar.eM(8);
                        intValue = 0;
                    }
                    if (intValue == 0 || intValue == 1) {
                        readUnsignedShort = lVar.readUnsignedShort();
                        lVar.eM(6);
                        byte[] bArr2 = lVar.data;
                        readUnsignedShort2 = lVar.position;
                        lVar.position = readUnsignedShort2 + 1;
                        readUnsignedShort3 = (bArr2[readUnsignedShort2] & 255) << 8;
                        byte[] bArr3 = lVar.data;
                        i9 = lVar.position;
                        lVar.position = i9 + 1;
                        readUnsignedShort3 |= bArr3[i9] & 255;
                        lVar.position += 2;
                        if (intValue == 1) {
                            lVar.eM(16);
                            intValue = readUnsignedShort3;
                        } else {
                            intValue = readUnsignedShort3;
                        }
                    } else if (intValue == 2) {
                        lVar.eM(16);
                        readUnsignedShort3 = (int) Math.round(Double.longBitsToDouble(lVar.readLong()));
                        readUnsignedShort = lVar.tI();
                        lVar.eM(20);
                        intValue = readUnsignedShort3;
                    }
                    i6 = lVar.position;
                    if (i3 == a.aWH) {
                        a = a(lVar, i5, readInt2);
                        if (a != null) {
                            readUnsignedShort2 = ((Integer) a.first).intValue();
                            if (drmInitData == null) {
                                drmInitData2 = null;
                            } else {
                                drmInitData2 = drmInitData.aw(((k) a.second).aZt);
                            }
                            cVar.aXN[i4] = (k) a.second;
                            i3 = readUnsignedShort2;
                        } else {
                            drmInitData2 = drmInitData;
                        }
                        lVar.setPosition(i6);
                        drmInitData4 = drmInitData2;
                    } else {
                        drmInitData4 = drmInitData;
                    }
                    if (i3 == a.aVU) {
                        str3 = "audio/ac3";
                    } else if (i3 == a.aVW) {
                        str3 = "audio/eac3";
                    } else if (i3 == a.aVY) {
                        str3 = "audio/vnd.dts";
                    } else if (i3 == a.aVZ || i3 == a.aWa) {
                        str3 = "audio/vnd.dts.hd";
                    } else if (i3 == a.aWb) {
                        str3 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (i3 == a.aXf) {
                        str3 = "audio/3gpp";
                    } else if (i3 == a.aXg) {
                        str3 = "audio/amr-wb";
                    } else if (i3 == a.aVS || i3 == a.aVT) {
                        str3 = "audio/raw";
                    } else if (i3 == a.aVQ) {
                        str3 = "audio/mpeg";
                    } else if (i3 == a.aXv) {
                        str3 = "audio/alac";
                    } else {
                        str3 = null;
                    }
                    Object obj3 = null;
                    str2 = str3;
                    i9 = intValue;
                    readUnsignedShort2 = readUnsignedShort;
                    while (i6 - i5 < readInt2) {
                        lVar.setPosition(i6);
                        int readInt5 = lVar.readInt();
                        com.google.android.exoplayer2.i.a.checkArgument(readInt5 > 0, "childAtomSize should be positive");
                        i3 = lVar.readInt();
                        if (i3 == a.aWq || (z && i3 == a.aVR)) {
                            Object obj4;
                            if (i3 == a.aWq) {
                                i3 = i6;
                            } else {
                                intValue = lVar.position;
                                while (intValue - i6 < readInt5) {
                                    lVar.setPosition(intValue);
                                    readUnsignedShort = lVar.readInt();
                                    com.google.android.exoplayer2.i.a.checkArgument(readUnsignedShort > 0, "childAtomSize should be positive");
                                    if (lVar.readInt() == a.aWq) {
                                        i3 = intValue;
                                    } else {
                                        intValue += readUnsignedShort;
                                    }
                                }
                                i3 = -1;
                            }
                            if (i3 != -1) {
                                Pair c2 = c(lVar, i3);
                                str2 = (String) c2.first;
                                obj4 = (byte[]) c2.second;
                                if ("audio/mp4a-latm".equals(str2)) {
                                    Pair q = com.google.android.exoplayer2.i.c.q(obj4);
                                    i9 = ((Integer) q.first).intValue();
                                    readUnsignedShort2 = ((Integer) q.second).intValue();
                                }
                            } else {
                                obj4 = obj3;
                            }
                            obj3 = obj4;
                        } else if (i3 == a.aVV) {
                            lVar.setPosition(i6 + 8);
                            cVar.aOv = com.google.android.exoplayer2.a.a.a(lVar, Integer.toString(i), str, drmInitData4);
                        } else if (i3 == a.aVX) {
                            lVar.setPosition(i6 + 8);
                            cVar.aOv = com.google.android.exoplayer2.a.a.b(lVar, Integer.toString(i), str, drmInitData4);
                        } else if (i3 == a.aWc) {
                            cVar.aOv = Format.a(Integer.toString(i), str2, -1, -1, readUnsignedShort2, i9, null, drmInitData4, str);
                        } else if (i3 == a.aXv) {
                            obj3 = new byte[readInt5];
                            lVar.setPosition(i6);
                            lVar.readBytes(obj3, 0, readInt5);
                        }
                        i6 += readInt5;
                    }
                    if (cVar.aOv == null && str2 != null) {
                        List list2;
                        int i10 = "audio/raw".equals(str2) ? 2 : -1;
                        String num = Integer.toString(i);
                        if (obj3 == null) {
                            list2 = null;
                        } else {
                            list2 = Collections.singletonList(obj3);
                        }
                        cVar.aOv = Format.a(num, str2, -1, -1, readUnsignedShort2, i9, i10, list2, drmInitData4, 0, str);
                    }
                } else if (i3 == a.aWQ || i3 == a.aXb || i3 == a.aXc || i3 == a.aXd || i3 == a.aXe) {
                    lVar.setPosition((i5 + 8) + 8);
                    List list3 = null;
                    long j = Long.MAX_VALUE;
                    if (i3 == a.aWQ) {
                        str2 = "application/ttml+xml";
                    } else if (i3 == a.aXb) {
                        str2 = "application/x-quicktime-tx3g";
                        i3 = (readInt2 - 8) - 8;
                        byte[] bArr4 = new byte[i3];
                        lVar.readBytes(bArr4, 0, i3);
                        list3 = Collections.singletonList(bArr4);
                    } else if (i3 == a.aXc) {
                        str2 = "application/x-mp4-vtt";
                    } else if (i3 == a.aXd) {
                        str2 = "application/ttml+xml";
                        j = 0;
                    } else if (i3 == a.aXe) {
                        str2 = "application/x-mp4-cea-608";
                        cVar.aXO = 1;
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(94951);
                        throw illegalStateException;
                    }
                    cVar.aOv = Format.a(Integer.toString(i), str2, 0, str, -1, null, j, list3);
                } else if (i3 == a.aXu) {
                    cVar.aOv = Format.k(Integer.toString(i), "application/x-camera-motion");
                }
                lVar.setPosition(i5 + readInt2);
                i3 = i4 + 1;
            } else {
                AppMethodBeat.o(94951);
                return cVar;
            }
        }
    }

    private static Pair<long[], long[]> b(a aVar) {
        AppMethodBeat.i(94952);
        if (aVar != null) {
            b dW = aVar.dW(a.aWx);
            if (dW != null) {
                l lVar = dW.aXz;
                lVar.setPosition(8);
                int dT = a.dT(lVar.readInt());
                int tI = lVar.tI();
                long[] jArr = new long[tI];
                long[] jArr2 = new long[tI];
                for (int i = 0; i < tI; i++) {
                    long readLong;
                    jArr[i] = dT == 1 ? lVar.tK() : lVar.cM();
                    if (dT == 1) {
                        readLong = lVar.readLong();
                    } else {
                        readLong = (long) lVar.readInt();
                    }
                    jArr2[i] = readLong;
                    byte[] bArr = lVar.data;
                    int i2 = lVar.position;
                    lVar.position = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = lVar.data;
                    int i4 = lVar.position;
                    lVar.position = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported media rate.");
                        AppMethodBeat.o(94952);
                        throw illegalArgumentException;
                    }
                    lVar.eM(2);
                }
                Pair<long[], long[]> create = Pair.create(jArr, jArr2);
                AppMethodBeat.o(94952);
                return create;
            }
        }
        Pair create2 = Pair.create(null, null);
        AppMethodBeat.o(94952);
        return create2;
    }

    private static Pair<String, byte[]> c(l lVar, int i) {
        Object obj = null;
        AppMethodBeat.i(94953);
        lVar.setPosition((i + 8) + 4);
        lVar.eM(1);
        k(lVar);
        lVar.eM(2);
        int readUnsignedByte = lVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            lVar.eM(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            lVar.eM(lVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            lVar.eM(2);
        }
        lVar.eM(1);
        k(lVar);
        Pair<String, byte[]> create;
        switch (lVar.readUnsignedByte()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 96:
            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                obj = "video/mpeg2";
                break;
            case 107:
                create = Pair.create("audio/mpeg", null);
                AppMethodBeat.o(94953);
                return create;
            case ErrorCode.STARTDOWNLOAD_6 /*165*/:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case ErrorCode.NEEDDOWNLOAD_FALSE_2 /*172*/:
                create = Pair.create("audio/vnd.dts", null);
                AppMethodBeat.o(94953);
                return create;
            case ErrorCode.NEEDDOWNLOAD_TRUE /*170*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_1 /*171*/:
                create = Pair.create("audio/vnd.dts.hd", null);
                AppMethodBeat.o(94953);
                return create;
        }
        lVar.eM(12);
        lVar.eM(1);
        readUnsignedByte = k(lVar);
        byte[] bArr = new byte[readUnsignedByte];
        lVar.readBytes(bArr, 0, readUnsignedByte);
        Pair create2 = Pair.create(obj, bArr);
        AppMethodBeat.o(94953);
        return create2;
    }

    private static Pair<Integer, k> b(l lVar, int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(94955);
        int i3 = i + 8;
        Object obj = null;
        Object obj2 = null;
        int i4 = 0;
        int i5 = -1;
        while (i3 - i < i2) {
            lVar.setPosition(i3);
            int readInt = lVar.readInt();
            int readInt2 = lVar.readInt();
            if (readInt2 == a.aWI) {
                obj = Integer.valueOf(lVar.readInt());
            } else if (readInt2 == a.aWD) {
                lVar.eM(4);
                obj2 = lVar.readString(4);
            } else if (readInt2 == a.aWE) {
                i4 = readInt;
                i5 = i3;
            }
            i3 += readInt;
        }
        if ("cenc".equals(obj2) || "cbc1".equals(obj2) || "cens".equals(obj2) || "cbcs".equals(obj2)) {
            boolean z2;
            com.google.android.exoplayer2.i.a.checkArgument(obj != null, "frma atom is mandatory");
            if (i5 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.google.android.exoplayer2.i.a.checkArgument(z2, "schi atom is mandatory");
            k a = a(lVar, i5, i4, obj2);
            if (a == null) {
                z = false;
            }
            com.google.android.exoplayer2.i.a.checkArgument(z, "tenc atom is mandatory");
            Pair create = Pair.create(obj, a);
            AppMethodBeat.o(94955);
            return create;
        }
        AppMethodBeat.o(94955);
        return null;
    }

    private static k a(l lVar, int i, int i2, String str) {
        byte[] bArr = null;
        boolean z = true;
        AppMethodBeat.i(94956);
        int i3 = i + 8;
        while (i3 - i < i2) {
            lVar.setPosition(i3);
            int readInt = lVar.readInt();
            if (lVar.readInt() == a.aWF) {
                int i4;
                int i5;
                i3 = a.dT(lVar.readInt());
                lVar.eM(1);
                if (i3 == 0) {
                    lVar.eM(1);
                    i4 = 0;
                    i5 = 0;
                } else {
                    i3 = lVar.readUnsignedByte();
                    i5 = (i3 & 240) >> 4;
                    i4 = i3 & 15;
                }
                if (lVar.readUnsignedByte() != 1) {
                    z = false;
                }
                readInt = lVar.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                lVar.readBytes(bArr2, 0, 16);
                if (z && readInt == 0) {
                    i3 = lVar.readUnsignedByte();
                    bArr = new byte[i3];
                    lVar.readBytes(bArr, 0, i3);
                }
                k kVar = new k(z, str, readInt, bArr2, i5, i4, bArr);
                AppMethodBeat.o(94956);
                return kVar;
            }
            i3 += readInt;
        }
        AppMethodBeat.o(94956);
        return null;
    }

    private static int k(l lVar) {
        AppMethodBeat.i(94957);
        int readUnsignedByte = lVar.readUnsignedByte();
        int i = readUnsignedByte & com.tencent.view.d.MIC_SketchMark;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = lVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & com.tencent.view.d.MIC_SketchMark);
        }
        AppMethodBeat.o(94957);
        return i;
    }

    private static Pair<Integer, k> a(l lVar, int i, int i2) {
        AppMethodBeat.i(94954);
        int i3 = lVar.position;
        while (true) {
            int i4 = i3;
            if (i4 - i < i2) {
                lVar.setPosition(i4);
                int readInt = lVar.readInt();
                com.google.android.exoplayer2.i.a.checkArgument(readInt > 0, "childAtomSize should be positive");
                if (lVar.readInt() == a.aWC) {
                    Pair b = b(lVar, i4, readInt);
                    if (b != null) {
                        AppMethodBeat.o(94954);
                        return b;
                    }
                }
                i3 = i4 + readInt;
            } else {
                AppMethodBeat.o(94954);
                return null;
            }
        }
    }
}
