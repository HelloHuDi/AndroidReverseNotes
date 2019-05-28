package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32064k;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.o */
public final class C32038o implements C37245v {
    private long aSk;
    private C45042s aYf;
    private int bbo;
    private final C0845h bcX;
    private final C32064k bcY = new C32064k(new byte[10]);
    private boolean bcZ;
    private boolean bda;
    private boolean bdb;
    private int bdc;
    private int bdd;
    private boolean bde;
    private int state = 0;

    public C32038o(C0845h c0845h) {
        AppMethodBeat.m2504i(95143);
        this.bcX = c0845h;
        AppMethodBeat.m2505o(95143);
    }

    /* renamed from: a */
    public final void mo42784a(C45042s c45042s, C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95144);
        this.aYf = c45042s;
        this.bcX.mo2555a(c8662g, c8661d);
        AppMethodBeat.m2505o(95144);
    }

    /* renamed from: rn */
    public final void mo42785rn() {
        AppMethodBeat.m2504i(95145);
        this.state = 0;
        this.bbo = 0;
        this.bdb = false;
        this.bcX.mo2557rn();
        AppMethodBeat.m2505o(95145);
    }

    /* renamed from: a */
    public final void mo42783a(C32065l c32065l, boolean z) {
        AppMethodBeat.m2504i(95146);
        if (z) {
            switch (this.state) {
                case 3:
                    if (this.bdd != -1) {
                        new StringBuilder("Unexpected start indicator: expected ").append(this.bdd).append(" more bytes");
                    }
                    this.bcX.mo2558ro();
                    break;
            }
            setState(1);
        }
        while (c32065l.mo52382tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    c32065l.mo52369eM(c32065l.mo52382tB());
                    break;
                case 1:
                    if (!m52069a(c32065l, this.bcY.data, 9)) {
                        break;
                    }
                    this.bcY.setPosition(0);
                    if (this.bcY.mo52354ed(24) != 1) {
                        this.bdd = -1;
                        i = 0;
                    } else {
                        this.bcY.mo52355ee(8);
                        i = this.bcY.mo52354ed(16);
                        this.bcY.mo52355ee(5);
                        this.bde = this.bcY.mo52358rl();
                        this.bcY.mo52355ee(2);
                        this.bcZ = this.bcY.mo52358rl();
                        this.bda = this.bcY.mo52358rl();
                        this.bcY.mo52355ee(6);
                        this.bdc = this.bcY.mo52354ed(8);
                        if (i == 0) {
                            this.bdd = -1;
                        } else {
                            this.bdd = ((i + 6) - 9) - this.bdc;
                        }
                        i = 1;
                    }
                    if (i != 0) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    setState(i);
                    break;
                case 2:
                    if (m52069a(c32065l, this.bcY.data, Math.min(10, this.bdc)) && m52069a(c32065l, null, this.bdc)) {
                        this.bcY.setPosition(0);
                        this.aSk = -9223372036854775807L;
                        if (this.bcZ) {
                            this.bcY.mo52355ee(4);
                            long ed = ((long) this.bcY.mo52354ed(3)) << 30;
                            this.bcY.mo52355ee(1);
                            ed |= (long) (this.bcY.mo52354ed(15) << 15);
                            this.bcY.mo52355ee(1);
                            ed |= (long) this.bcY.mo52354ed(15);
                            this.bcY.mo52355ee(1);
                            if (!this.bdb && this.bda) {
                                this.bcY.mo52355ee(4);
                                long ed2 = ((long) this.bcY.mo52354ed(3)) << 30;
                                this.bcY.mo52355ee(1);
                                ed2 |= (long) (this.bcY.mo52354ed(15) << 15);
                                this.bcY.mo52355ee(1);
                                ed2 |= (long) this.bcY.mo52354ed(15);
                                this.bcY.mo52355ee(1);
                                this.aYf.mo72551ao(ed2);
                                this.bdb = true;
                            }
                            this.aSk = this.aYf.mo72551ao(ed);
                        }
                        this.bcX.mo2556d(this.aSk, this.bde);
                        setState(3);
                        break;
                    }
                case 3:
                    int i2;
                    i = c32065l.mo52382tB();
                    if (this.bdd == -1) {
                        i2 = 0;
                    } else {
                        i2 = i - this.bdd;
                    }
                    if (i2 > 0) {
                        i -= i2;
                        c32065l.mo52368eL(c32065l.position + i);
                    }
                    this.bcX.mo2559t(c32065l);
                    if (this.bdd == -1) {
                        break;
                    }
                    this.bdd -= i;
                    if (this.bdd != 0) {
                        break;
                    }
                    this.bcX.mo2558ro();
                    setState(1);
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95146);
    }

    private void setState(int i) {
        this.state = i;
        this.bbo = 0;
    }

    /* renamed from: a */
    private boolean m52069a(C32065l c32065l, byte[] bArr, int i) {
        AppMethodBeat.m2504i(95147);
        int min = Math.min(c32065l.mo52382tB(), i - this.bbo);
        if (min <= 0) {
            AppMethodBeat.m2505o(95147);
            return true;
        }
        if (bArr == null) {
            c32065l.mo52369eM(min);
        } else {
            c32065l.readBytes(bArr, this.bbo, min);
        }
        this.bbo = min + this.bbo;
        if (this.bbo == i) {
            AppMethodBeat.m2505o(95147);
            return true;
        }
        AppMethodBeat.m2505o(95147);
        return false;
    }
}
