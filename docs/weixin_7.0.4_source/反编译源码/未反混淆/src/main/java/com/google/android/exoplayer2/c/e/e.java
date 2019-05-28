package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e {
    private static final int bak = v.aT("OggS");
    private final l aTj = new l(255);
    public int aVG;
    public int bal;
    public long bam;
    public long ban;
    public long bao;
    public long bap;
    public int baq;
    public int bar;
    public final int[] bas = new int[255];
    public int type;

    e() {
        AppMethodBeat.i(95041);
        AppMethodBeat.o(95041);
    }

    static {
        AppMethodBeat.i(95043);
        AppMethodBeat.o(95043);
    }

    public final void reset() {
        this.bal = 0;
        this.type = 0;
        this.bam = 0;
        this.ban = 0;
        this.bao = 0;
        this.bap = 0;
        this.baq = 0;
        this.aVG = 0;
        this.bar = 0;
    }

    public final boolean c(f fVar, boolean z) {
        int i = 0;
        AppMethodBeat.i(95042);
        this.aTj.reset();
        reset();
        int i2 = (fVar.getLength() == -1 || fVar.getLength() - fVar.qZ() >= 27) ? true : 0;
        o oVar;
        if (i2 == 0 || !fVar.b(this.aTj.data, 0, 27, true)) {
            if (z) {
                AppMethodBeat.o(95042);
                return false;
            }
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(95042);
            throw eOFException;
        } else if (this.aTj.cM() == ((long) bak)) {
            this.bal = this.aTj.readUnsignedByte();
            if (this.bal == 0) {
                this.type = this.aTj.readUnsignedByte();
                this.bam = this.aTj.tG();
                this.ban = this.aTj.tE();
                this.bao = this.aTj.tE();
                this.bap = this.aTj.tE();
                this.baq = this.aTj.readUnsignedByte();
                this.aVG = this.baq + 27;
                this.aTj.reset();
                fVar.b(this.aTj.data, 0, this.baq);
                while (i < this.baq) {
                    this.bas[i] = this.aTj.readUnsignedByte();
                    this.bar += this.bas[i];
                    i++;
                }
                AppMethodBeat.o(95042);
                return true;
            } else if (z) {
                AppMethodBeat.o(95042);
                return false;
            } else {
                oVar = new o("unsupported bit stream revision");
                AppMethodBeat.o(95042);
                throw oVar;
            }
        } else if (z) {
            AppMethodBeat.o(95042);
            return false;
        } else {
            oVar = new o("expected OggS capture pattern at begin of page");
            AppMethodBeat.o(95042);
            throw oVar;
        }
    }
}
