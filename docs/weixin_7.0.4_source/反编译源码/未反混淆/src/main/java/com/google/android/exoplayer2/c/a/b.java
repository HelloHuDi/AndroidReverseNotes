package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements e, l {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(94863);
            e[] eVarArr = new e[]{new b()};
            AppMethodBeat.o(94863);
            return eVarArr;
        }
    };
    private static final int aTi = v.aT("FLV");
    private final com.google.android.exoplayer2.i.l aTj = new com.google.android.exoplayer2.i.l(4);
    private final com.google.android.exoplayer2.i.l aTk = new com.google.android.exoplayer2.i.l(9);
    private final com.google.android.exoplayer2.i.l aTl = new com.google.android.exoplayer2.i.l(11);
    private final com.google.android.exoplayer2.i.l aTm = new com.google.android.exoplayer2.i.l();
    private g aTn;
    private int aTo = 1;
    private int aTp;
    public int aTq;
    public int aTr;
    public long aTs;
    private a aTt;
    private e aTu;
    private c aTv;

    static {
        AppMethodBeat.i(94868);
        AppMethodBeat.o(94868);
    }

    public b() {
        AppMethodBeat.i(94864);
        AppMethodBeat.o(94864);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(94865);
        fVar.b(this.aTj.data, 0, 3);
        this.aTj.setPosition(0);
        if (this.aTj.tD() != aTi) {
            AppMethodBeat.o(94865);
            return false;
        }
        fVar.b(this.aTj.data, 0, 2);
        this.aTj.setPosition(0);
        if ((this.aTj.readUnsignedShort() & 250) != 0) {
            AppMethodBeat.o(94865);
            return false;
        }
        fVar.b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        int readInt = this.aTj.readInt();
        fVar.qY();
        fVar.dH(readInt);
        fVar.b(this.aTj.data, 0, 4);
        this.aTj.setPosition(0);
        if (this.aTj.readInt() == 0) {
            AppMethodBeat.o(94865);
            return true;
        }
        AppMethodBeat.o(94865);
        return false;
    }

    public final void a(g gVar) {
        this.aTn = gVar;
    }

    public final void g(long j, long j2) {
        this.aTo = 1;
        this.aTp = 0;
    }

    public final int a(f fVar, k kVar) {
        AppMethodBeat.i(94866);
        while (true) {
            int readUnsignedByte;
            boolean z;
            switch (this.aTo) {
                case 1:
                    if (fVar.a(this.aTk.data, 0, 9, true)) {
                        this.aTk.setPosition(0);
                        this.aTk.eM(4);
                        readUnsignedByte = this.aTk.readUnsignedByte();
                        boolean z2 = (readUnsignedByte & 4) != 0;
                        if ((readUnsignedByte & 1) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && this.aTt == null) {
                            this.aTt = new a(this.aTn.dM(8));
                        }
                        if (z && this.aTu == null) {
                            this.aTu = new e(this.aTn.dM(9));
                        }
                        if (this.aTv == null) {
                            this.aTv = new c();
                        }
                        this.aTn.rb();
                        this.aTn.a(this);
                        this.aTp = (this.aTk.readInt() - 9) + 4;
                        this.aTo = 2;
                        z = true;
                    } else {
                        readUnsignedByte = 0;
                    }
                    if (readUnsignedByte != 0) {
                        break;
                    }
                    AppMethodBeat.o(94866);
                    return -1;
                case 2:
                    fVar.dG(this.aTp);
                    this.aTp = 0;
                    this.aTo = 3;
                    break;
                case 3:
                    if (fVar.a(this.aTl.data, 0, 11, true)) {
                        this.aTl.setPosition(0);
                        this.aTq = this.aTl.readUnsignedByte();
                        this.aTr = this.aTl.tD();
                        this.aTs = (long) this.aTl.tD();
                        this.aTs = (((long) (this.aTl.readUnsignedByte() << 24)) | this.aTs) * 1000;
                        this.aTl.eM(3);
                        this.aTo = 4;
                        z = true;
                    } else {
                        readUnsignedByte = 0;
                    }
                    if (readUnsignedByte != 0) {
                        break;
                    }
                    AppMethodBeat.o(94866);
                    return -1;
                case 4:
                    if (this.aTq == 8 && this.aTt != null) {
                        this.aTt.b(b(fVar), this.aTs);
                        z = true;
                    } else if (this.aTq == 9 && this.aTu != null) {
                        this.aTu.b(b(fVar), this.aTs);
                        z = true;
                    } else if (this.aTq != 18 || this.aTv == null) {
                        fVar.dG(this.aTr);
                        z = false;
                    } else {
                        this.aTv.b(b(fVar), this.aTs);
                        z = true;
                    }
                    this.aTp = 4;
                    this.aTo = 2;
                    if (!z) {
                        break;
                    }
                    AppMethodBeat.o(94866);
                    return 0;
                    break;
                default:
                    break;
            }
        }
    }

    private com.google.android.exoplayer2.i.l b(f fVar) {
        AppMethodBeat.i(94867);
        if (this.aTr > this.aTm.capacity()) {
            this.aTm.n(new byte[Math.max(this.aTm.capacity() * 2, this.aTr)], 0);
        } else {
            this.aTm.setPosition(0);
        }
        this.aTm.eL(this.aTr);
        fVar.readFully(this.aTm.data, 0, this.aTr);
        com.google.android.exoplayer2.i.l lVar = this.aTm;
        AppMethodBeat.o(94867);
        return lVar;
    }

    public final boolean qX() {
        return false;
    }

    public final long getDurationUs() {
        return this.aTv.aOz;
    }

    public final long M(long j) {
        return 0;
    }
}
