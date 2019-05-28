package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements h {
    private final String aOt;
    private Format aOv;
    long aSk;
    private m aTw;
    private final k bbl;
    private final l bbm;
    private String bbn;
    private int bbo;
    private boolean bbp;
    private long bbq;
    private int sampleSize;
    private int state;

    public b() {
        this(null);
    }

    public b(String str) {
        AppMethodBeat.i(95075);
        this.bbl = new k(new byte[8]);
        this.bbm = new l(this.bbl.data);
        this.state = 0;
        this.aOt = str;
        AppMethodBeat.o(95075);
    }

    public final void rn() {
        this.state = 0;
        this.bbo = 0;
        this.bbp = false;
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95076);
        dVar.rz();
        this.bbn = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        AppMethodBeat.o(95076);
    }

    public final void d(long j, boolean z) {
        this.aSk = j;
    }

    public final void t(l lVar) {
        AppMethodBeat.i(95077);
        while (lVar.tB() > 0) {
            switch (this.state) {
                case 0:
                    if (!u(lVar)) {
                        break;
                    }
                    this.state = 1;
                    this.bbm.data[0] = (byte) 11;
                    this.bbm.data[1] = (byte) 119;
                    this.bbo = 2;
                    break;
                case 1:
                    if (!a(lVar, this.bbm.data)) {
                        break;
                    }
                    rp();
                    this.bbm.setPosition(0);
                    this.aTw.a(this.bbm, 8);
                    this.state = 2;
                    break;
                case 2:
                    int min = Math.min(lVar.tB(), this.sampleSize - this.bbo);
                    this.aTw.a(lVar, min);
                    this.bbo = min + this.bbo;
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
        AppMethodBeat.o(95077);
    }

    public final void ro() {
    }

    private boolean a(l lVar, byte[] bArr) {
        AppMethodBeat.i(95078);
        int min = Math.min(lVar.tB(), 8 - this.bbo);
        lVar.readBytes(bArr, this.bbo, min);
        this.bbo = min + this.bbo;
        if (this.bbo == 8) {
            AppMethodBeat.o(95078);
            return true;
        }
        AppMethodBeat.o(95078);
        return false;
    }

    private boolean u(l lVar) {
        AppMethodBeat.i(95079);
        while (lVar.tB() > 0) {
            if (this.bbp) {
                int readUnsignedByte = lVar.readUnsignedByte();
                if (readUnsignedByte == com.tencent.view.d.MIC_AVROUND_BLUR) {
                    this.bbp = false;
                    AppMethodBeat.o(95079);
                    return true;
                }
                this.bbp = readUnsignedByte == 11;
            } else {
                this.bbp = lVar.readUnsignedByte() == 11;
            }
        }
        AppMethodBeat.o(95079);
        return false;
    }

    private void rp() {
        AppMethodBeat.i(95080);
        this.bbl.setPosition(0);
        a a = com.google.android.exoplayer2.a.a.a(this.bbl);
        if (!(this.aOv != null && a.aOn == this.aOv.aOn && a.sampleRate == this.aOv.sampleRate && a.mimeType == this.aOv.aOd)) {
            this.aOv = Format.a(this.bbn, a.mimeType, -1, -1, a.aOn, a.sampleRate, null, null, this.aOt);
            this.aTw.f(this.aOv);
        }
        this.sampleSize = a.aPy;
        this.bbq = (1000000 * ((long) a.sampleCount)) / ((long) this.aOv.sampleRate);
        AppMethodBeat.o(95080);
    }
}
