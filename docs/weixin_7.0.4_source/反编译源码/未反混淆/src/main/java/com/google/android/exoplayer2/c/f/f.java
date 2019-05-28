package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.h;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f implements h {
    private final String aOt;
    private Format aOv;
    private long aSk;
    private m aTw;
    private int bbE;
    private final l bbm = new l(new byte[15]);
    private int bbo;
    private long bbq;
    private String bbx;
    private int sampleSize;
    private int state;

    public f(String str) {
        AppMethodBeat.i(95103);
        this.bbm.data[0] = Byte.MAX_VALUE;
        this.bbm.data[1] = (byte) -2;
        this.bbm.data[2] = Byte.MIN_VALUE;
        this.bbm.data[3] = (byte) 1;
        this.state = 0;
        this.aOt = str;
        AppMethodBeat.o(95103);
    }

    public final void rn() {
        this.state = 0;
        this.bbo = 0;
        this.bbE = 0;
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95104);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        AppMethodBeat.o(95104);
    }

    public final void d(long j, boolean z) {
        this.aSk = j;
    }

    /* JADX WARNING: Missing block: B:13:0x003d, code skipped:
            r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(l lVar) {
        AppMethodBeat.i(95105);
        while (lVar.tB() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    while (lVar.tB() > 0) {
                        this.bbE <<= 8;
                        this.bbE |= lVar.readUnsignedByte();
                        if (this.bbE == 2147385345) {
                            this.bbE = 0;
                            i = 1;
                            if (i == 0) {
                                break;
                            }
                            this.bbo = 4;
                            this.state = 1;
                            break;
                        }
                    }
                    break;
                case 1:
                    byte[] bArr = this.bbm.data;
                    int min = Math.min(lVar.tB(), 15 - this.bbo);
                    lVar.readBytes(bArr, this.bbo, min);
                    this.bbo += min;
                    if (this.bbo == 15) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i == 0) {
                        break;
                    }
                    bArr = this.bbm.data;
                    if (this.aOv == null) {
                        this.aOv = h.a(bArr, this.bbx, this.aOt);
                        this.aTw.f(this.aOv);
                    }
                    this.sampleSize = h.l(bArr);
                    this.bbq = (long) ((int) ((((long) h.k(bArr)) * 1000000) / ((long) this.aOv.sampleRate)));
                    this.bbm.setPosition(0);
                    this.aTw.a(this.bbm, 15);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(lVar.tB(), this.sampleSize - this.bbo);
                    this.aTw.a(lVar, i);
                    this.bbo = i + this.bbo;
                    if (this.bbo != this.sampleSize) {
                        break;
                    }
                    this.aTw.a(this.aSk, 1, this.sampleSize, 0, null);
                    this.aSk += this.bbq;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
        AppMethodBeat.o(95105);
    }

    public final void ro() {
    }
}
