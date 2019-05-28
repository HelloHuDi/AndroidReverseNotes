package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.j;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m implements h {
    private final String aOt;
    private int aPy;
    private long aSk;
    private boolean aTf;
    private com.google.android.exoplayer2.c.m aTw;
    private long bbL;
    private String bbx;
    private final l bcP;
    private final j bcQ;
    private int bcR;
    private boolean bcS;
    private int state;

    public m() {
        this(null);
    }

    public m(String str) {
        AppMethodBeat.i(95137);
        this.state = 0;
        this.bcP = new l(4);
        this.bcP.data[0] = (byte) -1;
        this.bcQ = new j();
        this.aOt = str;
        AppMethodBeat.o(95137);
    }

    public final void rn() {
        this.state = 0;
        this.bcR = 0;
        this.bcS = false;
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95138);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        AppMethodBeat.o(95138);
    }

    public final void d(long j, boolean z) {
        this.aSk = j;
    }

    public final void t(l lVar) {
        AppMethodBeat.i(95139);
        while (lVar.tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    byte[] bArr = lVar.data;
                    i = lVar.position;
                    int i2 = lVar.limit;
                    int i3 = i;
                    while (i3 < i2) {
                        int i4;
                        boolean z = (bArr[i3] & 255) == 255;
                        if (this.bcS && (bArr[i3] & 224) == 224) {
                            i4 = 1;
                        } else {
                            boolean i42 = false;
                        }
                        this.bcS = z;
                        if (i42 != 0) {
                            lVar.setPosition(i3 + 1);
                            this.bcS = false;
                            this.bcP.data[1] = bArr[i3];
                            this.bcR = 2;
                            this.state = 1;
                            break;
                        }
                        i3++;
                    }
                    lVar.setPosition(i2);
                    break;
                case 1:
                    i = Math.min(lVar.tB(), 4 - this.bcR);
                    lVar.readBytes(this.bcP.data, this.bcR, i);
                    this.bcR = i + this.bcR;
                    if (this.bcR < 4) {
                        break;
                    }
                    this.bcP.setPosition(0);
                    if (!j.a(this.bcP.readInt(), this.bcQ)) {
                        this.bcR = 0;
                        this.state = 1;
                        break;
                    }
                    this.aPy = this.bcQ.aPy;
                    if (!this.aTf) {
                        this.bbL = (1000000 * ((long) this.bcQ.aTa)) / ((long) this.bcQ.sampleRate);
                        this.aTw.f(Format.a(this.bbx, this.bcQ.mimeType, -1, 4096, this.bcQ.channels, this.bcQ.sampleRate, null, null, this.aOt));
                        this.aTf = true;
                    }
                    this.bcP.setPosition(0);
                    this.aTw.a(this.bcP, 4);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(lVar.tB(), this.aPy - this.bcR);
                    this.aTw.a(lVar, i);
                    this.bcR = i + this.bcR;
                    if (this.bcR < this.aPy) {
                        break;
                    }
                    this.aTw.a(this.aSk, 1, this.aPy, 0, null);
                    this.aSk += this.bbL;
                    this.bcR = 0;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(95139);
    }

    public final void ro() {
    }
}
