package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.storage.bi;

public final class k {
    public static int k(bi biVar) {
        AppMethodBeat.i(77793);
        if (biVar.bAA()) {
            b X = b.X(biVar.field_content, biVar.field_reserved);
            if (X == null) {
                AppMethodBeat.o(77793);
                return 0;
            }
            int i = X.type;
            AppMethodBeat.o(77793);
            return i;
        }
        AppMethodBeat.o(77793);
        return 0;
    }
}
