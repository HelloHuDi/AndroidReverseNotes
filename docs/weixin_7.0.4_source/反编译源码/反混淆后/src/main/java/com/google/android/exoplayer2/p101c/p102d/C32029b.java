package com.google.android.exoplayer2.p101c.p102d;

import android.util.Pair;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.p099a.C32018a;
import com.google.android.exoplayer2.p101c.C17644i;
import com.google.android.exoplayer2.p101c.p102d.C0840d.C0841a;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32026a;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32027b;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32062c;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.video.C37284a;
import com.google.android.exoplayer2.video.C45053b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.d.b */
final class C32029b {
    private static final int aXA = C17675v.m27562aT("vide");
    private static final int aXB = C17675v.m27562aT("soun");
    private static final int aXC = C17675v.m27562aT("text");
    private static final int aXD = C17675v.m27562aT("sbtl");
    private static final int aXE = C17675v.m27562aT("subt");
    private static final int aXF = C17675v.m27562aT("clcp");
    private static final int aXG = C17675v.m27562aT("cenc");
    private static final int aXi = C17675v.m27562aT("meta");

    /* renamed from: com.google.android.exoplayer2.c.d.b$a */
    static final class C0837a {
        public int aXH;
        private final boolean aXI;
        private final C32065l aXJ;
        private final C32065l aXK;
        private int aXL;
        private int aXM;
        public int index;
        public final int length;
        /* renamed from: xb */
        public long f1033xb;

        public C0837a(C32065l c32065l, C32065l c32065l2, boolean z) {
            boolean z2 = true;
            AppMethodBeat.m2504i(94941);
            this.aXK = c32065l;
            this.aXJ = c32065l2;
            this.aXI = z;
            c32065l2.setPosition(12);
            this.length = c32065l2.mo52389tI();
            c32065l.setPosition(12);
            this.aXM = c32065l.mo52389tI();
            if (c32065l.readInt() != 1) {
                z2 = false;
            }
            C45039a.checkState(z2, "first_chunk must be 1");
            this.index = -1;
            AppMethodBeat.m2505o(94941);
        }

        /* renamed from: rf */
        public final boolean mo2544rf() {
            AppMethodBeat.m2504i(94942);
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                AppMethodBeat.m2505o(94942);
                return false;
            }
            long tK;
            if (this.aXI) {
                tK = this.aXJ.mo52391tK();
            } else {
                tK = this.aXJ.mo52366cM();
            }
            this.f1033xb = tK;
            if (this.index == this.aXL) {
                this.aXH = this.aXK.mo52389tI();
                this.aXK.mo52369eM(4);
                i = this.aXM - 1;
                this.aXM = i;
                this.aXL = i > 0 ? this.aXK.mo52389tI() - 1 : -1;
            }
            AppMethodBeat.m2505o(94942);
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b$b */
    interface C0838b {
        int getSampleCount();

        /* renamed from: rg */
        int mo2546rg();

        /* renamed from: rh */
        boolean mo2547rh();
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b$e */
    static final class C6264e implements C0838b {
        private final int aXQ = (this.aXz.mo52389tI() & 255);
        private int aXR;
        private int aXS;
        private final C32065l aXz;
        private final int sampleCount = this.aXz.mo52389tI();

        public C6264e(C32027b c32027b) {
            AppMethodBeat.m2504i(94946);
            this.aXz = c32027b.aXz;
            this.aXz.setPosition(12);
            AppMethodBeat.m2505o(94946);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        /* renamed from: rg */
        public final int mo2546rg() {
            AppMethodBeat.m2504i(94947);
            int readUnsignedByte;
            if (this.aXQ == 8) {
                readUnsignedByte = this.aXz.readUnsignedByte();
                AppMethodBeat.m2505o(94947);
                return readUnsignedByte;
            } else if (this.aXQ == 16) {
                readUnsignedByte = this.aXz.readUnsignedShort();
                AppMethodBeat.m2505o(94947);
                return readUnsignedByte;
            } else {
                readUnsignedByte = this.aXR;
                this.aXR = readUnsignedByte + 1;
                if (readUnsignedByte % 2 == 0) {
                    this.aXS = this.aXz.readUnsignedByte();
                    readUnsignedByte = (this.aXS & 240) >> 4;
                    AppMethodBeat.m2505o(94947);
                    return readUnsignedByte;
                }
                readUnsignedByte = this.aXS & 15;
                AppMethodBeat.m2505o(94947);
                return readUnsignedByte;
            }
        }

        /* renamed from: rh */
        public final boolean mo2547rh() {
            return false;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b$d */
    static final class C17636d implements C0838b {
        private final int aXP = this.aXz.mo52389tI();
        private final C32065l aXz;
        private final int sampleCount = this.aXz.mo52389tI();

        public C17636d(C32027b c32027b) {
            AppMethodBeat.m2504i(94944);
            this.aXz = c32027b.aXz;
            this.aXz.setPosition(12);
            AppMethodBeat.m2505o(94944);
        }

        public final int getSampleCount() {
            return this.sampleCount;
        }

        /* renamed from: rg */
        public final int mo2546rg() {
            AppMethodBeat.m2504i(94945);
            int tI;
            if (this.aXP == 0) {
                tI = this.aXz.mo52389tI();
                AppMethodBeat.m2505o(94945);
                return tI;
            }
            tI = this.aXP;
            AppMethodBeat.m2505o(94945);
            return tI;
        }

        /* renamed from: rh */
        public final boolean mo2547rh() {
            return this.aXP != 0;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b$c */
    static final class C25517c {
        public Format aOv;
        public int aTz;
        public final C25518k[] aXN;
        public int aXO = 0;

        public C25517c(int i) {
            AppMethodBeat.m2504i(94943);
            this.aXN = new C25518k[i];
            AppMethodBeat.m2505o(94943);
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.b$f */
    static final class C32028f {
        final int aOi;
        final long duration;
        /* renamed from: id */
        final int f14675id;

        public C32028f(int i, long j, int i2) {
            this.f14675id = i;
            this.duration = j;
            this.aOi = i2;
        }
    }

    static {
        AppMethodBeat.m2504i(94958);
        AppMethodBeat.m2505o(94958);
    }

    /* renamed from: a */
    public static C37236j m52026a(C32026a c32026a, C32027b c32027b, long j, DrmInitData drmInitData, boolean z, boolean z2) {
        int i;
        AppMethodBeat.m2504i(94948);
        C32026a dX = c32026a.mo52323dX(C32025a.aWl);
        C32065l c32065l = dX.mo52322dW(C32025a.aWz).aXz;
        c32065l.setPosition(16);
        int readInt = c32065l.readInt();
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
            AppMethodBeat.m2505o(94948);
            return null;
        }
        int i2;
        long j2;
        long j3;
        C32065l c32065l2 = c32026a.mo52322dW(C32025a.aWv).aXz;
        c32065l2.setPosition(8);
        int dT = C32025a.m52017dT(c32065l2.readInt());
        c32065l2.mo52369eM(dT == 0 ? 8 : 16);
        int readInt2 = c32065l2.readInt();
        c32065l2.mo52369eM(4);
        Object obj = 1;
        int i3 = c32065l2.position;
        readInt = dT == 0 ? 4 : 8;
        for (i2 = 0; i2 < readInt; i2++) {
            if (c32065l2.data[i3 + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            c32065l2.mo52369eM(readInt);
            j2 = -9223372036854775807L;
        } else {
            j2 = dT == 0 ? c32065l2.mo52366cM() : c32065l2.mo52391tK();
            if (j2 == 0) {
                j2 = -9223372036854775807L;
            }
        }
        c32065l2.mo52369eM(16);
        i2 = c32065l2.readInt();
        dT = c32065l2.readInt();
        c32065l2.mo52369eM(4);
        i3 = c32065l2.readInt();
        int readInt3 = c32065l2.readInt();
        if (i2 == 0 && dT == 65536 && i3 == -65536 && readInt3 == 0) {
            i2 = 90;
        } else if (i2 == 0 && dT == -65536 && i3 == 65536 && readInt3 == 0) {
            i2 = 270;
        } else if (i2 == -65536 && dT == 0 && i3 == 0 && readInt3 == -65536) {
            i2 = 180;
        } else {
            i2 = 0;
        }
        C32028f c32028f = new C32028f(readInt2, j2, i2);
        if (j == -9223372036854775807L) {
            j2 = c32028f.duration;
        } else {
            j2 = j;
        }
        c32065l2 = c32027b.aXz;
        c32065l2.setPosition(8);
        c32065l2.mo52369eM(C32025a.m52017dT(c32065l2.readInt()) == 0 ? 8 : 16);
        long cM = c32065l2.mo52366cM();
        if (j2 == -9223372036854775807L) {
            j3 = -9223372036854775807L;
        } else {
            j3 = C17675v.m27564b(j2, 1000000, cM);
        }
        C32026a dX2 = dX.mo52323dX(C32025a.aWm).mo52323dX(C32025a.aWn);
        C32065l c32065l3 = dX.mo52322dW(C32025a.aWy).aXz;
        c32065l3.setPosition(8);
        readInt3 = C32025a.m52017dT(c32065l3.readInt());
        c32065l3.mo52369eM(readInt3 == 0 ? 8 : 16);
        long cM2 = c32065l3.mo52366cM();
        c32065l3.mo52369eM(readInt3 == 0 ? 4 : 8);
        readInt = c32065l3.readUnsignedShort();
        Pair create = Pair.create(Long.valueOf(cM2), ((char) (((readInt >> 10) & 31) + 96)) + ((char) (((readInt >> 5) & 31) + 96)) + ((char) ((readInt & 31) + 96)));
        C25517c a = C32029b.m52025a(dX2.mo52322dW(C32025a.aWA).aXz, c32028f.f14675id, c32028f.aOi, (String) create.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair b = C32029b.m52030b(c32026a.mo52323dX(C32025a.aWw));
            jArr2 = (long[]) b.second;
            jArr = (long[]) b.first;
        }
        if (a.aOv == null) {
            AppMethodBeat.m2505o(94948);
            return null;
        }
        C37236j c37236j = new C37236j(c32028f.f14675id, i, ((Long) create.first).longValue(), cM, j3, a.aOv, a.aXO, a.aXN, a.aTz, jArr, jArr2);
        AppMethodBeat.m2505o(94948);
        return c37236j;
    }

    /* renamed from: a */
    public static C25519m m52028a(C37236j c37236j, C32026a c32026a, C17644i c17644i) {
        C0838b c17636d;
        AppMethodBeat.m2504i(94949);
        C32027b dW = c32026a.mo52322dW(C32025a.aWX);
        if (dW != null) {
            c17636d = new C17636d(dW);
        } else {
            dW = c32026a.mo52322dW(C32025a.aWY);
            if (dW == null) {
                C37269o c37269o = new C37269o("Track has no sample table size information");
                AppMethodBeat.m2505o(94949);
                throw c37269o;
            }
            c17636d = new C6264e(dW);
        }
        int sampleCount = c17636d.getSampleCount();
        C25519m c25519m;
        if (sampleCount == 0) {
            c25519m = new C25519m(new long[0], new int[0], 0, new long[0], new int[0]);
            AppMethodBeat.m2505o(94949);
            return c25519m;
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
        dW = c32026a.mo52322dW(C32025a.aWZ);
        if (dW == null) {
            z = true;
            dW = c32026a.mo52322dW(C32025a.aXa);
        }
        C32065l c32065l = dW.aXz;
        C32065l c32065l2 = c32026a.mo52322dW(C32025a.aWW).aXz;
        C32065l c32065l3 = c32026a.mo52322dW(C32025a.aWT).aXz;
        dW = c32026a.mo52322dW(C32025a.aWU);
        C32065l c32065l4 = dW != null ? dW.aXz : null;
        C32027b dW2 = c32026a.mo52322dW(C32025a.aWV);
        C32065l c32065l5 = dW2 != null ? dW2.aXz : null;
        C0837a c0837a = new C0837a(c32065l2, c32065l, z);
        c32065l3.setPosition(12);
        int tI = c32065l3.mo52389tI() - 1;
        int tI2 = c32065l3.mo52389tI();
        int tI3 = c32065l3.mo52389tI();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        if (c32065l5 != null) {
            c32065l5.setPosition(12);
            i5 = c32065l5.mo52389tI();
        }
        int i7 = -1;
        int i8 = 0;
        if (c32065l4 != null) {
            c32065l4.setPosition(12);
            i8 = c32065l4.mo52389tI();
            if (i8 > 0) {
                i7 = c32065l4.mo52389tI() - 1;
            } else {
                c32065l4 = null;
            }
        }
        if (c17636d.mo2547rh() && "audio/raw".equals(c37236j.aOv.aOd) && tI == 0 && r8 == 0 && i8 == 0) {
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
                    C45039a.checkState(c0837a.mo2544rf());
                    j2 = c0837a.f1033xb;
                    i10 = c0837a.aXH;
                }
                if (c32065l5 != null) {
                    i8 = i6;
                    i7 = i5;
                    while (i4 == 0 && i7 > 0) {
                        i4 = c32065l5.mo52389tI();
                        i8 = c32065l5.readInt();
                        i7--;
                    }
                    i4--;
                } else {
                    i8 = i6;
                    i7 = i5;
                }
                obj6[i] = j2;
                obj2[i] = c17636d.mo2546rg();
                if (obj2[i] > i9) {
                    i9 = obj2[i];
                }
                jArr2[i] = ((long) i8) + j;
                obj7[i] = c32065l4 == null ? 1 : 0;
                if (i == i11) {
                    obj7[i] = 1;
                    i6 = i2 - 1;
                    if (i6 > 0) {
                        i2 = i6;
                        i11 = c32065l4.mo52389tI() - 1;
                    } else {
                        i2 = i6;
                    }
                }
                j += (long) tI3;
                i6 = tI2 - 1;
                if (i6 != 0 || tI <= 0) {
                    i12 = i6;
                } else {
                    i5 = c32065l3.mo52389tI();
                    tI--;
                    tI3 = c32065l3.mo52389tI();
                    i12 = i5;
                }
                j2 += (long) obj2[i];
                i10--;
                i++;
                i6 = i8;
                i5 = i7;
                tI2 = i12;
            }
            C45039a.checkArgument(i4 == 0);
            while (i5 > 0) {
                C45039a.checkArgument(c32065l5.mo52389tI() == 0);
                c32065l5.readInt();
                i5--;
            }
            if (!(i2 == 0 && tI2 == 0 && i10 == 0 && tI == 0)) {
                new StringBuilder("Inconsistent stbl box for track ").append(c37236j.f15847id).append(": remainingSynchronizationSamples ").append(i2).append(", remainingSamplesAtTimestampDelta ").append(tI2).append(", remainingSamplesInChunk ").append(i10).append(", remainingTimestampDeltaChanges ").append(tI);
            }
            obj3 = obj7;
            jArr = jArr2;
            obj4 = obj2;
            i3 = i9;
            obj5 = obj6;
        } else {
            long[] jArr3 = new long[c0837a.length];
            int[] iArr = new int[c0837a.length];
            while (c0837a.mo2544rf()) {
                jArr3[c0837a.index] = c0837a.f1033xb;
                iArr[c0837a.index] = c0837a.aXH;
            }
            C0841a a = C0840d.m1922a(c17636d.mo2546rg(), jArr3, iArr, (long) tI3);
            obj5 = a.offsets;
            obj4 = a.aSB;
            i3 = a.aXU;
            jArr = a.aXV;
            obj3 = a.aXW;
        }
        if (c37236j.aZp == null || c17644i.mo32329rc()) {
            C17675v.m27556a(jArr, c37236j.aZm);
            c25519m = new C25519m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.m2505o(94949);
            return c25519m;
        }
        long b;
        if (c37236j.aZp.length == 1 && c37236j.type == 1 && jArr.length >= 2) {
            long j3 = c37236j.aZq[0];
            b = C17675v.m27564b(c37236j.aZp[0], c37236j.aZm, c37236j.aZn) + j3;
            if (jArr[0] <= j3 && j3 < jArr[1] && jArr[jArr.length - 1] < b && b <= j) {
                long j4 = j - b;
                j3 = C17675v.m27564b(j3 - jArr[0], (long) c37236j.aOv.sampleRate, c37236j.aZm);
                b = C17675v.m27564b(j4, (long) c37236j.aOv.sampleRate, c37236j.aZm);
                if (!(j3 == 0 && b == 0) && j3 <= 2147483647L && b <= 2147483647L) {
                    c17644i.aOp = (int) j3;
                    c17644i.aOq = (int) b;
                    C17675v.m27556a(jArr, c37236j.aZm);
                    c25519m = new C25519m(obj5, obj4, i3, jArr, obj3);
                    AppMethodBeat.m2505o(94949);
                    return c25519m;
                }
            }
        }
        int i13;
        if (c37236j.aZp.length == 1 && c37236j.aZp[0] == 0) {
            for (i13 = 0; i13 < jArr.length; i13++) {
                jArr[i13] = C17675v.m27564b(jArr[i13] - c37236j.aZq[0], 1000000, c37236j.aZm);
            }
            c25519m = new C25519m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.m2505o(94949);
            return c25519m;
        }
        int i14;
        int i15;
        int i16;
        Object obj8;
        Object obj9;
        boolean z2 = c37236j.type == 1;
        i4 = 0;
        tI3 = 0;
        i9 = 0;
        i5 = 0;
        while (true) {
            int i17 = i5;
            i14 = i4;
            i15 = i9;
            i16 = tI3;
            if (i17 >= c37236j.aZp.length) {
                break;
            }
            j = c37236j.aZq[i17];
            if (j != -1) {
                b = C17675v.m27564b(c37236j.aZp[i17], c37236j.aZm, c37236j.aZn);
                i9 = C17675v.m27554a(jArr, j, true, true);
                tI3 = C17675v.m27554a(jArr, b + j, z2, false);
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
        for (int i19 = 0; i19 < c37236j.aZp.length; i19++) {
            long j5 = c37236j.aZq[i19];
            long j6 = c37236j.aZp[i19];
            if (j5 != -1) {
                long b2 = j5 + C17675v.m27564b(j6, c37236j.aZm, c37236j.aZn);
                i9 = C17675v.m27554a(jArr, j5, true, true);
                int a2 = C17675v.m27554a(jArr, b2, z2, false);
                if (i != 0) {
                    tI3 = a2 - i9;
                    System.arraycopy(obj5, i9, obj8, i18, tI3);
                    System.arraycopy(obj4, i9, obj9, i18, tI3);
                    System.arraycopy(obj3, i9, obj2, i18, tI3);
                }
                for (i2 = i9; i2 < a2; i2++) {
                    jArr4[i18] = C17675v.m27564b(jArr[i2] - j5, 1000000, c37236j.aZm) + C17675v.m27564b(b, 1000000, c37236j.aZn);
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
            C17675v.m27556a(jArr, c37236j.aZm);
            c25519m = new C25519m(obj5, obj4, i3, jArr, obj3);
            AppMethodBeat.m2505o(94949);
            return c25519m;
        }
        c25519m = new C25519m(obj8, obj9, i16, jArr4, obj2);
        AppMethodBeat.m2505o(94949);
        return c25519m;
    }

    /* renamed from: a */
    public static Metadata m52029a(C32027b c32027b, boolean z) {
        AppMethodBeat.m2504i(94950);
        if (z) {
            AppMethodBeat.m2505o(94950);
            return null;
        }
        C32065l c32065l = c32027b.aXz;
        c32065l.setPosition(8);
        while (c32065l.mo52382tB() >= 8) {
            int i = c32065l.position;
            int readInt = c32065l.readInt();
            if (c32065l.readInt() == C32025a.aXi) {
                c32065l.setPosition(i);
                i += readInt;
                c32065l.mo52369eM(12);
                while (c32065l.position < i) {
                    readInt = c32065l.position;
                    int readInt2 = c32065l.readInt();
                    if (c32065l.readInt() == C32025a.aXj) {
                        c32065l.setPosition(readInt);
                        i = readInt + readInt2;
                        c32065l.mo52369eM(8);
                        List arrayList = new ArrayList();
                        while (c32065l.position < i) {
                            Entry o = C0842f.m1927o(c32065l);
                            if (o != null) {
                                arrayList.add(o);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            AppMethodBeat.m2505o(94950);
                            return metadata;
                        }
                        AppMethodBeat.m2505o(94950);
                        return null;
                    }
                    c32065l.mo52369eM(readInt2 - 8);
                }
                AppMethodBeat.m2505o(94950);
                return null;
            }
            c32065l.mo52369eM(readInt - 8);
        }
        AppMethodBeat.m2505o(94950);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:293:0x022e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static C25517c m52025a(C32065l c32065l, int i, int i2, String str, DrmInitData drmInitData, boolean z) {
        AppMethodBeat.m2504i(94951);
        c32065l.setPosition(12);
        int readInt = c32065l.readInt();
        C25517c c25517c = new C25517c(readInt);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < readInt) {
                int i5 = c32065l.position;
                int readInt2 = c32065l.readInt();
                C45039a.checkArgument(readInt2 > 0, "childAtomSize should be positive");
                i3 = c32065l.readInt();
                int readUnsignedShort;
                int readUnsignedShort2;
                int i6;
                Pair a;
                int intValue;
                DrmInitData drmInitData2;
                String str2;
                String str3;
                if (i3 == C32025a.aVI || i3 == C32025a.aVJ || i3 == C32025a.aWG || i3 == C32025a.aWS || i3 == C32025a.aVK || i3 == C32025a.aVL || i3 == C32025a.aVM || i3 == C32025a.aXr || i3 == C32025a.aXs) {
                    DrmInitData drmInitData3;
                    c32065l.setPosition((i5 + 8) + 8);
                    c32065l.mo52369eM(16);
                    readUnsignedShort = c32065l.readUnsignedShort();
                    readUnsignedShort2 = c32065l.readUnsignedShort();
                    Object obj = null;
                    float f = 1.0f;
                    c32065l.mo52369eM(50);
                    i6 = c32065l.position;
                    if (i3 == C32025a.aWG) {
                        a = C32029b.m52024a(c32065l, i5, readInt2);
                        if (a != null) {
                            intValue = ((Integer) a.first).intValue();
                            if (drmInitData == null) {
                                drmInitData2 = null;
                            } else {
                                drmInitData2 = drmInitData.mo32330aw(((C25518k) a.second).aZt);
                            }
                            c25517c.aXN[i4] = (C25518k) a.second;
                            i3 = intValue;
                        } else {
                            drmInitData2 = drmInitData;
                        }
                        c32065l.setPosition(i6);
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
                        c32065l.setPosition(i6);
                        int i8 = c32065l.position;
                        int readInt3 = c32065l.readInt();
                        if (readInt3 != 0 || c32065l.position - i5 != readInt2) {
                            C45039a.checkArgument(readInt3 > 0, "childAtomSize should be positive");
                            i3 = c32065l.readInt();
                            if (i3 == C32025a.aWo) {
                                C45039a.checkState(str2 == null);
                                str2 = "video/avc";
                                c32065l.setPosition(i8 + 8);
                                C37284a K = C37284a.m62588K(c32065l);
                                list = K.aOf;
                                c25517c.aTz = K.aTz;
                                if (obj == null) {
                                    f = K.brq;
                                }
                            } else if (i3 == C32025a.aWp) {
                                C45039a.checkState(str2 == null);
                                str2 = "video/hevc";
                                c32065l.setPosition(i8 + 8);
                                C45053b M = C45053b.m82638M(c32065l);
                                list = M.aOf;
                                c25517c.aTz = M.aTz;
                            } else if (i3 == C32025a.aXt) {
                                C45039a.checkState(str2 == null);
                                str2 = intValue == C32025a.aXr ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            } else if (i3 == C32025a.aVN) {
                                C45039a.checkState(str2 == null);
                                str2 = "video/3gpp";
                            } else if (i3 == C32025a.aWq) {
                                C45039a.checkState(str2 == null);
                                Pair c = C32029b.m52032c(c32065l, i8);
                                str3 = (String) c.first;
                                list = Collections.singletonList(c.second);
                                str2 = str3;
                            } else if (i3 == C32025a.aWP) {
                                c32065l.setPosition(i8 + 8);
                                f = ((float) c32065l.mo52389tI()) / ((float) c32065l.mo52389tI());
                                int obj2 = 1;
                            } else if (i3 == C32025a.aXp) {
                                i3 = i8 + 8;
                                while (i3 - i8 < readInt3) {
                                    c32065l.setPosition(i3);
                                    int readInt4 = c32065l.readInt();
                                    if (c32065l.readInt() == C32025a.aXq) {
                                        bArr = Arrays.copyOfRange(c32065l.data, i3, readInt4 + i3);
                                    } else {
                                        i3 += readInt4;
                                    }
                                }
                                bArr = null;
                            } else if (i3 == C32025a.aXo) {
                                i3 = c32065l.readUnsignedByte();
                                c32065l.mo52369eM(3);
                                if (i3 == 0) {
                                    switch (c32065l.readUnsignedByte()) {
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
                            c25517c.aOv = Format.m15272a(Integer.toString(i), str2, -1, readUnsignedShort, readUnsignedShort2, list, i2, f, bArr, i7, null, drmInitData3);
                        }
                    }
                    if (str2 == null) {
                    }
                } else if (i3 == C32025a.aVP || i3 == C32025a.aWH || i3 == C32025a.aVU || i3 == C32025a.aVW || i3 == C32025a.aVY || i3 == C32025a.aWb || i3 == C32025a.aVZ || i3 == C32025a.aWa || i3 == C32025a.aXf || i3 == C32025a.aXg || i3 == C32025a.aVS || i3 == C32025a.aVT || i3 == C32025a.aVQ || i3 == C32025a.aXv) {
                    int readUnsignedShort3;
                    int i9;
                    DrmInitData drmInitData4;
                    c32065l.setPosition((i5 + 8) + 8);
                    if (z) {
                        readUnsignedShort3 = c32065l.readUnsignedShort();
                        c32065l.mo52369eM(6);
                        intValue = readUnsignedShort3;
                    } else {
                        c32065l.mo52369eM(8);
                        intValue = 0;
                    }
                    if (intValue == 0 || intValue == 1) {
                        readUnsignedShort = c32065l.readUnsignedShort();
                        c32065l.mo52369eM(6);
                        byte[] bArr2 = c32065l.data;
                        readUnsignedShort2 = c32065l.position;
                        c32065l.position = readUnsignedShort2 + 1;
                        readUnsignedShort3 = (bArr2[readUnsignedShort2] & 255) << 8;
                        byte[] bArr3 = c32065l.data;
                        i9 = c32065l.position;
                        c32065l.position = i9 + 1;
                        readUnsignedShort3 |= bArr3[i9] & 255;
                        c32065l.position += 2;
                        if (intValue == 1) {
                            c32065l.mo52369eM(16);
                            intValue = readUnsignedShort3;
                        } else {
                            intValue = readUnsignedShort3;
                        }
                    } else if (intValue == 2) {
                        c32065l.mo52369eM(16);
                        readUnsignedShort3 = (int) Math.round(Double.longBitsToDouble(c32065l.readLong()));
                        readUnsignedShort = c32065l.mo52389tI();
                        c32065l.mo52369eM(20);
                        intValue = readUnsignedShort3;
                    }
                    i6 = c32065l.position;
                    if (i3 == C32025a.aWH) {
                        a = C32029b.m52024a(c32065l, i5, readInt2);
                        if (a != null) {
                            readUnsignedShort2 = ((Integer) a.first).intValue();
                            if (drmInitData == null) {
                                drmInitData2 = null;
                            } else {
                                drmInitData2 = drmInitData.mo32330aw(((C25518k) a.second).aZt);
                            }
                            c25517c.aXN[i4] = (C25518k) a.second;
                            i3 = readUnsignedShort2;
                        } else {
                            drmInitData2 = drmInitData;
                        }
                        c32065l.setPosition(i6);
                        drmInitData4 = drmInitData2;
                    } else {
                        drmInitData4 = drmInitData;
                    }
                    if (i3 == C32025a.aVU) {
                        str3 = "audio/ac3";
                    } else if (i3 == C32025a.aVW) {
                        str3 = "audio/eac3";
                    } else if (i3 == C32025a.aVY) {
                        str3 = "audio/vnd.dts";
                    } else if (i3 == C32025a.aVZ || i3 == C32025a.aWa) {
                        str3 = "audio/vnd.dts.hd";
                    } else if (i3 == C32025a.aWb) {
                        str3 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (i3 == C32025a.aXf) {
                        str3 = "audio/3gpp";
                    } else if (i3 == C32025a.aXg) {
                        str3 = "audio/amr-wb";
                    } else if (i3 == C32025a.aVS || i3 == C32025a.aVT) {
                        str3 = "audio/raw";
                    } else if (i3 == C32025a.aVQ) {
                        str3 = "audio/mpeg";
                    } else if (i3 == C32025a.aXv) {
                        str3 = "audio/alac";
                    } else {
                        str3 = null;
                    }
                    Object obj3 = null;
                    str2 = str3;
                    i9 = intValue;
                    readUnsignedShort2 = readUnsignedShort;
                    while (i6 - i5 < readInt2) {
                        c32065l.setPosition(i6);
                        int readInt5 = c32065l.readInt();
                        C45039a.checkArgument(readInt5 > 0, "childAtomSize should be positive");
                        i3 = c32065l.readInt();
                        if (i3 == C32025a.aWq || (z && i3 == C32025a.aVR)) {
                            Object obj4;
                            if (i3 == C32025a.aWq) {
                                i3 = i6;
                            } else {
                                intValue = c32065l.position;
                                while (intValue - i6 < readInt5) {
                                    c32065l.setPosition(intValue);
                                    readUnsignedShort = c32065l.readInt();
                                    C45039a.checkArgument(readUnsignedShort > 0, "childAtomSize should be positive");
                                    if (c32065l.readInt() == C32025a.aWq) {
                                        i3 = intValue;
                                    } else {
                                        intValue += readUnsignedShort;
                                    }
                                }
                                i3 = -1;
                            }
                            if (i3 != -1) {
                                Pair c2 = C32029b.m52032c(c32065l, i3);
                                str2 = (String) c2.first;
                                obj4 = (byte[]) c2.second;
                                if ("audio/mp4a-latm".equals(str2)) {
                                    Pair q = C32062c.m52121q(obj4);
                                    i9 = ((Integer) q.first).intValue();
                                    readUnsignedShort2 = ((Integer) q.second).intValue();
                                }
                            } else {
                                obj4 = obj3;
                            }
                            obj3 = obj4;
                        } else if (i3 == C32025a.aVV) {
                            c32065l.setPosition(i6 + 8);
                            c25517c.aOv = C32018a.m51989a(c32065l, Integer.toString(i), str, drmInitData4);
                        } else if (i3 == C32025a.aVX) {
                            c32065l.setPosition(i6 + 8);
                            c25517c.aOv = C32018a.m51991b(c32065l, Integer.toString(i), str, drmInitData4);
                        } else if (i3 == C32025a.aWc) {
                            c25517c.aOv = Format.m15271a(Integer.toString(i), str2, -1, -1, readUnsignedShort2, i9, null, drmInitData4, str);
                        } else if (i3 == C32025a.aXv) {
                            obj3 = new byte[readInt5];
                            c32065l.setPosition(i6);
                            c32065l.readBytes(obj3, 0, readInt5);
                        }
                        i6 += readInt5;
                    }
                    if (c25517c.aOv == null && str2 != null) {
                        List list2;
                        int i10 = "audio/raw".equals(str2) ? 2 : -1;
                        String num = Integer.toString(i);
                        if (obj3 == null) {
                            list2 = null;
                        } else {
                            list2 = Collections.singletonList(obj3);
                        }
                        c25517c.aOv = Format.m15270a(num, str2, -1, -1, readUnsignedShort2, i9, i10, list2, drmInitData4, 0, str);
                    }
                } else if (i3 == C32025a.aWQ || i3 == C32025a.aXb || i3 == C32025a.aXc || i3 == C32025a.aXd || i3 == C32025a.aXe) {
                    c32065l.setPosition((i5 + 8) + 8);
                    List list3 = null;
                    long j = Long.MAX_VALUE;
                    if (i3 == C32025a.aWQ) {
                        str2 = "application/ttml+xml";
                    } else if (i3 == C32025a.aXb) {
                        str2 = "application/x-quicktime-tx3g";
                        i3 = (readInt2 - 8) - 8;
                        byte[] bArr4 = new byte[i3];
                        c32065l.readBytes(bArr4, 0, i3);
                        list3 = Collections.singletonList(bArr4);
                    } else if (i3 == C32025a.aXc) {
                        str2 = "application/x-mp4-vtt";
                    } else if (i3 == C32025a.aXd) {
                        str2 = "application/ttml+xml";
                        j = 0;
                    } else if (i3 == C32025a.aXe) {
                        str2 = "application/x-mp4-cea-608";
                        c25517c.aXO = 1;
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.m2505o(94951);
                        throw illegalStateException;
                    }
                    c25517c.aOv = Format.m15276a(Integer.toString(i), str2, 0, str, -1, null, j, list3);
                } else if (i3 == C32025a.aXu) {
                    c25517c.aOv = Format.m15288k(Integer.toString(i), "application/x-camera-motion");
                }
                c32065l.setPosition(i5 + readInt2);
                i3 = i4 + 1;
            } else {
                AppMethodBeat.m2505o(94951);
                return c25517c;
            }
        }
    }

    /* renamed from: b */
    private static Pair<long[], long[]> m52030b(C32026a c32026a) {
        AppMethodBeat.m2504i(94952);
        if (c32026a != null) {
            C32027b dW = c32026a.mo52322dW(C32025a.aWx);
            if (dW != null) {
                C32065l c32065l = dW.aXz;
                c32065l.setPosition(8);
                int dT = C32025a.m52017dT(c32065l.readInt());
                int tI = c32065l.mo52389tI();
                long[] jArr = new long[tI];
                long[] jArr2 = new long[tI];
                for (int i = 0; i < tI; i++) {
                    long readLong;
                    jArr[i] = dT == 1 ? c32065l.mo52391tK() : c32065l.mo52366cM();
                    if (dT == 1) {
                        readLong = c32065l.readLong();
                    } else {
                        readLong = (long) c32065l.readInt();
                    }
                    jArr2[i] = readLong;
                    byte[] bArr = c32065l.data;
                    int i2 = c32065l.position;
                    c32065l.position = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = c32065l.data;
                    int i4 = c32065l.position;
                    c32065l.position = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported media rate.");
                        AppMethodBeat.m2505o(94952);
                        throw illegalArgumentException;
                    }
                    c32065l.mo52369eM(2);
                }
                Pair<long[], long[]> create = Pair.create(jArr, jArr2);
                AppMethodBeat.m2505o(94952);
                return create;
            }
        }
        Pair create2 = Pair.create(null, null);
        AppMethodBeat.m2505o(94952);
        return create2;
    }

    /* renamed from: c */
    private static Pair<String, byte[]> m52032c(C32065l c32065l, int i) {
        Object obj = null;
        AppMethodBeat.m2504i(94953);
        c32065l.setPosition((i + 8) + 4);
        c32065l.mo52369eM(1);
        C32029b.m52033k(c32065l);
        c32065l.mo52369eM(2);
        int readUnsignedByte = c32065l.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            c32065l.mo52369eM(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            c32065l.mo52369eM(c32065l.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            c32065l.mo52369eM(2);
        }
        c32065l.mo52369eM(1);
        C32029b.m52033k(c32065l);
        Pair<String, byte[]> create;
        switch (c32065l.readUnsignedByte()) {
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
                AppMethodBeat.m2505o(94953);
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
                AppMethodBeat.m2505o(94953);
                return create;
            case ErrorCode.NEEDDOWNLOAD_TRUE /*170*/:
            case ErrorCode.NEEDDOWNLOAD_FALSE_1 /*171*/:
                create = Pair.create("audio/vnd.dts.hd", null);
                AppMethodBeat.m2505o(94953);
                return create;
        }
        c32065l.mo52369eM(12);
        c32065l.mo52369eM(1);
        readUnsignedByte = C32029b.m52033k(c32065l);
        byte[] bArr = new byte[readUnsignedByte];
        c32065l.readBytes(bArr, 0, readUnsignedByte);
        Pair create2 = Pair.create(obj, bArr);
        AppMethodBeat.m2505o(94953);
        return create2;
    }

    /* renamed from: b */
    private static Pair<Integer, C25518k> m52031b(C32065l c32065l, int i, int i2) {
        boolean z = true;
        AppMethodBeat.m2504i(94955);
        int i3 = i + 8;
        Object obj = null;
        Object obj2 = null;
        int i4 = 0;
        int i5 = -1;
        while (i3 - i < i2) {
            c32065l.setPosition(i3);
            int readInt = c32065l.readInt();
            int readInt2 = c32065l.readInt();
            if (readInt2 == C32025a.aWI) {
                obj = Integer.valueOf(c32065l.readInt());
            } else if (readInt2 == C32025a.aWD) {
                c32065l.mo52369eM(4);
                obj2 = c32065l.readString(4);
            } else if (readInt2 == C32025a.aWE) {
                i4 = readInt;
                i5 = i3;
            }
            i3 += readInt;
        }
        if ("cenc".equals(obj2) || "cbc1".equals(obj2) || "cens".equals(obj2) || "cbcs".equals(obj2)) {
            boolean z2;
            C45039a.checkArgument(obj != null, "frma atom is mandatory");
            if (i5 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            C45039a.checkArgument(z2, "schi atom is mandatory");
            C25518k a = C32029b.m52027a(c32065l, i5, i4, obj2);
            if (a == null) {
                z = false;
            }
            C45039a.checkArgument(z, "tenc atom is mandatory");
            Pair create = Pair.create(obj, a);
            AppMethodBeat.m2505o(94955);
            return create;
        }
        AppMethodBeat.m2505o(94955);
        return null;
    }

    /* renamed from: a */
    private static C25518k m52027a(C32065l c32065l, int i, int i2, String str) {
        byte[] bArr = null;
        boolean z = true;
        AppMethodBeat.m2504i(94956);
        int i3 = i + 8;
        while (i3 - i < i2) {
            c32065l.setPosition(i3);
            int readInt = c32065l.readInt();
            if (c32065l.readInt() == C32025a.aWF) {
                int i4;
                int i5;
                i3 = C32025a.m52017dT(c32065l.readInt());
                c32065l.mo52369eM(1);
                if (i3 == 0) {
                    c32065l.mo52369eM(1);
                    i4 = 0;
                    i5 = 0;
                } else {
                    i3 = c32065l.readUnsignedByte();
                    i5 = (i3 & 240) >> 4;
                    i4 = i3 & 15;
                }
                if (c32065l.readUnsignedByte() != 1) {
                    z = false;
                }
                readInt = c32065l.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                c32065l.readBytes(bArr2, 0, 16);
                if (z && readInt == 0) {
                    i3 = c32065l.readUnsignedByte();
                    bArr = new byte[i3];
                    c32065l.readBytes(bArr, 0, i3);
                }
                C25518k c25518k = new C25518k(z, str, readInt, bArr2, i5, i4, bArr);
                AppMethodBeat.m2505o(94956);
                return c25518k;
            }
            i3 += readInt;
        }
        AppMethodBeat.m2505o(94956);
        return null;
    }

    /* renamed from: k */
    private static int m52033k(C32065l c32065l) {
        AppMethodBeat.m2504i(94957);
        int readUnsignedByte = c32065l.readUnsignedByte();
        int i = readUnsignedByte & C31128d.MIC_SketchMark;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = c32065l.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & C31128d.MIC_SketchMark);
        }
        AppMethodBeat.m2505o(94957);
        return i;
    }

    /* renamed from: a */
    private static Pair<Integer, C25518k> m52024a(C32065l c32065l, int i, int i2) {
        AppMethodBeat.m2504i(94954);
        int i3 = c32065l.position;
        while (true) {
            int i4 = i3;
            if (i4 - i < i2) {
                c32065l.setPosition(i4);
                int readInt = c32065l.readInt();
                C45039a.checkArgument(readInt > 0, "childAtomSize should be positive");
                if (c32065l.readInt() == C32025a.aWC) {
                    Pair b = C32029b.m52031b(c32065l, i4, readInt);
                    if (b != null) {
                        AppMethodBeat.m2505o(94954);
                        return b;
                    }
                }
                i3 = i4 + readInt;
            } else {
                AppMethodBeat.m2505o(94954);
                return null;
            }
        }
    }
}
