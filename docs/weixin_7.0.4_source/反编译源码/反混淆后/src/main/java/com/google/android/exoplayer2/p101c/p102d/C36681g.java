package com.google.android.exoplayer2.p101c.p102d;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p101c.C17644i;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32026a;
import com.google.android.exoplayer2.p101c.p102d.C32025a.C32027b;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.p111i.C45041j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Stack;

/* renamed from: com.google.android.exoplayer2.c.d.g */
public final class C36681g implements C32034e, C37247l {
    public static final C32039h aTh = new C366821();
    private static final int aZh = C17675v.m27562aT("qt  ");
    private long aOz;
    private C8662g aTn;
    private int aTo;
    private final C32065l aTx;
    private final C32065l aTy;
    private int aUF;
    private int aUG;
    private final C32065l aYg;
    private final Stack<C32026a> aYi;
    private int aYk;
    private long aYl;
    private int aYm;
    private C32065l aYn;
    private C8651a[] aZi;
    private boolean aZj;
    private final int flags;

    /* renamed from: com.google.android.exoplayer2.c.d.g$a */
    static final class C8651a {
        public final C32041m aVw;
        public int aXR;
        public final C37236j aYy;
        public final C25519m aZk;

        public C8651a(C37236j c37236j, C25519m c25519m, C32041m c32041m) {
            this.aYy = c37236j;
            this.aZk = c25519m;
            this.aVw = c32041m;
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.d.g$1 */
    static class C366821 implements C32039h {
        C366821() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(94997);
            C32034e[] c32034eArr = new C32034e[]{new C36681g()};
            AppMethodBeat.m2505o(94997);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(95005);
        AppMethodBeat.m2505o(95005);
    }

    public C36681g() {
        this(0);
    }

    public C36681g(int i) {
        AppMethodBeat.m2504i(94998);
        this.flags = i;
        this.aYg = new C32065l(16);
        this.aYi = new Stack();
        this.aTx = new C32065l(C45041j.bqY);
        this.aTy = new C32065l(4);
        AppMethodBeat.m2505o(94998);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(94999);
        boolean h = C45023i.m82492h(c45026f);
        AppMethodBeat.m2505o(94999);
        return h;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        this.aTn = c8662g;
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        AppMethodBeat.m2504i(95000);
        this.aYi.clear();
        this.aYm = 0;
        this.aUG = 0;
        this.aUF = 0;
        if (j == 0) {
            m60831ri();
            AppMethodBeat.m2505o(95000);
            return;
        }
        if (this.aZi != null) {
            for (C8651a c8651a : this.aZi) {
                C25519m c25519m = c8651a.aZk;
                int Q = c25519m.mo42778Q(j2);
                if (Q == -1) {
                    Q = c25519m.mo42779R(j2);
                }
                c8651a.aXR = Q;
            }
        }
        AppMethodBeat.m2505o(95000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x002c A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(95001);
        while (true) {
            Object obj;
            int i;
            long j;
            long position;
            switch (this.aTo) {
                case 0:
                    long length;
                    if (this.aYm == 0) {
                        if (!c45026f.mo59478a(this.aYg.data, 0, 8, true)) {
                            obj = null;
                            if (obj == null) {
                                break;
                            }
                            AppMethodBeat.m2505o(95001);
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
                        C37269o c37269o = new C37269o("Atom size less than header length (unsupported).");
                        AppMethodBeat.m2505o(95001);
                        throw c37269o;
                    }
                    i = this.aYk;
                    if (i == C32025a.aWi || i == C32025a.aWk || i == C32025a.aWl || i == C32025a.aWm || i == C32025a.aWn || i == C32025a.aWw) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        length = (c45026f.getPosition() + this.aYl) - ((long) this.aYm);
                        this.aYi.add(new C32026a(this.aYk, length));
                        if (this.aYl == ((long) this.aYm)) {
                            m60829P(length);
                        } else {
                            m60831ri();
                        }
                    } else {
                        i = this.aYk;
                        if (i == C32025a.aWy || i == C32025a.aWj || i == C32025a.aWz || i == C32025a.aWA || i == C32025a.aWT || i == C32025a.aWU || i == C32025a.aWV || i == C32025a.aWx || i == C32025a.aWW || i == C32025a.aWX || i == C32025a.aWY || i == C32025a.aWZ || i == C32025a.aXa || i == C32025a.aWv || i == C32025a.aVH || i == C32025a.aXh) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            C45039a.checkState(this.aYm == 8);
                            C45039a.checkState(this.aYl <= 2147483647L);
                            this.aYn = new C32065l((int) this.aYl);
                            System.arraycopy(this.aYg.data, 0, this.aYn.data, 0, 8);
                            this.aTo = 1;
                        } else {
                            this.aYn = null;
                            this.aTo = 1;
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                    }
                    break;
                case 1:
                    j = this.aYl - ((long) this.aYm);
                    position = c45026f.getPosition() + j;
                    if (this.aYn != null) {
                        c45026f.readFully(this.aYn.data, this.aYm, (int) j);
                        if (this.aYk == C32025a.aVH) {
                            boolean z;
                            C32065l c32065l = this.aYn;
                            c32065l.setPosition(8);
                            if (c32065l.readInt() == aZh) {
                                z = true;
                            } else {
                                c32065l.mo52369eM(4);
                                while (c32065l.mo52382tB() > 0) {
                                    if (c32065l.readInt() == aZh) {
                                        z = true;
                                    }
                                }
                                z = false;
                            }
                            this.aZj = z;
                            obj = null;
                        } else if (this.aYi.isEmpty()) {
                            obj = null;
                        } else {
                            ((C32026a) this.aYi.peek()).mo52321a(new C32027b(this.aYk, this.aYn));
                            obj = null;
                        }
                    } else if (j < 262144) {
                        c45026f.mo59482dG((int) j);
                        obj = null;
                    } else {
                        c32040k.position = c45026f.getPosition() + j;
                        obj = 1;
                    }
                    m60829P(position);
                    if (obj == null || this.aTo == 2) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        break;
                    }
                    AppMethodBeat.m2505o(95001);
                    return 1;
                    break;
                case 2:
                    int i2;
                    int i3 = -1;
                    j = Long.MAX_VALUE;
                    for (i = 0; i < this.aZi.length; i++) {
                        C8651a c8651a = this.aZi[i];
                        i2 = c8651a.aXR;
                        if (i2 != c8651a.aZk.sampleCount) {
                            position = c8651a.aZk.offsets[i2];
                            if (position < j) {
                                j = position;
                                i3 = i;
                            }
                        }
                    }
                    if (i3 == -1) {
                        AppMethodBeat.m2505o(95001);
                        return -1;
                    }
                    C8651a c8651a2 = this.aZi[i3];
                    C32041m c32041m = c8651a2.aVw;
                    int i4 = c8651a2.aXR;
                    j = c8651a2.aZk.offsets[i4];
                    i = c8651a2.aZk.aSB[i4];
                    if (c8651a2.aYy.aZo == 1) {
                        j += 8;
                        i -= 8;
                    }
                    long position2 = (j - c45026f.getPosition()) + ((long) this.aUG);
                    if (position2 < 0 || position2 >= 262144) {
                        c32040k.position = j;
                        AppMethodBeat.m2505o(95001);
                        return 1;
                    }
                    c45026f.mo59482dG((int) position2);
                    int i5;
                    if (c8651a2.aYy.aTz != 0) {
                        byte[] bArr = this.aTy.data;
                        bArr[0] = (byte) 0;
                        bArr[1] = (byte) 0;
                        bArr[2] = (byte) 0;
                        i5 = c8651a2.aYy.aTz;
                        int i6 = 4 - c8651a2.aYy.aTz;
                        while (this.aUG < i) {
                            if (this.aUF == 0) {
                                c45026f.readFully(this.aTy.data, i6, i5);
                                this.aTy.setPosition(0);
                                this.aUF = this.aTy.mo52389tI();
                                this.aTx.setPosition(0);
                                c32041m.mo42835a(this.aTx, 4);
                                this.aUG += 4;
                                i += i6;
                            } else {
                                i2 = c32041m.mo42832a(c45026f, this.aUF, false);
                                this.aUG += i2;
                                this.aUF -= i2;
                            }
                        }
                        i2 = i;
                    } else {
                        while (this.aUG < i) {
                            i5 = c32041m.mo42832a(c45026f, i - this.aUG, false);
                            this.aUG += i5;
                            this.aUF -= i5;
                        }
                        i2 = i;
                    }
                    c32041m.mo42834a(c8651a2.aZk.aZO[i4], c8651a2.aZk.aXW[i4], i2, 0, null);
                    c8651a2.aXR++;
                    this.aUG = 0;
                    this.aUF = 0;
                    AppMethodBeat.m2505o(95001);
                    return 0;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException();
                    AppMethodBeat.m2505o(95001);
                    throw illegalStateException;
            }
        }
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return true;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        AppMethodBeat.m2504i(95002);
        long j2 = Long.MAX_VALUE;
        C8651a[] c8651aArr = this.aZi;
        int length = c8651aArr.length;
        int i = 0;
        while (i < length) {
            C25519m c25519m = c8651aArr[i].aZk;
            int Q = c25519m.mo42778Q(j);
            if (Q == -1) {
                Q = c25519m.mo42779R(j);
            }
            long j3 = c25519m.offsets[Q];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        AppMethodBeat.m2505o(95002);
        return j2;
    }

    /* renamed from: ri */
    private void m60831ri() {
        this.aTo = 0;
        this.aYm = 0;
    }

    /* renamed from: P */
    private void m60829P(long j) {
        AppMethodBeat.m2504i(95003);
        while (!this.aYi.isEmpty() && ((C32026a) this.aYi.peek()).aXw == j) {
            C32026a c32026a = (C32026a) this.aYi.pop();
            if (c32026a.type == C32025a.aWi) {
                m60830f(c32026a);
                this.aYi.clear();
                this.aTo = 2;
            } else if (!this.aYi.isEmpty()) {
                ((C32026a) this.aYi.peek()).mo52320a(c32026a);
            }
        }
        if (this.aTo != 2) {
            m60831ri();
        }
        AppMethodBeat.m2505o(95003);
    }

    /* renamed from: f */
    private void m60830f(C32026a c32026a) {
        Metadata metadata;
        AppMethodBeat.m2504i(95004);
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        C17644i c17644i = new C17644i();
        C32027b dW = c32026a.mo52322dW(C32025a.aXh);
        if (dW != null) {
            Metadata a = C32029b.m52029a(dW, this.aZj);
            if (a != null) {
                c17644i.mo32328c(a);
            }
            metadata = a;
        } else {
            metadata = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            long j2 = j;
            if (i2 < c32026a.aXy.size()) {
                C32026a c32026a2 = (C32026a) c32026a.aXy.get(i2);
                if (c32026a2.type == C32025a.aWk) {
                    C37236j a2 = C32029b.m52026a(c32026a2, c32026a.mo52322dW(C32025a.aWj), -9223372036854775807L, null, (this.flags & 1) != 0, this.aZj);
                    if (a2 != null) {
                        C25519m a3 = C32029b.m52028a(a2, c32026a2.mo52323dX(C32025a.aWl).mo52323dX(C32025a.aWm).mo52323dX(C32025a.aWn), c17644i);
                        if (a3.sampleCount != 0) {
                            C8651a c8651a = new C8651a(a2, a3, this.aTn.mo19157dM(i2));
                            Format dw = a2.aOv.mo19117dw(a3.aXU + 30);
                            if (a2.type == 1) {
                                if (c17644i.mo32329rc()) {
                                    dw = dw.mo19115aY(c17644i.aOp, c17644i.aOq);
                                }
                                if (metadata != null) {
                                    dw = dw.mo19113a(metadata);
                                }
                            }
                            c8651a.aVw.mo42836f(dw);
                            j2 = Math.max(j2, a2.aOz);
                            arrayList.add(c8651a);
                        }
                    }
                }
                j = j2;
                i = i2 + 1;
            } else {
                this.aOz = j2;
                this.aZi = (C8651a[]) arrayList.toArray(new C8651a[arrayList.size()]);
                this.aTn.mo19158rb();
                this.aTn.mo19156a(this);
                AppMethodBeat.m2505o(95004);
                return;
            }
        }
    }
}
