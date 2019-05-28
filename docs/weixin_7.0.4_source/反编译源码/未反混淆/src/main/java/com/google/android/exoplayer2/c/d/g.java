package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Stack;

public final class g implements e, l {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(94997);
            e[] eVarArr = new e[]{new g()};
            AppMethodBeat.o(94997);
            return eVarArr;
        }
    };
    private static final int aZh = v.aT("qt  ");
    private long aOz;
    private com.google.android.exoplayer2.c.g aTn;
    private int aTo;
    private final com.google.android.exoplayer2.i.l aTx;
    private final com.google.android.exoplayer2.i.l aTy;
    private int aUF;
    private int aUG;
    private final com.google.android.exoplayer2.i.l aYg;
    private final Stack<a> aYi;
    private int aYk;
    private long aYl;
    private int aYm;
    private com.google.android.exoplayer2.i.l aYn;
    private a[] aZi;
    private boolean aZj;
    private final int flags;

    static final class a {
        public final m aVw;
        public int aXR;
        public final j aYy;
        public final m aZk;

        public a(j jVar, m mVar, m mVar2) {
            this.aYy = jVar;
            this.aZk = mVar;
            this.aVw = mVar2;
        }
    }

    static {
        AppMethodBeat.i(95005);
        AppMethodBeat.o(95005);
    }

    public g() {
        this(0);
    }

    public g(int i) {
        AppMethodBeat.i(94998);
        this.flags = i;
        this.aYg = new com.google.android.exoplayer2.i.l(16);
        this.aYi = new Stack();
        this.aTx = new com.google.android.exoplayer2.i.l(j.bqY);
        this.aTy = new com.google.android.exoplayer2.i.l(4);
        AppMethodBeat.o(94998);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(94999);
        boolean h = i.h(fVar);
        AppMethodBeat.o(94999);
        return h;
    }

    public final void a(com.google.android.exoplayer2.c.g gVar) {
        this.aTn = gVar;
    }

    public final void g(long j, long j2) {
        AppMethodBeat.i(95000);
        this.aYi.clear();
        this.aYm = 0;
        this.aUG = 0;
        this.aUF = 0;
        if (j == 0) {
            ri();
            AppMethodBeat.o(95000);
            return;
        }
        if (this.aZi != null) {
            for (a aVar : this.aZi) {
                m mVar = aVar.aZk;
                int Q = mVar.Q(j2);
                if (Q == -1) {
                    Q = mVar.R(j2);
                }
                aVar.aXR = Q;
            }
        }
        AppMethodBeat.o(95000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0006 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x002c A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(95001);
        while (true) {
            Object obj;
            int i;
            long j;
            long position;
            switch (this.aTo) {
                case 0:
                    long length;
                    if (this.aYm == 0) {
                        if (!fVar.a(this.aYg.data, 0, 8, true)) {
                            obj = null;
                            if (obj == null) {
                                break;
                            }
                            AppMethodBeat.o(95001);
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
                        o oVar = new o("Atom size less than header length (unsupported).");
                        AppMethodBeat.o(95001);
                        throw oVar;
                    }
                    i = this.aYk;
                    if (i == a.aWi || i == a.aWk || i == a.aWl || i == a.aWm || i == a.aWn || i == a.aWw) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        length = (fVar.getPosition() + this.aYl) - ((long) this.aYm);
                        this.aYi.add(new a(this.aYk, length));
                        if (this.aYl == ((long) this.aYm)) {
                            P(length);
                        } else {
                            ri();
                        }
                    } else {
                        i = this.aYk;
                        if (i == a.aWy || i == a.aWj || i == a.aWz || i == a.aWA || i == a.aWT || i == a.aWU || i == a.aWV || i == a.aWx || i == a.aWW || i == a.aWX || i == a.aWY || i == a.aWZ || i == a.aXa || i == a.aWv || i == a.aVH || i == a.aXh) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            com.google.android.exoplayer2.i.a.checkState(this.aYm == 8);
                            com.google.android.exoplayer2.i.a.checkState(this.aYl <= 2147483647L);
                            this.aYn = new com.google.android.exoplayer2.i.l((int) this.aYl);
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
                    position = fVar.getPosition() + j;
                    if (this.aYn != null) {
                        fVar.readFully(this.aYn.data, this.aYm, (int) j);
                        if (this.aYk == a.aVH) {
                            boolean z;
                            com.google.android.exoplayer2.i.l lVar = this.aYn;
                            lVar.setPosition(8);
                            if (lVar.readInt() == aZh) {
                                z = true;
                            } else {
                                lVar.eM(4);
                                while (lVar.tB() > 0) {
                                    if (lVar.readInt() == aZh) {
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
                            ((a) this.aYi.peek()).a(new b(this.aYk, this.aYn));
                            obj = null;
                        }
                    } else if (j < 262144) {
                        fVar.dG((int) j);
                        obj = null;
                    } else {
                        kVar.position = fVar.getPosition() + j;
                        obj = 1;
                    }
                    P(position);
                    if (obj == null || this.aTo == 2) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj == null) {
                        break;
                    }
                    AppMethodBeat.o(95001);
                    return 1;
                    break;
                case 2:
                    int i2;
                    int i3 = -1;
                    j = Long.MAX_VALUE;
                    for (i = 0; i < this.aZi.length; i++) {
                        a aVar = this.aZi[i];
                        i2 = aVar.aXR;
                        if (i2 != aVar.aZk.sampleCount) {
                            position = aVar.aZk.offsets[i2];
                            if (position < j) {
                                j = position;
                                i3 = i;
                            }
                        }
                    }
                    if (i3 == -1) {
                        AppMethodBeat.o(95001);
                        return -1;
                    }
                    a aVar2 = this.aZi[i3];
                    m mVar = aVar2.aVw;
                    int i4 = aVar2.aXR;
                    j = aVar2.aZk.offsets[i4];
                    i = aVar2.aZk.aSB[i4];
                    if (aVar2.aYy.aZo == 1) {
                        j += 8;
                        i -= 8;
                    }
                    long position2 = (j - fVar.getPosition()) + ((long) this.aUG);
                    if (position2 < 0 || position2 >= 262144) {
                        kVar.position = j;
                        AppMethodBeat.o(95001);
                        return 1;
                    }
                    fVar.dG((int) position2);
                    int i5;
                    if (aVar2.aYy.aTz != 0) {
                        byte[] bArr = this.aTy.data;
                        bArr[0] = (byte) 0;
                        bArr[1] = (byte) 0;
                        bArr[2] = (byte) 0;
                        i5 = aVar2.aYy.aTz;
                        int i6 = 4 - aVar2.aYy.aTz;
                        while (this.aUG < i) {
                            if (this.aUF == 0) {
                                fVar.readFully(this.aTy.data, i6, i5);
                                this.aTy.setPosition(0);
                                this.aUF = this.aTy.tI();
                                this.aTx.setPosition(0);
                                mVar.a(this.aTx, 4);
                                this.aUG += 4;
                                i += i6;
                            } else {
                                i2 = mVar.a(fVar, this.aUF, false);
                                this.aUG += i2;
                                this.aUF -= i2;
                            }
                        }
                        i2 = i;
                    } else {
                        while (this.aUG < i) {
                            i5 = mVar.a(fVar, i - this.aUG, false);
                            this.aUG += i5;
                            this.aUF -= i5;
                        }
                        i2 = i;
                    }
                    mVar.a(aVar2.aZk.aZO[i4], aVar2.aZk.aXW[i4], i2, 0, null);
                    aVar2.aXR++;
                    this.aUG = 0;
                    this.aUF = 0;
                    AppMethodBeat.o(95001);
                    return 0;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException();
                    AppMethodBeat.o(95001);
                    throw illegalStateException;
            }
        }
    }

    public final boolean qX() {
        return true;
    }

    public final long getDurationUs() {
        return this.aOz;
    }

    public final long M(long j) {
        AppMethodBeat.i(95002);
        long j2 = Long.MAX_VALUE;
        a[] aVarArr = this.aZi;
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            m mVar = aVarArr[i].aZk;
            int Q = mVar.Q(j);
            if (Q == -1) {
                Q = mVar.R(j);
            }
            long j3 = mVar.offsets[Q];
            if (j3 >= j2) {
                j3 = j2;
            }
            i++;
            j2 = j3;
        }
        AppMethodBeat.o(95002);
        return j2;
    }

    private void ri() {
        this.aTo = 0;
        this.aYm = 0;
    }

    private void P(long j) {
        AppMethodBeat.i(95003);
        while (!this.aYi.isEmpty() && ((a) this.aYi.peek()).aXw == j) {
            a aVar = (a) this.aYi.pop();
            if (aVar.type == a.aWi) {
                f(aVar);
                this.aYi.clear();
                this.aTo = 2;
            } else if (!this.aYi.isEmpty()) {
                ((a) this.aYi.peek()).a(aVar);
            }
        }
        if (this.aTo != 2) {
            ri();
        }
        AppMethodBeat.o(95003);
    }

    private void f(a aVar) {
        Metadata metadata;
        AppMethodBeat.i(95004);
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        b dW = aVar.dW(a.aXh);
        if (dW != null) {
            Metadata a = b.a(dW, this.aZj);
            if (a != null) {
                iVar.c(a);
            }
            metadata = a;
        } else {
            metadata = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            long j2 = j;
            if (i2 < aVar.aXy.size()) {
                a aVar2 = (a) aVar.aXy.get(i2);
                if (aVar2.type == a.aWk) {
                    j a2 = b.a(aVar2, aVar.dW(a.aWj), -9223372036854775807L, null, (this.flags & 1) != 0, this.aZj);
                    if (a2 != null) {
                        m a3 = b.a(a2, aVar2.dX(a.aWl).dX(a.aWm).dX(a.aWn), iVar);
                        if (a3.sampleCount != 0) {
                            a aVar3 = new a(a2, a3, this.aTn.dM(i2));
                            Format dw = a2.aOv.dw(a3.aXU + 30);
                            if (a2.type == 1) {
                                if (iVar.rc()) {
                                    dw = dw.aY(iVar.aOp, iVar.aOq);
                                }
                                if (metadata != null) {
                                    dw = dw.a(metadata);
                                }
                            }
                            aVar3.aVw.f(dw);
                            j2 = Math.max(j2, a2.aOz);
                            arrayList.add(aVar3);
                        }
                    }
                }
                j = j2;
                i = i2 + 1;
            } else {
                this.aOz = j2;
                this.aZi = (a[]) arrayList.toArray(new a[arrayList.size()]);
                this.aTn.rb();
                this.aTn.a(this);
                AppMethodBeat.o(95004);
                return;
            }
        }
    }
}
