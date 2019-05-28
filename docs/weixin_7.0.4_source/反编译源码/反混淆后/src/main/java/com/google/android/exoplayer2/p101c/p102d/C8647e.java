package com.google.android.exoplayer2.p101c.p102d;

import android.support.p057v4.widget.C8415j;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.p101c.C25515a;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C32041m.C8663a;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32026a;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32027b;
import com.google.android.exoplayer2.p105f.p798a.C45031g;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.p111i.C45042s;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* renamed from: com.google.android.exoplayer2.c.d.e */
public final class C8647e implements C32034e {
    public static final C32039h aTh = new C86481();
    private static final int aXX = C17675v.m27562aT("seig");
    private static final byte[] aXY = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private long aOz;
    private C8662g aTn;
    private int aTo;
    private final C32065l aTx;
    private int aUF;
    private int aUG;
    private final C37236j aXZ;
    private final SparseArray<C8650b> aYa;
    private final C32065l aYb;
    private final C32065l aYc;
    private final C32065l aYd;
    private final C32065l aYe;
    private final C45042s aYf;
    private final C32065l aYg;
    private final byte[] aYh;
    private final Stack<C32026a> aYi;
    private final LinkedList<C8649a> aYj;
    private int aYk;
    private long aYl;
    private int aYm;
    private C32065l aYn;
    private long aYo;
    private int aYp;
    private long aYq;
    private C8650b aYr;
    private boolean aYs;
    private C32041m aYt;
    private C32041m[] aYu;
    private boolean aYv;
    private final int flags;
    private int sampleSize;

    /* renamed from: com.google.android.exoplayer2.c.d.e$1 */
    static class C86481 implements C32039h {
        C86481() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(94960);
            C32034e[] c32034eArr = new C32034e[]{new C8647e()};
            AppMethodBeat.m2505o(94960);
            return c32034eArr;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.e$a */
    static final class C8649a {
        public final long aYw;
        public final int size;

        public C8649a(long j, int i) {
            this.aYw = j;
            this.size = i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.e$b */
    static final class C8650b {
        public final C32041m aTw;
        public int aYA;
        public int aYB;
        public int aYC;
        public final C8652l aYx = new C8652l();
        public C37236j aYy;
        public C0839c aYz;

        public C8650b(C32041m c32041m) {
            AppMethodBeat.m2504i(94961);
            this.aTw = c32041m;
            AppMethodBeat.m2505o(94961);
        }

        /* renamed from: a */
        public final void mo19145a(C37236j c37236j, C0839c c0839c) {
            AppMethodBeat.m2504i(94962);
            this.aYy = (C37236j) C45039a.checkNotNull(c37236j);
            this.aYz = (C0839c) C45039a.checkNotNull(c0839c);
            this.aTw.mo42836f(c37236j.aOv);
            reset();
            AppMethodBeat.m2505o(94962);
        }

        public final void reset() {
            AppMethodBeat.m2504i(94963);
            this.aYx.reset();
            this.aYA = 0;
            this.aYC = 0;
            this.aYB = 0;
            AppMethodBeat.m2505o(94963);
        }

        /* renamed from: b */
        public final void mo19146b(DrmInitData drmInitData) {
            AppMethodBeat.m2504i(94964);
            C25518k dZ = this.aYy.mo59490dZ(this.aYx.aZw.aXT);
            this.aTw.mo42836f(this.aYy.aOv.mo19112a(drmInitData.mo32330aw(dZ != null ? dZ.aZt : null)));
            AppMethodBeat.m2505o(94964);
        }
    }

    static {
        AppMethodBeat.m2504i(94989);
        AppMethodBeat.m2505o(94989);
    }

    public C8647e() {
        this(0);
    }

    public C8647e(int i) {
        this(i, null);
    }

    public C8647e(int i, C45042s c45042s) {
        this(i, c45042s, (byte) 0);
    }

    private C8647e(int i, C45042s c45042s, byte b) {
        AppMethodBeat.m2504i(94965);
        this.flags = i | 0;
        this.aYf = c45042s;
        this.aXZ = null;
        this.aYg = new C32065l(16);
        this.aTx = new C32065l(C45041j.bqY);
        this.aYb = new C32065l(5);
        this.aYc = new C32065l();
        this.aYd = new C32065l(1);
        this.aYe = new C32065l();
        this.aYh = new byte[16];
        this.aYi = new Stack();
        this.aYj = new LinkedList();
        this.aYa = new SparseArray();
        this.aOz = -9223372036854775807L;
        this.aYq = -9223372036854775807L;
        m15332ri();
        AppMethodBeat.m2505o(94965);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(94966);
        boolean g = C45023i.m82491g(c45026f);
        AppMethodBeat.m2505o(94966);
        return g;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(94967);
        this.aTn = c8662g;
        if (this.aXZ != null) {
            C8650b c8650b = new C8650b(c8662g.mo19157dM(0));
            c8650b.mo19145a(this.aXZ, new C0839c(0, 0, 0, 0));
            this.aYa.put(0, c8650b);
            m15333rj();
            this.aTn.mo19158rb();
        }
        AppMethodBeat.m2505o(94967);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(94968);
        int size = this.aYa.size();
        for (int i = 0; i < size; i++) {
            ((C8650b) this.aYa.valueAt(i)).reset();
        }
        this.aYj.clear();
        this.aYp = 0;
        this.aYi.clear();
        m15332ri();
        AppMethodBeat.m2505o(94968);
    }

    /* JADX WARNING: Removed duplicated region for block: B:279:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0501 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0066 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(94969);
        while (true) {
            Object obj;
            long length;
            C37269o c37269o;
            long position;
            int size;
            C8652l c8652l;
            int i;
            long cM;
            int i2;
            int readInt;
            int tB;
            C8650b c8650b;
            C8650b c8650b2;
            switch (this.aTo) {
                case 0:
                    if (this.aYm == 0) {
                        if (!c45026f.mo59478a(this.aYg.data, 0, 8, true)) {
                            obj = null;
                            if (obj == null) {
                                break;
                            }
                            AppMethodBeat.m2505o(94969);
                            return -1;
                        }
                        this.aYm = 8;
                        this.aYg.setPosition(0);
                        this.aYl = this.aYg.mo52366cM();
                        this.aYk = this.aYg.readInt();
                    }
                    if (this.aYl == 1) {
                        c45026f.readFully(this.aYg.data, 8, 8);
                        this.aYm += 8;
                        this.aYl = this.aYg.mo52391tK();
                    } else if (this.aYl == 0) {
                        length = c45026f.getLength();
                        if (length == -1 && !this.aYi.isEmpty()) {
                            length = ((C32026a) this.aYi.peek()).aXw;
                        }
                        if (length != -1) {
                            this.aYl = (length - c45026f.getPosition()) + ((long) this.aYm);
                        }
                    }
                    if (this.aYl < ((long) this.aYm)) {
                        c37269o = new C37269o("Atom size less than header length (unsupported).");
                        AppMethodBeat.m2505o(94969);
                        throw c37269o;
                    }
                    position = c45026f.getPosition() - ((long) this.aYm);
                    if (this.aYk == C32025a.aWr) {
                        size = this.aYa.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            c8652l = ((C8650b) this.aYa.valueAt(i3)).aYx;
                            c8652l.aZx = position;
                            c8652l.aZz = position;
                            c8652l.aZy = position;
                        }
                    }
                    if (this.aYk == C32025a.aVO) {
                        this.aYr = null;
                        this.aYo = this.aYl + position;
                        if (!this.aYv) {
                            this.aTn.mo19156a(new C17646a(this.aOz));
                            this.aYv = true;
                        }
                        this.aTo = 2;
                    } else {
                        i = this.aYk;
                        if (i == C32025a.aWi || i == C32025a.aWk || i == C32025a.aWl || i == C32025a.aWm || i == C32025a.aWn || i == C32025a.aWr || i == C32025a.aWs || i == C32025a.aWt || i == C32025a.aWw) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            length = (c45026f.getPosition() + this.aYl) - 8;
                            this.aYi.add(new C32026a(this.aYk, length));
                            if (this.aYl == ((long) this.aYm)) {
                                m15315P(length);
                            } else {
                                m15332ri();
                            }
                        } else {
                            i = this.aYk;
                            if (i == C32025a.aWz || i == C32025a.aWy || i == C32025a.aWj || i == C32025a.aWh || i == C32025a.aWA || i == C32025a.aWd || i == C32025a.aWe || i == C32025a.aWv || i == C32025a.aWf || i == C32025a.aWg || i == C32025a.aWB || i == C32025a.aWJ || i == C32025a.aWK || i == C32025a.aWO || i == C32025a.aWN || i == C32025a.aWL || i == C32025a.aWM || i == C32025a.aWx || i == C32025a.aWu || i == C32025a.aXn) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                if (this.aYm != 8) {
                                    c37269o = new C37269o("Leaf atom defines extended atom size (unsupported).");
                                    AppMethodBeat.m2505o(94969);
                                    throw c37269o;
                                } else if (this.aYl > 2147483647L) {
                                    c37269o = new C37269o("Leaf atom with length > 2147483647 (unsupported).");
                                    AppMethodBeat.m2505o(94969);
                                    throw c37269o;
                                } else {
                                    this.aYn = new C32065l((int) this.aYl);
                                    System.arraycopy(this.aYg.data, 0, this.aYn.data, 0, 8);
                                    this.aTo = 1;
                                }
                            } else if (this.aYl > 2147483647L) {
                                c37269o = new C37269o("Skipping atom with length > 2147483647 (unsupported).");
                                AppMethodBeat.m2505o(94969);
                                throw c37269o;
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
                        c45026f.readFully(this.aYn.data, 8, i);
                        C32027b c32027b = new C32027b(this.aYk, this.aYn);
                        position = c45026f.getPosition();
                        if (!this.aYi.isEmpty()) {
                            ((C32026a) this.aYi.peek()).mo52321a(c32027b);
                        } else if (c32027b.type == C32025a.aWh) {
                            long cM2;
                            C32065l c32065l = c32027b.aXz;
                            c32065l.setPosition(8);
                            i = C32025a.m52017dT(c32065l.readInt());
                            c32065l.mo52369eM(4);
                            cM = c32065l.mo52366cM();
                            if (i == 0) {
                                length = c32065l.mo52366cM();
                                cM2 = position + c32065l.mo52366cM();
                            } else {
                                length = c32065l.mo52391tK();
                                cM2 = position + c32065l.mo52391tK();
                            }
                            long b = C17675v.m27564b(length, 1000000, cM);
                            c32065l.mo52369eM(2);
                            int readUnsignedShort = c32065l.readUnsignedShort();
                            int[] iArr = new int[readUnsignedShort];
                            long[] jArr = new long[readUnsignedShort];
                            long[] jArr2 = new long[readUnsignedShort];
                            long[] jArr3 = new long[readUnsignedShort];
                            i2 = 0;
                            long j = b;
                            long j2 = cM2;
                            while (i2 < readUnsignedShort) {
                                readInt = c32065l.readInt();
                                if ((C8415j.INVALID_ID & readInt) != 0) {
                                    c37269o = new C37269o("Unhandled indirect reference");
                                    AppMethodBeat.m2505o(94969);
                                    throw c37269o;
                                }
                                cM2 = c32065l.mo52366cM();
                                iArr[i2] = readInt & BaseClientBuilder.API_PRIORITY_OTHER;
                                jArr[i2] = j2;
                                jArr3[i2] = j;
                                length += cM2;
                                cM2 = C17675v.m27564b(length, 1000000, cM);
                                jArr2[i2] = cM2 - jArr3[i2];
                                c32065l.mo52369eM(4);
                                j2 += (long) iArr[i2];
                                i2++;
                                j = cM2;
                            }
                            Pair create = Pair.create(Long.valueOf(b), new C25515a(iArr, jArr, jArr2, jArr3));
                            this.aYq = ((Long) create.first).longValue();
                            this.aTn.mo19156a((C37247l) create.second);
                            this.aYv = true;
                        } else if (c32027b.type == C32025a.aXn) {
                            C32065l c32065l2 = c32027b.aXz;
                            if (this.aYt != null) {
                                c32065l2.setPosition(12);
                                c32065l2.mo52392tL();
                                c32065l2.mo52392tL();
                                position = C17675v.m27564b(c32065l2.mo52366cM(), 1000000, c32065l2.mo52366cM());
                                c32065l2.setPosition(12);
                                tB = c32065l2.mo52382tB();
                                this.aYt.mo42835a(c32065l2, tB);
                                if (this.aYq != -9223372036854775807L) {
                                    this.aYt.mo42834a(position + this.aYq, 1, tB, 0, null);
                                } else {
                                    this.aYj.addLast(new C8649a(position, tB));
                                    this.aYp += tB;
                                }
                            }
                        }
                    } else {
                        c45026f.mo59482dG(i);
                    }
                    m15315P(c45026f.getPosition());
                    break;
                case 2:
                    c8650b = null;
                    position = Long.MAX_VALUE;
                    tB = this.aYa.size();
                    size = 0;
                    while (size < tB) {
                        c8652l = ((C8650b) this.aYa.valueAt(size)).aYx;
                        if (!c8652l.aZM || c8652l.aZz >= position) {
                            c8650b2 = c8650b;
                        } else {
                            position = c8652l.aZz;
                            c8650b2 = (C8650b) this.aYa.valueAt(size);
                        }
                        size++;
                        c8650b = c8650b2;
                    }
                    if (c8650b != null) {
                        i = (int) (position - c45026f.getPosition());
                        if (i >= 0) {
                            c45026f.mo59482dG(i);
                            c8652l = c8650b.aYx;
                            c45026f.readFully(c8652l.aZL.data, 0, c8652l.aZK);
                            c8652l.aZL.setPosition(0);
                            c8652l.aZM = false;
                            break;
                        }
                        c37269o = new C37269o("Offset to encryption data was negative.");
                        AppMethodBeat.m2505o(94969);
                        throw c37269o;
                    }
                    this.aTo = 3;
                    break;
                    break;
                default:
                    int i4;
                    C25518k c25518k;
                    if (this.aTo == 3) {
                        if (this.aYr == null) {
                            SparseArray sparseArray = this.aYa;
                            c8650b = null;
                            cM = Long.MAX_VALUE;
                            i2 = sparseArray.size();
                            i4 = 0;
                            while (i4 < i2) {
                                c8650b2 = (C8650b) sparseArray.valueAt(i4);
                                if (c8650b2.aYC != c8650b2.aYx.aZA) {
                                    position = c8650b2.aYx.aZB[c8650b2.aYC];
                                    if (position < cM) {
                                        i4++;
                                        cM = position;
                                        c8650b = c8650b2;
                                    }
                                }
                                position = cM;
                                c8650b2 = c8650b;
                                i4++;
                                cM = position;
                                c8650b = c8650b2;
                            }
                            if (c8650b == null) {
                                i = (int) (this.aYo - c45026f.getPosition());
                                if (i >= 0) {
                                    c45026f.mo59482dG(i);
                                    m15332ri();
                                    obj = null;
                                    if (obj != null) {
                                        break;
                                    }
                                    AppMethodBeat.m2505o(94969);
                                    return 0;
                                }
                                c37269o = new C37269o("Offset to end of mdat was negative.");
                                AppMethodBeat.m2505o(94969);
                                throw c37269o;
                            }
                            i = (int) (c8650b.aYx.aZB[c8650b.aYC] - c45026f.getPosition());
                            if (i < 0) {
                                i = 0;
                            }
                            c45026f.mo59482dG(i);
                            this.aYr = c8650b;
                        }
                        this.sampleSize = this.aYr.aYx.aZD[this.aYr.aYA];
                        if (this.aYr.aYx.aZH) {
                            C32065l c32065l3;
                            C8650b c8650b3 = this.aYr;
                            C8652l c8652l2 = c8650b3.aYx;
                            i = c8652l2.aZw.aXT;
                            if (c8652l2.aZJ != null) {
                                c25518k = c8652l2.aZJ;
                            } else {
                                c25518k = c8650b3.aYy.mo59490dZ(i);
                            }
                            if (c25518k.aZu != 0) {
                                c32065l3 = c8652l2.aZL;
                                i = c25518k.aZu;
                            } else {
                                byte[] bArr = c25518k.aZv;
                                this.aYe.mo52371n(bArr, bArr.length);
                                c32065l3 = this.aYe;
                                i = bArr.length;
                            }
                            boolean z = c8652l2.aZI[c8650b3.aYA];
                            this.aYd.data[0] = (byte) ((z ? 128 : 0) | i);
                            this.aYd.setPosition(0);
                            C32041m c32041m = c8650b3.aTw;
                            c32041m.mo42835a(this.aYd, 1);
                            c32041m.mo42835a(c32065l3, i);
                            if (z) {
                                c32065l3 = c8652l2.aZL;
                                int readUnsignedShort2 = c32065l3.readUnsignedShort();
                                c32065l3.mo52369eM(-2);
                                readUnsignedShort2 = (readUnsignedShort2 * 6) + 2;
                                c32041m.mo42835a(c32065l3, readUnsignedShort2);
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
                            c45026f.mo59482dG(8);
                        }
                        this.aTo = 4;
                        this.aUF = 0;
                    }
                    C8652l c8652l3 = this.aYr.aYx;
                    C37236j c37236j = this.aYr.aYy;
                    C32041m c32041m2 = this.aYr.aTw;
                    size = this.aYr.aYA;
                    if (c37236j.aTz != 0) {
                        byte[] bArr2 = this.aYb.data;
                        bArr2[0] = (byte) 0;
                        bArr2[1] = (byte) 0;
                        bArr2[2] = (byte) 0;
                        i4 = c37236j.aTz + 1;
                        int i5 = 4 - c37236j.aTz;
                        while (this.aUG < this.sampleSize) {
                            if (this.aUF == 0) {
                                c45026f.readFully(bArr2, i5, i4);
                                this.aYb.setPosition(0);
                                this.aUF = this.aYb.mo52389tI() - 1;
                                this.aTx.setPosition(0);
                                c32041m2.mo42835a(this.aTx, 4);
                                c32041m2.mo42835a(this.aYb, 1);
                                boolean z2 = this.aYu != null && C45041j.m82576b(c37236j.aOv.aOd, bArr2[4]);
                                this.aYs = z2;
                                this.aUG += 5;
                                this.sampleSize += i5;
                            } else {
                                if (this.aYs) {
                                    this.aYc.reset(this.aUF);
                                    c45026f.readFully(this.aYc.data, 0, this.aUF);
                                    c32041m2.mo42835a(this.aYc, this.aUF);
                                    readInt = this.aUF;
                                    i2 = C45041j.m82578j(this.aYc.data, this.aYc.limit);
                                    this.aYc.setPosition("video/hevc".equals(c37236j.aOv.aOd) ? 1 : 0);
                                    this.aYc.mo52368eL(i2);
                                    C45031g.m82526a(c8652l3.mo19150eb(size) * 1000, this.aYc, this.aYu);
                                    i = readInt;
                                } else {
                                    i = c32041m2.mo42832a(c45026f, this.aUF, false);
                                }
                                this.aUG += i;
                                this.aUF -= i;
                            }
                        }
                    } else {
                        while (this.aUG < this.sampleSize) {
                            this.aUG = c32041m2.mo42832a(c45026f, this.sampleSize - this.aUG, false) + this.aUG;
                        }
                    }
                    position = c8652l3.mo19150eb(size) * 1000;
                    if (this.aYf != null) {
                        position = this.aYf.mo72552ap(position);
                    }
                    i = c8652l3.aZG[size] ? 1 : 0;
                    C8663a c8663a = null;
                    if (c8652l3.aZH) {
                        size = ErrorDialogData.SUPPRESSED | i;
                        if (c8652l3.aZJ != null) {
                            c25518k = c8652l3.aZJ;
                        } else {
                            c25518k = c37236j.mo59490dZ(c8652l3.aZw.aXT);
                        }
                        c8663a = c25518k.aUO;
                    } else {
                        size = i;
                    }
                    c32041m2.mo42834a(position, size, this.sampleSize, 0, c8663a);
                    while (!this.aYj.isEmpty()) {
                        C8649a c8649a = (C8649a) this.aYj.removeFirst();
                        this.aYp -= c8649a.size;
                        this.aYt.mo42834a(c8649a.aYw + position, 1, c8649a.size, this.aYp, null);
                    }
                    c8650b2 = this.aYr;
                    c8650b2.aYA++;
                    c8650b2 = this.aYr;
                    c8650b2.aYB++;
                    if (this.aYr.aYB == c8652l3.aZC[this.aYr.aYC]) {
                        c8650b2 = this.aYr;
                        c8650b2.aYC++;
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

    /* renamed from: ri */
    private void m15332ri() {
        this.aTo = 0;
        this.aYm = 0;
    }

    /* renamed from: P */
    private void m15315P(long j) {
        AppMethodBeat.m2504i(94970);
        while (!this.aYi.isEmpty() && ((C32026a) this.aYi.peek()).aXw == j) {
            m15326c((C32026a) this.aYi.pop());
        }
        m15332ri();
        AppMethodBeat.m2505o(94970);
    }

    /* renamed from: c */
    private void m15326c(C32026a c32026a) {
        AppMethodBeat.m2504i(94971);
        if (c32026a.type == C32025a.aWi) {
            m15327d(c32026a);
            AppMethodBeat.m2505o(94971);
        } else if (c32026a.type == C32025a.aWr) {
            m15328e(c32026a);
            AppMethodBeat.m2505o(94971);
        } else {
            if (!this.aYi.isEmpty()) {
                ((C32026a) this.aYi.peek()).mo52320a(c32026a);
            }
            AppMethodBeat.m2505o(94971);
        }
    }

    /* renamed from: d */
    private void m15327d(C32026a c32026a) {
        C37236j a;
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(94972);
        C45039a.checkState(this.aXZ == null, "Unexpected moov box.");
        DrmInitData u = C8647e.m15334u(c32026a.aXx);
        C32026a dX = c32026a.mo52323dX(C32025a.aWt);
        SparseArray sparseArray = new SparseArray();
        long j = -9223372036854775807L;
        int size = dX.aXx.size();
        for (int i2 = 0; i2 < size; i2++) {
            C32027b c32027b = (C32027b) dX.aXx.get(i2);
            if (c32027b.type == C32025a.aWf) {
                Pair l = C8647e.m15329l(c32027b.aXz);
                sparseArray.put(((Integer) l.first).intValue(), l.second);
            } else if (c32027b.type == C32025a.aWu) {
                j = C8647e.m15330m(c32027b.aXz);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = c32026a.aXy.size();
        for (size = 0; size < size2; size++) {
            C32026a c32026a2 = (C32026a) c32026a.aXy.get(size);
            if (c32026a2.type == C32025a.aWk) {
                boolean z2;
                C32027b dW = c32026a.mo52322dW(C32025a.aWj);
                if ((this.flags & 32) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                a = C32029b.m52026a(c32026a2, dW, j, u, z2, false);
                if (a != null) {
                    sparseArray2.put(a.f15847id, a);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.aYa.size() == 0) {
            while (i < size3) {
                C37236j c37236j = (C37236j) sparseArray2.valueAt(i);
                C8650b c8650b = new C8650b(this.aTn.mo19157dM(i));
                c8650b.mo19145a(c37236j, (C0839c) sparseArray.get(c37236j.f15847id));
                this.aYa.put(c37236j.f15847id, c8650b);
                this.aOz = Math.max(this.aOz, c37236j.aOz);
                i++;
            }
            m15333rj();
            this.aTn.mo19158rb();
            AppMethodBeat.m2505o(94972);
            return;
        }
        if (this.aYa.size() != size3) {
            z = false;
        }
        C45039a.checkState(z);
        while (i < size3) {
            a = (C37236j) sparseArray2.valueAt(i);
            ((C8650b) this.aYa.get(a.f15847id)).mo19145a(a, (C0839c) sparseArray.get(a.f15847id));
            i++;
        }
        AppMethodBeat.m2505o(94972);
    }

    /* renamed from: e */
    private void m15328e(C32026a c32026a) {
        AppMethodBeat.m2504i(94973);
        C8647e.m15318a(c32026a, this.aYa, this.flags, this.aYh);
        DrmInitData u = C8647e.m15334u(c32026a.aXx);
        if (u != null) {
            int size = this.aYa.size();
            for (int i = 0; i < size; i++) {
                ((C8650b) this.aYa.valueAt(i)).mo19146b(u);
            }
        }
        AppMethodBeat.m2505o(94973);
    }

    /* renamed from: rj */
    private void m15333rj() {
        AppMethodBeat.m2504i(94974);
        if ((this.flags & 4) != 0 && this.aYt == null) {
            this.aYt = this.aTn.mo19157dM(this.aYa.size());
            this.aYt.mo42836f(Format.m15286c("application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.flags & 8) != 0 && this.aYu == null) {
            this.aTn.mo19157dM(this.aYa.size() + 1).mo42836f(Format.m15285as("application/cea-608"));
            this.aYu = new C32041m[]{r0};
        }
        AppMethodBeat.m2505o(94974);
    }

    /* renamed from: l */
    private static Pair<Integer, C0839c> m15329l(C32065l c32065l) {
        AppMethodBeat.m2504i(94975);
        c32065l.setPosition(12);
        Pair create = Pair.create(Integer.valueOf(c32065l.readInt()), new C0839c(c32065l.mo52389tI() - 1, c32065l.mo52389tI(), c32065l.mo52389tI(), c32065l.readInt()));
        AppMethodBeat.m2505o(94975);
        return create;
    }

    /* renamed from: m */
    private static long m15330m(C32065l c32065l) {
        AppMethodBeat.m2504i(94976);
        c32065l.setPosition(8);
        long cM;
        if (C32025a.m52017dT(c32065l.readInt()) == 0) {
            cM = c32065l.mo52366cM();
            AppMethodBeat.m2505o(94976);
            return cM;
        }
        cM = c32065l.mo52391tK();
        AppMethodBeat.m2505o(94976);
        return cM;
    }

    /* renamed from: a */
    private static void m15318a(C32026a c32026a, SparseArray<C8650b> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.m2504i(94977);
        int size = c32026a.aXy.size();
        for (int i2 = 0; i2 < size; i2++) {
            C32026a c32026a2 = (C32026a) c32026a.aXy.get(i2);
            if (c32026a2.type == C32025a.aWs) {
                C8647e.m15325b(c32026a2, sparseArray, i, bArr);
            }
        }
        AppMethodBeat.m2505o(94977);
    }

    /* renamed from: b */
    private static void m15325b(C32026a c32026a, SparseArray<C8650b> sparseArray, int i, byte[] bArr) {
        AppMethodBeat.m2504i(94978);
        C8650b a = C8647e.m15317a(c32026a.mo52322dW(C32025a.aWe).aXz, (SparseArray) sparseArray, i);
        if (a == null) {
            AppMethodBeat.m2505o(94978);
            return;
        }
        C8652l c8652l = a.aYx;
        long j = c8652l.aZN;
        a.reset();
        if (c32026a.mo52322dW(C32025a.aWd) != null && (i & 2) == 0) {
            j = C8647e.m15331n(c32026a.mo52322dW(C32025a.aWd).aXz);
        }
        C8647e.m15319a(c32026a, a, j, i);
        C25518k dZ = a.aYy.mo59490dZ(c8652l.aZw.aXT);
        C32027b dW = c32026a.mo52322dW(C32025a.aWJ);
        if (dW != null) {
            C8647e.m15320a(dZ, dW.aXz, c8652l);
        }
        dW = c32026a.mo52322dW(C32025a.aWK);
        if (dW != null) {
            C8647e.m15322a(dW.aXz, c8652l);
        }
        dW = c32026a.mo52322dW(C32025a.aWO);
        if (dW != null) {
            C8647e.m15321a(dW.aXz, 0, c8652l);
        }
        dW = c32026a.mo52322dW(C32025a.aWL);
        C32027b dW2 = c32026a.mo52322dW(C32025a.aWM);
        if (!(dW == null || dW2 == null)) {
            C8647e.m15324a(dW.aXz, dW2.aXz, dZ != null ? dZ.aZt : null, c8652l);
        }
        int size = c32026a.aXx.size();
        for (int i2 = 0; i2 < size; i2++) {
            C32027b c32027b = (C32027b) c32026a.aXx.get(i2);
            if (c32027b.type == C32025a.aWN) {
                C8647e.m15323a(c32027b.aXz, c8652l, bArr);
            }
        }
        AppMethodBeat.m2505o(94978);
    }

    /* renamed from: a */
    private static void m15319a(C32026a c32026a, C8650b c8650b, long j, int i) {
        C32027b c32027b;
        AppMethodBeat.m2504i(94979);
        int i2 = 0;
        int i3 = 0;
        List list = c32026a.aXx;
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            int tI;
            c32027b = (C32027b) list.get(i4);
            if (c32027b.type == C32025a.aWg) {
                C32065l c32065l = c32027b.aXz;
                c32065l.setPosition(12);
                tI = c32065l.mo52389tI();
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
        c8650b.aYC = 0;
        c8650b.aYB = 0;
        c8650b.aYA = 0;
        c8650b.aYx.mo19148bd(i2, i3);
        i3 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            c32027b = (C32027b) list.get(i6);
            if (c32027b.type == C32025a.aWg) {
                int i7 = i3 + 1;
                i5 = C8647e.m15316a(c8650b, i3, j, i, c32027b.aXz, i5);
                i3 = i7;
            }
        }
        AppMethodBeat.m2505o(94979);
    }

    /* renamed from: a */
    private static void m15320a(C25518k c25518k, C32065l c32065l, C8652l c8652l) {
        boolean z = true;
        AppMethodBeat.m2504i(94980);
        int i = c25518k.aZu;
        c32065l.setPosition(8);
        if ((C32025a.m52018dU(c32065l.readInt()) & 1) == 1) {
            c32065l.mo52369eM(8);
        }
        int readUnsignedByte = c32065l.readUnsignedByte();
        int tI = c32065l.mo52389tI();
        if (tI != c8652l.sampleCount) {
            C37269o c37269o = new C37269o("Length mismatch: " + tI + ", " + c8652l.sampleCount);
            AppMethodBeat.m2505o(94980);
            throw c37269o;
        }
        if (readUnsignedByte == 0) {
            boolean[] zArr = c8652l.aZI;
            readUnsignedByte = 0;
            int i2 = 0;
            while (i2 < tI) {
                boolean z2;
                int readUnsignedByte2 = c32065l.readUnsignedByte();
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
            Arrays.fill(c8652l.aZI, 0, tI, z);
        }
        c8652l.mo19149ea(readUnsignedByte);
        AppMethodBeat.m2505o(94980);
    }

    /* renamed from: a */
    private static void m15322a(C32065l c32065l, C8652l c8652l) {
        AppMethodBeat.m2504i(94981);
        c32065l.setPosition(8);
        int readInt = c32065l.readInt();
        if ((C32025a.m52018dU(readInt) & 1) == 1) {
            c32065l.mo52369eM(8);
        }
        int tI = c32065l.mo52389tI();
        if (tI != 1) {
            C37269o c37269o = new C37269o("Unexpected saio entry count: ".concat(String.valueOf(tI)));
            AppMethodBeat.m2505o(94981);
            throw c37269o;
        }
        readInt = C32025a.m52017dT(readInt);
        c8652l.aZz = (readInt == 0 ? c32065l.mo52366cM() : c32065l.mo52391tK()) + c8652l.aZz;
        AppMethodBeat.m2505o(94981);
    }

    /* renamed from: a */
    private static C8650b m15317a(C32065l c32065l, SparseArray<C8650b> sparseArray, int i) {
        AppMethodBeat.m2504i(94982);
        c32065l.setPosition(8);
        int dU = C32025a.m52018dU(c32065l.readInt());
        int readInt = c32065l.readInt();
        if ((i & 16) != 0) {
            readInt = 0;
        }
        C8650b c8650b = (C8650b) sparseArray.get(readInt);
        if (c8650b == null) {
            AppMethodBeat.m2505o(94982);
            return null;
        }
        if ((dU & 1) != 0) {
            long tK = c32065l.mo52391tK();
            c8650b.aYx.aZy = tK;
            c8650b.aYx.aZz = tK;
        }
        C0839c c0839c = c8650b.aYz;
        c8650b.aYx.aZw = new C0839c((dU & 2) != 0 ? c32065l.mo52389tI() - 1 : c0839c.aXT, (dU & 8) != 0 ? c32065l.mo52389tI() : c0839c.duration, (dU & 16) != 0 ? c32065l.mo52389tI() : c0839c.size, (dU & 32) != 0 ? c32065l.mo52389tI() : c0839c.flags);
        AppMethodBeat.m2505o(94982);
        return c8650b;
    }

    /* renamed from: n */
    private static long m15331n(C32065l c32065l) {
        AppMethodBeat.m2504i(94983);
        c32065l.setPosition(8);
        long tK;
        if (C32025a.m52017dT(c32065l.readInt()) == 1) {
            tK = c32065l.mo52391tK();
            AppMethodBeat.m2505o(94983);
            return tK;
        }
        tK = c32065l.mo52366cM();
        AppMethodBeat.m2505o(94983);
        return tK;
    }

    /* renamed from: a */
    private static int m15316a(C8650b c8650b, int i, long j, int i2, C32065l c32065l, int i3) {
        Object obj;
        long b;
        AppMethodBeat.m2504i(94984);
        c32065l.setPosition(8);
        int dU = C32025a.m52018dU(c32065l.readInt());
        C37236j c37236j = c8650b.aYy;
        C8652l c8652l = c8650b.aYx;
        C0839c c0839c = c8652l.aZw;
        c8652l.aZC[i] = c32065l.mo52389tI();
        c8652l.aZB[i] = c8652l.aZy;
        if ((dU & 1) != 0) {
            long[] jArr = c8652l.aZB;
            jArr[i] = jArr[i] + ((long) c32065l.readInt());
        }
        Object obj2 = (dU & 4) != 0 ? 1 : null;
        int i4 = c0839c.flags;
        if (obj2 != null) {
            i4 = c32065l.mo52389tI();
        }
        Object obj3 = (dU & 256) != 0 ? 1 : null;
        Object obj4 = (dU & 512) != 0 ? 1 : null;
        Object obj5 = (dU & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0 ? 1 : null;
        if ((dU & 2048) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (c37236j.aZp != null && c37236j.aZp.length == 1 && c37236j.aZp[0] == 0) {
            b = C17675v.m27564b(c37236j.aZq[0], 1000, c37236j.aZm);
        } else {
            b = 0;
        }
        int[] iArr = c8652l.aZD;
        int[] iArr2 = c8652l.aZE;
        long[] jArr2 = c8652l.aZF;
        boolean[] zArr = c8652l.aZG;
        Object obj6 = (c37236j.type != 2 || (i2 & 1) == 0) ? null : 1;
        int i5 = i3 + c8652l.aZC[i];
        long j2 = c37236j.aZm;
        if (i > 0) {
            j = c8652l.aZN;
        }
        long j3 = j;
        while (i3 < i5) {
            int tI = obj3 != null ? c32065l.mo52389tI() : c0839c.duration;
            int tI2 = obj4 != null ? c32065l.mo52389tI() : c0839c.size;
            int readInt = (i3 != 0 || obj2 == null) ? obj5 != null ? c32065l.readInt() : c0839c.flags : i4;
            if (obj != null) {
                iArr2[i3] = (int) ((((long) c32065l.readInt()) * 1000) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr2[i3] = C17675v.m27564b(j3, 1000, j2) - b;
            iArr[i3] = tI2;
            boolean z = ((readInt >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            j3 += (long) tI;
            i3++;
        }
        c8652l.aZN = j3;
        AppMethodBeat.m2505o(94984);
        return i5;
    }

    /* renamed from: a */
    private static void m15323a(C32065l c32065l, C8652l c8652l, byte[] bArr) {
        AppMethodBeat.m2504i(94985);
        c32065l.setPosition(8);
        c32065l.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, aXY)) {
            C8647e.m15321a(c32065l, 16, c8652l);
            AppMethodBeat.m2505o(94985);
            return;
        }
        AppMethodBeat.m2505o(94985);
    }

    /* renamed from: a */
    private static void m15321a(C32065l c32065l, int i, C8652l c8652l) {
        AppMethodBeat.m2504i(94986);
        c32065l.setPosition(i + 8);
        int dU = C32025a.m52018dU(c32065l.readInt());
        C37269o c37269o;
        if ((dU & 1) != 0) {
            c37269o = new C37269o("Overriding TrackEncryptionBox parameters is unsupported.");
            AppMethodBeat.m2505o(94986);
            throw c37269o;
        }
        boolean z;
        if ((dU & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int tI = c32065l.mo52389tI();
        if (tI != c8652l.sampleCount) {
            c37269o = new C37269o("Length mismatch: " + tI + ", " + c8652l.sampleCount);
            AppMethodBeat.m2505o(94986);
            throw c37269o;
        }
        Arrays.fill(c8652l.aZI, 0, tI, z);
        c8652l.mo19149ea(c32065l.mo52382tB());
        c8652l.mo19151q(c32065l);
        AppMethodBeat.m2505o(94986);
    }

    /* renamed from: a */
    private static void m15324a(C32065l c32065l, C32065l c32065l2, String str, C8652l c8652l) {
        AppMethodBeat.m2504i(94987);
        c32065l.setPosition(8);
        int readInt = c32065l.readInt();
        if (c32065l.readInt() != aXX) {
            AppMethodBeat.m2505o(94987);
            return;
        }
        if (C32025a.m52017dT(readInt) == 1) {
            c32065l.mo52369eM(4);
        }
        C37269o c37269o;
        if (c32065l.readInt() != 1) {
            c37269o = new C37269o("Entry count in sbgp != 1 (unsupported).");
            AppMethodBeat.m2505o(94987);
            throw c37269o;
        }
        c32065l2.setPosition(8);
        readInt = c32065l2.readInt();
        if (c32065l2.readInt() != aXX) {
            AppMethodBeat.m2505o(94987);
            return;
        }
        readInt = C32025a.m52017dT(readInt);
        if (readInt == 1) {
            if (c32065l2.mo52366cM() == 0) {
                c37269o = new C37269o("Variable length description in sgpd found (unsupported)");
                AppMethodBeat.m2505o(94987);
                throw c37269o;
            }
        } else if (readInt >= 2) {
            c32065l2.mo52369eM(4);
        }
        if (c32065l2.mo52366cM() != 1) {
            c37269o = new C37269o("Entry count in sgpd != 1 (unsupported).");
            AppMethodBeat.m2505o(94987);
            throw c37269o;
        }
        c32065l2.mo52369eM(1);
        readInt = c32065l2.readUnsignedByte();
        int i = (readInt & 240) >> 4;
        int i2 = readInt & 15;
        if (c32065l2.readUnsignedByte() == 1) {
            readInt = 1;
        } else {
            readInt = 0;
        }
        if (readInt == 0) {
            AppMethodBeat.m2505o(94987);
            return;
        }
        int readUnsignedByte = c32065l2.readUnsignedByte();
        byte[] bArr = new byte[16];
        c32065l2.readBytes(bArr, 0, 16);
        byte[] bArr2 = null;
        if (readUnsignedByte == 0) {
            readInt = c32065l2.readUnsignedByte();
            bArr2 = new byte[readInt];
            c32065l2.readBytes(bArr2, 0, readInt);
        }
        c8652l.aZH = true;
        c8652l.aZJ = new C25518k(true, str, readUnsignedByte, bArr, i, i2, bArr2);
        AppMethodBeat.m2505o(94987);
    }

    /* renamed from: u */
    private static DrmInitData m15334u(List<C32027b> list) {
        AppMethodBeat.m2504i(94988);
        int size = list.size();
        List list2 = null;
        for (int i = 0; i < size; i++) {
            C32027b c32027b = (C32027b) list.get(i);
            if (c32027b.type == C32025a.aWB) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                byte[] bArr = c32027b.aXz.data;
                UUID n = C37235h.m62446n(bArr);
                if (n != null) {
                    list2.add(new SchemeData(n, "video/mp4", bArr));
                }
            }
        }
        if (list2 == null) {
            AppMethodBeat.m2505o(94988);
            return null;
        }
        DrmInitData drmInitData = new DrmInitData(list2);
        AppMethodBeat.m2505o(94988);
        return drmInitData;
    }
}
