package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.j;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ugc.TXRecordCommon;
import java.io.EOFException;

public final class b implements e {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(94922);
            e[] eVarArr = new e[]{new b()};
            AppMethodBeat.o(94922);
            return eVarArr;
        }
    };
    private static final int aVq = v.aT("Xing");
    private static final int aVr = v.aT("Info");
    private static final int aVs = v.aT("VBRI");
    private Metadata aOb;
    private final l aTj;
    private g aTn;
    private long aVA;
    private int aVB;
    private final long aVt;
    private final j aVu;
    private final i aVv;
    private m aVw;
    private int aVx;
    private a aVy;
    private long aVz;
    private final int flags;

    interface a extends com.google.android.exoplayer2.c.l {
        long O(long j);
    }

    static {
        AppMethodBeat.i(94930);
        AppMethodBeat.o(94930);
    }

    public b() {
        this(0);
    }

    public b(int i) {
        this(i, -9223372036854775807L);
    }

    public b(int i, long j) {
        AppMethodBeat.i(94923);
        this.flags = i;
        this.aVt = j;
        this.aTj = new l(10);
        this.aVu = new j();
        this.aVv = new i();
        this.aVz = -9223372036854775807L;
        AppMethodBeat.o(94923);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(94924);
        boolean a = a(fVar, true);
        AppMethodBeat.o(94924);
        return a;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(94925);
        this.aTn = gVar;
        this.aVw = this.aTn.dM(0);
        this.aTn.rb();
        AppMethodBeat.o(94925);
    }

    public final void g(long j, long j2) {
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
    public final int a(f fVar, k kVar) {
        int readInt;
        AppMethodBeat.i(94926);
        if (this.aVx == 0) {
            try {
                a(fVar, false);
            } catch (EOFException e) {
                AppMethodBeat.o(94926);
                return -1;
            }
        }
        if (this.aVy == null) {
            int i;
            j jVar;
            long position;
            long length;
            int i2;
            int i3;
            long j;
            int readInt2;
            a f;
            i iVar;
            int i4;
            int readUnsignedShort;
            m mVar;
            String str;
            int i5;
            Metadata metadata;
            l lVar = new l(this.aVu.aPy);
            fVar.b(lVar.data, 0, this.aVu.aPy);
            int i6 = (this.aVu.version & 1) != 0 ? this.aVu.channels != 1 ? 36 : 21 : this.aVu.channels != 1 ? 21 : 13;
            if (lVar.limit >= i6 + 4) {
                lVar.setPosition(i6);
                readInt = lVar.readInt();
                if (readInt == aVq || readInt == aVr) {
                    i = readInt;
                    long[] jArr;
                    if (i != aVq || i == aVr) {
                        jVar = this.aVu;
                        position = fVar.getPosition();
                        length = fVar.getLength();
                        i2 = jVar.aTa;
                        i3 = jVar.sampleRate;
                        j = position + ((long) jVar.aPy);
                        readInt2 = lVar.readInt();
                        if ((readInt2 & 1) == 1) {
                            readInt = lVar.tI();
                            if (readInt != 0) {
                                long b = v.b((long) readInt, ((long) i2) * 1000000, (long) i3);
                                Object dVar;
                                if ((readInt2 & 6) != 6) {
                                    dVar = new d(j, b, length);
                                } else {
                                    long tI = (long) lVar.tI();
                                    lVar.eM(1);
                                    jArr = new long[99];
                                    for (readInt = 0; readInt < 99; readInt++) {
                                        jArr[readInt] = (long) lVar.readUnsignedByte();
                                    }
                                    dVar = new d(j, b, length, jArr, tI, jVar.aPy);
                                }
                                if (!(f == null || this.aVv.rc())) {
                                    fVar.qY();
                                    fVar.dH(i6 + 141);
                                    fVar.b(this.aTj.data, 0, 3);
                                    this.aTj.setPosition(0);
                                    iVar = this.aVv;
                                    i2 = this.aTj.tD();
                                    i4 = i2 >> 12;
                                    i2 &= 4095;
                                    if (i4 > 0 || i2 > 0) {
                                        iVar.aOp = i4;
                                        iVar.aOq = i2;
                                    }
                                }
                                fVar.dG(this.aVu.aPy);
                                if (!(f == null || f.qX() || i != aVr)) {
                                    f = f(fVar);
                                }
                            }
                        }
                        f = null;
                        fVar.qY();
                        fVar.dH(i6 + 141);
                        fVar.b(this.aTj.data, 0, 3);
                        this.aTj.setPosition(0);
                        iVar = this.aVv;
                        i2 = this.aTj.tD();
                        i4 = i2 >> 12;
                        i2 &= 4095;
                        iVar.aOp = i4;
                        iVar.aOq = i2;
                        fVar.dG(this.aVu.aPy);
                        f = f(fVar);
                    } else if (i == aVs) {
                        j jVar2 = this.aVu;
                        long position2 = fVar.getPosition();
                        long length2 = fVar.getLength();
                        lVar.eM(10);
                        readInt = lVar.readInt();
                        if (readInt <= 0) {
                            f = null;
                        } else {
                            i3 = jVar2.sampleRate;
                            long b2 = v.b((long) readInt, ((long) (i3 >= TXRecordCommon.AUDIO_SAMPLERATE_32000 ? 1152 : 576)) * 1000000, (long) i3);
                            readUnsignedShort = lVar.readUnsignedShort();
                            int readUnsignedShort2 = lVar.readUnsignedShort();
                            int readUnsignedShort3 = lVar.readUnsignedShort();
                            lVar.eM(2);
                            long j2 = position2 + ((long) jVar2.aPy);
                            long[] jArr2 = new long[(readUnsignedShort + 1)];
                            jArr = new long[(readUnsignedShort + 1)];
                            jArr2[0] = 0;
                            jArr[0] = j2;
                            readInt = 1;
                            while (readInt < jArr2.length) {
                                int readUnsignedByte;
                                switch (readUnsignedShort3) {
                                    case 1:
                                        readUnsignedByte = lVar.readUnsignedByte();
                                        break;
                                    case 2:
                                        readUnsignedByte = lVar.readUnsignedShort();
                                        break;
                                    case 3:
                                        readUnsignedByte = lVar.tD();
                                        break;
                                    case 4:
                                        readUnsignedByte = lVar.tI();
                                        break;
                                    default:
                                        f = null;
                                        break;
                                }
                            }
                            f = new c(jArr2, jArr, b2);
                        }
                        fVar.dG(this.aVu.aPy);
                    } else {
                        f = null;
                        fVar.qY();
                    }
                    this.aVy = f;
                    if (this.aVy == null || !(this.aVy.qX() || (this.flags & 1) == 0)) {
                        this.aVy = f(fVar);
                    }
                    this.aTn.a(this.aVy);
                    mVar = this.aVw;
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
                    mVar.f(Format.a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
                }
            }
            if (lVar.limit >= 40) {
                lVar.setPosition(36);
                if (lVar.readInt() == aVs) {
                    i = aVs;
                    if (i != aVq) {
                    }
                    jVar = this.aVu;
                    position = fVar.getPosition();
                    length = fVar.getLength();
                    i2 = jVar.aTa;
                    i3 = jVar.sampleRate;
                    j = position + ((long) jVar.aPy);
                    readInt2 = lVar.readInt();
                    if ((readInt2 & 1) == 1) {
                    }
                    f = null;
                    fVar.qY();
                    fVar.dH(i6 + 141);
                    fVar.b(this.aTj.data, 0, 3);
                    this.aTj.setPosition(0);
                    iVar = this.aVv;
                    i2 = this.aTj.tD();
                    i4 = i2 >> 12;
                    i2 &= 4095;
                    iVar.aOp = i4;
                    iVar.aOq = i2;
                    fVar.dG(this.aVu.aPy);
                    f = f(fVar);
                    this.aVy = f;
                    this.aVy = f(fVar);
                    this.aTn.a(this.aVy);
                    mVar = this.aVw;
                    str = this.aVu.mimeType;
                    i3 = this.aVu.channels;
                    i5 = this.aVu.sampleRate;
                    readUnsignedShort = this.aVv.aOp;
                    readInt2 = this.aVv.aOq;
                    if ((this.flags & 2) != 0) {
                    }
                    mVar.f(Format.a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
                }
            }
            i = 0;
            if (i != aVq) {
            }
            jVar = this.aVu;
            position = fVar.getPosition();
            length = fVar.getLength();
            i2 = jVar.aTa;
            i3 = jVar.sampleRate;
            j = position + ((long) jVar.aPy);
            readInt2 = lVar.readInt();
            if ((readInt2 & 1) == 1) {
            }
            f = null;
            fVar.qY();
            fVar.dH(i6 + 141);
            fVar.b(this.aTj.data, 0, 3);
            this.aTj.setPosition(0);
            iVar = this.aVv;
            i2 = this.aTj.tD();
            i4 = i2 >> 12;
            i2 &= 4095;
            iVar.aOp = i4;
            iVar.aOq = i2;
            fVar.dG(this.aVu.aPy);
            f = f(fVar);
            this.aVy = f;
            this.aVy = f(fVar);
            this.aTn.a(this.aVy);
            mVar = this.aVw;
            str = this.aVu.mimeType;
            i3 = this.aVu.channels;
            i5 = this.aVu.sampleRate;
            readUnsignedShort = this.aVv.aOp;
            readInt2 = this.aVv.aOq;
            if ((this.flags & 2) != 0) {
            }
            mVar.f(Format.a(null, str, -1, 4096, i3, i5, -1, readUnsignedShort, readInt2, null, null, 0, null, metadata));
        }
        if (this.aVB == 0) {
            fVar.qY();
            if (fVar.b(this.aTj.data, 0, 4, true)) {
                this.aTj.setPosition(0);
                readInt = this.aTj.readInt();
                if (!i(readInt, (long) this.aVx) || j.dN(readInt) == -1) {
                    fVar.dG(1);
                    this.aVx = 0;
                    AppMethodBeat.o(94926);
                    return 0;
                }
                j.a(readInt, this.aVu);
                if (this.aVz == -9223372036854775807L) {
                    this.aVz = this.aVy.O(fVar.getPosition());
                    if (this.aVt != -9223372036854775807L) {
                        this.aVz = (this.aVt - this.aVy.O(0)) + this.aVz;
                    }
                }
                this.aVB = this.aVu.aPy;
            } else {
                AppMethodBeat.o(94926);
                return -1;
            }
        }
        readInt = this.aVw.a(fVar, this.aVB, true);
        if (readInt == -1) {
            AppMethodBeat.o(94926);
            return -1;
        }
        this.aVB -= readInt;
        if (this.aVB > 0) {
            AppMethodBeat.o(94926);
            return 0;
        }
        this.aVw.a(((this.aVA * 1000000) / ((long) this.aVu.sampleRate)) + this.aVz, 1, this.aVu.aPy, 0, null);
        this.aVA += (long) this.aVu.aTa;
        this.aVB = 0;
        AppMethodBeat.o(94926);
        return 0;
    }

    private boolean a(f fVar, boolean z) {
        int qZ;
        int i;
        int i2;
        int i3;
        int i4;
        AppMethodBeat.i(94927);
        int i5 = z ? 16384 : WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        fVar.qY();
        if (fVar.getPosition() == 0) {
            e(fVar);
            qZ = (int) fVar.qZ();
            if (!z) {
                fVar.dG(qZ);
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
            if (!fVar.b(bArr, 0, 4, z2)) {
                break;
            }
            this.aTj.setPosition(0);
            qZ = this.aTj.readInt();
            if (i3 == 0 || i(qZ, (long) i3)) {
                int dN = j.dN(qZ);
                if (dN != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                        qZ = i3;
                    } else {
                        j.a(qZ, this.aVu);
                    }
                    fVar.dH(dN - 4);
                    i3 = qZ;
                }
            }
            qZ = i + 1;
            if (i == i5) {
                if (z) {
                    AppMethodBeat.o(94927);
                    return false;
                }
                o oVar = new o("Searched too many bytes.");
                AppMethodBeat.o(94927);
                throw oVar;
            } else if (z) {
                fVar.qY();
                fVar.dH(i2 + qZ);
                i = qZ;
                i3 = 0;
                i4 = 0;
            } else {
                fVar.dG(1);
                i = qZ;
                i3 = 0;
                i4 = 0;
            }
        }
        if (z) {
            fVar.dG(i2 + i);
        } else {
            fVar.qY();
        }
        this.aVx = i3;
        AppMethodBeat.o(94927);
        return true;
    }

    private void e(f fVar) {
        AppMethodBeat.i(94928);
        int i = 0;
        while (true) {
            fVar.b(this.aTj.data, 0, 10);
            this.aTj.setPosition(0);
            if (this.aTj.tD() == com.google.android.exoplayer2.metadata.id3.a.bbg) {
                this.aTj.eM(3);
                int tH = this.aTj.tH();
                int i2 = tH + 10;
                if (this.aOb == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.aTj.data, 0, bArr, 0, 10);
                    fVar.b(bArr, 10, tH);
                    this.aOb = new com.google.android.exoplayer2.metadata.id3.a((this.flags & 2) != 0 ? i.aSR : null).d(bArr, i2);
                    if (this.aOb != null) {
                        this.aVv.c(this.aOb);
                    }
                } else {
                    fVar.dH(tH);
                }
                i += i2;
            } else {
                fVar.qY();
                fVar.dH(i);
                AppMethodBeat.o(94928);
                return;
            }
        }
    }

    private a f(f fVar) {
        AppMethodBeat.i(94929);
        fVar.b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        j.a(this.aTj.readInt(), this.aVu);
        a aVar = new a(fVar.getPosition(), this.aVu.bitrate, fVar.getLength());
        AppMethodBeat.o(94929);
        return aVar;
    }

    private static boolean i(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }
}
