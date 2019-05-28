package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class p {
    public static final p bhZ = new p(new o[0]);
    private int aBR;
    public final o[] bia;
    public final int length;

    static {
        AppMethodBeat.i(95558);
        AppMethodBeat.o(95558);
    }

    public p(o... oVarArr) {
        AppMethodBeat.i(95555);
        this.bia = oVarArr;
        this.length = oVarArr.length;
        AppMethodBeat.o(95555);
    }

    public final int a(o oVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.bia[i] == oVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.i(95556);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bia);
        }
        int i = this.aBR;
        AppMethodBeat.o(95556);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95557);
        if (this == obj) {
            AppMethodBeat.o(95557);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95557);
            return false;
        } else {
            p pVar = (p) obj;
            if (this.length == pVar.length && Arrays.equals(this.bia, pVar.bia)) {
                AppMethodBeat.o(95557);
                return true;
            }
            AppMethodBeat.o(95557);
            return false;
        }
    }
}
