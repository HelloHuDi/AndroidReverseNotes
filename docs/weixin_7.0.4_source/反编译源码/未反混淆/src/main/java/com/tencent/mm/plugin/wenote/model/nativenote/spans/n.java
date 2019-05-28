package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n extends e {
    final boolean uRY;
    public final boolean uRZ;

    public n(int i, int i2, boolean z, boolean z2) {
        super(i, i2);
        this.uRY = z;
        this.uRZ = z2;
    }

    public final boolean a(e eVar) {
        AppMethodBeat.i(26958);
        if (eVar == null) {
            AppMethodBeat.o(26958);
            return false;
        } else if (eVar.isEmpty()) {
            boolean z;
            if (eVar.aqm < this.aqm || eVar.Ls >= this.Ls) {
                z = false;
            } else {
                z = true;
            }
            boolean z2;
            if (eVar.aqm < this.aqm || eVar.Ls > this.Ls) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (z2 && this.uRZ)) {
                AppMethodBeat.o(26958);
                return true;
            }
            AppMethodBeat.o(26958);
            return false;
        } else if (Math.max(this.aqm, eVar.aqm) < Math.min(this.Ls, eVar.Ls)) {
            AppMethodBeat.o(26958);
            return true;
        } else {
            AppMethodBeat.o(26958);
            return false;
        }
    }

    public final int dfF() {
        AppMethodBeat.i(26959);
        int abs = Math.abs(this.Ls - this.aqm);
        AppMethodBeat.o(26959);
        return abs;
    }
}
