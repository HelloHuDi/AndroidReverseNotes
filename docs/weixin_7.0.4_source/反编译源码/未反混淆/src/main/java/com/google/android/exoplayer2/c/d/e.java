package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e implements com.google.android.exoplayer2.c.e {
    public static final h aTh = new h() {
        public final com.google.android.exoplayer2.c.e[] ra() {
            AppMethodBeat.i(94960);
            com.google.android.exoplayer2.c.e[] eVarArr = new com.google.android.exoplayer2.c.e[]{new e()};
            AppMethodBeat.o(94960);
            return eVarArr;
        }
    };
    private static final int aXX = v.aT("seig");
    private static final byte[] aXY = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private long aOz;
    private g aTn;
    private int aTo;
    private final l aTx;
    private int aUF;
    private int aUG;
    private final j aXZ;
    private final SparseArray<b> aYa;
    private final l aYb;
    private final l aYc;
    private final l aYd;
    private final l aYe;
    private final s aYf;
    private final l aYg;
    private final byte[] aYh;
    private final Stack<a> aYi;
    private final LinkedList<a> aYj;
    private int aYk;
    private long aYl;
    private int aYm;
    private l aYn;
    private long aYo;
    private int aYp;
    private long aYq;
    private b aYr;
    private boolean aYs;
    private m aYt;
    private m[] aYu;
    private boolean aYv;
    private final int flags;
    private int sampleSize;

    static final class a {
        public final long aYw;
        public final int size;

        public a(long j, int i) {
            this.aYw = j;
            this.size = i;
        }
    }

    static final class b {
        public final m aTw;
        public int aYA;
        public int aYB;
        public int aYC;
        public final l aYx = new l();
        public j aYy;
        public c aYz;

        public b(m mVar) {
            AppMethodBeat.i(94961);
            this.aTw = mVar;
            AppMethodBeat.o(94961);
        }

        public final void a(j jVar, c cVar) {
            AppMethodBeat.i(94962);
            this.aYy = (j) com.google.android.exoplayer2.i.a.checkNotNull(jVar);
            this.aYz = (c) com.google.android.exoplayer2.i.a.checkNotNull(cVar);
            this.aTw.f(jVar.aOv);
            reset();
            AppMethodBeat.o(94962);
        }

        public final void reset() {
            AppMethodBeat.i(94963);
            this.aYx.reset();
            this.aYA = 0;
            this.aYC = 0;
            this.aYB = 0;
            AppMethodBeat.o(94963);
        }

        public final void b(DrmInitData drmInitData) {
            AppMethodBeat.i(94964);
            k dZ = this.aYy.dZ(this.aYx.aZw.aXT);
            this.aTw.f(this.aYy.aOv.a(drmInitData.aw(dZ != null ? dZ.aZt : null)));
            AppMethodBeat.o(94964);
        }
    }

    static {
        AppMethodBeat.i(94989);
        AppMethodBeat.o(94989);
    }

    public e() {
        this(0);
    }

    public e(int i) {
        this(i, null);
    }

    public e(int i, s sVar) {
        this(i, sVar, (byte) 0);
    }

    private e(int i, s sVar, byte b) {
        AppMethodBeat.i(94965);
        this.flags = i | 0;
        this.aYf = sVar;
        this.aXZ = null;
        this.aYg = new l(16);
        this.aTx = new l(j.bqY);
        this.aYb = new l(5);
        this.aYc = new l();
        this.aYd = new l(1);
        this.aYe = new l();
        this.aYh = new byte[16];
        this.aYi = new Stack();
        this.aYj = new LinkedList();
        this.aYa = new SparseArray();
        this.aOz = -9223372036854775807L;
        this.aYq = -9223372036854775807L;
        ri();
        AppMethodBeat.o(94965);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(94966);
        boolean g = i.g(fVar);
        AppMethodBeat.o(94966);
        return g;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(94967);
        this.aTn = gVar;
        if (this.aXZ != null) {
            b bVar = new b(gVar.dM(0));
            bVar.a(this.aXZ, new c(0, 0, 0, 0));
            this.aYa.put(0, bVar);
            rj();
            this.aTn.rb();
        }
        AppMethodBeat.o(94967);
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(94968);
        int size = this.aYa.size();
        for (int i = 0; i < size; i++) {
            ((b) this.aYa.valueAt(i)).reset();
        }
        this.aYj.clear();
        this.aYp = 0;
        this.aYi.clear();
        ri();
        AppMethodBeat.o(94968);
    }

    /* JADX WARNING: Removed duplicated region for block: B:279:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0501 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0066 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(94969);
        while (true) {
            Object obj;
            long length;
            o oVar;
            long position;
            int size;
            l lVar;
            int i;
            long cM;
            int i2;
            int readInt;
            int tB;
            b bVar;
            b bVar2;
            switch (this.aTo) {
                case 0:
                    if (this.aYm == 0) {
                        if (!fVar.a(this.aYg.data, 0, 8, true)) {
                            obj = null;
                            if (obj == null) {
                                break;
                            }
                            AppMethodBeat.o(94969);
                            return -1;
                        }
                        this.aYm = 8;
                        this.aYg.setPosition(0);
                        this.aYl = this.aYg.cM();
                        this.aYk = this.aYg.readInt();
                    }
                    if (this.aYl == 1) {
                        fVar.readFully(this.aYg.data, 8, 8);
                        this.aYm += 8;
                        this.aYl = this.aYg.tK();
                    } else if (this.aYl == 0) {
                        length = fVar.getLength();
                        if (length == -1 && !this.aYi.isEmpty()) {
                            length = ((a) this.aYi.peek()).aXw;
                        }
                        if (length != -1) {
                            this.aYl = (length - fVar.getPosition()) + ((long) this.aYm);
                        }
                    }
                    if (this.aYl < ((long) this.aYm)) {
                        oVar = new o("Atom size less than header length (unsupported).");
                        AppMethodBeat.o(94969);
                        throw oVar;
                    }
                    position = fVar.getPosition() - ((long) this.aYm);
                    if (this.aYk == a.aWr) {
                        size = this.aYa.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            lVar = ((b) this.aYa.valueAt(i3)).aYx;
                            lVar.aZx = position;
                            lVar.aZz = position;
                            lVar.aZy = position;
                        }
                    }
                    if (this.aYk == a.aVO) {
                        this.aYr = null;
                        this.aYo = this.aYl + position;
                        if (!this.aYv) {
                            this.aTn.a(new com.google.android.exoplayer2.c.l.a(this.aOz));
                            this.aYv = true;
                        }
                        this.aTo = 2;
                    } else {
                        i = this.aYk;
                        if (i == a.aWi || i == a.aWk || i == a.aWl || i == a.aWm || i == a.aWn || i == a.aWr || i == a.aWs || i == a.aWt || i == a.aWw) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            length = (fVar.getPosition() + this.aYl) - 8;
                            this.aYi.add(new a(this.aYk, length));
                            if (this.aYl == ((long) this.aYm)) {
                                P(length);
                            } else {
                                ri();
                            }
                        } else {
                            i = this.aYk;
                            if (i == a.aWz || i == a.aWy || i == a.aWj || i == a.aWh || i == a.aWA || i == a.aWd || i == a.aWe || i == a.aWv || i == a.aWf || i == a.aWg || i == a.aWB || i == a.aWJ || i == a.aWK || i == a.aWO || i == a.aWN || i == a.aWL || i == a.aWM || i == a.aWx || i == a.aWu || i == a.aXn) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                if (this.aYm != 8) {
                                    oVar = new o("Leaf atom defines extended atom size (unsupported).");
                                    AppMethodBeat.o(94969);
                                    throw oVar;
                                } else if (this.aYl > 2147483647L) {
                                    oVar = new o("Leaf atom with length > 2147483647 (unsupported).");
                                    AppMethodBeat.o(94969);
                                    throw oVar;
                                } else {
                                    this.aYn = new l((int) this.aYl);
                                    System.arraycopy(this.aYg.data, 0, this.aYn.data, 0, 8);
                                    this.aTo = 1;
                                }
                            } else if (this.aYl > 2147483647L) {
                                oVar = new o("Skipping atom with length > 2147483647 (unsupported).");
                                AppMethodBeat.o(94969);
                                throw oVar;
                            } else {
                                this.aYn = null;
                                this.aTo = 1;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                    }
                    break;
                case 1:
                    i = ((int) this.aYl) - this.aYm;
                    if (this.aYn != null) {
                        fVar.readFully(this.aYn.data, 8, i);
                        b bVar3 = new b(this.aYk, this.aYn);
                        position = fVar.getPosition();
                        if (!this.aYi.isEmpty()) {
                            ((a) this.aYi.peek()).a(bVar3);
                        } else if (bVar3.type == a.aWh) {
                            long cM2;
                            l lVar2 = bVar3.aXz;
                            lVar2.setPosition(8);
                            i = a.dT(lVar2.readInt());
                            lVar2.eM(4);
                            cM = lVar2.cM();
                            if (i == 0) {
                                length = lVar2.cM();
                                cM2 = position + lVar2.cM();
                            } else {
                                length = lVar2.tK();
                                cM2 = position + lVar2.tK();
                            }
                            long b = v.b(length, 1000000, cM);
                            lVar2.eM(2);
                            int readUnsignedShort = lVar2.readUnsignedShort();
                            int[] iArr = new int[readUnsignedShort];
                            long[] jArr = new long[readUnsignedShort];
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            i2 = 0;
                            long j = b;
                            long j2 = cM2;
                            while (i2 < readUnsignedShort) {
                                readInt = lVar2.readInt();
                                if ((android.support.v4.widget.j.INVALID_ID & readInt) != 0) {
                                    oVar = new o("Unhandled indirect reference");
                                    AppMethodBeat.o(94969);
                                    throw oVar;
                                }
                                cM2 = lVar2.cM();
                                iArr[i2] = readInt & BaseClientBuilder.API_PRIORITY_OTHER;
                                jArr[i2] = j2;
                                jArr3[i2] = j;
                                length += cM2;
                                cM2 = v.b(length, 1000000, cM);
                                jArr2[i2] = cM2 - jArr3[i2];
                                lVar2.eM(4);
                                j2 += (long) iArr[i2];
                                i2++;
                                j = cM2;
                            }
                            Pair create = Pair.create(Long.valueOf(b), new com.google.android.exoplayer2.c.a(iArr, jArr, jArr2, jArr3));
                            this.aYq = ((Long) create.first).longValue();
                            this.aTn.a((com.google.android.exoplayer2.c.l) create.second);
                            this.aYv = true;
                        } else if (bVar3.type == a.aXn) {
                            l lVar3 = bVar3.aXz;
                            if (this.aYt != null) {
                                lVar3.setPosition(12);
                                lVar3.tL();
                                lVar3.tL();
                                position = v.b(lVar3.cM(), 1000000, lVar3.cM());
                                lVar3.setPosition(12);
                                tB = lVar3.tB();
                                this.aYt.a(lVar3, tB);
                                if (this.aYq != -9223372036854775807L) {
                                    this.aYt.a(position + this.aYq, 1, tB, 0, null);
                                } else {
                                    this.aYj.addLast(new a(position, tB));
                                    this.aYp += tB;
                                }
                            }
                        }
                    } else {
                        fVar.dG(i);
                    }
                    P(fVar.getPosition());
                    break;
                case 2:
                    bVar = null;
                    position = Long.MAX_VALUE;
                    tB = this.aYa.size();
                    size = 0;
                    while (size < tB) {
                        lVar = ((b) this.aYa.valueAt(size)).aYx;
                        if (!lVar.aZM || lVar.aZz >= position) {
                            bVar2 = bVar;
                        } else {
                            position = lVar.aZz;
                            bVar2 = (b) this.aYa.valueAt(size);
                        }
                        size++;
                        bVar = bVar2;
                    }
                    if (bVar != null) {
                        i = (int) (position - fVar.getPosition());
                        if (i >= 0) {
                            fVar.dG(i);
                            lVar = bVar.aYx;
                            fVar.readFully(lVar.aZL.data, 0, lVar.aZK);
                            lVar.aZL.setPosition(0);
                            lVar.aZM = false;
                            break;
                        }
                        oVar = new o("Offset to encryption data was negative.");
                        AppMethodBeat.o(94969);
                        throw oVar;
                    }
                    this.aTo = 3;
                    break;
                    break;
                default:
                    int i4;
                    k kVar2;
                    if (this.aTo == 3) {
                        if (this.aYr == null) {
                            SparseArray sparseArray = this.aYa;
                            bVar = null;
                            cM = Long.MAX_VALUE;
                            i2 = sparseArray.size();
                            i4 = 0;
                            while (i4 < i2) {
                                bVar2 = (b) sparseArray.valueAt(i4);
                                if (bVar2.aYC != bVar2.aYx.aZA) {
                                    position = bVar2.aYx.aZB[bVar2.aYC];
                                    if (position < cM) {
                                        i4++;
                                        cM = position;
                                        bVar = bVar2;
                                    }
                                }
                                position = cM;
                                bVar2 = bVar;
                                i4++;
                                cM = position;
                                bVar = bVar2;
                            }
                            if (bVar == null) {
                                i = (int) (this.aYo - fVar.getPosition());
                                if (i >= 0) {
                                    fVar.dG(i);
                                    ri();
                                    obj = null;
                                    if (obj != null) {
                                        break;
                                    }
                                    AppMethodBeat.o(94969);
                                    return 0;
                                }
                                oVar = new o("Offset to end of mdat was negative.");
                                AppMethodBeat.o(94969);
                                throw oVar;
                            }
                            i = (int) (bVar.aYx.aZB[bVar.aYC] - fVar.getPosition());
                            if (i < 0) {
                                i = 0;
                            }
                            fVar.dG(i);
                            this.aYr = bVar;
                        }
                        this.sampleSize = this.aYr.aYx.aZD[this.aYr.aYA];
                        if (this.aYr.aYx.aZH) {
                            l lVar4;
                            b bVar4 = this.aYr;
                            l lVar5 = bVar4.aYx;
                            i = lVar5.aZw.aXT;
                            if (lVar5.aZJ != null) {
                                kVar2 = lVar5.aZJ;
                            } else {
                                kVar2 = bVar4.aYy.dZ(i);
                            }
                            if (kVar2.aZu != 0) {
                                lVar4 = lVar5.aZL;
                                i = kVar2.aZu;
                            } else {
                                byte[] bArr = kVar2.aZv;
                                this.aYe.n(bArr, bArr.length);
                                lVar4 = this.aYe;
                                i = bArr.length;
                            }
                            boolean z = lVar5.aZI[bVar4.aYA];
                            this.aYd.data[0] = (byte) ((z ? 128 : 0) | i);
                            this.aYd.setPosition(0);
                            m mVar = bVar4.aTw;
                            mVar.a(this.aYd, 1);
                            mVar.a(lVar4, i);
                            if (z) {
                                lVar4 = lVar5.aZL;
                                int readUnsignedShort2 = lVar4.readUnsignedShort();
                                lVar4.eM(-2);
                                readUnsignedShort2 = (readUnsignedShort2 * 6) + 2;
                                mVar.a(lVar4, readUnsignedShort2);
                                i = (i + 1) + readUnsignedShort2;
                            } else {
                                i++;
                            }
                            this.aUG = i;
                            this.sampleSize += this.aUG;
                        } else {
                            this.aUG = 0;
                        }
                        if (this.aYr.aYy.aZo == 1) {
                            this.sampleSize -= 8;
                            fVar.dG(8);
                        }
                        this.aTo = 4;
                        this.aUF = 0;
                    }
                    l lVar6 = this.aYr.aYx;
                    j jVar = this.aYr.aYy;
                    m mVar2 = this.aYr.aTw;
                    size = this.aYr.aYA;
                    if (jVar.aTz != 0) {
                        byte[] bArr2 = this.aYb.data;
                        bArr2[0] = (byte) 0;
                        bArr2[1] = (byte) 0;
                        bArr2[2] = (byte) 0;
                        i4 = jVar.aTz + 1;
                        int i5 = 4 - jVar.aTz;
                        while (this.aUG < this.sampleSize) {
                            if (this.aUF == 0) {
                                fVar.readFully(bArr2, i5, i4);
                                this.aYb.setPosition(0);
                                this.aUF = this.aYb.tI() - 1;
                                this.aTx.setPosition(0);
                                mVar2.a(this.aTx, 4);
                                mVar2.a(this.aYb, 1);
                                boolean z2 = this.aYu != null && j.b(jVar.aOv.aOd, bArr2[4]);
                                this.aYs = z2;
                                this.aUG += 5;
                                this.sampleSize += i5;
                            } else {
                                if (this.aYs) {
                                    this.aYc.reset(this.aUF);
                                    fVar.readFully(this.aYc.data, 0, this.aUF);
                                    mVar2.a(this.aYc, this.aUF);
                                    readInt = this.aUF;
                                    i2 = j.j(this.aYc.data, this.aYc.limit);
                                    this.aYc.setPosition("video/hevc".equals(jVar.aOv.aOd) ? 1 : 0);
                                    this.aYc.eL(i2);
                                    com.google.android.exoplayer2.f.a.g.a(lVar6.eb(size) * 1000, this.aYc, this.aYu);
                                    i = readInt;
                                } else {
                                    i = mVar2.a(fVar, this.aUF, false);
                                }
                                this.aUG += i;
                                this.aUF -= i;
                            }
                        }
                    } else {
                        while (this.aUG < this.sampleSize) {
                            this.aUG = mVar2.a(fVar, this.sampleSize - this.aUG, false) + this.aUG;
                        }
                    }
                    position = lVar6.eb(size) * 1000;
                    if (this.aYf != null) {
                        position = this.aYf.ap(position);
                    }
                    i = lVar6.aZG[size] ? 1 : 0;
                    com.google.android.exoplayer2.c.m.a aVar = null;
                    if (lVar6.aZH) {
                        size = ErrorDialogData.SUPPRESSED | i;
                        if (lVar6.aZJ != null) {
                            kVar2 = lVar6.aZJ;
                        } else {
                            kVar2 = jVar.dZ(lVar6.aZw.aXT);
                        }
                        aVar = kVar2.aUO;
                    } else {
                        size = i;
                    }
                    mVar2.a(position, size, this.sampleSize, 0, aVar);
                    while (!this.aYj.isEmpty()) {
                        a aVar2 = (a) this.aYj.removeFirst();
                        this.aYp -= aVar2.size;
                        this.aYt.a(aVar2.aYw + position, 1, aVar2.size, this.aYp, null);
                    }
                    bVar2 = this.aYr;
                    bVar2.aYA++;
                    bVar2 = this.aYr;
                    bVar2.aYB++;
                    if (this.aYr.aYB == lVar6.aZC[this.aYr.aYC]) {
                        bVar2 = this.aYr;
                        bVar2.aYC++;
                        this.aYr.aYB = 0;
                        this.aYr = null;
                    }
                    this.aTo = 3;
                    obj = 1;
                    if (obj != null) {
                    }
                    break;
            }
        }
    }

    private void ri() {
        this.aTo = 0;
        this.aYm = 0;
    }

    private void P(long j) {
        AppMethodBeat.i(94970);
        while (!this.aYi.isEmpty() && ((a) this.aYi.peek()).aXw == j) {
            c((a) this.aYi.pop());
        }
        ri();
        AppMethodBeat.o(94970);
    }

    private void c(a aVar) {
        AppMethodBeat.i(94971);
        if (aVar.type == a.aWi) {
            d(aVar);
            AppMethodBeat.o(94971);
        } else if (aVar.type == a.aWr) {
            e(aVar);
            AppMethodBeat.o(94971);
        } else {
            if (!this.aYi.isEmpty()) {
                ((a) this.aYi.peek()).a(aVar);
            }
            AppMethodBeat.o(94971);
        }
    }

    private void d(a aVar) {
        j a;
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(94972);
        com.google.android.exoplayer2.i.a.checkState(this.aXZ == null, "Unexpected moov box.");
        DrmInitData u = u(aVar.aXx);
        a dX = aVar.dX(a.aWt);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = dX.aXx.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) dX.aXx.get(i2);
            if (bVar.type == a.aWf) {
                Pair l = l(bVar.aXz);
                sparseArray.put(((Integer) l.first).intValue(), l.second);
            } else if (bVar.type == a.aWu) {
                j = m(bVar.aXz);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.aXy.size();
        for (size = 0; size < size2; size++) {
            a aVar2 = (a) aVar.aXy.get(size);
            if (aVar2.type == a.aWk) {
                boolean z2;
                b dW = aVar.dW(a.aWj);
                if ((this.flags & 32) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a = b.a(aVar2, dW, j, u, z2, false);
                if (a != null) {
                    sparseArray2.put(a.id, a);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.aYa.size() == 0) {
            while (i < size3) {
                j jVar = (j) sparseArray2.valueAt(i);
                b bVar2 = new b(this.aTn.dM(i));
                bVar2.a(jVar, (c) sparseArray.get(jVar.id));
                this.aYa.put(jVar.id, bVar2);
                this.aOz = Math.max(this.aOz, jVar.aOz);
                i++;
            }
            rj();
            this.aTn.rb();
            AppMethodBeat.o(94972);
            return;
        }
        if (this.aYa.size() != size3) {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        while (i < size3) {
            a = (j) sparseArray2.valueAt(i);
            ((b) this.aYa.get(a.id)).a(a, (c) sparseArray.get(a.id));
            i++;
        }
        AppMethodBeat.o(94972);
    }

    private void e(a aVar) {
        AppMethodBeat.i(94973);
        a(aVar, this.aYa, this.flags, this.aYh);
        DrmInitData u = u(aVar.aXx);
        if (u != null) {
            int size = this.aYa.size();
            for (int i = 0; i < size; i++) {
                ((b) this.aYa.valueAt(i)).b(u);
            }
        }
        AppMethodBeat.o(94973);
    }

    private void rj() {
        AppMethodBeat.i(94974);
        if ((this.flags & 4) != 0 && this.aYt == null) {
            this.aYt = this.aTn.dM(this.aYa.size());
            this.aYt.f(Format.c("application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.flags & 8) != 0 && this.aYu == null) {
            this.aTn.dM(this.aYa.size() + 1).f(Format.as("application/cea-608"));
            this.aYu = new m[]{r0};
        }
        AppMethodBeat.o(94974);
    }

    private static Pair<Integer, c> l(l lVar) {
        AppMethodBeat.i(94975);
        lVar.setPosition(12);
        Pair create = Pair.create(Integer.valueOf(lVar.readInt()), new c(lVar.tI() - 1, lVar.tI(), lVar.tI(), lVar.readInt()));
        AppMethodBeat.o(94975);
        return create;
    }

    private static long m(l lVar) {
        AppMethodBeat.i(94976);
        lVar.setPosition(8);
        long cM;
        if (a.dT(lVar.readInt()) == 0) {
            cM = lVar.cM();
            AppMethodBeat.o(94976);
            return cM;
        }
        cM = lVar.tK();
        AppMethodBeat.o(94976);
        return cM;
    }

    private static void a(a aVar, SparseArray<b> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.i(94977);
        int size = aVar.aXy.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar2 = (a) aVar.aXy.get(i2);
            if (aVar2.type == a.aWs) {
                b(aVar2, sparseArray, i, bArr);
            }
        }
        AppMethodBeat.o(94977);
    }

    private static void b(a aVar, SparseArray<b> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.i(94978);
        b a = a(aVar.dW(a.aWe).aXz, (SparseArray) sparseArray, i);
        if (a == null) {
            AppMethodBeat.o(94978);
            return;
        }
        l lVar = a.aYx;
        long j = lVar.aZN;
        a.reset();
        if (aVar.dW(a.aWd) != null && (i & 2) == 0) {
            j = n(aVar.dW(a.aWd).aXz);
        }
        a(aVar, a, j, i);
        k dZ = a.aYy.dZ(lVar.aZw.aXT);
        b dW = aVar.dW(a.aWJ);
        if (dW != null) {
            a(dZ, dW.aXz, lVar);
        }
        dW = aVar.dW(a.aWK);
        if (dW != null) {
            a(dW.aXz, lVar);
        }
        dW = aVar.dW(a.aWO);
        if (dW != null) {
            a(dW.aXz, 0, lVar);
        }
        dW = aVar.dW(a.aWL);
        b dW2 = aVar.dW(a.aWM);
        if (!(dW == null || dW2 == null)) {
            a(dW.aXz, dW2.aXz, dZ != null ? dZ.aZt : null, lVar);
        }
        int size = aVar.aXx.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) aVar.aXx.get(i2);
            if (bVar.type == a.aWN) {
                a(bVar.aXz, lVar, bArr);
            }
        }
        AppMethodBeat.o(94978);
    }

    private static void a(a aVar, b bVar, long j, int i) {
        b bVar2;
        AppMethodBeat.i(94979);
        int i2 = 0;
        int i3 = 0;
        List list = aVar.aXx;
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            int tI;
            bVar2 = (b) list.get(i4);
            if (bVar2.type == a.aWg) {
                l lVar = bVar2.aXz;
                lVar.setPosition(12);
                tI = lVar.tI();
                if (tI > 0) {
                    tI += i3;
                    i2++;
                    i4++;
                    i3 = tI;
                }
            }
            tI = i3;
            i4++;
            i3 = tI;
        }
        bVar.aYC = 0;
        bVar.aYB = 0;
        bVar.aYA = 0;
        bVar.aYx.bd(i2, i3);
        i3 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            bVar2 = (b) list.get(i6);
            if (bVar2.type == a.aWg) {
                int i7 = i3 + 1;
                i5 = a(bVar, i3, j, i, bVar2.aXz, i5);
                i3 = i7;
            }
        }
        AppMethodBeat.o(94979);
    }

    private static void a(k kVar, l lVar, l lVar2) {
        boolean z = true;
        AppMethodBeat.i(94980);
        int i = kVar.aZu;
        lVar.setPosition(8);
        if ((a.dU(lVar.readInt()) & 1) == 1) {
            lVar.eM(8);
        }
        int readUnsignedByte = lVar.readUnsignedByte();
        int tI = lVar.tI();
        if (tI != lVar2.sampleCount) {
            o oVar = new o("Length mismatch: " + tI + ", " + lVar2.sampleCount);
            AppMethodBeat.o(94980);
            throw oVar;
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = lVar2.aZI;
            readUnsignedByte = 0;
            int i2 = 0;
            while (i2 < tI) {
                boolean z2;
                int readUnsignedByte2 = lVar.readUnsignedByte();
                int i3 = readUnsignedByte + readUnsignedByte2;
                if (readUnsignedByte2 > i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i2] = z2;
                i2++;
                readUnsignedByte = i3;
            }
        } else {
            if (readUnsignedByte <= i) {
                z = false;
            }
            readUnsignedByte = (readUnsignedByte * tI) + 0;
            Arrays.fill(lVar2.aZI, 0, tI, z);
        }
        lVar2.ea(readUnsignedByte);
        AppMethodBeat.o(94980);
    }

    private static void a(l lVar, l lVar2) {
        AppMethodBeat.i(94981);
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if ((a.dU(readInt) & 1) == 1) {
            lVar.eM(8);
        }
        int tI = lVar.tI();
        if (tI != 1) {
            o oVar = new o("Unexpected saio entry count: ".concat(String.valueOf(tI)));
            AppMethodBeat.o(94981);
            throw oVar;
        }
        readInt = a.dT(readInt);
        lVar2.aZz = (readInt == 0 ? lVar.cM() : lVar.tK()) + lVar2.aZz;
        AppMethodBeat.o(94981);
    }

    private static b a(l lVar, SparseArray<b> sparseArray, int i) {
        AppMethodBeat.i(94982);
        lVar.setPosition(8);
        int dU = a.dU(lVar.readInt());
        int readInt = lVar.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        b bVar = (b) sparseArray.get(readInt);
        if (bVar == null) {
            AppMethodBeat.o(94982);
            return null;
        }
        if ((dU & 1) != 0) {
            long tK = lVar.tK();
            bVar.aYx.aZy = tK;
            bVar.aYx.aZz = tK;
        }
        c cVar = bVar.aYz;
        bVar.aYx.aZw = new c((dU & 2) != 0 ? lVar.tI() - 1 : cVar.aXT, (dU & 8) != 0 ? lVar.tI() : cVar.duration, (dU & 16) != 0 ? lVar.tI() : cVar.size, (dU & 32) != 0 ? lVar.tI() : cVar.flags);
        AppMethodBeat.o(94982);
        return bVar;
    }

    private static long n(l lVar) {
        AppMethodBeat.i(94983);
        lVar.setPosition(8);
        long tK;
        if (a.dT(lVar.readInt()) == 1) {
            tK = lVar.tK();
            AppMethodBeat.o(94983);
            return tK;
        }
        tK = lVar.cM();
        AppMethodBeat.o(94983);
        return tK;
    }

    private static int a(b bVar, int i, long j, int i2, l lVar, int i3) {
        Object obj;
        long b;
        AppMethodBeat.i(94984);
        lVar.setPosition(8);
        int dU = a.dU(lVar.readInt());
        j jVar = bVar.aYy;
        l lVar2 = bVar.aYx;
        c cVar = lVar2.aZw;
        lVar2.aZC[i] = lVar.tI();
        lVar2.aZB[i] = lVar2.aZy;
        if ((dU & 1) != 0) {
            long[] jArr = lVar2.aZB;
            jArr[i] = jArr[i] + ((long) lVar.readInt());
        }
        Object obj2 = (dU & 4) != 0 ? 1 : null;
        int i4 = cVar.flags;
        if (obj2 != null) {
            i4 = lVar.tI();
        }
        Object obj3 = (dU & 256) != 0 ? 1 : null;
        Object obj4 = (dU & 512) != 0 ? 1 : null;
        Object obj5 = (dU & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 1 : null;
        if ((dU & 2048) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (jVar.aZp != null && jVar.aZp.length == 1 && jVar.aZp[0] == 0) {
            b = v.b(jVar.aZq[0], 1000, jVar.aZm);
        } else {
            b = 0;
        }
        int[] iArr = lVar2.aZD;
        int[] iArr2 = lVar2.aZE;
        long[] jArr2 = lVar2.aZF;
        boolean[] zArr = lVar2.aZG;
        Object obj6 = (jVar.type != 2 || (i2 & 1) == 0) ? null : 1;
        int i5 = i3 + lVar2.aZC[i];
        long j2 = jVar.aZm;
        if (i > 0) {
            j = lVar2.aZN;
        }
        long j3 = j;
        while (i3 < i5) {
            int tI = obj3 != null ? lVar.tI() : cVar.duration;
            int tI2 = obj4 != null ? lVar.tI() : cVar.size;
            int readInt = (i3 != 0 || obj2 == null) ? obj5 != null ? lVar.readInt() : cVar.flags : i4;
            if (obj != null) {
                iArr2[i3] = (int) ((((long) lVar.readInt()) * 1000) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = v.b(j3, 1000, j2) - b;
            iArr[i3] = tI2;
            boolean z = ((readInt >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j3 += (long) tI;
            i3++;
        }
        lVar2.aZN = j3;
        AppMethodBeat.o(94984);
        return i5;
    }

    private static void a(l lVar, l lVar2, byte[] bArr) {
        AppMethodBeat.i(94985);
        lVar.setPosition(8);
        lVar.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, aXY)) {
            a(lVar, 16, lVar2);
            AppMethodBeat.o(94985);
            return;
        }
        AppMethodBeat.o(94985);
    }

    private static void a(l lVar, int i, l lVar2) {
        AppMethodBeat.i(94986);
        lVar.setPosition(i + 8);
        int dU = a.dU(lVar.readInt());
        o oVar;
        if ((dU & 1) != 0) {
            oVar = new o("Overriding TrackEncryptionBox parameters is unsupported.");
            AppMethodBeat.o(94986);
            throw oVar;
        }
        boolean z;
        if ((dU & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int tI = lVar.tI();
        if (tI != lVar2.sampleCount) {
            oVar = new o("Length mismatch: " + tI + ", " + lVar2.sampleCount);
            AppMethodBeat.o(94986);
            throw oVar;
        }
        Arrays.fill(lVar2.aZI, 0, tI, z);
        lVar2.ea(lVar.tB());
        lVar2.q(lVar);
        AppMethodBeat.o(94986);
    }

    private static void a(l lVar, l lVar2, String str, l lVar3) {
        AppMethodBeat.i(94987);
        lVar.setPosition(8);
        int readInt = lVar.readInt();
        if (lVar.readInt() != aXX) {
            AppMethodBeat.o(94987);
            return;
        }
        if (a.dT(readInt) == 1) {
            lVar.eM(4);
        }
        o oVar;
        if (lVar.readInt() != 1) {
            oVar = new o("Entry count in sbgp != 1 (unsupported).");
            AppMethodBeat.o(94987);
            throw oVar;
        }
        lVar2.setPosition(8);
        readInt = lVar2.readInt();
        if (lVar2.readInt() != aXX) {
            AppMethodBeat.o(94987);
            return;
        }
        readInt = a.dT(readInt);
        if (readInt == 1) {
            if (lVar2.cM() == 0) {
                oVar = new o("Variable length description in sgpd found (unsupported)");
                AppMethodBeat.o(94987);
                throw oVar;
            }
        } else if (readInt >= 2) {
            lVar2.eM(4);
        }
        if (lVar2.cM() != 1) {
            oVar = new o("Entry count in sgpd != 1 (unsupported).");
            AppMethodBeat.o(94987);
            throw oVar;
        }
        lVar2.eM(1);
        readInt = lVar2.readUnsignedByte();
        int i = (readInt & 240) >> 4;
        int i2 = readInt & 15;
        if (lVar2.readUnsignedByte() == 1) {
            readInt = 1;
        } else {
            readInt = 0;
        }
        if (readInt == 0) {
            AppMethodBeat.o(94987);
            return;
        }
        int readUnsignedByte = lVar2.readUnsignedByte();
        byte[] bArr = new byte[16];
        lVar2.readBytes(bArr, 0, 16);
        byte[] bArr2 = null;
        if (readUnsignedByte == 0) {
            readInt = lVar2.readUnsignedByte();
            bArr2 = new byte[readInt];
            lVar2.readBytes(bArr2, 0, readInt);
        }
        lVar3.aZH = true;
        lVar3.aZJ = new k(true, str, readUnsignedByte, bArr, i, i2, bArr2);
        AppMethodBeat.o(94987);
    }

    private static DrmInitData u(List<b> list) {
        AppMethodBeat.i(94988);
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) list.get(i);
            if (bVar.type == a.aWB) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = bVar.aXz.data;
                UUID n = h.n(bArr);
                if (n != null) {
                    list2.add(new SchemeData(n, "video/mp4", bArr));
                }
            }
        }
        if (list2 == null) {
            AppMethodBeat.o(94988);
            return null;
        }
        DrmInitData drmInitData = new DrmInitData(list2);
        AppMethodBeat.o(94988);
        return drmInitData;
    }
}
