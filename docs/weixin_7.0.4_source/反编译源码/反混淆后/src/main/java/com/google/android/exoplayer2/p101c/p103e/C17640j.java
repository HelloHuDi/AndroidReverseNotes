package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.p103e.C25522k.C25523b;
import com.google.android.exoplayer2.p101c.p103e.C25522k.C25524c;
import com.google.android.exoplayer2.p101c.p103e.C25522k.C25525d;
import com.google.android.exoplayer2.p101c.p103e.C25522k.C8655a;
import com.google.android.exoplayer2.p101c.p103e.C32031h.C32032a;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.e.j */
final class C17640j extends C32031h {
    private C8654a baH;
    private int baI;
    private boolean baJ;
    private C25525d baK;
    private C25523b baL;

    /* renamed from: com.google.android.exoplayer2.c.e.j$a */
    static final class C8654a {
        public final C25523b baL;
        public final C25525d baM;
        public final byte[] baN;
        public final C25524c[] baO;
        public final int baP;

        public C8654a(C25525d c25525d, C25523b c25523b, byte[] bArr, C25524c[] c25524cArr, int i) {
            this.baM = c25525d;
            this.baL = c25523b;
            this.baN = bArr;
            this.baO = c25524cArr;
            this.baP = i;
        }
    }

    C17640j() {
    }

    /* renamed from: r */
    public static boolean m27475r(C32065l c32065l) {
        AppMethodBeat.m2504i(95056);
        try {
            boolean a = C25522k.m40333a(1, c32065l, true);
            AppMethodBeat.m2505o(95056);
            return a;
        } catch (C37269o e) {
            AppMethodBeat.m2505o(95056);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void reset(boolean z) {
        AppMethodBeat.m2504i(95057);
        super.reset(z);
        if (z) {
            this.baH = null;
            this.baK = null;
            this.baL = null;
        }
        this.baI = 0;
        this.baJ = false;
        AppMethodBeat.m2505o(95057);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: V */
    public final void mo32320V(long j) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(95058);
        super.mo32320V(j);
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
        AppMethodBeat.m2505o(95058);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: s */
    public final long mo32323s(C32065l c32065l) {
        int i = 0;
        AppMethodBeat.m2504i(95059);
        if ((c32065l.data[0] & 1) == 1) {
            AppMethodBeat.m2505o(95059);
            return -1;
        }
        int i2;
        byte b = c32065l.data[0];
        C8654a c8654a = this.baH;
        if (c8654a.baO[(b >> 1) & (255 >>> (8 - c8654a.baP))].baW) {
            i2 = c8654a.baM.bbe;
        } else {
            i2 = c8654a.baM.bbd;
        }
        if (this.baJ) {
            i = (this.baI + i2) / 4;
        }
        long j = (long) i;
        c32065l.mo52368eL(c32065l.limit + 4);
        c32065l.data[c32065l.limit - 4] = (byte) ((int) (j & 255));
        c32065l.data[c32065l.limit - 3] = (byte) ((int) ((j >>> 8) & 255));
        c32065l.data[c32065l.limit - 2] = (byte) ((int) ((j >>> 16) & 255));
        c32065l.data[c32065l.limit - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.baJ = true;
        this.baI = i2;
        long j2 = (long) i;
        AppMethodBeat.m2505o(95059);
        return j2;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32321a(C32065l c32065l, long j, C32032a c32032a) {
        AppMethodBeat.m2504i(95060);
        if (this.baH != null) {
            AppMethodBeat.m2505o(95060);
            return false;
        }
        C8654a c8654a;
        long tE;
        int tF;
        int tF2;
        int tF3;
        int readUnsignedByte;
        int i;
        C37269o c37269o;
        if (this.baK == null) {
            C25522k.m40333a(1, c32065l, false);
            long tE2 = c32065l.mo52385tE();
            int readUnsignedByte2 = c32065l.readUnsignedByte();
            tE = c32065l.mo52385tE();
            tF = c32065l.mo52386tF();
            tF2 = c32065l.mo52386tF();
            tF3 = c32065l.mo52386tF();
            readUnsignedByte = c32065l.readUnsignedByte();
            this.baK = new C25525d(tE2, readUnsignedByte2, tE, tF, tF2, tF3, (int) Math.pow(2.0d, (double) (readUnsignedByte & 15)), (int) Math.pow(2.0d, (double) ((readUnsignedByte & 240) >> 4)), (c32065l.readUnsignedByte() & 1) > 0, Arrays.copyOf(c32065l.data, c32065l.limit));
            c8654a = null;
        } else if (this.baL == null) {
            C25522k.m40333a(3, c32065l, false);
            String readString = c32065l.readString((int) c32065l.mo52385tE());
            readUnsignedByte = readString.length() + 11;
            tE = c32065l.mo52385tE();
            String[] strArr = new String[((int) tE)];
            readUnsignedByte += 4;
            for (i = 0; ((long) i) < tE; i++) {
                readUnsignedByte += 4;
                strArr[i] = c32065l.readString((int) c32065l.mo52385tE());
                readUnsignedByte += strArr[i].length();
            }
            if ((c32065l.readUnsignedByte() & 1) == 0) {
                c37269o = new C37269o("framing bit expected to be set");
                AppMethodBeat.m2505o(95060);
                throw c37269o;
            }
            this.baL = new C25523b(readString, strArr, readUnsignedByte + 1);
            c8654a = null;
        } else {
            byte[] bArr = new byte[c32065l.limit];
            System.arraycopy(c32065l.data, 0, bArr, 0, c32065l.limit);
            int i2 = this.baK.channels;
            C25522k.m40333a(5, c32065l, false);
            int readUnsignedByte3 = c32065l.readUnsignedByte() + 1;
            C25521i c25521i = new C25521i(c32065l.data);
            c25521i.mo42781ee(c32065l.position * 8);
            for (tF3 = 0; tF3 < readUnsignedByte3; tF3++) {
                if (c25521i.mo42780ed(24) != 5653314) {
                    c37269o = new C37269o("expected code book to start with [0x56, 0x43, 0x42] at " + ((c25521i.baF * 8) + c25521i.baG));
                    AppMethodBeat.m2505o(95060);
                    throw c37269o;
                }
                int ed;
                i = c25521i.mo42780ed(16);
                int ed2 = c25521i.mo42780ed(24);
                long[] jArr = new long[ed2];
                boolean rl = c25521i.mo42782rl();
                if (rl) {
                    ed = c25521i.mo42780ed(5) + 1;
                    readUnsignedByte = 0;
                    while (readUnsignedByte < jArr.length) {
                        tF2 = c25521i.mo42780ed(C25522k.m40337ef(ed2 - readUnsignedByte));
                        for (tF = 0; tF < tF2 && readUnsignedByte < jArr.length; tF++) {
                            jArr[readUnsignedByte] = (long) ed;
                            readUnsignedByte++;
                        }
                        ed++;
                    }
                } else {
                    boolean rl2 = c25521i.mo42782rl();
                    for (readUnsignedByte = 0; readUnsignedByte < jArr.length; readUnsignedByte++) {
                        if (!rl2 || c25521i.mo42782rl()) {
                            jArr[readUnsignedByte] = (long) (c25521i.mo42780ed(5) + 1);
                        } else {
                            jArr[readUnsignedByte] = 0;
                        }
                    }
                }
                ed = c25521i.mo42780ed(4);
                if (ed > 2) {
                    c37269o = new C37269o("lookup type greater than 2 not decodable: ".concat(String.valueOf(ed)));
                    AppMethodBeat.m2505o(95060);
                    throw c37269o;
                }
                if (ed == 1 || ed == 2) {
                    long j2;
                    c25521i.mo42781ee(32);
                    c25521i.mo42781ee(32);
                    readUnsignedByte = c25521i.mo42780ed(4) + 1;
                    c25521i.mo42781ee(1);
                    if (ed != 1) {
                        j2 = (long) (ed2 * i);
                    } else if (i != 0) {
                        j2 = (long) Math.floor(Math.pow((double) ((long) ed2), 1.0d / ((double) ((long) i))));
                    } else {
                        j2 = 0;
                    }
                    c25521i.mo42781ee((int) (j2 * ((long) readUnsignedByte)));
                }
                C8655a c8655a = new C8655a(i, ed2, jArr, ed, rl);
            }
            i = c25521i.mo42780ed(6) + 1;
            for (readUnsignedByte = 0; readUnsignedByte < i; readUnsignedByte++) {
                if (c25521i.mo42780ed(16) != 0) {
                    c37269o = new C37269o("placeholder of time domain transforms not zeroed out");
                    AppMethodBeat.m2505o(95060);
                    throw c37269o;
                }
            }
            C25522k.m40336c(c25521i);
            C25522k.m40335b(c25521i);
            C25522k.m40332a(i2, c25521i);
            C25524c[] a = C25522k.m40334a(c25521i);
            if (c25521i.mo42782rl()) {
                c8654a = new C8654a(this.baK, this.baL, bArr, a, C25522k.m40337ef(a.length - 1));
            } else {
                c37269o = new C37269o("framing bit after modes not set as expected");
                AppMethodBeat.m2505o(95060);
                throw c37269o;
            }
        }
        this.baH = c8654a;
        if (this.baH == null) {
            AppMethodBeat.m2505o(95060);
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.baH.baM.data);
        arrayList.add(this.baH.baN);
        c32032a.aOv = Format.m15271a(null, "audio/vorbis", this.baH.baM.bbb, -1, this.baH.baM.channels, (int) this.baH.baM.sampleRate, arrayList, null, null);
        AppMethodBeat.m2505o(95060);
        return true;
    }
}
