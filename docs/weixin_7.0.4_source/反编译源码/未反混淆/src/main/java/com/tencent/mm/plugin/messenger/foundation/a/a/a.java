package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;

public final class a {
    public static long a(ak akVar, int i, long j) {
        AppMethodBeat.i(60016);
        if (akVar == null) {
            AppMethodBeat.o(60016);
            return 0;
        }
        if (j == 0) {
            j = bo.anU();
        }
        long a;
        switch (i) {
            case 2:
                a = a(akVar, j) | 4611686018427387904L;
                AppMethodBeat.o(60016);
                return a;
            case 3:
                a = a(akVar, j) & -4611686018427387905L;
                AppMethodBeat.o(60016);
                return a;
            case 4:
                a = a(akVar, j) & 4611686018427387904L;
                AppMethodBeat.o(60016);
                return a;
            case 5:
                a = a(akVar, j) | 1152921504606846976L;
                AppMethodBeat.o(60016);
                return a;
            case 6:
                a = a(akVar, j) & -1152921504606846977L;
                AppMethodBeat.o(60016);
                return a;
            case 7:
                a = a(akVar, j) & 1152921504606846976L;
                AppMethodBeat.o(60016);
                return a;
            default:
                a = a(akVar, j);
                AppMethodBeat.o(60016);
                return a;
        }
    }

    public static long a(ak akVar, long j) {
        return (akVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }
}
