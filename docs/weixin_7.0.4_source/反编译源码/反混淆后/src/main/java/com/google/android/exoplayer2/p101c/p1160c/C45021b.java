package com.google.android.exoplayer2.p101c.p1160c;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.C41620a;
import com.google.android.exoplayer2.p101c.C0852j;
import com.google.android.exoplayer2.p101c.C17644i;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;
import java.io.EOFException;

/* renamed from: com.google.android.exoplayer2.c.c.b */
public final class C45021b implements C32034e {
    public static final C32039h aTh = new C176351();
    private static final int aVq = C17675v.m27562aT("Xing");
    private static final int aVr = C17675v.m27562aT("Info");
    private static final int aVs = C17675v.m27562aT("VBRI");
    private Metadata aOb;
    private final C32065l aTj;
    private C8662g aTn;
    private long aVA;
    private int aVB;
    private final long aVt;
    private final C0852j aVu;
    private final C17644i aVv;
    private C32041m aVw;
    private int aVx;
    private C41597a aVy;
    private long aVz;
    private final int flags;

    /* renamed from: com.google.android.exoplayer2.c.c.b$1 */
    static class C176351 implements C32039h {
        C176351() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(94922);
            C32034e[] c32034eArr = new C32034e[]{new C45021b()};
            AppMethodBeat.m2505o(94922);
            return c32034eArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.c.b$a */
    interface C41597a extends C37247l {
        /* renamed from: O */
        long mo42777O(long j);
    }

    static {
        AppMethodBeat.m2504i(94930);
        AppMethodBeat.m2505o(94930);
    }

    public C45021b() {
        this(0);
    }

    public C45021b(int i) {
        this(i, -9223372036854775807L);
    }

    public C45021b(int i, long j) {
        AppMethodBeat.m2504i(94923);
        this.flags = i;
        this.aVt = j;
        this.aTj = new C32065l(10);
        this.aVu = new C0852j();
        this.aVv = new C17644i();
        this.aVz = -9223372036854775807L;
        AppMethodBeat.m2505o(94923);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(94924);
        boolean a = m82480a(c45026f, true);
        AppMethodBeat.m2505o(94924);
        return a;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(94925);
        this.aTn = c8662g;
        this.aVw = this.aTn.mo19157dM(0);
        this.aTn.mo19158rb();
        AppMethodBeat.m2505o(94925);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        this.aVx = 0;
        this.aVz = -9223372036854775807L;
        this.aVA = 0;
        this.aVB = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02b3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02b3  */
    /* JADX WARNING: Missing block: B:95:0x0277, code skipped:
            r4 = r4 + ((long) (r3 * r12));
            r8[r2] = (((long) r2) * r16) / ((long) r9);
     */
    /* JADX WARNING: Missing block: B:96:0x0288, code skipped:
            if (r14 != -1) goto L_0x029f;
     */
    /* JADX WARNING: Missing block: B:97:0x028a, code skipped:
            r6 = r4;
     */
    /* JADX WARNING: Missing block: B:98:0x028b, code skipped:
            r10[r2] = r6;
            r2 = r2 + 1;
     */
    /* JADX WARNING: Missing block: B:102:0x029f, code skipped:
            r6 = java.lang.Math.min(r14, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        int readInt;
        AppMethodBeat.m2504i(94926);
        if (this.aVx == 0) {
            try {
                m82480a(c45026f, false);
            } catch (EOFException e) {
                AppMethodBeat.m2505o(94926);
                return -1;
            }
        }
        if (this.aVy == null) {
            int i;
            C0852j c0852j;
            long position;
            long length;
            int i2;
            int i3;
            long j;
            int readInt2;
            C41597a f;
            C17644i c17644i;
            int i4;
            int readUnsignedShort;
            C32041m c32041m;
            String str;
            int i5;
            Metadata metadata;
            C32065l c32065l = new C32065l(this.aVu.aPy);
            c45026f.mo59479b(c32065l.data, 0, this.aVu.aPy);
            int i6 = (this.aVu.version & 1) != 0 ? this.aVu.channels != 1 ? 36 : 21 : this.aVu.channels != 1 ? 21 : 13;
            if (c32065l.limit >= i6 + 4) {
                c32065l.setPosition(i6);
                readInt = c32065l.readInt();
                if (readInt == aVq || readInt == aVr) {
                    i = readInt;
                    long[] jArr;
                    if (i != aVq || i == aVr) {
                        c0852j = this.aVu;
                        position = c45026f.getPosition();
                        length = c45026f.getLength();
                        i2 = c0852j.aTa;
                        i3 = c0852j.sampleRate;
                        j = position + ((long) c0852j.aPy);
                        readInt2 = c32065l.readInt();
                        if ((readInt2 & 1) == 1) {
                            readInt = c32065l.mo52389tI();
                            if (readInt != 0) {
                                long b = C17675v.m27564b((long) readInt, ((long) i2) * 1000000, (long) i3);
                                Object c25516d;
                                if ((readInt2 & 6) != 6) {
                                    c25516d = new C25516d(j, b, length);
                                } else {
                                    long tI = (long) c32065l.mo52389tI();
                                    c32065l.mo52369eM(1);
                                    jArr = new long[99];
                                    for (readInt = 0; readInt < 99; readInt++) {
                                        jArr[readInt] = (long) c32065l.readUnsignedByte();
                                    }
                                    c25516d = new C25516d(j, b, length, jArr, tI, c0852j.aPy);
                                }
                                if (!(f == null || this.aVv.mo32329rc())) {
                                    c45026f.mo59486qY();
                                    c45026f.mo59483dH(i6 + 141);
                                    c45026f.mo59479b(this.aTj.data, 0, 3);
                                    this.aTj.setPosition(0);
                                    c17644i = this.aVv;
                                    i2 = this.aTj.mo52384tD();
                                    i4 = i2 >> 12;
                                    i2 &= 4095;
                                    if (i4 > 0 || i2 > 0) {
                                        c17644i.aOp = i4;
                                        c17644i.aOq = i2;
                                    }
                                }
                                c45026f.mo59482dG(this.aVu.aPy);
                                if (!(f == null || f.mo2552qX() || i != aVr)) {
                                    f = m82482f(c45026f);
                                }
                            }
                        }
                        f = null;
                        c45026f.mo59486qY();
                        c45026f.mo59483dH(i6 + 141);
                        c45026f.mo59479b(this.aTj.data, 0, 3);
                        this.aTj.setPosition(0);
                        c17644i = this.aVv;
                        i2 = this.aTj.mo52384tD();
                        i4 = i2 >> 12;
                        i2 &= 4095;
                        c17644i.aOp = i4;
                        c17644i.aOq = i2;
                        c45026f.mo59482dG(this.aVu.aPy);
                        f = m82482f(c45026f);
                    } else if (i == aVs) {
                        C0852j c0852j2 = this.aVu;
                        long position2 = c45026f.getPosition();
                        long length2 = c45026f.getLength();
                        c32065l.mo52369eM(10);
                        readInt = c32065l.readInt();
                        if (readInt <= 0) {
                            f = null;
                        } else {
                            i3 = c0852j2.sampleRate;
                            long b2 = C17675v.m27564b((long) readInt, ((long) (i3 >= TXRecordCommon.AUDIO_SAMPLERATE_32000 ? 1152 : 576)) * 1000000, (long) i3);
                            readUnsignedShort = c32065l.readUnsignedShort();
                            int readUnsignedShort2 = c32065l.readUnsignedShort();
                            int readUnsignedShort3 = c32065l.readUnsignedShort();
                            c32065l.mo52369eM(2);
                            long j2 = position2 + ((long) c0852j2.aPy);
                            long[] jArr2 = new long[(readUnsignedShort + 1)];
                            jArr = new long[(readUnsignedShort + 1)];
                            jArr2[0] = 0;
                            jArr[0] = j2;
                            readInt = 1;
                            while (readInt < jArr2.length) {
                                int readUnsignedByte;
                                switch (readUnsignedShort3) {
                                    case 1:
                                        readUnsignedByte = c32065l.readUnsignedByte();
                                        break;
                                    case 2:
                                        readUnsignedByte = c32065l.readUnsignedShort();
                                        break;
                                    case 3:
                                        readUnsignedByte = c32065l.mo52384tD();
                                        break;
                                    case 4:
                                        readUnsignedByte = c32065l.mo52389tI();
                                        break;
                                    default:
                                        f = null;
                                        break;
                                }
                            }
                            f = new C37234c(jArr2, jArr, b2);
                        }
                        c45026f.mo59482dG(this.aVu.aPy);
                    } else {
                        f = null;
                        c45026f.mo59486qY();
                    }
                    this.aVy = f;
                    if (this.aVy == null || !(this.aVy.mo2552qX() || (this.flags & 1) == 0)) {
                        this.aVy = m82482f(c45026f);
                    }
                    this.aTn.mo19156a(this.aVy);
                    c32041m = this.aVw;
                    str = this.aVu.mimeType;
                    i3 = this.aVu.channels;
                    i5 = this.aVu.sampleRate;
                    readUnsignedShort = this.aVv.aOp;
                    readInt2 = this.aVv.aOq;
                    if ((this.flags & 2) != 0) {
                        metadata = null;
                    } else {
                        metadata = this.aOb;
                    }
                    c32041m.mo42836f(Format.m15269a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
                }
            }
            if (c32065l.limit >= 40) {
                c32065l.setPosition(36);
                if (c32065l.readInt() == aVs) {
                    i = aVs;
                    if (i != aVq) {
                    }
                    c0852j = this.aVu;
                    position = c45026f.getPosition();
                    length = c45026f.getLength();
                    i2 = c0852j.aTa;
                    i3 = c0852j.sampleRate;
                    j = position + ((long) c0852j.aPy);
                    readInt2 = c32065l.readInt();
                    if ((readInt2 & 1) == 1) {
                    }
                    f = null;
                    c45026f.mo59486qY();
                    c45026f.mo59483dH(i6 + 141);
                    c45026f.mo59479b(this.aTj.data, 0, 3);
                    this.aTj.setPosition(0);
                    c17644i = this.aVv;
                    i2 = this.aTj.mo52384tD();
                    i4 = i2 >> 12;
                    i2 &= 4095;
                    c17644i.aOp = i4;
                    c17644i.aOq = i2;
                    c45026f.mo59482dG(this.aVu.aPy);
                    f = m82482f(c45026f);
                    this.aVy = f;
                    this.aVy = m82482f(c45026f);
                    this.aTn.mo19156a(this.aVy);
                    c32041m = this.aVw;
                    str = this.aVu.mimeType;
                    i3 = this.aVu.channels;
                    i5 = this.aVu.sampleRate;
                    readUnsignedShort = this.aVv.aOp;
                    readInt2 = this.aVv.aOq;
                    if ((this.flags & 2) != 0) {
                    }
                    c32041m.mo42836f(Format.m15269a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
                }
            }
            i = 0;
            if (i != aVq) {
            }
            c0852j = this.aVu;
            position = c45026f.getPosition();
            length = c45026f.getLength();
            i2 = c0852j.aTa;
            i3 = c0852j.sampleRate;
            j = position + ((long) c0852j.aPy);
            readInt2 = c32065l.readInt();
            if ((readInt2 & 1) == 1) {
            }
            f = null;
            c45026f.mo59486qY();
            c45026f.mo59483dH(i6 + 141);
            c45026f.mo59479b(this.aTj.data, 0, 3);
            this.aTj.setPosition(0);
            c17644i = this.aVv;
            i2 = this.aTj.mo52384tD();
            i4 = i2 >> 12;
            i2 &= 4095;
            c17644i.aOp = i4;
            c17644i.aOq = i2;
            c45026f.mo59482dG(this.aVu.aPy);
            f = m82482f(c45026f);
            this.aVy = f;
            this.aVy = m82482f(c45026f);
            this.aTn.mo19156a(this.aVy);
            c32041m = this.aVw;
            str = this.aVu.mimeType;
            i3 = this.aVu.channels;
            i5 = this.aVu.sampleRate;
            readUnsignedShort = this.aVv.aOp;
            readInt2 = this.aVv.aOq;
            if ((this.flags & 2) != 0) {
            }
            c32041m.mo42836f(Format.m15269a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
        }
        if (this.aVB == 0) {
            c45026f.mo59486qY();
            if (c45026f.mo59480b(this.aTj.data, 0, 4, true)) {
                this.aTj.setPosition(0);
                readInt = this.aTj.readInt();
                if (!C45021b.m82483i(readInt, (long) this.aVx) || C0852j.m1953dN(readInt) == -1) {
                    c45026f.mo59482dG(1);
                    this.aVx = 0;
                    AppMethodBeat.m2505o(94926);
                    return 0;
                }
                C0852j.m1952a(readInt, this.aVu);
                if (this.aVz == -9223372036854775807L) {
                    this.aVz = this.aVy.mo42777O(c45026f.getPosition());
                    if (this.aVt != -9223372036854775807L) {
                        this.aVz = (this.aVt - this.aVy.mo42777O(0)) + this.aVz;
                    }
                }
                this.aVB = this.aVu.aPy;
            } else {
                AppMethodBeat.m2505o(94926);
                return -1;
            }
        }
        readInt = this.aVw.mo42832a(c45026f, this.aVB, true);
        if (readInt == -1) {
            AppMethodBeat.m2505o(94926);
            return -1;
        }
        this.aVB -= readInt;
        if (this.aVB > 0) {
            AppMethodBeat.m2505o(94926);
            return 0;
        }
        this.aVw.mo42834a(((this.aVA * 1000000) / ((long) this.aVu.sampleRate)) + this.aVz, 1, this.aVu.aPy, 0, null);
        this.aVA += (long) this.aVu.aTa;
        this.aVB = 0;
        AppMethodBeat.m2505o(94926);
        return 0;
    }

    /* renamed from: a */
    private boolean m82480a(C45026f c45026f, boolean z) {
        int qZ;
        int i;
        int i2;
        int i3;
        int i4;
        AppMethodBeat.m2504i(94927);
        int i5 = z ? 16384 : WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        c45026f.mo59486qY();
        if (c45026f.getPosition() == 0) {
            m82481e(c45026f);
            qZ = (int) c45026f.mo59487qZ();
            if (!z) {
                c45026f.mo59482dG(qZ);
            }
            i = 0;
            i2 = qZ;
            i3 = 0;
            i4 = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        while (true) {
            boolean z2;
            byte[] bArr = this.aTj.data;
            if (i4 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!c45026f.mo59480b(bArr, 0, 4, z2)) {
                break;
            }
            this.aTj.setPosition(0);
            qZ = this.aTj.readInt();
            if (i3 == 0 || C45021b.m82483i(qZ, (long) i3)) {
                int dN = C0852j.m1953dN(qZ);
                if (dN != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                        qZ = i3;
                    } else {
                        C0852j.m1952a(qZ, this.aVu);
                    }
                    c45026f.mo59483dH(dN - 4);
                    i3 = qZ;
                }
            }
            qZ = i + 1;
            if (i == i5) {
                if (z) {
                    AppMethodBeat.m2505o(94927);
                    return false;
                }
                C37269o c37269o = new C37269o("Searched too many bytes.");
                AppMethodBeat.m2505o(94927);
                throw c37269o;
            } else if (z) {
                c45026f.mo59486qY();
                c45026f.mo59483dH(i2 + qZ);
                i = qZ;
                i3 = 0;
                i4 = 0;
            } else {
                c45026f.mo59482dG(1);
                i = qZ;
                i3 = 0;
                i4 = 0;
            }
        }
        if (z) {
            c45026f.mo59482dG(i2 + i);
        } else {
            c45026f.mo59486qY();
        }
        this.aVx = i3;
        AppMethodBeat.m2505o(94927);
        return true;
    }

    /* renamed from: e */
    private void m82481e(C45026f c45026f) {
        AppMethodBeat.m2504i(94928);
        int i = 0;
        while (true) {
            c45026f.mo59479b(this.aTj.data, 0, 10);
            this.aTj.setPosition(0);
            if (this.aTj.mo52384tD() == C41620a.bbg) {
                this.aTj.mo52369eM(3);
                int tH = this.aTj.mo52388tH();
                int i2 = tH + 10;
                if (this.aOb == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.aTj.data, 0, bArr, 0, 10);
                    c45026f.mo59479b(bArr, 10, tH);
                    this.aOb = new C41620a((this.flags & 2) != 0 ? C17644i.aSR : null).mo66752d(bArr, i2);
                    if (this.aOb != null) {
                        this.aVv.mo32328c(this.aOb);
                    }
                } else {
                    c45026f.mo59483dH(tH);
                }
                i += i2;
            } else {
                c45026f.mo59486qY();
                c45026f.mo59483dH(i);
                AppMethodBeat.m2505o(94928);
                return;
            }
        }
    }

    /* renamed from: f */
    private C41597a m82482f(C45026f c45026f) {
        AppMethodBeat.m2504i(94929);
        c45026f.mo59479b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        C0852j.m1952a(this.aTj.readInt(), this.aVu);
        C37233a c37233a = new C37233a(c45026f.getPosition(), this.aVu.bitrate, c45026f.getLength());
        AppMethodBeat.m2505o(94929);
        return c37233a;
    }

    /* renamed from: i */
    private static boolean m82483i(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }
}
