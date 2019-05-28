package com.google.android.exoplayer2.p101c.p795a;

import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.a.b */
public final class C17631b implements C32034e, C37247l {
    public static final C32039h aTh = new C176301();
    private static final int aTi = C17675v.m27562aT("FLV");
    private final C32065l aTj = new C32065l(4);
    private final C32065l aTk = new C32065l(9);
    private final C32065l aTl = new C32065l(11);
    private final C32065l aTm = new C32065l();
    private C8662g aTn;
    private int aTo = 1;
    private int aTp;
    public int aTq;
    public int aTr;
    public long aTs;
    private C17629a aTt;
    private C44647e aTu;
    private C17632c aTv;

    /* renamed from: com.google.android.exoplayer2.c.a.b$1 */
    static class C176301 implements C32039h {
        C176301() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(94863);
            C32034e[] c32034eArr = new C32034e[]{new C17631b()};
            AppMethodBeat.m2505o(94863);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(94868);
        AppMethodBeat.m2505o(94868);
    }

    public C17631b() {
        AppMethodBeat.m2504i(94864);
        AppMethodBeat.m2505o(94864);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(94865);
        c45026f.mo59479b(this.aTj.data, 0, 3);
        this.aTj.setPosition(0);
        if (this.aTj.mo52384tD() != aTi) {
            AppMethodBeat.m2505o(94865);
            return false;
        }
        c45026f.mo59479b(this.aTj.data, 0, 2);
        this.aTj.setPosition(0);
        if ((this.aTj.readUnsignedShort() & 250) != 0) {
            AppMethodBeat.m2505o(94865);
            return false;
        }
        c45026f.mo59479b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        int readInt = this.aTj.readInt();
        c45026f.mo59486qY();
        c45026f.mo59483dH(readInt);
        c45026f.mo59479b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        if (this.aTj.readInt() == 0) {
            AppMethodBeat.m2505o(94865);
            return true;
        }
        AppMethodBeat.m2505o(94865);
        return false;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        this.aTn = c8662g;
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        this.aTo = 1;
        this.aTp = 0;
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        AppMethodBeat.m2504i(94866);
        while (true) {
            int readUnsignedByte;
            boolean z;
            switch (this.aTo) {
                case 1:
                    if (c45026f.mo59478a(this.aTk.data, 0, 9, true)) {
                        this.aTk.setPosition(0);
                        this.aTk.mo52369eM(4);
                        readUnsignedByte = this.aTk.readUnsignedByte();
                        boolean z2 = (readUnsignedByte & 4) != 0;
                        if ((readUnsignedByte & 1) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && this.aTt == null) {
                            this.aTt = new C17629a(this.aTn.mo19157dM(8));
                        }
                        if (z && this.aTu == null) {
                            this.aTu = new C44647e(this.aTn.mo19157dM(9));
                        }
                        if (this.aTv == null) {
                            this.aTv = new C17632c();
                        }
                        this.aTn.mo19158rb();
                        this.aTn.mo19156a(this);
                        this.aTp = (this.aTk.readInt() - 9) + 4;
                        this.aTo = 2;
                        z = true;
                    } else {
                        readUnsignedByte = 0;
                    }
                    if (readUnsignedByte != 0) {
                        break;
                    }
                    AppMethodBeat.m2505o(94866);
                    return -1;
                case 2:
                    c45026f.mo59482dG(this.aTp);
                    this.aTp = 0;
                    this.aTo = 3;
                    break;
                case 3:
                    if (c45026f.mo59478a(this.aTl.data, 0, 11, true)) {
                        this.aTl.setPosition(0);
                        this.aTq = this.aTl.readUnsignedByte();
                        this.aTr = this.aTl.mo52384tD();
                        this.aTs = (long) this.aTl.mo52384tD();
                        this.aTs = (((long) (this.aTl.readUnsignedByte() << 24)) | this.aTs) * 1000;
                        this.aTl.mo52369eM(3);
                        this.aTo = 4;
                        z = true;
                    } else {
                        readUnsignedByte = 0;
                    }
                    if (readUnsignedByte != 0) {
                        break;
                    }
                    AppMethodBeat.m2505o(94866);
                    return -1;
                case 4:
                    if (this.aTq == 8 && this.aTt != null) {
                        this.aTt.mo66728b(m27438b(c45026f), this.aTs);
                        z = true;
                    } else if (this.aTq == 9 && this.aTu != null) {
                        this.aTu.mo66728b(m27438b(c45026f), this.aTs);
                        z = true;
                    } else if (this.aTq != 18 || this.aTv == null) {
                        c45026f.mo59482dG(this.aTr);
                        z = false;
                    } else {
                        this.aTv.mo66728b(m27438b(c45026f), this.aTs);
                        z = true;
                    }
                    this.aTp = 4;
                    this.aTo = 2;
                    if (!z) {
                        break;
                    }
                    AppMethodBeat.m2505o(94866);
                    return 0;
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: b */
    private C32065l m27438b(C45026f c45026f) {
        AppMethodBeat.m2504i(94867);
        if (this.aTr > this.aTm.capacity()) {
            this.aTm.mo52371n(new byte[Math.max(this.aTm.capacity() * 2, this.aTr)], 0);
        } else {
            this.aTm.setPosition(0);
        }
        this.aTm.mo52368eL(this.aTr);
        c45026f.readFully(this.aTm.data, 0, this.aTr);
        C32065l c32065l = this.aTm;
        AppMethodBeat.m2505o(94867);
        return c32065l;
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return false;
    }

    public final long getDurationUs() {
        return this.aTv.aOz;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        return 0;
    }
}
