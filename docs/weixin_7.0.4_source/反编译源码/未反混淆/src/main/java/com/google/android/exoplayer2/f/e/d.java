package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    int backgroundColor;
    String bnS;
    int bnT;
    boolean bnU;
    boolean bnV;
    int bnW = -1;
    int bnX = -1;
    int bnY = -1;
    int bnZ = -1;
    int boa = -1;
    d bob;
    Alignment boc;
    float fontSize;
    String id;

    public final int getStyle() {
        int i = 0;
        if (this.bnY == -1 && this.bnZ == -1) {
            return -1;
        }
        int i2 = this.bnY == 1 ? 1 : 0;
        if (this.bnZ == 1) {
            i = 2;
        }
        return i2 | i;
    }

    public final d aK(boolean z) {
        boolean z2;
        int i = 1;
        AppMethodBeat.i(95690);
        if (this.bob == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.checkState(z2);
        if (!z) {
            i = 0;
        }
        this.bnW = i;
        AppMethodBeat.o(95690);
        return this;
    }

    public final d aL(boolean z) {
        boolean z2;
        int i = 1;
        AppMethodBeat.i(95691);
        if (this.bob == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        a.checkState(z2);
        if (!z) {
            i = 0;
        }
        this.bnX = i;
        AppMethodBeat.o(95691);
        return this;
    }

    public final d eE(int i) {
        AppMethodBeat.i(95692);
        a.checkState(this.bob == null);
        this.bnT = i;
        this.bnU = true;
        AppMethodBeat.o(95692);
        return this;
    }

    public final d eF(int i) {
        this.backgroundColor = i;
        this.bnV = true;
        return this;
    }

    /* Access modifiers changed, original: final */
    public final d b(d dVar) {
        AppMethodBeat.i(95693);
        if (dVar != null) {
            if (!this.bnU && dVar.bnU) {
                eE(dVar.bnT);
            }
            if (this.bnY == -1) {
                this.bnY = dVar.bnY;
            }
            if (this.bnZ == -1) {
                this.bnZ = dVar.bnZ;
            }
            if (this.bnS == null) {
                this.bnS = dVar.bnS;
            }
            if (this.bnW == -1) {
                this.bnW = dVar.bnW;
            }
            if (this.bnX == -1) {
                this.bnX = dVar.bnX;
            }
            if (this.boc == null) {
                this.boc = dVar.boc;
            }
            if (this.boa == -1) {
                this.boa = dVar.boa;
                this.fontSize = dVar.fontSize;
            }
            if (!this.bnV && dVar.bnV) {
                eF(dVar.backgroundColor);
            }
        }
        AppMethodBeat.o(95693);
        return this;
    }
}
