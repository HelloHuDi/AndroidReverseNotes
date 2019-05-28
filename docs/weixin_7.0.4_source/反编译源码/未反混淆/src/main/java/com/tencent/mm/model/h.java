package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.api.i;

public final class h implements i {
    public final j cH(String str) {
        AppMethodBeat.i(11223);
        j cH = z.aeV().cH(str);
        AppMethodBeat.o(11223);
        return cH;
    }

    public final String cI(String str) {
        AppMethodBeat.i(11224);
        String cI = z.aeV().cI(str);
        AppMethodBeat.o(11224);
        return cI;
    }
}
