package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o implements v {
    private long aSk;
    private s aYf;
    private int bbo;
    private final h bcX;
    private final k bcY = new k(new byte[10]);
    private boolean bcZ;
    private boolean bda;
    private boolean bdb;
    private int bdc;
    private int bdd;
    private boolean bde;
    private int state = 0;

    public o(h hVar) {
        AppMethodBeat.i(95143);
        this.bcX = hVar;
        AppMethodBeat.o(95143);
    }

    public final void a(s sVar, g gVar, d dVar) {
        AppMethodBeat.i(95144);
        this.aYf = sVar;
        this.bcX.a(gVar, dVar);
        AppMethodBeat.o(95144);
    }

    public final void rn() {
        AppMethodBeat.i(95145);
        this.state = 0;
        this.bbo = 0;
        this.bdb = false;
        this.bcX.rn();
        AppMethodBeat.o(95145);
    }

    public final void a(l lVar, boolean z) {
        AppMethodBeat.i(95146);
        if (z) {
            switch (this.state) {
                case 3:
                    if (this.bdd != -1) {
                        new StringBuilder("Unexpected start indicator: expected ").append(this.bdd).append(" more bytes");
                    }
                    this.bcX.ro();
                    break;
            }
            setState(1);
        }
        while (lVar.tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    lVar.eM(lVar.tB());
                    break;
                case 1:
                    if (!a(lVar, this.bcY.data, 9)) {
                        break;
                    }
                    this.bcY.setPosition(0);
                    if (this.bcY.ed(24) != 1) {
                        this.bdd = -1;
                        i = 0;
                    } else {
                        this.bcY.ee(8);
                        i = this.bcY.ed(16);
                        this.bcY.ee(5);
                        this.bde = this.bcY.rl();
                        this.bcY.ee(2);
                        this.bcZ = this.bcY.rl();
                        this.bda = this.bcY.rl();
                        this.bcY.ee(6);
                        this.bdc = this.bcY.ed(8);
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
                    if (a(lVar, this.bcY.data, Math.min(10, this.bdc)) && a(lVar, null, this.bdc)) {
                        this.bcY.setPosition(0);
                        this.aSk = -9223372036854775807L;
                        if (this.bcZ) {
                            this.bcY.ee(4);
                            long ed = ((long) this.bcY.ed(3)) << 30;
                            this.bcY.ee(1);
                            ed |= (long) (this.bcY.ed(15) << 15);
                            this.bcY.ee(1);
                            ed |= (long) this.bcY.ed(15);
                            this.bcY.ee(1);
                            if (!this.bdb && this.bda) {
                                this.bcY.ee(4);
                                long ed2 = ((long) this.bcY.ed(3)) << 30;
                                this.bcY.ee(1);
                                ed2 |= (long) (this.bcY.ed(15) << 15);
                                this.bcY.ee(1);
                                ed2 |= (long) this.bcY.ed(15);
                                this.bcY.ee(1);
                                this.aYf.ao(ed2);
                                this.bdb = true;
                            }
                            this.aSk = this.aYf.ao(ed);
                        }
                        this.bcX.d(this.aSk, this.bde);
                        setState(3);
                        break;
                    }
                case 3:
                    int i2;
                    i = lVar.tB();
                    if (this.bdd == -1) {
                        i2 = 0;
                    } else {
                        i2 = i - this.bdd;
                    }
                    if (i2 > 0) {
                        i -= i2;
                        lVar.eL(lVar.position + i);
                    }
                    this.bcX.t(lVar);
                    if (this.bdd == -1) {
                        break;
                    }
                    this.bdd -= i;
                    if (this.bdd != 0) {
                        break;
                    }
                    this.bcX.ro();
                    setState(1);
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(95146);
    }

    private void setState(int i) {
        this.state = i;
        this.bbo = 0;
    }

    private boolean a(l lVar, byte[] bArr, int i) {
        AppMethodBeat.i(95147);
        int min = Math.min(lVar.tB(), i - this.bbo);
        if (min <= 0) {
            AppMethodBeat.o(95147);
            return true;
        }
        if (bArr == null) {
            lVar.eM(min);
        } else {
            lVar.readBytes(bArr, this.bbo, min);
        }
        this.bbo = min + this.bbo;
        if (this.bbo == i) {
            AppMethodBeat.o(95147);
            return true;
        }
        AppMethodBeat.o(95147);
        return false;
    }
}
